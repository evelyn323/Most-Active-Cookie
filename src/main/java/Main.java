import ui.CookieCommandUserInput;

/**
 * The main class that starts the program
 */
public class Main {

    /**
     * Method that starts the program
     */
    @SuppressWarnings("InfiniteLoopStatement")
    public static void main(String[] args) {
        while (true) {
            CookieCommandUserInput cookieCommandUserInput = new CookieCommandUserInput();
            cookieCommandUserInput.collectCommand();
        }
    }
}
