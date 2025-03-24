package Module_2;

public class team {
    private String teamName = "";
    private String[] players = new String[20];
    private int playerCount = 0;

    // Constructor
    public team(String teamName) {
        this.teamName = teamName;
    }

    // Add a player to the team
    public void addPlayer(String player) {
        if (playerCount < players.length) {
            players[playerCount] = player;
            playerCount++;
        } else {
            System.out.println("Cannot add more players. Team is full.");
        }
    }

    // Get array of players
    public String[] getPlayers() {
        return players;
    }

    // Get number of players
    public int getPlayerCount() {
        return playerCount;
    }

    // Get team name
    public String getTeamName() {
        return teamName;
    }
}

