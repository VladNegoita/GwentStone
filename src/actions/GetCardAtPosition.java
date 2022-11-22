package actions;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import main.Helpers;
import main.Table;

public final class GetCardAtPosition extends Action {
    private int x;
    private int y;

    public int getX() {
        return x;
    }

    public void setX(final int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(final int y) {
        this.y = y;
    }

    @Override
    public String getCommand() {
        return super.getCommand();
    }

    @Override
    public void setCommand(final String command) {
        super.setCommand(command);
    }

    public GetCardAtPosition(final String command, int x, int y) {
        super(command);
        this.x = x;
        this.y = y;
    }

    @Override
    public ObjectNode apply(final Table table) {
        final ObjectMapper mapper = new ObjectMapper();
        ObjectNode output = mapper.createObjectNode();
        output.put("command", this.getCommand());
        output.put("x", this.x);
        output.put("y", this.y);

        if (table.getTable().get(x).size() <= this.y)
            output.put("output", "No card available at that position.");
        else
            output.putPOJO("output", Helpers.getCardDeep(table.getTable().get(x).get(y)));

        return output;
    }
}
