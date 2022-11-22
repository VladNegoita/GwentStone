package cards.MinionCards;

import cards.Card;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;

public class Minion extends Card {
    private int health;
    private int attackDamage;

    public Minion(final int mana, final String description, final ArrayList<String> colors, final String name, final int health, final int attackDamage) {
        super(mana, description, colors, name);
        this.health = health;
        this.attackDamage = attackDamage;
    }

    public boolean isUsed() {
        return used;
    }

    public void setUsed(final boolean used) {
        this.used = used;
    }

    @JsonIgnore
    private boolean used = false;

    @JsonIgnore
    private boolean frozen = false;

    public Minion(final Card other) {
        super(other);
        this.health = ((Minion)other).getHealth();
        this.attackDamage = ((Minion)other).getAttackDamage();
        this.used = ((Minion)other).isUsed();
        this.frozen = ((Minion)other).isFrozen();
    }

    public boolean isFrozen() {
        return frozen;
    }

    public void setFrozen(final boolean frozen) {
        this.frozen = frozen;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(final int health) {
        this.health = health;
    }

    public int getAttackDamage() {
        return attackDamage;
    }

    public void setAttackDamage(final int attackDamage) {
        this.attackDamage = Math.max(attackDamage, 0);
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
