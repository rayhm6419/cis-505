import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class TestExpenseTracker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input;
        boolean program = true;

        do {
            input = ValidatorIO.getInt(scanner, menu());
            switch (input) {
                case 1:
                    try {
                        ArrayList<Transaction> transactions = TransactionIO.findAll();
                        for (Transaction tran : transactions) {
                            System.out.printf(tran.toString());
                        }
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    break;

                case 2:
                    String c = "y";
                    ArrayList<Transaction> transactions = new ArrayList<>();

                    while (c.equalsIgnoreCase("y")) {
                        String date = ValidatorIO.getString(scanner, "\nEnter the date:");
                        String description = ValidatorIO.getString(scanner, "\nEnter the description: ");
                        double amount = ValidatorIO.getDouble(scanner, "Enter the amount: ");

                        Transaction transaction = new Transaction(date, description, amount);

                        transactions.add(transaction);

                        c = ValidatorIO.getString(scanner, "\n Add another transaction? (y/n)");
                    }
                    try {
                        TransactionIO.bulkInsert(transactions);
                    } catch (IOException e) {
                        System.out.printf("\n Exception: " + e.getMessage());
                    }
                    break;

                case 3:
                    try {
                        double total = TransactionIO.findAll().stream().mapToDouble(Transaction::getAmount).sum();
                        System.out.printf("Total Expenses: $%,6.2f\n", total);
                    } catch (IOException e) {
                        System.out.println("Error calculating total expenses: " + e.getMessage());
                    }
                    break;
            }
            System.out.print("Continue? (y/n): ");


        }
        while (scanner.next().equalsIgnoreCase("Y"));

        scanner.close();
    }
    public static String menu(){
        return "Welcome to the Expense Tracker\n\n" +
                "MENU OPTIONS\n" +
                "1. View Transactions\n" +
                "2. Add Transactions\n" +
                "3. View Expense\n\n" +
                "Please choose an option: ";
    }
}
