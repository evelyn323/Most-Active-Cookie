package main.java.ui;

import main.java.controller.MostActiveCookieInputs;

import java.util.Scanner;

/**
 * UI Class that takes in the user's command line input and calls on the required controller
 */
public class CookieCommandUserInput {

    public void collectCommand() {
        Scanner scanner = new Scanner(System.in);
        String action = scanner.nextLine();
        try {
            MostActiveCookieInputs mostActiveCookieInputs = new MostActiveCookieInputs(action);
            mostActiveCookieInputs.getMostActiveCookie();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
