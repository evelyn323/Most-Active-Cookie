package usecase;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Class that checks the array of cookies on a given day to get the most active cookies that day
 */
public class MostActiveCookie {
    // Contains the most active cookies on that date
    private ArrayList<String> activeCookies;

    // To get the cookies that occurred on that date
    private final CookiesOnDate cookiesOnDate;

    private String date;


    /**
     * Constructor for this class. Initializes necessary instance attributes.
     */
    public MostActiveCookie(){
        this.cookiesOnDate = new CookiesOnDate();
    }

    /**
     * Set the date to get cookies for
     * @param date date to get most active cookies for
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * Find the most active cookies on this date
     * @param fileName the cookie file to get data from
     */
    public void findMostActive(String fileName) throws Exception {
        cookiesOnDate.collectCookies(fileName);

        activeCookies = new ArrayList<>();

        String[] cookies = cookiesOnDate.getDatesOfCookies().get(date);

        Arrays.sort(cookies); // sort array so all the same cookies are together

        int mostOccurrences = 1; // The greatest number of times any cookie has appeared
        int currentOccurrences = 1; // The number of times current cookie has appeared
        String currentCookie = "";

        for (String cookie: cookies) {

            if (currentCookie.equals(cookie)) {
                currentOccurrences += 1;
            }
            else {
                if (mostOccurrences < currentOccurrences) {
                    activeCookies = new ArrayList<>();
                    activeCookies.add(currentCookie);
                    mostOccurrences = currentOccurrences;
                }
                else if (mostOccurrences == currentOccurrences) {
                    activeCookies.add(cookie);
                }
                currentOccurrences = 1;
                currentCookie = cookie;
            }

        }

    }

    /**
     * pass the most active cookies on the date given to this class in the constructor to the presenter class
     */
    public void displayActiveCookies(CookiesPresentable cookiesPresentable) {
        cookiesPresentable.displayMostActiveCookies(activeCookies.toArray(new String[0]));
    }

    /**
     * Get the most active cookies
     * @return the most active cookies on the set date
     */
    public String[] getActiveCookies() {
        return activeCookies.toArray(new String[0]);
    }

}
