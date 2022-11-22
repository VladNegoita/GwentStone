package actions;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import main.Table;

public final class GetPlayerMana extends Action {

    private int playerIdx;

    public GetPlayerMana(final String command, final int playerIdx) {
        super(command);
        this.playerIdx = playerIdx;
    }

    public int getPlayerIdx() {
        return playerIdx;
    }

    public void setPlayerIdx(final int playerIdx) {
        this.playerIdx = playerIdx;
    }

    public GetPlayerMana(final String command) {
        super(command);
    }

    @Override
    public String getCommand() {
        return super.getCommand();
    }

    @Override
    public void setCommand(final String command) {
        super.setCommand(command);
    }

    @Override
    public ObjectNode apply(final Table table) {
        final ObjectMapper mapper = new ObjectMapper();
        ObjectNode output = mapper.createObjectNode();
        output.put("command", this.getCommand());
        output.put("playerIdx", this.playerIdx);
        if (playerIdx == 1) {
            output.putPOJO("output", table.getPlayer1().getMana());
        } else {
            output.putPOJO("output", table.getPlayer2().getMana());
        }

        return output;
    }
}
