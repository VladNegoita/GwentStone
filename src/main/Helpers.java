package main;

import actions.*;
import cards.Card;
import cards.EnvironmentCards.Firestorm;
import cards.EnvironmentCards.HeartHound;
import cards.EnvironmentCards.Winterfell;
import cards.HeroCards.EmpressThorina;
import cards.HeroCards.GeneralKocioraw;
import cards.HeroCards.Hero;
import cards.HeroCards.KingMudface;
import cards.HeroCards.LordRoyce;
import cards.MinionCards.Disciple;
import cards.MinionCards.Minion;
import cards.MinionCards.Miraj;
import cards.MinionCards.TheCursedOne;
import cards.MinionCards.TheRipper;
import fileio.ActionsInput;
import fileio.CardInput;
import fileio.DecksInput;
import fileio.StartGameInput;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public final class Helpers {
    public static Card getCard(CardInput cardInput) {
        return switch (cardInput.getName()) {
            case "Firestorm" -> new Firestorm(cardInput.getMana(), cardInput.getDescription(), cardInput.getColors(),
                        cardInput.getName());
            case "Heart Hound" -> new HeartHound(cardInput.getMana(), cardInput.getDescription(), cardInput.getColors(),
                        cardInput.getName());
            case "Winterfell" -> new Winterfell(cardInput.getMana(), cardInput.getDescription(), cardInput.getColors(),
                        cardInput.getName());
            case "Empress Thorina" -> new EmpressThorina(cardInput.getMana(), cardInput.getDescription(),
                    cardInput.getColors(),
                        cardInput.getName());
            case "General Kocioraw" -> new GeneralKocioraw(cardInput.getMana(), cardInput.getDescription(),
                    cardInput.getColors(),
                        cardInput.getName());
            case "King Mudface" -> new KingMudface(cardInput.getMana(), cardInput.getDescription(),
                    cardInput.getColors(),
                        cardInput.getName());
            case "Lord Royce" -> new LordRoyce(cardInput.getMana(), cardInput.getDescription(),
                    cardInput.getColors(),
                        cardInput.getName());
            case "Miraj" -> new Miraj(cardInput.getMana(), cardInput.getDescription(), cardInput.getColors(),
                        cardInput.getName(), cardInput.getHealth(), cardInput.getAttackDamage());
            case "Disciple" -> new Disciple(cardInput.getMana(), cardInput.getDescription(), cardInput.getColors(),
                        cardInput.getName(), cardInput.getHealth(), cardInput.getAttackDamage());
            case "The Cursed One" -> new TheCursedOne(cardInput.getMana(), cardInput.getDescription(),
                    cardInput.getColors(),
                        cardInput.getName(), cardInput.getHealth(), cardInput.getAttackDamage());
            case "The Ripper" -> new TheRipper(cardInput.getMana(), cardInput.getDescription(), cardInput.getColors(),
                        cardInput.getName(), cardInput.getHealth(), cardInput.getAttackDamage());
            default -> new Minion(cardInput.getMana(), cardInput.getDescription(), cardInput.getColors(),
                        cardInput.getName(), cardInput.getHealth(), cardInput.getAttackDamage());
        };
    }

    public static Card getCardDeep(Card card) {
        return switch (card.getName()) {
            case "Firestorm" -> new Firestorm(card);
            case "Heart Hound" -> new HeartHound(card);
            case "Winterfell" -> new Winterfell(card);
            case "Empress Thorina" -> new EmpressThorina(card);
            case "General Kocioraw" -> new GeneralKocioraw(card);
            case "King Mudface" -> new KingMudface(card);
            case "Lord Royce" -> new LordRoyce(card);
            case "Miraj" -> new Miraj(card);
            case "Disciple" -> new Disciple(card);
            case "The Cursed One" -> new TheCursedOne(card);
            case "The Ripper" -> new TheRipper(card);
            default -> new Minion(card);
        };
    }

    public static ArrayList<ArrayList<Card>> getDecks(DecksInput decksInput) {
        ArrayList<ArrayList<Card>> decks = new ArrayList<>();
        for (int i = 0; i < decksInput.getNrDecks(); ++i) {
            decks.add(new ArrayList<>());
            for (int j = 0; j < decksInput.getNrCardsInDeck(); ++j) {
                decks.get(i).add(getCard(decksInput.getDecks().get(i).get(j)));
            }
        }

        return decks;
    }

    public static void loadStartGame(Table table, StartGameInput startGame) {
        table.setTable(new ArrayList<>());
        table.getTable().add(new ArrayList<>());
        table.getTable().add(new ArrayList<>());
        table.getTable().add(new ArrayList<>());
        table.getTable().add(new ArrayList<>());

        table.getPlayer1().setHero((Hero)getCard(startGame.getPlayerOneHero()));
        table.getPlayer2().setHero((Hero)getCard(startGame.getPlayerTwoHero()));

        ArrayList<Card> deck1 = getDeepCopy(table.getPlayer1().getDecks().get(startGame.getPlayerOneDeckIdx()));
        Collections.shuffle(deck1, new Random(startGame.getShuffleSeed()));
        ArrayList<Card> deck2 = getDeepCopy(table.getPlayer2().getDecks().get(startGame.getPlayerTwoDeckIdx()));
        Collections.shuffle(deck2, new Random(startGame.getShuffleSeed()));

        table.getPlayer1().setCurrentDeck(deck1);
        table.getPlayer2().setCurrentDeck(deck2);

        table.getPlayer1().setHand(new ArrayList<>());
        table.getPlayer1().getHand().add(table.getPlayer1().getCurrentDeck().get(0));
        table.getPlayer1().getCurrentDeck().remove(0);
        table.getPlayer2().setHand(new ArrayList<>());
        table.getPlayer2().getHand().add(table.getPlayer2().getCurrentDeck().get(0));
        table.getPlayer2().getCurrentDeck().remove(0);

        table.setCurrentPlayer(startGame.getStartingPlayer());

        table.getPlayer1().setMana(1);
        table.getPlayer2().setMana(1);
    }

    public static Action getAction(ActionsInput actionInput) {

        return switch (actionInput.getCommand()) {
            case "getPlayerDeck" -> new GetPlayerDeck(actionInput.getCommand(), actionInput.getPlayerIdx());
            case "getPlayerHero" -> new GetPlayerHero(actionInput.getCommand(), actionInput.getPlayerIdx());
            case "getPlayerTurn" -> new GetPlayerTurn(actionInput.getCommand());
            case "endPlayerTurn" -> new EndPlayerTurn(actionInput.getCommand());
            case "placeCard" -> new PlaceCard(actionInput.getCommand(), actionInput.getHandIdx());
            case "getCardsInHand" -> new GetCardsInHand(actionInput.getCommand(), actionInput.getPlayerIdx());
            case "getPlayerMana" -> new GetPlayerMana(actionInput.getCommand(), actionInput.getPlayerIdx());
            case "getCardsOnTable" -> new GetCardsOnTable(actionInput.getCommand());
            case "getEnvironmentCardsInHand" -> new GetEnvironmentCardsInHand(actionInput.getCommand(),
                    actionInput.getPlayerIdx());
            case "useEnvironmentCard" -> new UseEnvironmentCard(actionInput.getCommand(), actionInput.getHandIdx(),
                    actionInput.getAffectedRow());
            case "getCardAtPosition" -> new GetCardAtPosition(actionInput.getCommand(), actionInput.getX(),
                    actionInput.getY());
            case "getFrozenCardsOnTable" -> new GetFrozenCardsOnTable(actionInput.getCommand());
            default -> new EndPlayerTurn(actionInput.getCommand());
        };
    }

    public static ArrayList<Card> getDeepCopy(ArrayList<Card> deck) {
        ArrayList<Card> newDeck = new ArrayList<>();

        for (Card card : deck)
            newDeck.add(getCardDeep(card));

        return newDeck;
    }

    public static ArrayList<ArrayList<Card>> getDeepCopyTable(ArrayList<ArrayList<Card>> table) {
        ArrayList<ArrayList<Card>> newTable = new ArrayList<>();
        for (ArrayList<Card> row : table)
            newTable.add(getDeepCopy(row));

        return newTable;
    }

    public static boolean isEnvironment(Card card) {
        return switch(card.getName()) {
            case "Firestorm", "Heart Hound", "Winterfell" -> true;
            default -> false;
        };
    }

    public static Player getCurrentPlayer(Table table) {
        return (table.getCurrentPlayer() == 1 ? table.getPlayer1() : table.getPlayer2());
    }
}
