package actions;

import cards.Card;
import cards.MinionCards.Minion;
import cards.MinionCards.SpecialAbilityMinion;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import fileio.Coordinates;
import main.Constants;
import main.Helpers;
import main.Table;

public final class CardUsesAbility extends Action {

    private Coordinates cardAttacker;
    private Coordinates cardAttacked;

    public Coordinates getCardAttacker() {
        return cardAttacker;
    }

    public void setCardAttacker(final Coordinates cardAttacker) {
        this.cardAttacker = cardAttacker;
    }

    public Coordinates getCardAttacked() {
        return cardAttacked;
    }

    public void setCardAttacked(final Coordinates cardAttacked) {
        this.cardAttacked = cardAttacked;
    }

    @Override
    public String getCommand() {
        return super.getCommand();
    }

    @Override
    public void setCommand(final String command) {
        super.setCommand(command);
    }

    public CardUsesAbility(final String command, final Coordinates cardAttacker, final Coordinates
            cardAttacked) {
        super(command);
        this.cardAttacker = cardAttacker;
        this.cardAttacked = cardAttacked;
    }

    @Override
    public ObjectNode apply(final Table table) {
        final ObjectMapper mapper = new ObjectMapper();
        ObjectNode output = mapper.createObjectNode();
        output.put("command", this.getCommand());
        output.putPOJO("cardAttacker", this.cardAttacker);
        output.putPOJO("cardAttacked", this.cardAttacked);

        Card attacked = table.getTable().get(this.cardAttacked.getX()).
                get(this.cardAttacked.getY());
        Card attacker = table.getTable().get(this.cardAttacker.getX()).
                get(this.cardAttacker.getY());

        if (((Minion) attacker).isFrozen()) {
            output.put("error", "Attacker card is frozen.");
            return output;
        }

        if (((Minion) attacker).isUsed()) {
            output.put("error", "Attacker card has already attacked this turn.");
            return output;
        }

        if (attacker.getName().equals("Disciple")) {
            if ((table.getCurrentPlayerIdx() == 1 && this.cardAttacked.getX() <= 1)
                    || (table.getCurrentPlayerIdx() == 2 && this.cardAttacked.getX() >= 2)) {
                output.put("error", "Attacked card does not belong to the current player.");
                return output;
            }
        } else {
            if ((table.getCurrentPlayerIdx() == 1 && this.cardAttacked.getX() >= 2)
                    || (table.getCurrentPlayerIdx() == 2 && this.cardAttacked.getX() <= 1)) {
                output.put("error", "Attacked card does not belong to the enemy.");
                return output;
            }

            if (Helpers.hasTank(table, Constants.ROWCOUNT - 1 - table.getCurrentPlayerIdx())
                    && !Helpers.isTank(attacked)) {
                output.put("error", "Attacked card is not of type 'Tank'.");
                return output;
            }
        }

        ((SpecialAbilityMinion) attacker).specialAbility(table,
                this.cardAttacked.getX(), this.cardAttacked.getY());
        ((SpecialAbilityMinion) attacker).setUsed(true);

        return null;
    }
}
