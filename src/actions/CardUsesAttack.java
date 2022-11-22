package actions;

import cards.Card;
import cards.MinionCards.Minion;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import fileio.Coordinates;
import main.Helpers;
import main.Table;

public final class CardUsesAttack extends Action {

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

    public CardUsesAttack(final String command, final Coordinates cardAttacker, final Coordinates cardAttacked) {
        super(command);
        this.cardAttacker = cardAttacker;
        this.cardAttacked = cardAttacked;
    }

    @Override
    public ObjectNode apply(final Table table) {
        final ObjectMapper mapper = new ObjectMapper();
        ObjectNode output = mapper.createObjectNode();
        output.put("command", this.getCommand());
        output.putPOJO("cardAttacker", cardAttacker);
        output.putPOJO("cardAttacked", cardAttacked);

        Minion attacked = (Minion)table.getTable().get(cardAttacked.getX()).get(cardAttacked.getY());
        Minion attacker = (Minion)table.getTable().get(cardAttacker.getX()).get(cardAttacker.getY());
        if ((table.getCurrentPlayer() == 1 && this.cardAttacked.getX() >= 2) ||
                (table.getCurrentPlayer() == 2 && this.cardAttacked.getX() <= 1)) {
            output.put("error", "Attacked card does not belong to the enemy.");
            return output;
        }

        if (attacker.isUsed()) {
            output.put("error", "Attacker card has already attacked this turn.");
            return output;
        }

        if (attacker.isFrozen()) {
            output.put("error", "Attacker card is frozen.");
            return output;
        }

        if (Helpers.hasTank(table, 3 - table.getCurrentPlayer()) && !Helpers.isTank(attacked)) {
            output.put("error", "Attacked card is not of type 'Tank'.");
            return output;
        }

        attacked.setHealth(attacked.getHealth() - attacker.getAttackDamage());
        attacker.setUsed(true);
        return null;
    }
}
