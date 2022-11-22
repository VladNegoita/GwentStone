package actions;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import main.Helpers;
import main.Table;

public class GetCardAtPosition extends Action {
    private int x;
    private int y;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String getCommand() {
        return super.getCommand();
    }

    @Override
    public void setCommand(String command) {
        super.setCommand(command);
    }

    public GetCardAtPosition(String command, int x, int y) {
        super(command);
        this.x = x;
        this.y = y;
    }

    @Override
    public ObjectNode apply(Table table) {
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
