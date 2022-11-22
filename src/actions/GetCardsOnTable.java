package actions;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import main.Helpers;
import main.Table;

public final class GetCardsOnTable extends Action {

    @Override
    public String getCommand() {
        return super.getCommand();
    }

    @Override
    public void setCommand(final String command) {
        super.setCommand(command);
    }

    public GetCardsOnTable(final String command) {
        super(command);
    }

    @Override
    public ObjectNode apply(final Table table) {
        final ObjectMapper mapper = new ObjectMapper();
        ObjectNode output = mapper.createObjectNode();
        output.put("command", this.getCommand());
        output.putPOJO("output", Helpers.getDeepCopyTable(table.getTable()));
        return output;
    }
}
