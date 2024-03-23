public class Team {
    private  String teamName = " ";
    private  String[] players = new String[20];
    private  int playerCount = 0;

    public Team(String teamName){
        this.teamName = teamName;
    }

    public boolean addPlayer (String playerName){
        if (playerCount < players.length){
            players[playerCount] = playerName;
            playerCount++;
            return true;
        }
        return false;
    }

    public String[] getPlayers(){
        return players;
    }

    public int getPlayerCount(){
        return playerCount;
    }

    public String getTeamName(){
        return teamName;
    }
    
}