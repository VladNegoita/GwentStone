package cards.EnvironmentCards;

import cards.Ability;
import cards.Card;
import main.Table;

import java.util.ArrayList;

public abstract class Environment extends Card implements Ability {
    public Environment(final int mana, final String description, final ArrayList<String> colors, final String name) {
        super(mana, description, colors, name);
    }
    @Override
    public abstract void specialAbility(final Table table, final int affectedRow,  final int affectedColumn);

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
    public void setMana(int mana) {
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

    public Environment(final Card other) {
        super(other);
    }
}
