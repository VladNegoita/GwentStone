package cards.EnvironmentCards;

import cards.Card;

import java.util.ArrayList;

public class HeartHound extends Environment {
    public HeartHound(int mana, String description, ArrayList<String> colors, String name) {
        super(mana, description, colors, name);
    }

    @Override
    public void specialAbility() {
        // TODO
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

    public HeartHound(Card other) {
        super(other);
    }
}
