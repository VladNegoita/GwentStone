package cards.HeroCards;

import cards.Card;
import cards.MinionCards.Minion;
import main.Table;

import java.util.ArrayList;

public final class LordRoyce extends Hero {
    public LordRoyce(final int mana, final String description, final ArrayList<String> colors,
                     final String name) {
        super(mana, description, colors, name);
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
        Minion cardMaxAttack = (Minion) table.getTable().get(affectedRow).get(0);

        for (Card card : table.getTable().get(affectedRow)) {
            if (((Minion) card).getAttackDamage() > cardMaxAttack.getAttackDamage()) {
                cardMaxAttack = (Minion) card;
            }
        }

        cardMaxAttack.setFrozen(true);
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
    public boolean isUsed() {
        return super.isUsed();
    }

    @Override
    public void setUsed(final boolean used) {
        super.setUsed(used);
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

    public LordRoyce(final Card other) {
        super(other);
    }
}
