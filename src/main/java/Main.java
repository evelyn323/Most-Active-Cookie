package main.java;

import main.java.ui.CookieCommandUserInput;

/**
 * The main class that starts the program
 */
public class Main {

    @SuppressWarnings("InfiniteLoopStatement")
    public static void main(String[] args) {
        while (true) {
            CookieCommandUserInput cookieCommandUserInput = new CookieCommandUserInput();
            cookieCommandUserInput.collectCommand();
        }
    }
}
