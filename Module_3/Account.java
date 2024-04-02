import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Account {

    private double balance = 200;

    public double getBalance() {
        return this.balance;
    }

    public void deposit(double amt){
        if (amt > 0){
             this.balance += amt;
        }
    }

    public void withdraw(double amt){
        if (this.balance >= amt){
             this.balance -= amt;
        }
    }

    public void displayMenu (){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Account Menu");
        System.out.println("Enter <D/d> for deposit");
        System.out.println("Enter <W/w> for withdraw");
        System.out.println("Enter <B/b> for balance");
        System.out.print("Enter option>: ");
    }

    public String getTransactionDate(){
        Format date = new SimpleDateFormat("mm-dd-yyyy");
        return date.format(new Date());

    }
}