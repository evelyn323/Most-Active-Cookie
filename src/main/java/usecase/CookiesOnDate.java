package usecase;

import gateway.CSVFileReader;
import gateway.Readable;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Collect the list of cookies that occurred on a given date. Exact timestamps are ignored.
 */
public class CookiesOnDate {
    // Hashmap with dates as keys referring to an array of cookies that occurred on that date
    private HashMap<String, String[]> datesOfCookies;


    // The file reader interface
    private final Readable fileReader;

    /**
     * The constructor for this class
     */
    public CookiesOnDate() {
        this.fileReader = new CSVFileReader();
    }

    /**
     * Collect the dates and their respective cookies into a hashmap
     * @param fileName name of cookie log file
     * @throws Exception file not found
     */
    public void collectCookies(String fileName) throws Exception {
        datesOfCookies = new HashMap<>();
        String[] fileLines = fileReader.readFile(fileName);
        String currentDate = "";

        String[] cookieAndDate;
        String date;
        String cookie;

        ArrayList<String> cookiesOnDate = new ArrayList<>();
        for (String line : fileLines) {
            cookieAndDate = line.split(",");
            cookie = cookieAndDate[0];
            date = dateFromTimeStamp(cookieAndDate[1]);

            if (!currentDate.equals(date) && !currentDate.equals("")){
                datesOfCookies.put(currentDate, cookiesOnDate.toArray(new String[0]));
                cookiesOnDate = new ArrayList<>();
            }
            cookiesOnDate.add(cookie);

            currentDate = date;
        }
        // add last timestamp to hashmap
        datesOfCookies.put(currentDate, cookiesOnDate.toArray(new String[0]));

    }

    /**
     * Helper method to process the timestamp of the cookie
     * @param timeStamp the timeStamp of the cookie
     * @return the date of the cookie
     */
    private String dateFromTimeStamp(String timeStamp) {
        String[] timeStampComponents = timeStamp.split("T");
        return timeStampComponents[0];
    }

    /**
     * Get the Hashmap of dates referring to cookies occurring on that date
     * @return the Hashmap of dates referring to cookies occurring on that date
     */
    public HashMap<String, String[]> getDatesOfCookies() {
        return datesOfCookies;
    }


}
