package com.mycompany.app.comparators;

import com.mycompany.app.model.Match;
import java.util.Comparator;

public class EndedMatchesComparator implements Comparator<Match> {


    public int compare(Match o1, Match o2) {
        int result = o2.getAwayTeamScore() + o2.getHomeTeamScore() - o1.getHomeTeamScore() - o1.getAwayTeamScore();
        if (result == 0) result = o2.getStartDate().compareTo(o1.getStartDate());
        return result;
    }
}