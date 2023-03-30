package org.somegame.units;

import org.somegame.units.unitsabstract.Mage;

public class Priest extends Mage {
    private static final int HP = 150, ARMOR = 100, INITIATIVE = 3, CRITCHANCE = 20, ACCURACY = 70, MANA = 100, MANAREG = 10;
    private static final int[] BASEDMG = new int[]{10,10};

    protected Priest(int x, int y) {
        super(HP, ARMOR, INITIATIVE, x, y, BASEDMG, CRITCHANCE, ACCURACY, MANA, MANAREG);
        this.armType = ArmorType.unarmored;
    }
}
