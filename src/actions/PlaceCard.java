package actions;

import cards.Card;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import main.Helpers;
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

    private int getCorrespondingLine(Card card, int currentPlayer) {

        int correspondingLine = switch(card.getName()) {
            case "Sentinel", "Berserker", "The Cursed One", "Disciple" -> 0;
            case "The Ripper", "Miraj", "Goliath", "Warden" -> 1;
            default -> 404;
        };

        if (currentPlayer == 1)
            correspondingLine = 3 - correspondingLine;

        return correspondingLine;
    }

    @Override
    public ObjectNode apply(Table table) {
        final ObjectMapper mapper = new ObjectMapper();
        ObjectNode output = mapper.createObjectNode();
        output.put("command", this.getCommand());
        output.put("handIdx", this.handIdx);

        Player currentPlayer = (table.getCurrentPlayer() == 1 ? table.getPlayer1() : table.getPlayer2());
        if (Helpers.isEnvironment(currentPlayer.getHand().get(handIdx))) {
            output.putPOJO("error", "Cannot place environment card on table.");
            return output;
        }

        if (currentPlayer.getMana() < currentPlayer.getHand().get(handIdx).getMana()) {
            output.putPOJO("error", "Not enough mana to place card on table.");
            return output;
        }

        int correspondingLine = this.getCorrespondingLine(currentPlayer.getHand().get(handIdx), table.getCurrentPlayer());
        if (table.getTable().get(correspondingLine).size() == 5) {
            output.putPOJO("error", "Cannot place card on table since row is full.");
            return output;
        }

        table.getTable().get(correspondingLine).add(currentPlayer.getHand().get(handIdx));
        currentPlayer.setMana(currentPlayer.getMana() - currentPlayer.getHand().get(handIdx).getMana());
        currentPlayer.getHand().remove(handIdx);
        return null;
    }
}
