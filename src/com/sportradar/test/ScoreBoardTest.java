package com.sportradar.test;


import com.sportradar.main.ScoreBoard;
import com.sportradar.main.Team;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class ScoreBoardTest {

     ScoreBoard scoreBoard;
     private static final String HOME_TEAM_0 = "México";
     private static final String AWAY_TEAM_0 = "Canadá";
     private static final String HOME_TEAM_1 = "Spain";
     private static final String AWAY_TEAM_1 = "Brazil";
     private static final String HOME_TEAM_2 = "Uruguay";
     private static final String AWAY_TEAM_2 = "Italy";
     private static final int SCORE_AWAY_TEAM = 2;
     private static final int SCORE_HOME_TEAM = 1;
     private static int POS = 0;

    @BeforeEach
    void before(){
        scoreBoard = new ScoreBoard();
        ScoreBoard.teams = new ArrayList<>();
    }

    @Test
    public void testStartGame() throws Exception {
        //Given
        //When
        scoreBoard.startGame(HOME_TEAM_0, AWAY_TEAM_0);

        //Then
        assertEquals(HOME_TEAM_0, ScoreBoard.teams.get(0).getHomeTeam());
        assertEquals(AWAY_TEAM_0, ScoreBoard.teams.get(0).getAwayTeam());
    }

    @Test
    public void testStartGameFailsWhenNull() throws Exception {
        //Given
        //When

        //Then
        assertThrows(Exception.class,
                () -> scoreBoard.startGame(null, AWAY_TEAM_0));

    }

    @Test
    public void testFinishGame() {
        //Given
        ScoreBoard.teams.add(createNewTeam(0, HOME_TEAM_0, AWAY_TEAM_0));
        ScoreBoard.teams.add(createNewTeam(1, HOME_TEAM_1, AWAY_TEAM_1));

        //When
        scoreBoard.finishGame(1);

        //Then
        assertEquals(ScoreBoard.teams.size(), 1);
    }

    @Test
    public void testUpdateScore() {
        //Given
        ScoreBoard.teams.add(createNewTeam(0, HOME_TEAM_0, AWAY_TEAM_0));
        ScoreBoard.teams.add(createNewTeam(1, HOME_TEAM_1, AWAY_TEAM_1));

        //When
        scoreBoard.updateScore(1, SCORE_HOME_TEAM, SCORE_AWAY_TEAM);

        //Then
        assertEquals(ScoreBoard.teams.get(1).getScoreHomeTeam(), SCORE_HOME_TEAM);
        assertEquals(ScoreBoard.teams.get(1).getScoreAwayTeam(), SCORE_AWAY_TEAM);
    }
    @Test
    public void testShowBoard(){
        //Given
        ScoreBoard.teams.add(createNewTeam(0, HOME_TEAM_0, AWAY_TEAM_0));
        ScoreBoard.teams.add(createNewTeam(1, HOME_TEAM_1, AWAY_TEAM_1));
        ScoreBoard.teams.add(createNewTeam(2, HOME_TEAM_2, AWAY_TEAM_2));

        //When
        List<Team> teams = scoreBoard.showBoard();

        assertEquals(teams.get(0).getAwayTeam(), AWAY_TEAM_2);
        assertEquals(teams.get(0).getHomeTeam(), HOME_TEAM_2);

    }

    private Team createNewTeam(int pos, String homeTeam, String awayTeam) {
        return Team.builder()
                .awayTeam(awayTeam)
                .homeTeam(homeTeam)
                .scoreAwayTeam(0)
                .scoreHomeTeam(0)
                .pos(pos).build();
    }
}
