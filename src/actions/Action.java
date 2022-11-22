package actions;

import com.fasterxml.jackson.databind.node.ObjectNode;
import main.Table;

public abstract class Action {
    private String command;

    public Action(final String command) {
        this.command = command;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(final String command) {
        this.command = command;
    }

    public abstract ObjectNode apply(final Table table);
}
