package usecase;

/**
 * Interface that defines methods the presenter needs to display the cookies the use case passes in
 */
public interface CookiesPresentable {
    /**
     * Display these cookies
     * @param cookies The array of cookies to display
     */
    void displayMostActiveCookies(String[] cookies);
}
