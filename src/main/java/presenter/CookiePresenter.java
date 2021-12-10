package main.java.presenter;

import main.java.usecase.CookiesPresentable;
import main.java.ui.CookieView;

/**
 * Class that tells the view which cookies to display
 */
public class CookiePresenter implements CookiesPresentable {
    private CookieView cookieView;

    /**
     * Constructor for this class. Creates a new cookieView to display the cookies received
     */
    public CookiePresenter() {
        cookieView = new CookieView();
    }
    /**
     * Tell the view to display these cookies
     * @param cookies The array of cookies to display
     */
    @Override
    public void displayMostActiveCookies(String[] cookies) {
        for (String cookie: cookies) {
            cookieView.displayCookie(cookie);
        }
    }
}
