package main;

import cards.Card;
import cards.HeroCards.Hero;

import java.util.ArrayList;

public class Player {
    private Hero hero;
    private ArrayList <Card> hand;
    private ArrayList <Card> currentDeck;
    private ArrayList <ArrayList<Card>> decks;
    private int mana;

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public ArrayList<Card> getCurrentDeck() {
        return currentDeck;
    }

    public void setCurrentDeck(ArrayList<Card> currentDeck) {
        this.currentDeck = currentDeck;
    }


    public ArrayList<Card> getHand() {
        return hand;
    }

    public void setHand(ArrayList<Card> hand) {
        this.hand = hand;
    }

    public ArrayList<ArrayList<Card>> getDecks() {
        return decks;
    }

    public void setDecks(ArrayList<ArrayList<Card>> decks) {
        this.decks = decks;
    }

    public Hero getHero() {
        return hero;
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }
}
