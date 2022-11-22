package actions;

import com.fasterxml.jackson.databind.node.ObjectNode;
import main.Table;

public abstract class Action {
    private String command;

    public Action(final String command) {
        this.command = command;
    }

    /**
     *
     * @return the desired action's name
     */
    public String getCommand() {
        return command;
    }

    /**
     *
     * @param command - the desired action's name
     */
    public void setCommand(final String command) {
        this.command = command;
    }

    /**
     *
     * @param table - the game configuration
     * @return output in JSON format
     */
    public abstract ObjectNode apply(Table table);
}
