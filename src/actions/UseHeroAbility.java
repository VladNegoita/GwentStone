package actions;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import main.Constants;
import main.Helpers;
import main.Player;
import main.Table;

public final class UseHeroAbility extends Action {

    private final int affectedRow;

    @Override
    public String getCommand() {
        return super.getCommand();
    }

    @Override
    public void setCommand(final String command) {
        super.setCommand(command);
    }

    public UseHeroAbility(final String command, final int affectedRow) {
        super(command);
        this.affectedRow = affectedRow;
    }

    @Override
    public ObjectNode apply(final Table table) {
        final ObjectMapper mapper = new ObjectMapper();
        ObjectNode output = mapper.createObjectNode();
        output.put("command", this.getCommand());
        output.put("affectedRow", this.affectedRow);

        Player currentPlayer = Helpers.getCurrentPlayer(table);
        if (currentPlayer.getMana() < currentPlayer.getHero().getMana()) {
            output.put("error", "Not enough mana to use hero's ability.");
            return output;
        }

        if (currentPlayer.getHero().isUsed()) {
            output.put("error", "Hero has already attacked this turn.");
            return output;
        }

        if (currentPlayer.getHero().getName().equals("Lord Royce")
                || currentPlayer.getHero().getName().equals("Empress Thorina")) {
            if (table.getCurrentPlayerIdx() == 1 && this.affectedRow >= Constants.ROWCOUNT / 2
                    || (table.getCurrentPlayerIdx() == 2
                    && this.affectedRow < Constants.ROWCOUNT / 2)) {
                output.put("error", "Selected row does not belong to the enemy.");
                return output;
            }
        } else {
            if (table.getCurrentPlayerIdx() == 1 && this.affectedRow < Constants.ROWCOUNT / 2
                    || (table.getCurrentPlayerIdx() == 2
                    && this.affectedRow >= Constants.ROWCOUNT / 2)) {
                output.put("error", "Selected row does not belong to the current player.");
                return output;
            }
        }

        currentPlayer.getHero().specialAbility(table, this.affectedRow, 0);
        currentPlayer.getHero().setUsed(true);
        currentPlayer.setMana(currentPlayer.getMana() - currentPlayer.getHero().getMana());
        return null;
    }
}
