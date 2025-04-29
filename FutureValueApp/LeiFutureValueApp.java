package FutureValueApp;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.HPos;
import javafx.collections.ObservableList;
import javafx.scene.layout.StackPane;



public class LeiFutureValueApp extends Application {

    private TextField tfMonthlyPayment;
    private TextField tfInterestRate;
    private TextArea taResult;
    private Label lblMonthlyPayment;
    private Label lblInterestRate;
    private Label lblInterestRateFormat;
    private Label lblYears;
    private Label lblFutureValueDate;
    private Button btnClear;
    private Button btnCalculate;
    private ComboBox<Integer> cbYears;
    

    @Override
    public void start(Stage primaryStage) throws Exception{

        primaryStage.setTitle("Future Value App");

        // Creating Labels

        Label lblMonthlyPayment = new Label("Monthly Payment: ");
        Label lblInterestRate = new Label("Interest Rate: ");
        Label lblInterestRateFormat = new Label();
        Label lblYears = new Label("Years");

        //Creating Text Filed for Monthly Payment
        TextField textMonthlyPayment = new TextField();

        //Creating Text Filed for Interest Rate
        TextField textInterestRate = new TextField();

        // Create a Text Area
        TextArea textArea = new TextArea();
        textArea.setText("Enter your address here");
        textArea.setPrefColumnCount(15);
        textArea.setPrefHeight(120);
        textArea.setPrefWidth(300);

        // Creating a button
        Button btnClear = new Button("Clear");
        Button btnCalculate = new Button("Calculate");

        //Creating a combo box
        ComboBox<Integer> combo = new ComboBox<Integer>();

        //Setting the prompt text of the combo box
        combo.setPromptText("Select a Year");

        //Getting the observable list of the combo box
        ObservableList<Integer> list = combo.getItems();
        //Adding items to the combo box
        list.add(2023);
        list.add(2022);
        list.add(2021);
        list.add(2020);
        list.add(2019);

        GridPane gridPane = new GridPane();

        gridPane.setMinSize(400, 200);
        gridPane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));

        //Setting the vertical and horizontal gaps between the columns
        gridPane.setVgap(5.5);
        gridPane.setHgap(5.5);

        //setting the font color of the interest rate instruction to red
        lblInterestRateFormat.setTextFill(Color.RED);

        //Add the label to the grid pane
        gridPane.add(lblMonthlyPayment,1,2);
        gridPane.add(lblInterestRate,1,2);
        gridPane.add(lblInterestRateFormat,1,2);

        //Position of the label to the right of the pane
        GridPane.setHalignment(lblInterestRateFormat, HPos.RIGHT);

        HBox actionBtnContainer = new HBox(); // creating a new HBox container

        actionBtnContainer.setPadding(new Insets(15,0,15,30));  // set the container padding
        actionBtnContainer.setSpacing(10); //set the container spacing
        actionBtnContainer.getChildren().add(btnClear); // Add btnClear to the container
        actionBtnContainer.getChildren().add(btnCalculate); //Add btnCalculate to the container

        gridPane.add(actionBtnContainer, 1,4); //Add the container to the Grid Pane
        actionBtnContainer.getChildren().addAll(lblYears, combo);

        StackPane layout  = new StackPane();
        layout.getChildren().add(gridPane);
        layout.getChildren().add(gridPane);
        // Group group = new Group();
        Scene scene = new Scene(layout, 500, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {

        launch();
    }
}