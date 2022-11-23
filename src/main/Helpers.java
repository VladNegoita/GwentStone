package main;

import cards.Card;
import fileio.DecksInput;

import java.util.ArrayList;

import static cards.Card.getCard;
import static cards.Card.getCardDeepCopy;

public final class Helpers {

    /**
     *
     * @param decksInput decks in DecksInput format
     * @return decks in ArrayList<ArrayList<Card>> format
     */
    public static ArrayList<ArrayList<Card>> getDecks(final DecksInput decksInput) {
        ArrayList<ArrayList<Card>> decks = new ArrayList<>();
        for (int i = 0; i < decksInput.getNrDecks(); ++i) {
            decks.add(new ArrayList<>());
            for (int j = 0; j < decksInput.getNrCardsInDeck(); ++j) {
                decks.get(i).add(getCard(decksInput.getDecks().get(i).get(j)));
            }
        }

        return decks;
    }

    /**
     *
     * @param deck list of cards
     * @return deep copy of the provided deck
     */
    public static ArrayList<Card> getDeepCopy(final ArrayList<Card> deck) {
        ArrayList<Card> newDeck = new ArrayList<>();

        for (Card card : deck) {
            newDeck.add(getCardDeepCopy(card));
        }

        return newDeck;
    }

    /**
     *
     * @param table matrix of cards
     * @return deep copy of the matrix
     */
    public static ArrayList<ArrayList<Card>> getDeepCopyTable(
            final ArrayList<ArrayList<Card>> table) {
        ArrayList<ArrayList<Card>> newTable = new ArrayList<>();
        for (ArrayList<Card> row : table) {
            newTable.add(getDeepCopy(row));
        }

        return newTable;
    }

    /**
     *
     * @return if the card is environment
     */
    public static boolean isEnvironment(final Card card) {
        return switch (card.getName()) {
            case "Firestorm", "Heart Hound", "Winterfell" -> true;
            default -> false;
        };
    }

    /**
     *
     * @param table current game configuration
     * @return current player
     */
    public static Player getCurrentPlayer(final Table table) {
        return (table.getCurrentPlayerIdx() == 1 ? table.getPlayer1() : table.getPlayer2());
    }

    /**
     *
     * @return if the card is a tank
     */
    public static boolean isTank(final Card card) {
        return switch (card.getName()) {
            case "Goliath", "Warden" -> true;
            default -> false;
        };
    }

    /**
     *
     * @param table
     * @param playerIdx index of the player
     * @return if the player has tank cards
     */
    public static boolean hasTank(final Table table, final int playerIdx) {
        int left, right;
        if (playerIdx == 1) {
            left = Constants.ROWCOUNT / 2;
            right = Constants.ROWCOUNT - 1;
        } else {
            left = 0;
            right = Constants.ROWCOUNT / 2 - 1;
        }

        for (int row = left; row <= right; ++row) {
            for (Card card : table.getTable().get(row)) {
                if (isTank(card)) {
                    return true;
                }
            }
        }

        return false;
    }

    /**
     *
     * @param playerIdx the index of a player
     * @return the index of the other player
     */
    public static int theOtherPlayerIdx(final int playerIdx) {
        return 1 + 2 - playerIdx;
    }
    private Helpers() {

    }
}
