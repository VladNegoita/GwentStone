package actions;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import main.Helpers;
import main.Table;

public class GetPlayerHero extends Action {
    private int playerIdx;

    public GetPlayerHero(String command, int playerIdx) {
        super(command);
        this.playerIdx = playerIdx;
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
        output.put("playerIdx", this.playerIdx);
        if (playerIdx == 1)
            output.putPOJO("output", Helpers.getCardDeep(table.getPlayer1().getHero()));
        else
            output.putPOJO("output", Helpers.getCardDeep(table.getPlayer2().getHero()));

        return output;
    }
}
