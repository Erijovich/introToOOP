package org.somegame.units;

import org.somegame.units.unitsabstract.Melee;

public class Thief extends Melee {
    private static final int
            HP = 300, ARMOR = 150, INITIATIVE = 1, CRITCHANCE = 30, ACCURACY = 80;
    private static final int[]
            BASEDMG = new int[]{10,30};

    protected Thief(int x, int y) {
        super(HP, ARMOR, INITIATIVE, x, y, DamageType.sharp, BASEDMG, CRITCHANCE, ACCURACY);
    }
    public Thief(){this(1,1);}
}
