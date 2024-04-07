import java.util.Scanner;

public class TestBowlingShopApp {
    public static void displayMenu(){
        System.out.println("MENU OPTIONS");
        System.out.println("  1.<b> Bowling Balls");
        System.out.println("  2.<a> Bowling Bags");
        System.out.println("  3.<s> Bowling Shoes");
        System.out.println("  4.<x> To exit" + "\n");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String userInput;
        GenericQueue<Product> products;

        do {
            displayMenu();  // Display the menu
            System.out.print("Please choose an option: ");
            userInput = scanner.nextLine().trim().toLowerCase();
            System.out.println( "\n" + "-- Product Listing--");

            switch (userInput) {
                case "b":
                case "s":
                case "a":
                    products = ProductDB.getProduct(userInput);
                    while (products.size() > 0) {
                        System.out.println(products.dequeue().toString());
                    }
                    break;
                case "x":
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option, please try again.");
            }
        } while (!userInput.equals("x"));

        scanner.close();
    }
}