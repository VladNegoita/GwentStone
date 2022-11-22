package cards.EnvironmentCards;

import cards.Card;
import cards.MinionCards.Minion;
import main.Table;

import java.util.ArrayList;

public class Firestorm extends Environment {
    public Firestorm(int mana, String description, ArrayList<String> colors, String name) {
        super(mana, description, colors, name);
    }

    @Override
    public void specialAbility(Table table, int affectedRow) {
        for (Card card : table.getTable().get(affectedRow))
            ((Minion)card).setHealth(((Minion)card).getHealth() - 1);
    }

    @Override
    public int getMana() {
        return super.getMana();
    }

    @Override
    public String getDescription() {
        return super.getDescription();
    }

    @Override
    public ArrayList<String> getColors() {
        return super.getColors();
    }

    @Override
    public String getName() {
        return super.getName();
    }

    public Firestorm(Card other) {
        super(other);
    }

    @Override
    public void setMana(int mana) {
        super.setMana(mana);
    }

    @Override
    public void setDescription(String description) {
        super.setDescription(description);
    }

    @Override
    public void setColors(ArrayList<String> colors) {
        super.setColors(colors);
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }
}
