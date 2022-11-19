package actions;

import com.fasterxml.jackson.databind.node.ObjectNode;
import main.Table;

public class EndPlayerTurn extends Action {

    public EndPlayerTurn(String command) {
        super(command);
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
        table.setCurrentPlayer(3 - table.getCurrentPlayer());
        table.setEndedTurns(table.getEndedTurns() + 1);
        return null;
    }
}
