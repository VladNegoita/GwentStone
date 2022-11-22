package main;

import actions.Action;
import actions.CardUsesAbility;
import actions.CardUsesAttack;
import actions.EndPlayerTurn;
import actions.GetCardAtPosition;
import actions.GetCardsInHand;
import actions.GetCardsOnTable;
import actions.GetEnvironmentCardsInHand;
import actions.GetFrozenCardsOnTable;
import actions.GetPlayerDeck;
import actions.GetPlayerHero;
import actions.GetPlayerMana;
import actions.GetPlayerOneWins;
import actions.GetPlayerTurn;
import actions.GetPlayerTwoWins;
import actions.GetTotalGamesPlayed;
import actions.PlaceCard;
import actions.UseAttackHero;
import actions.UseEnvironmentCard;
import actions.UseHeroAbility;
import cards.Card;
import cards.EnvironmentCards.Firestorm;
import cards.EnvironmentCards.HeartHound;
import cards.EnvironmentCards.Winterfell;
import cards.HeroCards.EmpressThorina;
import cards.HeroCards.GeneralKocioraw;
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

import java.util.ArrayList;

public final class Helpers {
    /**
     *
     * @param cardInput Card in CardInput format
     * @return Card in Card format
     */
    public static Card getCard(final CardInput cardInput) {
        return switch (cardInput.getName()) {
            case "Firestorm" -> new Firestorm(cardInput.getMana(), cardInput.getDescription(),
                    cardInput.getColors(), cardInput.getName());
            case "Heart Hound" -> new HeartHound(cardInput.getMana(), cardInput.getDescription(),
                    cardInput.getColors(), cardInput.getName());
            case "Winterfell" -> new Winterfell(cardInput.getMana(), cardInput.getDescription(),
                    cardInput.getColors(), cardInput.getName());
            case "Empress Thorina" -> new EmpressThorina(cardInput.getMana(),
                    cardInput.getDescription(), cardInput.getColors(), cardInput.getName());
            case "General Kocioraw" -> new GeneralKocioraw(cardInput.getMana(),
                    cardInput.getDescription(), cardInput.getColors(), cardInput.getName());
            case "King Mudface" -> new KingMudface(cardInput.getMana(), cardInput.getDescription(),
                    cardInput.getColors(), cardInput.getName());
            case "Lord Royce" -> new LordRoyce(cardInput.getMana(), cardInput.getDescription(),
                    cardInput.getColors(), cardInput.getName());
            case "Miraj" -> new Miraj(cardInput.getMana(), cardInput.getDescription(),
                    cardInput.getColors(), cardInput.getName(), cardInput.getHealth(),
                    cardInput.getAttackDamage());
            case "Disciple" -> new Disciple(cardInput.getMana(), cardInput.getDescription(),
                    cardInput.getColors(), cardInput.getName(), cardInput.getHealth(),
                    cardInput.getAttackDamage());
            case "The Cursed One" -> new TheCursedOne(cardInput.getMana(),
                    cardInput.getDescription(), cardInput.getColors(),
                    cardInput.getName(), cardInput.getHealth(), cardInput.getAttackDamage());
            case "The Ripper" -> new TheRipper(cardInput.getMana(), cardInput.getDescription(),
                    cardInput.getColors(), cardInput.getName(), cardInput.getHealth(),
                    cardInput.getAttackDamage());
            default -> new Minion(cardInput.getMana(), cardInput.getDescription(),
                    cardInput.getColors(), cardInput.getName(), cardInput.getHealth(),
                    cardInput.getAttackDamage());
        };
    }

    /**
     *
     * @param card - card to be copied
     * @return deep copy of the card
     */
    public static Card getCardDeep(final Card card) {
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
     * @param actionInput action in ActionsInput format
     * @return action in Action format
     */
    public static Action getAction(final ActionsInput actionInput) {

        return switch (actionInput.getCommand()) {
            case "getPlayerDeck" -> new GetPlayerDeck(actionInput.getCommand(),
                    actionInput.getPlayerIdx());
            case "getPlayerHero" -> new GetPlayerHero(actionInput.getCommand(),
                    actionInput.getPlayerIdx());
            case "getPlayerTurn" -> new GetPlayerTurn(actionInput.getCommand());
            case "endPlayerTurn" -> new EndPlayerTurn(actionInput.getCommand());
            case "placeCard" -> new PlaceCard(actionInput.getCommand(), actionInput.getHandIdx());
            case "getCardsInHand" -> new GetCardsInHand(actionInput.getCommand(),
                    actionInput.getPlayerIdx());
            case "getPlayerMana" -> new GetPlayerMana(actionInput.getCommand(),
                    actionInput.getPlayerIdx());
            case "getCardsOnTable" -> new GetCardsOnTable(actionInput.getCommand());
            case "getEnvironmentCardsInHand" -> new GetEnvironmentCardsInHand(
                    actionInput.getCommand(), actionInput.getPlayerIdx());
            case "useEnvironmentCard" -> new UseEnvironmentCard(actionInput.getCommand(),
                    actionInput.getHandIdx(), actionInput.getAffectedRow());
            case "getCardAtPosition" -> new GetCardAtPosition(actionInput.getCommand(),
                    actionInput.getX(), actionInput.getY());
            case "getFrozenCardsOnTable" -> new GetFrozenCardsOnTable(
                    actionInput.getCommand());
            case "cardUsesAttack" -> new CardUsesAttack(actionInput.getCommand(),
                    actionInput.getCardAttacker(), actionInput.getCardAttacked());
            case "cardUsesAbility" -> new CardUsesAbility(actionInput.getCommand(),
                    actionInput.getCardAttacker(), actionInput.getCardAttacked());
            case "useAttackHero" -> new UseAttackHero(actionInput.getCommand(),
                    actionInput.getCardAttacker());
            case "useHeroAbility" -> new UseHeroAbility(actionInput.getCommand(),
                    actionInput.getAffectedRow());
            case "getTotalGamesPlayed" -> new GetTotalGamesPlayed(actionInput.getCommand());
            case "getPlayerOneWins" -> new GetPlayerOneWins(actionInput.getCommand());
            case "getPlayerTwoWins" -> new GetPlayerTwoWins(actionInput.getCommand());
            default -> new EndPlayerTurn(actionInput.getCommand());
        };
    }

    /**
     *
     * @param deck list of cards
     * @return deep copy of the provided deck
     */
    public static ArrayList<Card> getDeepCopy(final ArrayList<Card> deck) {
        ArrayList<Card> newDeck = new ArrayList<>();

        for (Card card : deck) {
            newDeck.add(getCardDeep(card));
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
     * @param card
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
     * @param card
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
