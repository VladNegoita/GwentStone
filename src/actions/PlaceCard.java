package actions;

import cards.EnvironmentCards.Environment;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import main.Player;
import main.Table;

public class PlaceCard extends Action {

    private int handIdx;
    public PlaceCard(String command, int handIdx) {
        super(command);
        this.handIdx = handIdx;
    }

    public int getHandIdx() {
        return handIdx;
    }

    public void setHandIdx(int handIdx) {
        this.handIdx = handIdx;
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
        final ObjectMapper mapper = new ObjectMapper();
        ObjectNode output = mapper.createObjectNode();
        output.put("command", this.getCommand());
        output.put("handIdx", this.handIdx);

        Player currentPlayer = (table.getCurrentPlayer() == 1 ? table.getPlayer1() : table.getPlayer2());
        if (currentPlayer.getHand().get(handIdx) instanceof Environment) {
            output.putPOJO("output", "Cannot place environment card on table.");
            return output;
        }

        if (currentPlayer.getMana() < currentPlayer.getHand().get(handIdx).getMana()) {
            output.putPOJO("output", "Not enough mana to place card on table.");
            return output;
        }

        // TODO
        
        return null;
    }
}
