package actions;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import main.Helpers;
import main.Table;

public final class GetPlayerDeck extends Action {

    private int playerIdx;

    public GetPlayerDeck(final String command, final int playerIdx) {
        super(command);
        this.playerIdx = playerIdx;
    }

    public int getPlayerIdx() {
        return playerIdx;
    }

    public void setPlayerIdx(final int playerIdx) {
        this.playerIdx = playerIdx;
    }

    @Override
    public ObjectNode apply(final Table table) {
        final ObjectMapper mapper = new ObjectMapper();
        ObjectNode output = mapper.createObjectNode();
        output.put("command", this.getCommand());
        output.put("playerIdx", this.playerIdx);

        if (playerIdx == 1) {
            output.putPOJO("output", Helpers.getDeepCopy(
                    table.getPlayer1().getCurrentDeck()));
        } else {
            output.putPOJO("output", Helpers.getDeepCopy(
                    table.getPlayer2().getCurrentDeck()));
        }

        return output;
    }

    @Override
    public String getCommand() {
        return super.getCommand();
    }

    @Override
    public void setCommand(final String command) {
        super.setCommand(command);
    }
}
