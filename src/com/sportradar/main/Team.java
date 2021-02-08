package com.sportradar.main;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Team {

    private int pos;
    private String homeTeam;
    private String awayTeam;
    private int scoreHomeTeam;
    private int scoreAwayTeam;
}
