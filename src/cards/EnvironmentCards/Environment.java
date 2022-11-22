package cards.EnvironmentCards;

import cards.Ability;
import cards.Card;
import main.Table;

import java.util.ArrayList;

public abstract class Environment extends Card implements Ability {
    public Environment(final int mana, final String description, final ArrayList<String> colors,
                       final String name) {
        super(mana, description, colors, name);
    }

    /**
     *
     * @param table the game configuration
     * @param affectedRow the row that is going to be affected
     * @param affectedColumn the column that is going to be affected
     */
    @Override
    public abstract void specialAbility(Table table, int affectedRow, int affectedColumn);

    /**
     *
     * @return the corresponding mana value for the environment card
     */
    @Override
    public int getMana() {
        return super.getMana();
    }

    /**
     *
     * @return the corresponding description of the environment card
     */
    @Override
    public String getDescription() {
        return super.getDescription();
    }

    /**
     *
     * @return the corresponding colors for the environment card's design
     */
    @Override
    public ArrayList<String> getColors() {
        return super.getColors();
    }

    /**
     *
     * @return the corresponding name of the environment card
     */
    @Override
    public String getName() {
        return super.getName();
    }

    /**
     *
     * @param mana corresponding value for the environment card
     */
    @Override
    public void setMana(final int mana) {
        super.setMana(mana);
    }

    /**
     *
     * @param description corresponding description of the environment card
     */
    @Override
    public void setDescription(final String description) {
        super.setDescription(description);
    }

    /**
     *
     * @param colors corresponding colors for the environment card design
     */
    @Override
    public void setColors(final ArrayList<String> colors) {
        super.setColors(colors);
    }

    /**
     *
     * @param name corresponding environment card name
     */
    @Override
    public void setName(final String name) {
        super.setName(name);
    }

    public Environment(final Card other) {
        super(other);
    }
}
