package com.company.test.util;

import com.company.test.game.Player;
import com.company.test.game.TheMatchesGame;

public class ConsoleWriter {

    public enum Situation {
        START,
        END,
        NEXT,
        MATCHES_COUNT,
        MOVE
    }

    public static void printMessageConsole(Situation situation, Player player, int matchesTaken) {
        switch (situation) {
            case START:
                System.out.println("Начало игры. На столе 20 спичек. Начинает компьютер.");
                break;
            case END:
                System.out.println("Игра окончена. Победил " + player.getName());
                break;
            case NEXT:
                System.out.println("Следующий ход за " + player.getName() + ".");
                break;
            case MATCHES_COUNT:
                System.out.println("Осталось " + TheMatchesGame.MATCHES_COUNT + " спичек.");
                break;
            case MOVE:
                System.out.println("Игрок " + player.getName() + " взял " + matchesTaken + ".");
                break;
            default:
                System.out.println("nothing to print here");
        }
    }

    public static void printSimpleMessage(String message) {
        System.out.println(message);
    }
}
