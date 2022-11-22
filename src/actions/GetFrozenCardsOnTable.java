package actions;

import cards.Card;
import cards.MinionCards.Minion;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import main.Helpers;
import main.Table;

import java.util.ArrayList;

public final class GetFrozenCardsOnTable extends Action {

    @Override
    public String getCommand() {
        return super.getCommand();
    }

    @Override
    public void setCommand(final String command) {
        super.setCommand(command);
    }

    public GetFrozenCardsOnTable(final String command) {
        super(command);
    }

    @Override
    public ObjectNode apply(final Table table) {
        ArrayList<Card> frozenCards = new ArrayList<>();
        for (ArrayList<Card> row : table.getTable())
            for (Card card : row)
                if (((Minion)card).isFrozen())
                    frozenCards.add(card);

        final ObjectMapper mapper = new ObjectMapper();
        ObjectNode output = mapper.createObjectNode();
        output.put("command", this.getCommand());
        output.putPOJO("output", Helpers.getDeepCopy(frozenCards));

        return output;
    }
}
