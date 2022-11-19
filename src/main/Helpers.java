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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;

public class Helpers {
    public static Card getCard(CardInput cardInput) {
        Card newCard;
        switch (cardInput.getName()) {
            case "Firestorm":
                newCard = new Firestorm(cardInput.getMana(), cardInput.getDescription(), cardInput.getColors(),
                        cardInput.getName());
                break;
            case "Heart Hound":
                newCard = new HeartHound(cardInput.getMana(), cardInput.getDescription(), cardInput.getColors(),
                        cardInput.getName());
                break;
            case "Winterfell":
                newCard = new Winterfell(cardInput.getMana(), cardInput.getDescription(), cardInput.getColors(),
                        cardInput.getName());
                break;
            case "Empress Thorina":
                newCard = new EmpressThorina(cardInput.getMana(), cardInput.getDescription(), cardInput.getColors(),
                        cardInput.getName());
                break;
            case "General Kocioraw":
                newCard = new GeneralKocioraw(cardInput.getMana(), cardInput.getDescription(), cardInput.getColors(),
                        cardInput.getName());
                break;
            case "King Mudface":
                newCard = new KingMudface(cardInput.getMana(), cardInput.getDescription(), cardInput.getColors(),
                        cardInput.getName());
                break;
            case "Lord Royce":
                newCard = new LordRoyce(cardInput.getMana(), cardInput.getDescription(), cardInput.getColors(),
                        cardInput.getName());
                break;
            case "Miraj":
                newCard = new Miraj(cardInput.getMana(), cardInput.getDescription(), cardInput.getColors(),
                        cardInput.getName(), cardInput.getHealth(), cardInput.getAttackDamage());
                break;
            case "Disciple":
                newCard = new Disciple(cardInput.getMana(), cardInput.getDescription(), cardInput.getColors(),
                        cardInput.getName(), cardInput.getHealth(), cardInput.getAttackDamage());
            case "The Cursed One":
                newCard = new TheCursedOne(cardInput.getMana(), cardInput.getDescription(), cardInput.getColors(),
                        cardInput.getName(), cardInput.getHealth(), cardInput.getAttackDamage());
                break;
            case "The Ripper":
                newCard = new TheRipper(cardInput.getMana(), cardInput.getDescription(), cardInput.getColors(),
                        cardInput.getName(), cardInput.getHealth(), cardInput.getAttackDamage());
                break;
            default:
                newCard = new Minion(cardInput.getMana(), cardInput.getDescription(), cardInput.getColors(),
                        cardInput.getName(), cardInput.getHealth(), cardInput.getAttackDamage());
        }

        return newCard;
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

        table.getPlayer1().setHero((Hero)getCard(startGame.getPlayerOneHero()));
        table.getPlayer2().setHero((Hero)getCard(startGame.getPlayerTwoHero()));

        ArrayList<Card> deck1 = new ArrayList<>(table.getPlayer1().getDecks().get(startGame.getPlayerOneDeckIdx()));
        Collections.shuffle(deck1, new Random(startGame.getShuffleSeed()));
        ArrayList<Card> deck2 = new ArrayList<>(table.getPlayer2().getDecks().get(startGame.getPlayerTwoDeckIdx()));
        Collections.shuffle(deck2, new Random(startGame.getShuffleSeed()));

        table.getPlayer1().setCurrentDeck(new ArrayList<>(deck1));
        table.getPlayer2().setCurrentDeck(new ArrayList<>(deck2));

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
            default -> null;
        };
    }
}
