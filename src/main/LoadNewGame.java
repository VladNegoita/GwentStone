package main;

import cards.Card;
import cards.HeroCards.Hero;
import fileio.StartGameInput;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import static cards.Card.getCard;
import static main.Helpers.getDeepCopy;

public final class LoadNewGame {

    private LoadNewGame() {

    }

    /**
     *
     * @param table game configuration
     * @param startGame the data used for starting a game
     */
    public static void loadStartGame(final Table table, final StartGameInput startGame) {
        table.setTable(new ArrayList<>());
        for (int row = 0; row < Constants.ROWCOUNT; ++row) {
            table.getTable().add(new ArrayList<>());
        }

        table.getPlayer1().setHero((Hero) getCard(startGame.getPlayerOneHero()));
        table.getPlayer2().setHero((Hero) getCard(startGame.getPlayerTwoHero()));

        ArrayList<Card> deck1 = getDeepCopy(table.getPlayer1().getDecks().get(
                startGame.getPlayerOneDeckIdx()));
        Collections.shuffle(deck1, new Random(startGame.getShuffleSeed()));
        ArrayList<Card> deck2 = getDeepCopy(table.getPlayer2().getDecks().get(
                startGame.getPlayerTwoDeckIdx()));
        Collections.shuffle(deck2, new Random(startGame.getShuffleSeed()));

        table.getPlayer1().setCurrentDeck(deck1);
        table.getPlayer2().setCurrentDeck(deck2);

        table.getPlayer1().setHand(new ArrayList<>());
        table.getPlayer1().getHand().add(table.getPlayer1().getCurrentDeck().get(0));
        table.getPlayer1().getCurrentDeck().remove(0);

        table.getPlayer2().setHand(new ArrayList<>());
        table.getPlayer2().getHand().add(table.getPlayer2().getCurrentDeck().get(0));
        table.getPlayer2().getCurrentDeck().remove(0);

        table.setCurrentPlayerIdx(startGame.getStartingPlayer());
        table.setEndedTurns(0);
        table.setCurrentRound(1);

        table.getPlayer1().setMana(1);
        table.getPlayer2().setMana(1);
    }
}
