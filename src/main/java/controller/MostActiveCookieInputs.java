package main.java.controller;

import main.java.presenter.CookiePresenter;
import main.java.usecase.MostActiveCookie;

/**
 * Receives and interprets the parameters passed in the Most Active Cookie command
 */
public class MostActiveCookieInputs {
    private String date;
    private String fileName;
    private final MostActiveCookie mostActiveCookie;

    /**
     * Constructor for this class
     * @param command the command the user entered
     */
    public MostActiveCookieInputs(String command) throws Exception {
        processCommandInput(command);
        mostActiveCookie = new MostActiveCookie(date, fileName);
    }

    /**
     * Process the command input to get the fileName and date
     * @param command the command the user entered
     */
    private void processCommandInput(String command) throws Exception {
        String[] commandComponents = command.split(" ");
        if (commandComponents[0].equals("most_active_cookie")) {
            fileName = commandComponents[1];
            date = commandComponents[3];
        }
        else {
            throw new Exception ("Invalid Command");
        }
    }

    public void getMostActiveCookie() {
        mostActiveCookie.findMostActive();
        mostActiveCookie.displayActiveCookies(new CookiePresenter());
    }

}
