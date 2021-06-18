package soccertournament.Entities;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Tournament {

    private final List<Team> teams = new ArrayList<>();

    public void ReadFile(String filePath) throws IOException {
        File file = new File(filePath);
        String[] splittedTeam;
        String[] splittedPlayer;
        Team team = new Team();

        Scanner myReader = new Scanner(file);
        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            splittedTeam = data.split("-");

            if(splittedTeam.length == 2){
                team = new Team();
                team.setTeamName(splittedTeam[1]);
            } else {
                splittedPlayer = splittedTeam[0].split(" ");
                Player player = new Player(splittedPlayer[0], splittedPlayer[1], splittedPlayer[2]);
                team.setPlayerList(player);
            }
            if(splittedTeam.length == 2) {
                teams.add(team);
            }
        }
    }

    public List<Team> GetTeamList() {
        return teams;
    }


    public void StartTournament() {
        newTournament();
        for(int i = 0; i < this.GetTeamList().size(); i++) {
            Team team = this.GetTeamList().get(i);
            team.resetPoints();
            for(int j = 0; j < this.GetTeamList().size(); j++) {
                Team nextTeam = this.GetTeamList().get(j);
                if(!team.getTeamName().equals(nextTeam.getTeamName())){
                    if(team.getTotalLevel() > nextTeam.getTotalLevel()) {
                        team.setPoints(3);
                    } else if (team.getTotalLevel() < nextTeam.getTotalLevel()) {
                        team.setPoints(0);
                    } else {
                        team.setPoints(1);
                    }
                }
            }
        }
    }

    /*
    public void StartTournament() {
        newTournament();
        for(int i = 0; i < this.GetTeamList().size(); i++) {
            Team homeTeam = this.GetTeamList().get(i);
            Team awayTeam  = new Team();
            if(i < this.GetTeamList().size() - 1) {
                awayTeam = this.GetTeamList().get(i+1);
            }
            if(homeTeam.getTotalLevel() > awayTeam.getTotalLevel()) {
                homeTeam.setPoints(3);
                awayTeam.setPoints(0);
            } else if (homeTeam.getTotalLevel() < awayTeam.getTotalLevel()) {
                homeTeam.setPoints(0);
                awayTeam.setPoints(3);
            } else {
                homeTeam.setPoints(1);
                awayTeam.setPoints(3);
            }
        }
    }
    */


    public void newTournament() {
        for(Team team: this.GetTeamList()) {
            for(int i = 0; i < team.getPlayerList().size(); i++) {
                team.getPlayerList().get(i).newLevel();
            }
        }
    }
}
