package com.company.test.ailogic;

import com.company.test.game.TheMatchesGame;

public class AiLogic implements Logic {

    @Override
    public int move() {
        int matchesTaken = 0;
        if (TheMatchesGame.MATCHES_COUNT == 20) {
            matchesTaken = 3;
            TheMatchesGame.MATCHES_COUNT -= matchesTaken;
            return matchesTaken;
        } else {
            matchesTaken = 4 - TheMatchesGame.getLastUserTurnMatches();
            TheMatchesGame.MATCHES_COUNT -= matchesTaken;
            return matchesTaken;
        }
    }
}
