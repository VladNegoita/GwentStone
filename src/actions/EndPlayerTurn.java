package actions;

import cards.Card;
import cards.MinionCards.Minion;
import com.fasterxml.jackson.databind.node.ObjectNode;
import main.Constants;
import main.Helpers;
import main.Table;

public final class EndPlayerTurn extends Action {

    public EndPlayerTurn(final String command) {
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
        int left, right;

        if (table.getCurrentPlayerIdx() == 1) {
            left = Constants.ROWCOUNT / 2;
            right = Constants.ROWCOUNT - 1;

            table.getPlayer1().getHero().setUsed(false);
        } else {
            left = 0;
            right = Constants.ROWCOUNT / 2 - 1;

            table.getPlayer2().getHero().setUsed(false);
        }

        for (int row = left; row <= right; ++row) {
            for (Card card : table.getTable().get(row)) {
                ((Minion) card).setFrozen(false);
                ((Minion) card).setUsed(false);
            }
        }

        table.setCurrentPlayerIdx(Helpers.theOtherPlayerIdx(table.getCurrentPlayerIdx()));
        table.setEndedTurns(table.getEndedTurns() + 1);
        return null;
    }
}
