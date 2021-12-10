package usecase;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;


/**
 * Test the MostActiveCookie method
 */
public class MostActiveCookieTest {
    private MostActiveCookie mostActiveCookie;

    /**
     * Setup before tests
     */
    @Before
    public void setup() {
        mostActiveCookie = new MostActiveCookie();

    }

    /**
     * Test the findMostActive method when there is one most active cookie for a date
     */
    @Test
    public void testFindMostActiveOne() {
        try{
            String[] expected = new String[]{"cookie1"};
            mostActiveCookie.setDate("2018-12-09");
            mostActiveCookie.findMostActive("src/test/resources/test1.csv");
            String[] actual = mostActiveCookie.getActiveCookies();
            assert(Arrays.equals(expected, actual));
        }
        catch (Exception ignored) {
            assert false;
        }

    }

    /**
     * Test the findMostActive method when there is more than one most active cookie for a date
     */
    @Test
    public void testFindMostActiveMoreThanOne() {
        try{
            String[] expected = new String[]{"cookie2", "cookie4", "cookie5"};
            mostActiveCookie.setDate("2018-12-08");
            mostActiveCookie.findMostActive("src/test/resources/test1.csv");
            String[] actual = mostActiveCookie.getActiveCookies();
            assert(Arrays.equals(expected, actual));
        }
        catch (Exception ignored) {
            assert false;
        }
    }

    /**
     * Test the findMostActive method when there is only one cookie for a date
     */
    @Test
    public void testFindMostActiveOneOnDate() {
        try{
            String[] expected = new String[]{"cookie4"};
            mostActiveCookie.setDate("2018-12-07");
            mostActiveCookie.findMostActive("src/test/resources/test1.csv");
            String[] actual = mostActiveCookie.getActiveCookies();
            assert(Arrays.equals(expected, actual));
        }
        catch (Exception ignored) {
            assert false;
        }
    }

}
