package actions;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import main.Stats;
import main.Table;

public final class GetTotalGamesPlayed extends Action {

    public GetTotalGamesPlayed(final String command) {
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
        output.put("output", Stats.getGamesPlayed());
        return output;
    }
}
