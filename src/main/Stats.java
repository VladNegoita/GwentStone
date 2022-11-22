package main;

public class Stats {
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

    public static void PlayerOneWon() {
        gamesPlayed += 1;
        playerOneWins += 1;
    }

    public static void PlayerTwoWon() {
        gamesPlayed += 1;
        playerTwoWins += 1;
    }
}
