package controller;

import presenter.MostActiveCookiePresenter;
import usecase.MostActiveCookie;


/**
 * Receives and interprets the parameters passed in the Most Active Cookie command
 */
public class MostActiveCookieController {
    private String date;
    private String fileName;
    private final MostActiveCookie mostActiveCookie;

    /**
     * Constructor for this class
     */
    public MostActiveCookieController() {
        mostActiveCookie = new MostActiveCookie();
    }


    /**
     * Get the most active cookie (displayed by presenter)
     * @param command the command the user entered
     */
    public void getMostActiveCookie(String command) throws Exception{
        processCommandInput(command);

        mostActiveCookie.setDate(date);
        mostActiveCookie.findMostActive(fileName);

        mostActiveCookie.displayActiveCookies(new MostActiveCookiePresenter());
    }

    /**
     * Process the command input to get the fileName and date and call on respective use case
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

}
