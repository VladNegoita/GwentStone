package cards.MinionCards;

import cards.Card;
import main.Table;

import java.util.ArrayList;

public class TheRipper extends SpecialAbilityMinion {
    public TheRipper(int mana, String description, ArrayList<String> colors, String name, int health,
                     int attackDamage) {
        super(mana, description, colors, name, health, attackDamage);
    }

    @Override
    public boolean isUsed() {
        return super.isUsed();
    }

    @Override
    public void setUsed(boolean used) {
        super.setUsed(used);
    }

    @Override
    public void specialAbility(Table table, int affectedRow, int affectedColumn) {
        Minion attacked = (Minion)table.getTable().get(affectedRow).get(affectedColumn);
        attacked.setAttackDamage(attacked.getAttackDamage() - 2);
    }

    @Override
    public int getHealth() {
        return super.getHealth();
    }

    @Override
    public void setHealth(int health) {
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

    public TheRipper(Card other) {
        super(other);
    }

    @Override
    public boolean isFrozen() {
        return super.isFrozen();
    }

    @Override
    public void setFrozen(boolean frozen) {
        super.setFrozen(frozen);
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
