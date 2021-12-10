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
            String[] expected = new String[]{"cookie1,2018-12-09T14:19:00+00:00", "cookie2,2018-12-09T10:13:00+00:00",
            "cookie3,2018-12-09T07:25:00+00:00", "cookie1,2018-12-09T06:19:00+00:00", "cookie2,2018-12-08T22:03:00+00:00",
            "cookie4,2018-12-08T21:30:00+00:00", "cookie5,2018-12-08T09:30:00+00:00", "cookie4,2018-12-07T23:30:00+00:00"};
            String[] fileContents = csvFileReader.readFile("src/test/resources/test1.csv");
            assert(Arrays.equals(expected, fileContents));
        }
        catch (Exception ignored) {
            assert false;
        }
    }
}
