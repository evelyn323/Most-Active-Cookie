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

    // Date to get cookies for
    private final String date;

    /**
     * Constructor for this class. Initializes necessary instance attributes.
     * @param date date to get most active cookies for
     * @param fileName the cookie file to get data from
     */
    public MostActiveCookie(String date, String fileName) throws Exception {
        this.cookiesOnDate = new CookiesOnDate();
        cookiesOnDate.collectCookies(fileName);
        this.date = date;
    }

    /**
     * Find the most active cookies on this date
     */
    public void findMostActive() {
        activeCookies = new ArrayList<>();

        String[] cookies = cookiesOnDate.getDatesOfCookies().get(date);
        Arrays.sort(cookies); // sort array so all the same cookies are together

        int mostOccurrences = 0; // The greatest number of times any cookie has appeared
        int currentOccurrences = 0; // The number of times current cookie has appeared
        String currentCookie = "";

        for (String cookie: cookies) {
            if (currentCookie.equals(cookie)) {
                currentOccurrences += 1;
            }
            else {
                if (currentOccurrences > mostOccurrences) {
                    // If current occurrences is greater than previous maximum, can discard previously stored cookies.
                    mostOccurrences = currentOccurrences;
                    activeCookies = new ArrayList<>();
                    activeCookies.add(cookie);
                }
                else if (currentOccurrences == mostOccurrences) {
                    // If current occurrences is same as previous maximum, add the cookie to the array list
                    activeCookies.add(cookie);
                }
                // setup for next cookie
                currentCookie = cookie;
                currentOccurrences = 0;
            }
        }

    }

    /**
     * pass the most active cookies on the date given to this class in the constructor to the presenter class
     */
    public void displayActiveCookies(CookiesPresentable cookiesPresentable) {
        cookiesPresentable.displayMostActiveCookies(activeCookies.toArray(new String[0]));
    }

}
