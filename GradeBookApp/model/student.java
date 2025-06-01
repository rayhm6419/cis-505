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

    // Getters
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCourse() {
        return course;
    }

    public String getGrade() {
        return grade;
    }

    // Setters
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    // Utility Methods
    public String toCSV() {
        return firstName + "," + lastName + "," + course + "," + grade;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " – " + course + " (" + grade + ")";
    }
}
