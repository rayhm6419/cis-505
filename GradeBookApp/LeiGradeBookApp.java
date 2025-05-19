package GradeBookApp;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class LeiGradeBookApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Labels
        Label firstNameLabel = new Label("First Name:");
        Label lastNameLabel = new Label("Last Name:");
        Label courseLabel = new Label("Course:");
        Label gradeLabel = new Label("Grade:");

        // Input Fields
        TextField firstNameField = new TextField();
        TextField lastNameField = new TextField();
        TextField courseField = new TextField();
        ComboBox<String> gradeComboBox = new ComboBox<>();
        gradeComboBox.getItems().addAll("A", "B", "C", "D", "F");

        // Buttons
        Button saveButton = new Button("Save Grade");
        Button clearButton = new Button("Clear Form");
        Button viewButton = new Button("View Grades");

        // GridPane for form fields
        GridPane formGrid = new GridPane();
        formGrid.setPadding(new Insets(20));
        formGrid.setHgap(10);
        formGrid.setVgap(10);

        formGrid.add(firstNameLabel, 0, 0);
        formGrid.add(firstNameField, 1, 0);
        formGrid.add(lastNameLabel, 0, 1);
        formGrid.add(lastNameField, 1, 1);
        formGrid.add(courseLabel, 0, 2);
        formGrid.add(courseField, 1, 2);
        formGrid.add(gradeLabel, 0, 3);
        formGrid.add(gradeComboBox, 1, 3);

        // HBox for buttons
        HBox buttonBox = new HBox(10, saveButton, clearButton, viewButton);
        buttonBox.setPadding(new Insets(10, 0, 0, 0));

        // VBox to hold everything
        VBox root = new VBox(10, formGrid, buttonBox);
        root.setPadding(new Insets(20));

        // Scene and Stage
        Scene scene = new Scene(root, 400, 300);
        primaryStage.setTitle("Grade Book App");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
