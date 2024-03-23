import java.util.Scanner;

public class TestSportsTeamApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continueProgram = true;

        System.out.println("welcome to the Sports Team App");

        while(continueProgram){
            System.out.print("Enter a team name: ");
            String teamName = scanner.nextLine();
            Team team = new Team(teamName);

            System.out.print("Enter the player names:\nhint: use commas for multiple players; no spaces: ");
            String[] playerNames = scanner.nextLine().split(",");

            for (String playerName : playerNames) {
                team.addPlayer(playerName.trim());
            }

            System.out.println("--Team Summary--");
            System.out.println("Number of players in team: " + team.getPlayerCount());
            System.out.print("Players on team: ");
            System.out.println(String.join(",", team.getPlayers()));

            System.out.print("Continue? (y/n): ");
            String decision = scanner.nextLine();

            if (!decision.equals("y")){
                break;
            }
        }
        scanner.close();
    }
}
