import java.util.Scanner;

public class TestCustomerAccountApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Account account = new Account();
        CustomerDB customer = new CustomerDB();
        Customer customerid = null;

        System.out.println("Welcome to the Customer Account App");
        System.out.println("Enter a customer ID: ");
        System.out.print("  ex: 1007, 1008, 1009>: ");
        int id = scanner.nextInt();
        if (id == 1007 || id == 1008 || id == 1009) {
            customerid=customer.getCustoemr(id);
        }
        do {
            account.displayMenu();
            String selection = scanner.next();
            switch (selection) {
                case "D":
                case "d":
                    System.out.print("Enter deposit amount: ");
                    double amount = scanner.nextDouble();
                    scanner.nextLine();
                    account.deposit(amount);
                    break;
                case "W":
                case "w":
                    System.out.println("Enter withdraw amount: ");
                    amount = scanner.nextDouble();
                    account.withdraw(amount);
                case "B":
                case "b":
                    System.out.println("Account balance: " + account.getBalance());
                    break;
            }
            System.out.println("Continue?(y/n): ");
        } while (scanner.next().equalsIgnoreCase("Y"));

        if(customer != null){
            System.out.println("---Customer Details---");
            System.out.println(customerid.toString());
            System.out.printf("Balance as of %s is $%,.2f%n", account.getTransactionDate(), account.getBalance());
            System.out.println("End of line...");
        }
    }
}
