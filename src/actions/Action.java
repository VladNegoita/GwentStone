package actions;

import com.fasterxml.jackson.databind.node.ObjectNode;
import fileio.ActionsInput;
import main.Table;

public abstract class Action {
    private String command;

    public Action(final String command) {
        this.command = command;
    }

    /**
     *
     * @return the desired action's name
     */
    public String getCommand() {
        return command;
    }

    /**
     *
     * @param command - the desired action's name
     */
    public void setCommand(final String command) {
        this.command = command;
    }

    /**
     *
     * @param table - the game configuration
     * @return output in JSON format
     */
    public abstract ObjectNode apply(Table table);

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
            default -> null;
        };
    }
}
