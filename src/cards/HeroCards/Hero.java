package cards.HeroCards;

import cards.Ability;
import cards.Card;

import java.util.ArrayList;

public abstract class Hero extends Card implements Ability {
    public Hero(int mana, String description, ArrayList<String> colors, String name) {
        super(mana, description, colors, name);
    }

    private int health = 30;
    private boolean used = false;

    public boolean isUsed() {
        return used;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    @Override
    public void specialAbility() {
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

    @Override
    public String toString() {
        return super.toString();
    }

}
