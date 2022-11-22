package cards;

import java.util.ArrayList;

public abstract class Card {
    public Card(final int mana, final String description, final ArrayList<String> colors,
                final String name) {
        this.mana = mana;
        this.description = description;
        this.colors = colors;
        this.name = name;
    }

    private int mana;
    private String description;
    private ArrayList<String> colors;
    private String name;

    /**
     *
     * @return the mana value corresponding to the card
     */
    public int getMana() {
        return mana;
    }

    public Card(final Card other) {
        this.mana = other.mana;
        this.description = new String(other.description);
        this.name = new String(other.name);
        this.colors = new ArrayList<>();
        for (String s : other.colors) {
            this.colors.add(new String(s));
        }
    }

    /**
     *
     * @return the description of the card
     */
    public String getDescription() {
        return description;
    }

    /**
     *
     * @return the colors for the design of the card
     */
    public ArrayList<String> getColors() {
        return colors;
    }

    /**
     *
     * @return the name of the card
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param mana corresponding value for the card
     */
    public void setMana(final int mana) {
        this.mana = mana;
    }

    /**
     *
     * @param description corresponding description of the card
     */
    public void setDescription(final String description) {
        this.description = description;
    }

    /**
     *
     * @param colors corresponding colors for the card design
     */
    public void setColors(final ArrayList<String> colors) {
        this.colors = colors;
    }

    /**
     *
     * @param name corresponding card name
     */
    public void setName(final String name) {
        this.name = name;
    }
}
