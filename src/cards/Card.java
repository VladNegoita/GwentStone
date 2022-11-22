package cards;

import java.util.ArrayList;

public abstract class Card {
    public Card(final int mana, final String description, final ArrayList<String> colors, final String name) {
        this.mana = mana;
        this.description = description;
        this.colors = colors;
        this.name = name;
    }

    private int mana;
    private String description;
    private ArrayList<String> colors;
    private String name;

    public int getMana() {
        return mana;
    }

    public Card(final Card other) {
        this.mana = other.mana;
        this.description = new String(other.description);
        this.name = new String(other.name);
        this.colors = new ArrayList<>();
        for (String s : other.colors)
            this.colors.add(new String(s));
    }

    public String getDescription() {
        return description;
    }

    public ArrayList<String> getColors() {
        return colors;
    }

    public String getName() {
        return name;
    }

    public void setMana(final int mana) {
        this.mana = mana;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public void setColors(final ArrayList<String> colors) {
        this.colors = colors;
    }

    public void setName(final String name) {
        this.name = name;
    }
}
