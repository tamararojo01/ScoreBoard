package com.sportradar.main;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ScoreBoard {

    private final static int DEFAULT_SCORE = 0;
    public static ArrayList<Team> teams = new ArrayList();
    private static int pos = 0;

    public void startGame(String homeTeam, String awayTeam) throws Exception {
        if (homeTeam == null || awayTeam == null){
            throw new Exception("The team name cannot be null");
        }
        Team team = Team.builder().awayTeam(awayTeam).homeTeam(homeTeam)
                .scoreAwayTeam(DEFAULT_SCORE).scoreAwayTeam(DEFAULT_SCORE).pos(pos++).build();
        teams.add(team);
    }

    public void finishGame(int pos) {
        teams.remove(pos);
    }

    public void updateScore(int pos, int scoreHomeTeam, int scoreAwayTeam) {
        teams.get(pos).setScoreAwayTeam(scoreAwayTeam);
        teams.get(pos).setScoreHomeTeam(scoreHomeTeam);
    }

    public List<Team> showBoard() {
         return teams.stream().sorted(Comparator.comparingInt(Team::getPos).reversed())
                .collect(Collectors.toList());

    }

}
