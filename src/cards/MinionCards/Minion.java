package cards.MinionCards;

import cards.Card;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;

public class Minion extends Card {
    private int health;
    private int attackDamage;

    public Minion(final int mana, final String description, final ArrayList<String> colors,
                  final String name, final int health, final int attackDamage) {
        super(mana, description, colors, name);
        this.health = health;
        this.attackDamage = attackDamage;
    }

    /**
     *
     * @return if the minion has used his action this turn
     */
    public boolean isUsed() {
        return used;
    }

    /**
     *
     * @param used marks the use of this minion
     */
    public void setUsed(final boolean used) {
        this.used = used;
    }

    @JsonIgnore
    private boolean used = false;

    @JsonIgnore
    private boolean frozen = false;

    public Minion(final Card other) {
        super(other);
        this.health = ((Minion) other).getHealth();
        this.attackDamage = ((Minion) other).getAttackDamage();
        this.used = ((Minion) other).isUsed();
        this.frozen = ((Minion) other).isFrozen();
    }

    /**
     *
     * @return if the card is frozen
     */
    public boolean isFrozen() {
        return frozen;
    }

    /**
     *
     * @param frozen freezes/unfreezes the minion
     */
    public void setFrozen(final boolean frozen) {
        this.frozen = frozen;
    }

    /**
     *
     * @return the value of the health of this minion
     */
    public int getHealth() {
        return health;
    }

    /**
     *
     * @param health the value of the health of this minion
     */
    public void setHealth(final int health) {
        this.health = health;
    }

    /**
     *
     * @return value of how much damage this minion deals to an opponent
     */
    public int getAttackDamage() {
        return attackDamage;
    }

    /**
     *
     * @param attackDamage value of how much damage this minion deals to an opponent
     */
    public void setAttackDamage(final int attackDamage) {
        this.attackDamage = Math.max(attackDamage, 0);
    }

    /**
     *
     * @return the mana value of the card (cost to put the card on table)
     */
    @Override
    public int getMana() {
        return super.getMana();
    }

    /**
     *
     * @return the description of the card
     */
    @Override
    public String getDescription() {
        return super.getDescription();
    }

    /**
     *
     * @return the colors for the design of the card
     */
    @Override
    public ArrayList<String> getColors() {
        return super.getColors();
    }

    /**
     *
     * @return the card name
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
}
