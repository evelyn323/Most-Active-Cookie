package ui;

import controller.MostActiveCookieController;

import java.util.Scanner;

/**
 * UI Class that takes in the user's command line input and calls on the required controller
 */
public class CookieCommandUserInput {
    private final MostActiveCookieController mostActiveCookieController;

    /**
     * Constructor for this class. Initializes the mostActiveCookieController
     */
    public CookieCommandUserInput() {
        this.mostActiveCookieController = new MostActiveCookieController();
    }

    /**
     * Collect the command from the user, then pass to the controller to process
     */
    public void collectCommand() {
        Scanner scanner = new Scanner(System.in);
        String action = scanner.nextLine();
        try {
            mostActiveCookieController.processCommandInput(action);
            mostActiveCookieController.getMostActiveCookie();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
