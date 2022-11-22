package main;

public final class Stats {
    private static int gamesPlayed = 0;
    private static int playerOneWins = 0;
    private static int playerTwoWins = 0;

    public static int getGamesPlayed() {
        return gamesPlayed;
    }

    public static int getPlayerOneWins() {
        return playerOneWins;
    }

    public static int getPlayerTwoWins() {
        return playerTwoWins;
    }

    /**
     * Method that should be called in case player one won a game
     */
    public static void playerOneWon() {
        gamesPlayed += 1;
        playerOneWins += 1;
    }

    /**
     * Method that should be called in case player two won a game
     */
    public static void playerTwoWon() {
        gamesPlayed += 1;
        playerTwoWins += 1;
    }

    /**
     *
     */
    public static void resetStats() {
        gamesPlayed = 0;
        playerOneWins = 0;
        playerTwoWins = 0;
    }

    private Stats() {

    }
}
