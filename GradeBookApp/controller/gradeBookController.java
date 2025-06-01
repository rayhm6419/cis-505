package GradeBookApp.controller;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import GradeBookApp.model.student;


public class gradeBookController {
    private static final String FILE_NAME = "grades.csv";

    private TextField firstNameField;
    private TextField lastNameField;
    private TextField courseField;
    private ComboBox<String> gradeComboBox;
    private TextArea outputArea;

    public gradeBookController(TextField firstNameField, TextField lastNameField, TextField courseField,
                                ComboBox<String> gradeComboBox, TextArea outputArea) {
        this.firstNameField = firstNameField;
        this.lastNameField = lastNameField;
        this.courseField = courseField;
        this.gradeComboBox = gradeComboBox;
        this.outputArea = outputArea;
    }
        // Calculate average GPA from a list of students
        public static double calculateGPA(List<student> students) {
            double total = 0;
            int count = 0;
    
            for (student s : students) {
                switch (s.getGrade()) {
                    case "A" -> total += 4.0;
                    case "B" -> total += 3.0;
                    case "C" -> total += 2.0;
                    case "D" -> total += 1.0;
                    case "F" -> total += 0.0;
                }
                count++;
            }
            return count > 0 ? total / count : 0.0;
        }
    
        // Update an existing student's data with new values
        public static void updateStudent(student original, student updated) {
            original.setFirstName(updated.getFirstName());
            original.setLastName(updated.getLastName());
            original.setCourse(updated.getCourse());
            original.setGrade(updated.getGrade());
    }

    public void handleSave() {
        String first = firstNameField.getText().trim();
        String last = lastNameField.getText().trim();
        String course = courseField.getText().trim();
        String grade = gradeComboBox.getValue();

        if (first.isEmpty() || last.isEmpty() || course.isEmpty() || grade == null) {
            outputArea.setText("Please fill in all fields.");
            return;
        }

        student student = new student(first, last, course, grade);

        try {
            boolean fileExists = Files.exists(Paths.get(FILE_NAME));
            BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true));
            if (!fileExists) {
                writer.write("firstName,lastName,course,grade");
                writer.newLine();
            }
            writer.write(student.toCSV());
            writer.newLine();
            writer.close();

            outputArea.setText("Grade saved: " + student);
            clearForm();

        } catch (IOException ex) {
            outputArea.setText("Error saving grade: " + ex.getMessage());
        }
    }

    public void handleClear() {
        clearForm();
        outputArea.clear();
    }

    public void handleView() {
        try {
            List<String> lines = Files.readAllLines(Paths.get(FILE_NAME));
            outputArea.setText(String.join("\n", lines));
        } catch (IOException ex) {
            outputArea.setText("Error loading grades: " + ex.getMessage());
        }
    }

    private void clearForm() {
        firstNameField.clear();
        lastNameField.clear();
        courseField.clear();
        gradeComboBox.getSelectionModel().clearSelection();
    }
}

