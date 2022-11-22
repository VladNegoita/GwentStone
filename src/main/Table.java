package main;

import cards.Card;
import cards.MinionCards.Minion;

import java.util.ArrayList;

import static java.lang.Integer.min;

public final class Table {
    private Player player1, player2;
    private ArrayList<ArrayList<Card>> table;
    private int currentPlayerIdx;
    private int endedTurns, currentRound;

    public int getCurrentRound() {
        return currentRound;
    }

    public void setCurrentRound(final int currentRound) {
        this.currentRound = currentRound;
    }

    public int getEndedTurns() {
        return endedTurns;
    }

    public void setEndedTurns(final int endedTurns) {
        this.endedTurns = endedTurns;
    }

    public int getCurrentPlayerIdx() {
        return currentPlayerIdx;
    }

    public void setCurrentPlayerIdx(final int currentPlayerIdx) {
        this.currentPlayerIdx = currentPlayerIdx;
    }

    public Player getPlayer1() {
        return player1;
    }

    public void setPlayer1(final Player player1) {
        this.player1 = player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void setPlayer2(final Player player2) {
        this.player2 = player2;
    }

    public ArrayList<ArrayList<Card>> getTable() {
        return table;
    }

    public void setTable(final ArrayList<ArrayList<Card>> table) {
        this.table = table;
    }

    /**
     * refreshes the configuration of the game:
     *      -> removes dead minions
     *      -> handles ended turns and rounds, mana receiving
     */
    public void refresh() {

        for (int row = 0; row < Constants.ROWCOUNT; ++row) {
            ArrayList<Card> toBeRemoved = new ArrayList<>();

            for (Card card : this.getTable().get(row)) {
                if (((Minion) card).getHealth() <= 0) {
                    toBeRemoved.add(card);
                }
            }

            for (Card card : toBeRemoved) {
                this.getTable().get(row).remove(card);
            }
        }

        if (this.endedTurns == 2) {
            this.endedTurns = 0;
            this.currentRound += 1;

            this.player1.setMana(this.player1.getMana() + min(this.currentRound,
                    Constants.MAXMANA));
            this.player2.setMana(this.player2.getMana() + min(this.currentRound,
                    Constants.MAXMANA));

            if (this.player1.getCurrentDeck().size() > 0) {
                this.player1.getHand().add(this.player1.getCurrentDeck().get(0));
                this.player1.getCurrentDeck().remove(0);
            }

            if (this.player2.getCurrentDeck().size() > 0) {
                this.player2.getHand().add(this.player2.getCurrentDeck().get(0));
                this.player2.getCurrentDeck().remove(0);
            }
        }
    }
}
