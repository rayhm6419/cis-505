package Module_6;

import java.util.*;

public class TestComposerApp { 
    public static void displayMenu(){ 
        System.out.println("  MENU OPTIONS");
        System.out.println("    1. View Composers");
        System.out.println("    2. Find Composer");
        System.out.println("    3. Add Composer");
        System.out.println("    4. Exit");
        System.out.println("");
        System.out.print("  Please choose an option: ");
    }

    public static void main(String[] args){
        MemComposerDao composers = new MemComposerDao(); 
        System.out.println("  Welcome to the Composer App");
        System.out.println("");
        do{ 
            displayMenu(); 
            Scanner input = new Scanner(System.in);
            int userInput = input.nextInt();

        
            if (userInput == 1){ 
                System.out.println("");
                System.out.println(composers.findAll());
            }
            else if (userInput == 2){ 
                System.out.println("");
                System.out.print("  Enter an id: ");
                Scanner userID = new Scanner(System.in);
                int id = userID.nextInt();
                System.out.println("");
                System.out.println(composers.findBy(id));
            }
            else if (userInput == 3){ 
                String cont = "y";

                while (cont.equalsIgnoreCase("y")){ 
                    System.out.println(""); 
                    System.out.print("  Enter an ID: ");
                    Scanner userID = new Scanner(System.in);
                    int id = userID.nextInt();

                    System.out.print("  Enter a name: "); 
                    Scanner userName = new Scanner(System.in);
                    String name = userName.nextLine();

                    System.out.print("  Enter a genre: "); 
                    Scanner userGenre = new Scanner(System.in);
                    String genre = userGenre.nextLine();

                    Composer newComposer = new Composer(id, name, genre);
                    composers.insert(newComposer); 
                    System.out.println(""); 
                    System.out.print("  Add another composer? (y/n): ");
                    Scanner userCont = new Scanner(System.in);
                    cont = userCont.nextLine();
                }
            }
            else if (userInput == 4){ 
                System.out.println("");
                System.out.println("  Session terminated by user...");
                System.out.println("");
                break;
            }
            else if (userInput != 1 || userInput !=2 || userInput !=3 || userInput != 4){ 
                System.out.println("  Error! Invalid input.");
            }
            System.out.println("");
            System.out.print("  Continue? y/n: "); 
            Scanner userContinue = new Scanner(System.in);
            System.out.print("");
            String continueChoice = userContinue.nextLine();
            System.out.println("");
            if (continueChoice.equalsIgnoreCase("n")){ 
                System.out.println("");
                System.out.println("  Session terminated by user...");
                System.out.println("");
                break;
            } else if (continueChoice.equalsIgnoreCase("y")){
                continue;
            }
        } while (true); 
    } 
} 
