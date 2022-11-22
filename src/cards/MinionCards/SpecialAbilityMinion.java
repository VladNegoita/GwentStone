package cards.MinionCards;

import cards.Ability;
import cards.Card;
import main.Table;

import java.util.ArrayList;

public abstract class SpecialAbilityMinion extends Minion implements Ability {

    public SpecialAbilityMinion(final int mana, final String description,
                                final ArrayList<String> colors, final String name,
                                final int health, final int attackDamage) {
        super(mana, description, colors, name, health, attackDamage);
    }

    /**
     *
     * @return if the minion has been used this turn
     */
    @Override
    public boolean isUsed() {
        return super.isUsed();
    }

    /**
     *
     * @param used marks the use of this minion
     */
    @Override
    public void setUsed(final boolean used) {
        super.setUsed(used);
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
     * @return the health of the minion
     */
    @Override
    public int getHealth() {
        return super.getHealth();
    }

    /**
     *
     * @param health the value of the health of this minion
     */
    @Override
    public void setHealth(final int health) {
        super.setHealth(health);
    }

    /**
     *
     * @return value of how much damage this minion deals to an opponent
     */
    @Override
    public int getAttackDamage() {
        return super.getAttackDamage();
    }

    /**
     *
     * @param attackDamage value of how much damage this minion deals to an opponent
     */
    @Override
    public void setAttackDamage(final int attackDamage) {
        super.setAttackDamage(attackDamage);
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
     * @param other
     */
    public SpecialAbilityMinion(final Card other) {
        super(other);
    }

    /**
     *
     * @return returns if the minion is frozen
     */
    @Override
    public boolean isFrozen() {
        return super.isFrozen();
    }

    /**
     *
     * @param frozen freezes/unfreezes the minion
     */
    @Override
    public void setFrozen(final boolean frozen) {
        super.setFrozen(frozen);
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
