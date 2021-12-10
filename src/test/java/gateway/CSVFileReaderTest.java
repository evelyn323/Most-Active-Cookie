package gateway;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

/**
 * Test the CSVFileReader class
 */
public class CSVFileReaderTest {
    private CSVFileReader csvFileReader;

    /**
     * Setup before tests
     */
    @Before
    public void setup() {
        csvFileReader = new CSVFileReader();
    }

    /**
     * Test the readFile method
     */
    @Test
    public void testReadFile() {
        try {
            String[] expected = new String[]{"cookie1, timestamp1", "cookie2, timestamp2"};
            String[] fileContents = csvFileReader.readFile("src/test/resources/test1.csv");
            assert(Arrays.equals(expected, fileContents));
        }
        catch (Exception ignored) {
            assert false;
        }
    }
}
