package actions;

import cards.HeroCards.Hero;
import cards.MinionCards.Minion;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import fileio.Coordinates;
import main.Helpers;
import main.Stats;
import main.Table;

public class UseAttackHero extends Action {
    private Coordinates cardAttacker;

    public UseAttackHero(String command, Coordinates cardAttacker) {
        super(command);
        this.cardAttacker = cardAttacker;
    }

    @Override
    public String getCommand() {
        return super.getCommand();
    }

    @Override
    public void setCommand(String command) {
        super.setCommand(command);
    }

    public Coordinates getCardAttacker() {
        return cardAttacker;
    }

    public void setCardAttacker(Coordinates cardAttacker) {
        this.cardAttacker = cardAttacker;
    }

    @Override
    public ObjectNode apply(Table table) {
        final ObjectMapper mapper = new ObjectMapper();
        ObjectNode output = mapper.createObjectNode();
        output.put("command", this.getCommand());
        output.putPOJO("cardAttacker", cardAttacker);

        Minion attacker = (Minion)table.getTable().get(cardAttacker.getX()).get(cardAttacker.getY());
        if (attacker.isFrozen()) {
            output.put("error", "Attacker card is frozen.");
            return output;
        }

        if (attacker.isUsed()) {
            output.put("error", "Attacker card has already attacked this turn.");
            return output;
        }

        if (Helpers.hasTank(table, 3 - table.getCurrentPlayer())) {
            output.put("error", "Attacked card is not of type 'Tank'.");
            return output;
        }

        Hero attackedHero = (table.getCurrentPlayer() == 1 ?
                table.getPlayer2().getHero() : table.getPlayer1().getHero());

        attackedHero.setHealth(attackedHero.getHealth() - attacker.getAttackDamage());
        attacker.setUsed(true);

        if (attackedHero.getHealth() <= 0) {
            ObjectNode ending = mapper.createObjectNode();
            String winner = (table.getCurrentPlayer() == 1 ? "one" : "two");
            ending.put("gameEnded", "Player " + winner + " killed the enemy hero.");

            if (table.getCurrentPlayer() == 1)
                Stats.PlayerOneWon();
            else
                Stats.PlayerTwoWon();

            return ending;
        }

        return null;
    }
}
