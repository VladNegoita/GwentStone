package cards.HeroCards;

import cards.Card;
import cards.MinionCards.Minion;
import main.Table;

import java.util.ArrayList;

public final class GeneralKocioraw extends Hero {
    public GeneralKocioraw(final int mana, final String description, final ArrayList<String> colors,
                           final String name) {
        super(mana, description, colors, name);
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
    public void specialAbility(final Table table, final int affectedRow, final int affectedColumn) {
        for (Card card : table.getTable().get(affectedRow)) {
            ((Minion) card).setAttackDamage(((Minion) card).getAttackDamage() + 1);
        }
    }

    @Override
    public int getMana() {
        return super.getMana();
    }

    @Override
    public String getDescription() {
        return super.getDescription();
    }

    public GeneralKocioraw(final Card other) {
        super(other);
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
}
