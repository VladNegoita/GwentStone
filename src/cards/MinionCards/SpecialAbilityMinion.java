package cards.MinionCards;

import cards.Ability;
import cards.Card;
import main.Table;

import java.util.ArrayList;

public abstract class SpecialAbilityMinion extends Minion implements Ability {

    public SpecialAbilityMinion(final int mana, final String description, final ArrayList<String> colors,
                                final String name, final int health, final int attackDamage) {
        super(mana, description, colors, name, health, attackDamage);
    }

    @Override
    public boolean isUsed() {
        return super.isUsed();
    }

    @Override
    public void setUsed(final boolean used) {
        super.setUsed(used);
    }

    @Override
    public abstract void specialAbility(final Table table, final int affectedRow, final int affectedColumn);

    @Override
    public int getHealth() {
        return super.getHealth();
    }

    @Override
    public void setHealth(final int health) {
        super.setHealth(health);
    }

    @Override
    public int getAttackDamage() {
        return super.getAttackDamage();
    }

    @Override
    public void setAttackDamage(final int attackDamage) {
        super.setAttackDamage(attackDamage);
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

    public SpecialAbilityMinion(final Card other) {
        super(other);
    }

    @Override
    public boolean isFrozen() {
        return super.isFrozen();
    }

    @Override
    public void setFrozen(final boolean frozen) {
        super.setFrozen(frozen);
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
}
