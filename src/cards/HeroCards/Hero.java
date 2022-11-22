package cards.HeroCards;

import cards.Ability;
import cards.Card;
import com.fasterxml.jackson.annotation.JsonIgnore;
import main.Table;

import java.util.ArrayList;

public abstract class Hero extends Card implements Ability {
    public Hero(final int mana, final String description, final ArrayList<String> colors, final String name) {
        super(mana, description, colors, name);
    }

    private int health = 30;

    @JsonIgnore
    private boolean used = false;

    public boolean isUsed() {
        return used;
    }

    public void setUsed(final boolean used) {
        this.used = used;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(final int health) {
        this.health = health;
    }

    @Override
    public abstract void specialAbility(final Table table, final int affectedRow, final int affectedColumn);

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

    public Hero(final Card other) {
        super(other);
        this.health = ((Hero)other).getHealth();
        this.used = ((Hero)other).isUsed();
    }
}
