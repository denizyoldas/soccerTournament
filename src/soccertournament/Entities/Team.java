package soccertournament.Entities;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private String teamName;
    private final List<Player> playerList = new ArrayList<>();
    private int points = 0;

    public Team() {
    }


    public void setPlayerList(Player playerList) {
        this.playerList.add(playerList);
    }

    public void setPoints(int points) {
        this.points += points;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public void resetPoints() {
        this.points = 0;
    }

    public int getTotalLevel() {
        int totalLevel = 0;
        for(Player player: playerList){
            totalLevel += player.getLevel();
        }
        return totalLevel;
    }

    public String getTeamName() {
        return teamName;
    }

    public List<Player> getPlayerList() {
        return playerList;
    }

    public int getPoints() {
        return points;
    }
}