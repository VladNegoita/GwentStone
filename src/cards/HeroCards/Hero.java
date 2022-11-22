package cards.HeroCards;

import cards.Ability;
import cards.Card;
import com.fasterxml.jackson.annotation.JsonIgnore;
import main.Constants;
import main.Table;

import java.util.ArrayList;

public abstract class Hero extends Card implements Ability {
    public Hero(final int mana, final String description, final ArrayList<String> colors,
                final String name) {
        super(mana, description, colors, name);
    }

    private int health = Constants.HEROHEALTH;

    @JsonIgnore
    private boolean used = false;

    /**
     *
     * @return if the hero has used his ability in this turn
     */
    public boolean isUsed() {
        return used;
    }

    /**
     *
     * @param used marks on/off the use of the ability in the current round
     */
    public void setUsed(final boolean used) {
        this.used = used;
    }

    /**
     *
     * @return health of the hero
     */
    public int getHealth() {
        return health;
    }

    /**
     *
     * @param health the new health of the hero
     */
    public void setHealth(final int health) {
        this.health = health;
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
     * @return the cost of the ability (in mana)
     */
    @Override
    public int getMana() {
        return super.getMana();
    }

    /**
     *
     * @return the description of the hero
     */
    @Override
    public String getDescription() {
        return super.getDescription();
    }

    /**
     *
     * @return the design colors
     */
    @Override
    public ArrayList<String> getColors() {
        return super.getColors();
    }

    /**
     *
     * @return the hero's name
     */
    @Override
    public String getName() {
        return super.getName();
    }

    /**
     *
     * @param mana corresponding value for the card
     */
    @Override
    public void setMana(final int mana) {
        super.setMana(mana);
    }

    /**
     *
     * @param description corresponding description of the card
     */
    @Override
    public void setDescription(final String description) {
        super.setDescription(description);
    }

    /**
     *
     * @param colors corresponding colors for the card design
     */
    @Override
    public void setColors(final ArrayList<String> colors) {
        super.setColors(colors);
    }

    /**
     *
     * @param name corresponding card name
     */
    @Override
    public void setName(final String name) {
        super.setName(name);
    }

    /**
     *
     * @param other another card which gives us the new attributes
     */
    public Hero(final Card other) {
        super(other);
        this.health = ((Hero) other).getHealth();
        this.used = ((Hero) other).isUsed();
    }
}
