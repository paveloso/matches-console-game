package com.company.test.game;

import com.company.test.ailogic.AiLogic;
import com.company.test.ailogic.UserLogic;
import com.company.test.util.ConsoleWriter;
import com.company.test.util.ScannerUtil;

import java.util.Scanner;

public class TheMatchesGame {

    public static int MATCHES_COUNT = 20;

    private Player pcPlayer;
    private Player userPlayer;

    private static int lastUserTurnMatches = 0;

    public void startGame() {
        boolean isUserTurnNow = false;

        initPlayers(initUserName(ScannerUtil.getScannerInstance()));

        ConsoleWriter.printMessageConsole(ConsoleWriter.Situation.START, null, 0);

        int matchesTaken = 0;
        while (MATCHES_COUNT > 1) {
            if (!isUserTurnNow) {
                matchesTaken = pcPlayer.getLogic().move();
                ConsoleWriter.printMessageConsole(ConsoleWriter.Situation.MOVE, pcPlayer, matchesTaken);
                ConsoleWriter.printMessageConsole(ConsoleWriter.Situation.MATCHES_COUNT, null, 0);
                ConsoleWriter.printMessageConsole(ConsoleWriter.Situation.NEXT, userPlayer, 0);
                isUserTurnNow = true;
            } else {
                matchesTaken = userPlayer.getLogic().move();
                lastUserTurnMatches = matchesTaken;
                ConsoleWriter.printMessageConsole(ConsoleWriter.Situation.MOVE, userPlayer, matchesTaken);
                ConsoleWriter.printMessageConsole(ConsoleWriter.Situation.MATCHES_COUNT, null, 0);
                ConsoleWriter.printMessageConsole(ConsoleWriter.Situation.NEXT, pcPlayer, 0);
                isUserTurnNow = false;
            }
        }

        if (isUserTurnNow) {
            ConsoleWriter.printMessageConsole(ConsoleWriter.Situation.END, pcPlayer, 0);
        } else {
            ConsoleWriter.printMessageConsole(ConsoleWriter.Situation.END, pcPlayer, 0);
        }
    }

    private void initPlayers(String userName) {
        userPlayer = new Player(userName, Player.PlayerType.USER, new UserLogic());
        pcPlayer = new Player("PC", Player.PlayerType.PC, new AiLogic());
    }

    private String initUserName(Scanner scanner) {
        ConsoleWriter.printSimpleMessage("Укажите Ваше имя: ");
        String userName = scanner.nextLine();
        ConsoleWriter.printSimpleMessage("Здравствуйте, " + userName + "!");
        return userName;
    }

    public static int getLastUserTurnMatches() {
        return lastUserTurnMatches;
    }
}
