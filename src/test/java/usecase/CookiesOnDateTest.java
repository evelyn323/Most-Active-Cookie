package usecase;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Test the CookiesOnDate class
 */
public class CookiesOnDateTest {
    private CookiesOnDate cookiesOnDate;

    /**
     * Setup before tests
     */
    @Before
    public void setup() {
        cookiesOnDate = new CookiesOnDate();
    }

    @Test
    public void testCollectCookies() {
        try {
            HashMap<String, String[]> expected = new HashMap<>();
            expected.put("2018-12-09", new String[]{"cookie1", "cookie2", "cookie3", "cookie1"});
            expected.put("2018-12-08", new String[]{"cookie2", "cookie4", "cookie5"});
            expected.put("2018-12-07", new String[]{"cookie4"});

            cookiesOnDate.collectCookies("src/test/resources/test1.csv");
            HashMap<String, String[]> actual = cookiesOnDate.getDatesOfCookies();

            assertEquals(expected.keySet(), actual.keySet());
            for (String key: actual.keySet()) {
                assert(Arrays.equals(expected.get(key), actual.get(key)));
            }
        }
        catch (Exception ignored) {
            assert false;
        }

    }

}
