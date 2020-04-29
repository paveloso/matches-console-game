package com.company.test.util;

import java.util.Scanner;

public class ScannerUtil {

    private static Scanner instance;

    private ScannerUtil() {}

    public static Scanner getScannerInstance() {
        if (instance == null) {
            instance = new Scanner(System.in);
        }
        return instance;
    }

    public static void destroyScannerInstance() {
        instance = null;
    }
}
