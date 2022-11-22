package actions;

import cards.EnvironmentCards.Environment;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import main.Helpers;
import main.Player;
import main.Table;

public class UseEnvironmentCard extends Action {
    private int handIdx;
    private int affectedRow;

    public UseEnvironmentCard(String command, int handIdx, int affectedRow) {
        super(command);
        this.handIdx = handIdx;
        this.affectedRow = affectedRow;
    }

    public int getHandIdx() {
        return handIdx;
    }

    public void setHandIdx(int handIdx) {
        this.handIdx = handIdx;
    }

    public int getAffectedRow() {
        return affectedRow;
    }

    public void setAffectedRow(int affectedRow) {
        this.affectedRow = affectedRow;
    }

    @Override
    public String getCommand() {
        return super.getCommand();
    }

    @Override
    public void setCommand(String command) {
        super.setCommand(command);
    }

    @Override
    public ObjectNode apply(Table table) {
        Player currentPlayer = Helpers.getCurrentPlayer(table);

        final ObjectMapper mapper = new ObjectMapper();
        ObjectNode output = mapper.createObjectNode();
        output.put("command", this.getCommand());
        output.put("handIdx", this.handIdx);
        output.put("affectedRow", this.affectedRow);

        if (!Helpers.isEnvironment(currentPlayer.getHand().get(this.handIdx))) {
            output.putPOJO("error", "Chosen card is not of type environment.");
            return output;
        }

        if (currentPlayer.getMana() < currentPlayer.getHand().get(this.handIdx).getMana()) {
            output.putPOJO("error", "Not enough mana to use environment card.");
            return output;
        }

        if ((table.getCurrentPlayer() == 1 && (this.affectedRow == 2 || this.affectedRow == 3)) ||
                (table.getCurrentPlayer() == 2 && (this.affectedRow == 0 || this.affectedRow == 1))) {
            output.putPOJO("error", "Chosen row does not belong to the enemy.");
            return output;
        }

        if (currentPlayer.getHand().get(this.handIdx).getName().equals("Heart Hound") &&
                (table.getTable().get(3 - this.affectedRow).size() == 5)) {
            output.putPOJO("error", "Cannot steal enemy card since the player's row is full.");
            return output;
        }

        currentPlayer.setMana(currentPlayer.getMana() - currentPlayer.getHand().get(this.handIdx).getMana());
        ((Environment)currentPlayer.getHand().get(this.handIdx)).specialAbility(table, this.affectedRow);
        currentPlayer.getHand().remove(this.handIdx);

        return null;
    }
}
