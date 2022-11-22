package actions;

import cards.Card;
import cards.MinionCards.Minion;
import com.fasterxml.jackson.databind.node.ObjectNode;
import main.Table;

import java.util.ArrayList;

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
        int left, right;

        if (table.getCurrentPlayer() == 1) {
            left = 2;
            right = 3;

            table.getPlayer1().getHero().setUsed(false);
        } else {
            left = 0;
            right = 1;

            table.getPlayer2().getHero().setUsed(false);
        }

        for (int row = left; row <= right; ++row) {
            for (Card card : table.getTable().get(row)) {
                ((Minion)card).setFrozen(false);
                ((Minion)card).setUsed(false);
            }
        }

        table.setCurrentPlayer(3 - table.getCurrentPlayer());
        table.setEndedTurns(table.getEndedTurns() + 1);
        return null;
    }
}
