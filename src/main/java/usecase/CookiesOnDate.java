package main.java.usecase;

import main.java.gateway.CSVFileReader;
import main.java.gateway.Readable;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Collect the list of cookies that occurred on a given date. Exact timestamps are ignored.
 */
public class CookiesOnDate {
    // Hashmap with dates as keys referring to an array of cookies that occurred on that date
    HashMap<String, String[]> datesOfCookies;

    // The name of the cookie log file
    private final String fileName;

    // The file reader interface
    private final Readable fileReader;

    /**
     * The constructor for this class
     * @param fileName name of cookie log file
     */
    public CookiesOnDate(String fileName) {
        this.fileReader = new CSVFileReader();
        this.fileName = fileName;
    }

    /**
     * Collect the dates and their respective cookies into a hashmap
     * @throws Exception file not found
     */
    public void collectCookies() throws Exception {
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
            if (currentDate.equals(date)) {
                cookiesOnDate.add(cookie);
            }
            else if (!currentDate.equals("")){
                datesOfCookies.put(currentDate, cookiesOnDate.toArray(new String[0]));
                cookiesOnDate = new ArrayList<>();
            }
            currentDate = date;
        }

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
