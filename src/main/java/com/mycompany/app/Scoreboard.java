package com.mycompany.app;

import com.mycompany.app.comparators.EndedMatchesComparator;
import com.mycompany.app.model.Match;
import com.mycompany.app.model.Team;
import com.neovisionaries.i18n.CountryCode;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class Scoreboard {
    private static final List<Match> matchList = new ArrayList<>();
    private static final List<Match> matchListEnded = new ArrayList<>();
    private final static List<CountryCode> countryCodes = Arrays.asList(CountryCode.values());
    private static final int countryListSize = countryCodes.size();
    private static final Random random = new Random();

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Scoreboard started");

        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                initializeMatch();
            }
            TimeUnit.MILLISECONDS.sleep(50);
        }

        updateMatchList();
        endMatches();

        for (Match match : matchListEnded) {
            System.out.println(match.getHost().getName() + " " + match.getHomeTeamScore() + " - " +
                    match.getGuest().getName() + " " + match.getAwayTeamScore());
            //System.out.println(match);
        }
    }

    static void initializeMatch() {
        Match match = new Match(new Team(countryCodes.get(random.nextInt(countryListSize))),
                new Team(countryCodes.get(random.nextInt(countryListSize))));
        matchList.add(match);
    }

    static void updateMatchList() {
        for (Match match : Scoreboard.matchList) match.updateMatch(random.nextInt(10), random.nextInt(10));
    }

    static void endMatches() {
        matchListEnded.addAll(Scoreboard.matchList);
        Collections.sort(matchListEnded, new EndedMatchesComparator());
        Scoreboard.matchList.clear();
    }
}
