package cards;

import main.Table;

public interface Ability {
    /**
     *
     * @param table the game configuration
     * @param affectedRow the row that is going to be affected
     * @param affectedColumn the column that is going to be affected
     */
    void specialAbility(Table table, int affectedRow, int affectedColumn);
}
