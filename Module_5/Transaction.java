package Module_5;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Transaction {
    private String date;
    private String description;
    private double amount;

    public Transaction() {
        date = String.valueOf(new SimpleDateFormat("MM-dd-yyyy").format(Calendar.getInstance().getTime()));
        description = "";
        amount = 0.0;
    } 

    public Transaction(String date, String description, double amount) {
        this.date = date;
        this.description = description;
        this.amount = amount;
    } 

    public String getDate() {
        return date;
    } 

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    } 

    public void setDescription(String description) {
        this.description = description;
    }

    public double getAmount() {
        return amount;
    } 


    public void setAmount(double amount) {
        this.amount = amount;
    } 

    @Override
    public String toString() {
        return "Date: "+date+"\nDescription: "+description+"\nAmount: "+String.valueOf(amount)+"\n";
    } 
} 