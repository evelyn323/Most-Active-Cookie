package main.java.gateway;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * Read a CSV File
 */
public class CSVFileReader implements Readable {

    /**
     * Reads the CSV file given and stores the lines in an array that is returned.
     * @param fileName name of the CSV file to read
     * @return a String array of the lines in the file
     * @throws Exception file not found
     */
    @Override
    public String[] readFile(String fileName) throws Exception{
        ArrayList<String> fileLines = new ArrayList<>();
        String line;
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        while ((line = br.readLine()) != null) {
                fileLines.add(line);
            }
        return fileLines.toArray(new String[0]);
    }

}
