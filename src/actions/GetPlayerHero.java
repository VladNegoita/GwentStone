package actions;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import main.Helpers;
import main.Table;

public final class GetPlayerHero extends Action {
    private final int playerIdx;

    public GetPlayerHero(final String command, final int playerIdx) {
        super(command);
        this.playerIdx = playerIdx;
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
            output.putPOJO("output", Helpers.getCardDeep(table.getPlayer1().getHero()));
        } else {
            output.putPOJO("output", Helpers.getCardDeep(table.getPlayer2().getHero()));
        }

        return output;
    }
}
