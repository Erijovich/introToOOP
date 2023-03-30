package org.somegame.units;

import org.somegame.units.unitsabstract.Mage;

public class Wizard extends Mage {
    private static final int HP = 150, ARMOR = 100, INITIATIVE = 3, CRITCHANCE = 20, ACCURACY = 70, MANA = 100, MANAREG = 10;
    private static final int[] BASEDMG = new int[]{5,30};

    protected Wizard(int x, int y) {
        super(HP, ARMOR, INITIATIVE, x, y, BASEDMG, CRITCHANCE, ACCURACY, MANA, MANAREG);
    }
}

