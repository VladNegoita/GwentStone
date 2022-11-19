package main;

import cards.Card;

import java.util.ArrayList;

public class Table {
    private Player player1, player2;
    ArrayList<ArrayList<Card>> table;

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
}
