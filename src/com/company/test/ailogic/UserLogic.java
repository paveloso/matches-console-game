package com.company.test.ailogic;

import com.company.test.game.TheMatchesGame;
import com.company.test.util.ConsoleWriter;
import com.company.test.util.ScannerUtil;

import java.util.InputMismatchException;

public class UserLogic implements Logic {
    @Override
    public int move() {
        int matchesTaken = 0;
        ConsoleWriter.printSimpleMessage("Какое количество спичек вы возьмёте? ");
        do {
            try {
                matchesTaken = ScannerUtil.getScannerInstance().nextInt();
                if (matchesTaken == 0 || matchesTaken > 3) {
                    throw new IllegalStateException();
                }
            } catch (InputMismatchException ex) {
                ConsoleWriter.printSimpleMessage("Вы должны ввести цифру!");
                ScannerUtil.destroyScannerInstance();
            } catch (IllegalStateException ex) {
                ConsoleWriter.printSimpleMessage("Вы должны ввести цифру 1, 2 или 3!");
                ScannerUtil.destroyScannerInstance();
            } finally {
                ScannerUtil.destroyScannerInstance();
            }

        } while (matchesTaken <= 0 || matchesTaken >= 4);
        TheMatchesGame.MATCHES_COUNT -= matchesTaken;
        return matchesTaken;
    }
}
