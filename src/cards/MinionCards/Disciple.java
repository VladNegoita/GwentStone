package cards.MinionCards;

import cards.Card;
import main.Table;

import java.util.ArrayList;

public final class Disciple extends SpecialAbilityMinion {
    public Disciple(final int mana, final String description, final ArrayList<String> colors, final String name,
                    final int health, final int attackDamage) {
        super(mana, description, colors, name, health, attackDamage);
    }

    @Override
    public void specialAbility(final Table table, final int affectedRow, final int affectedColumn) {
        Minion attacked = (Minion)table.getTable().get(affectedRow).get(affectedColumn);
        attacked.setHealth(attacked.getHealth() + 2);
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
    public void setAttackDamage(int attackDamage) {
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

    public Disciple(Card other) {
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
}
