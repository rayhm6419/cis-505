package Module_2;
import java.util.Scanner;

public class TestSportTeamApp {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String choice;

        System.out.println("Welcome to the Sports Team App!");

        do {
            // Get team name
            System.out.print("\nEnter a team name: ");
            String teamName = input.nextLine();

            // Create new team
            team team = new team(teamName);

            // Get player names
            System.out.print("Enter player names (comma-separated, no spaces): ");
            String playerInput = input.nextLine();
            String[] playerArray = playerInput.split(",");

            // Add each player to the team
            for (String player : playerArray) {
                team.addPlayer(player);
            }

            // Output results
            System.out.println("Number of players in team: " + team.getPlayerCount());

            System.out.print("Players on team: ");
            for (int i = 0; i < team.getPlayerCount(); i++) {
                System.out.print(team.getPlayers()[i]);
                if (i < team.getPlayerCount() - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println();

            // Ask to continue
            System.out.print("Would you like to enter another team? (yes/no): ");
            choice = input.nextLine().trim().toLowerCase();

        } while (choice.equals("yes"));

        System.out.println("Thanks for using the Sports Team App!");
        input.close();
    }
}
