package com.mycompany.app.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Setter
@Getter
@ToString
public class Match {
    private Date startDate;
    private Team host;
    private Team guest;
    private int homeTeamScore;
    private int awayTeamScore;

    public Match(Team host, Team guest) {
        this.host = host;
        this.guest = guest;
        this.startDate = new Date();
        this.homeTeamScore = getHomeTeamScore();
        this.awayTeamScore = getAwayTeamScore();
    }

    public void updateMatch(int homeTeamGoals, int awayTeamGoals) {
        this.setHomeTeamScore(homeTeamGoals);
        this.setAwayTeamScore(awayTeamGoals);
    }
}
