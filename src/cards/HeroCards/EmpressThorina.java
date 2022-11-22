package cards.HeroCards;

import cards.Card;
import cards.MinionCards.Minion;
import main.Table;

import java.util.ArrayList;

public class EmpressThorina extends Hero {
    public EmpressThorina(int mana, String description, ArrayList<String> colors, String name) {
        super(mana, description, colors, name);
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
    public void specialAbility(Table table, int affectedRow, int affectedColumn) {
        Minion cardMaxHealth = (Minion) table.getTable().get(affectedRow).get(0);

        for (Card card : table.getTable().get(affectedRow))
            if (((Minion) card).getHealth() > cardMaxHealth.getHealth())
                cardMaxHealth = (Minion) card;

        table.getTable().get(affectedRow).remove(cardMaxHealth);
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
    public boolean isUsed() {
        return super.isUsed();
    }

    @Override
    public void setUsed(boolean used) {
        super.setUsed(used);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void setMana(int mana) {
        super.setMana(mana);
    }

    public EmpressThorina(Card other) {
        super(other);
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
