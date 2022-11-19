package actions;

import com.fasterxml.jackson.databind.node.ObjectNode;
import main.Table;

public abstract class Action {
    private String command;

    public Action(String command) {
        this.command = command;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public abstract ObjectNode apply(Table table);
}
