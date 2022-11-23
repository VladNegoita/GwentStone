package cards;

import cards.EnvironmentCards.Firestorm;
import cards.EnvironmentCards.HeartHound;
import cards.EnvironmentCards.Winterfell;
import cards.HeroCards.EmpressThorina;
import cards.HeroCards.GeneralKocioraw;
import cards.HeroCards.KingMudface;
import cards.HeroCards.LordRoyce;
import cards.MinionCards.Disciple;
import cards.MinionCards.Minion;
import cards.MinionCards.Miraj;
import cards.MinionCards.TheCursedOne;
import cards.MinionCards.TheRipper;
import fileio.CardInput;

import java.util.ArrayList;

public abstract class Card {

    /**
     *
     * @param cardInput Card in CardInput format
     * @return Card in Card format
     */
    public static Card getCard(final CardInput cardInput) {
        return switch (cardInput.getName()) {
            case "Firestorm" -> new Firestorm(cardInput.getMana(), cardInput.getDescription(),
                    cardInput.getColors(), cardInput.getName());
            case "Heart Hound" -> new HeartHound(cardInput.getMana(), cardInput.getDescription(),
                    cardInput.getColors(), cardInput.getName());
            case "Winterfell" -> new Winterfell(cardInput.getMana(), cardInput.getDescription(),
                    cardInput.getColors(), cardInput.getName());
            case "Empress Thorina" -> new EmpressThorina(cardInput.getMana(),
                    cardInput.getDescription(), cardInput.getColors(), cardInput.getName());
            case "General Kocioraw" -> new GeneralKocioraw(cardInput.getMana(),
                    cardInput.getDescription(), cardInput.getColors(), cardInput.getName());
            case "King Mudface" -> new KingMudface(cardInput.getMana(), cardInput.getDescription(),
                    cardInput.getColors(), cardInput.getName());
            case "Lord Royce" -> new LordRoyce(cardInput.getMana(), cardInput.getDescription(),
                    cardInput.getColors(), cardInput.getName());
            case "Miraj" -> new Miraj(cardInput.getMana(), cardInput.getDescription(),
                    cardInput.getColors(), cardInput.getName(), cardInput.getHealth(),
                    cardInput.getAttackDamage());
            case "Disciple" -> new Disciple(cardInput.getMana(), cardInput.getDescription(),
                    cardInput.getColors(), cardInput.getName(), cardInput.getHealth(),
                    cardInput.getAttackDamage());
            case "The Cursed One" -> new TheCursedOne(cardInput.getMana(),
                    cardInput.getDescription(), cardInput.getColors(),
                    cardInput.getName(), cardInput.getHealth(), cardInput.getAttackDamage());
            case "The Ripper" -> new TheRipper(cardInput.getMana(), cardInput.getDescription(),
                    cardInput.getColors(), cardInput.getName(), cardInput.getHealth(),
                    cardInput.getAttackDamage());
            default -> new Minion(cardInput.getMana(), cardInput.getDescription(),
                    cardInput.getColors(), cardInput.getName(), cardInput.getHealth(),
                    cardInput.getAttackDamage());
        };
    }

    /**
     *
     * @param card - card to be copied
     * @return deep copy of the card
     */
    public static Card getCardDeepCopy(final Card card) {
        return switch (card.getName()) {
            case "Firestorm" -> new Firestorm(card);
            case "Heart Hound" -> new HeartHound(card);
            case "Winterfell" -> new Winterfell(card);
            case "Empress Thorina" -> new EmpressThorina(card);
            case "General Kocioraw" -> new GeneralKocioraw(card);
            case "King Mudface" -> new KingMudface(card);
            case "Lord Royce" -> new LordRoyce(card);
            case "Miraj" -> new Miraj(card);
            case "Disciple" -> new Disciple(card);
            case "The Cursed One" -> new TheCursedOne(card);
            case "The Ripper" -> new TheRipper(card);
            default -> new Minion(card);
        };
    }

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
