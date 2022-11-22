package cards.EnvironmentCards;

import cards.Card;
import cards.MinionCards.Minion;
import main.Table;

import java.util.ArrayList;

public final class HeartHound extends Environment {
    public HeartHound(final int mana, final String description, final ArrayList<String> colors, final String name) {
        super(mana, description, colors, name);
    }

    @Override
    public void specialAbility(final Table table, final int affectedRow, final int affectedColumn) {

        Minion minionMaxHealth = (Minion)table.getTable().get(affectedRow).get(0);
        for (Card card : table.getTable().get(affectedRow))
            if (((Minion)card).getHealth() > minionMaxHealth.getHealth())
                minionMaxHealth = (Minion)card;

        table.getTable().get(3 - affectedRow).add(minionMaxHealth);
        table.getTable().get(affectedRow).remove(minionMaxHealth);
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

    @Override
    public void setMana(final int mana) {
        super.setMana(mana);
    }

    @Override
    public void setDescription(final String description) {
        super.setDescription(description);
    }

    @Override
    public void setColors(final ArrayList<String> colors) {
        super.setColors(colors);
    }

    @Override
    public void setName(final String name) {
        super.setName(name);
    }

    public HeartHound(Card other) {
        super(other);
    }
}
