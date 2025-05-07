package Module_8;

import java.text.SimpleDateFormat;

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
import javafx.scene.layout.StackPane;
import java.util.Date;
import javafx.collections.FXCollections;

public class LeiEnhancedFutureValueApp extends Application {

    private TextField txtMonthlyPayment;
    private TextField txtInterestRate;
    private TextArea txtResults;
    private Label lblFutureValueDate;
    private ComboBox<Integer> cbYears;
    private Button btnClear;
    private Button btnCalculate;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Future Value App");

        // Labels
        Label lblMonthlyPayment = new Label("Monthly Payment: ");
        Label lblInterestRate = new Label("Interest Rate (%): ");
        Label lblInterestRateFormat = new Label("Enter rate as a percent, e.g., 5.5");
        lblInterestRateFormat.setTextFill(Color.RED);
        Label lblYears = new Label("Years:");
        lblFutureValueDate = new Label();

        // Input Fields
        txtMonthlyPayment = new TextField();
        txtInterestRate = new TextField();

        // TextArea
        txtResults = new TextArea();
        txtResults.setPrefColumnCount(15);
        txtResults.setPrefHeight(100);
        txtResults.setPrefWidth(300);
        txtResults.setEditable(false);

        // ComboBox for year durations
        cbYears = new ComboBox<>();
        cbYears.setPromptText("Select number of years");
        cbYears.setItems(FXCollections.observableArrayList(1, 2, 3, 4, 5, 10, 15, 20, 30));

        // Buttons
        btnClear = new Button("Clear");
        btnCalculate = new Button("Calculate");

        // Button Actions
        btnClear.setOnAction(e -> clearFormFields());
        btnCalculate.setOnAction(e -> calculateResults());

        // Layout
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        gridPane.setVgap(5.5);
        gridPane.setHgap(5.5);
        gridPane.setAlignment(Pos.CENTER);

        gridPane.add(lblMonthlyPayment, 0, 0);
        gridPane.add(txtMonthlyPayment, 1, 0);

        gridPane.add(lblInterestRate, 0, 1);
        gridPane.add(txtInterestRate, 1, 1);
        gridPane.add(lblInterestRateFormat, 1, 2);
        GridPane.setHalignment(lblInterestRateFormat, HPos.RIGHT);

        gridPane.add(lblYears, 0, 3);
        gridPane.add(cbYears, 1, 3);

        HBox actionBtnContainer = new HBox(10, btnCalculate, btnClear);
        gridPane.add(actionBtnContainer, 1, 4);

        gridPane.add(lblFutureValueDate, 0, 5, 2, 1);
        gridPane.add(txtResults, 0, 6, 2, 1);

        StackPane layout = new StackPane(gridPane);
        Scene scene = new Scene(layout, 500, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setTitle("Lei Future Value App");

    }

    private void clearFormFields() {
        txtMonthlyPayment.setText("");
        txtInterestRate.setText("");
        txtResults.setText("");
        lblFutureValueDate.setText("");
        cbYears.setValue(0);
    }

    private void calculateResults() {
        try {
            double monthlyPayment = Double.parseDouble(txtMonthlyPayment.getText());
            double interestRate = Double.parseDouble(txtInterestRate.getText());
            int years = cbYears.getValue();

            double futureValue = FinanceCalculator.calculateFutureValue(monthlyPayment, interestRate, years);

            lblFutureValueDate.setText("Calculation as of " + getTodayDate());
            txtResults.setText("The future value is " + String.format("%.2f", futureValue));
        } catch (NumberFormatException | NullPointerException e) {
            txtResults.setText("Please enter valid numeric values and select a year.");
        }
    }

    private String getTodayDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        return sdf.format(new Date());
    }

    public static void main(String[] args) {
        launch();
    }
}