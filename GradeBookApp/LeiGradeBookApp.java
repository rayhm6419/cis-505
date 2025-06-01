package GradeBookApp;

import GradeBookApp.controller.gradeBookController;
import GradeBookApp.model.student;
import javafx.application.Application;
import javafx.collections.*;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.stage.Stage;


public class LeiGradeBookApp extends Application {

    private final ObservableList<student> studentData = FXCollections.observableArrayList();
    private TableView<student> tableView = new TableView<>();

    @Override
    public void start(Stage primaryStage) {
        // Labels
        Label firstNameLabel = new Label("First Name:");
        Label lastNameLabel = new Label("Last Name:");
        Label courseLabel = new Label("Course:");
        Label gradeLabel = new Label("Grade:");
        Label gpaLabel = new Label("Average GPA: ");

        // Inputs
        TextField firstNameField = new TextField();
        TextField lastNameField = new TextField();
        TextField courseField = new TextField();
        ComboBox<String> gradeComboBox = new ComboBox<>();
        gradeComboBox.getItems().addAll("A", "B", "C", "D", "F");

        // Buttons
        Button saveButton = new Button("Save Grade");
        Button clearButton = new Button("Clear Form");
        Button gpaButton = new Button("Calculate GPA");

        // Table Columns
        TableColumn<student, String> firstNameCol = new TableColumn<>("First Name");
        firstNameCol.setCellValueFactory(new PropertyValueFactory<>("firstName"));

        TableColumn<student, String> lastNameCol = new TableColumn<>("Last Name");
        lastNameCol.setCellValueFactory(new PropertyValueFactory<>("lastName"));

        TableColumn<student, String> courseCol = new TableColumn<>("Course");
        courseCol.setCellValueFactory(new PropertyValueFactory<>("course"));

        TableColumn<student, String> gradeCol = new TableColumn<>("Grade");
        gradeCol.setCellValueFactory(new PropertyValueFactory<>("grade"));

        tableView.getColumns().addAll(firstNameCol, lastNameCol, courseCol, gradeCol);
        tableView.setItems(studentData);
        tableView.setPrefHeight(200);

        // Save/Edit button action
        saveButton.setOnAction(e -> {
            String first = firstNameField.getText();
            String last = lastNameField.getText();
            String course = courseField.getText();
            String grade = gradeComboBox.getValue();

            if (first.isEmpty() || last.isEmpty() || course.isEmpty() || grade == null) return;

            student selected = tableView.getSelectionModel().getSelectedItem();
            student newStudent = new student(first, last, course, grade);
            if (selected != null) {
                gradeBookController.updateStudent(selected, newStudent);
                tableView.refresh();
            } else {
                studentData.add(newStudent);
            }

            firstNameField.clear();
            lastNameField.clear();
            courseField.clear();
            gradeComboBox.setValue(null);
            tableView.getSelectionModel().clearSelection();
        });

        clearButton.setOnAction(e -> {
            firstNameField.clear();
            lastNameField.clear();
            courseField.clear();
            gradeComboBox.setValue(null);
            tableView.getSelectionModel().clearSelection();
        });

        gpaButton.setOnAction(e -> {
            double gpa = gradeBookController.calculateGPA(studentData);
            gpaLabel.setText(String.format("Average GPA: %.2f", gpa));
        });

        tableView.setOnMouseClicked(event -> {
            student selected = tableView.getSelectionModel().getSelectedItem();
            if (selected != null) {
                firstNameField.setText(selected.getFirstName());
                lastNameField.setText(selected.getLastName());
                courseField.setText(selected.getCourse());
                gradeComboBox.setValue(selected.getGrade());
            }
        });

        // Layout
        GridPane form = new GridPane();
        form.setPadding(new Insets(10));
        form.setHgap(10);
        form.setVgap(10);
        form.add(firstNameLabel, 0, 0);
        form.add(firstNameField, 1, 0);
        form.add(lastNameLabel, 0, 1);
        form.add(lastNameField, 1, 1);
        form.add(courseLabel, 0, 2);
        form.add(courseField, 1, 2);
        form.add(gradeLabel, 0, 3);
        form.add(gradeComboBox, 1, 3);
        form.add(saveButton, 0, 4);
        form.add(clearButton, 1, 4);
        form.add(gpaButton, 0, 5);
        form.add(gpaLabel, 1, 5);

        VBox root = new VBox(10, form, tableView);
        root.setPadding(new Insets(10));

        Scene scene = new Scene(root, 600, 500);
        primaryStage.setTitle("Lei Grade Book");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
