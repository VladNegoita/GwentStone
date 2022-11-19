package main;

import cards.Card;

import java.util.ArrayList;

public class Table {
    private Player player1, player2;
    ArrayList<ArrayList<Card>> table;
    private int currentPlayer;
    private int endedTurns = 0, currentRound = 1;

    public int getEndedTurns() {
        return endedTurns;
    }

    public void setEndedTurns(int endedTurns) {
        this.endedTurns = endedTurns;
    }

    public int getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(int currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public Player getPlayer1() {
        return player1;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public ArrayList<ArrayList<Card>> getTable() {
        return table;
    }

    public void setTable(ArrayList<ArrayList<Card>> table) {
        this.table = table;
    }

    public void refresh() {
        if (this.endedTurns == 2) {
            this.endedTurns = 0;
            this.currentRound += 1;

            this.player1.setMana(this.player1.getMana() + this.currentRound);
            this.player2.setMana(this.player2.getMana() + this.currentRound);
        }
    }
}
