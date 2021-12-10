package gateway;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Scanner;

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

        File f = new File(fileName);
        FileInputStream fileInputStream = new FileInputStream(f);
        Scanner scanner = new Scanner(fileInputStream);

        while (scanner.hasNextLine()) {
            fileLines.add(scanner.nextLine());
        }
        return fileLines.toArray(new String[0]);
    }

}
