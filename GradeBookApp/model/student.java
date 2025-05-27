package GradeBookApp.model;

public class student {
    private String firstName;
    private String lastName;
    private String course;
    private String grade;

    public student(String firstName, String lastName, String course, String grade) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.course = course;
        this.grade = grade;
    }

    public String toCSV() {
        return firstName + "," + lastName + "," + course + "," + grade;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " - " + course + " (" + grade + ")";
    }
}

