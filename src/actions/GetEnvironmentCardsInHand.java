package actions;

import cards.Card;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import main.Helpers;
import main.Player;
import main.Table;

import java.util.ArrayList;

public class GetEnvironmentCardsInHand extends Action {
    private int playerIdx;

    public GetEnvironmentCardsInHand(String command, int playerIdx) {
        super(command);
        this.playerIdx = playerIdx;
    }

    @Override
    public String getCommand() {
        return super.getCommand();
    }

    @Override
    public void setCommand(String command) {
        super.setCommand(command);
    }

    public int getPlayerIdx() {
        return playerIdx;
    }

    public void setPlayerIdx(int playerIdx) {
        this.playerIdx = playerIdx;
    }

    @Override
    public ObjectNode apply(Table table) {
        Player currentPlayer = Helpers.getCurrentPlayer(table);
        ArrayList<Card> environmentCardsInHand = new ArrayList<>();
        for (Card card : currentPlayer.getHand())
            if (Helpers.isEnvironment(card))
                environmentCardsInHand.add(card);

        final ObjectMapper mapper = new ObjectMapper();
        ObjectNode output = mapper.createObjectNode();
        output.put("command", this.getCommand());
        output.put("playerIdx", this.playerIdx);
        output.putPOJO("output", Helpers.getDeepCopy(environmentCardsInHand));

        return output;
    }
}
