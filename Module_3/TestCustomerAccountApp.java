package Module_3;

import java.util.Scanner;

public class TestCustomerAccountApp {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to the Customer Account App");

        System.out.print("Enter a customer ID:" +"\n" + "ex: 1007, 1008, 1009:");
        int customerId = input.nextInt();
        input.nextLine();
        Customer customer = CustomerDB.getCustomer(customerId);

        Account menu = customer.getAccount();

        String choice;
        
        do{
            menu.displayMenu();

            String option = input.nextLine();

            switch (option.toLowerCase()) {
                case "d":
                System.out.println();
                System.out.print("Enter deposit amount: ");
                double depositAmt = input.nextDouble();
                menu.deposit(depositAmt);
                input.nextLine();
                break;

                case "w":
                System.out.println();
                System.out.print("Enter withdraw amount: ");
                double withdraw = input.nextDouble();
                menu.withdraw(withdraw);
                input.nextLine(); 
                break;

                case "b":
                menu.getBalance();
                    break;
                default:
                    System.out.println("Error: Invalid Option.");
            }
                    
            System.out.print("Continue? (y/n): ");
            choice = input.nextLine();
                } while (choice.equalsIgnoreCase("y"));
        
                // Print final output
                System.out.println("\nCustomer Details:");
                System.out.println(customer); 
                System.out.println();
                System.out.printf("\nBalance as of %s is $%.2f%n", menu.getTransactionDate(), menu.getBalance());
            }
        }

