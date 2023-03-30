package org.somegame.units;

import org.somegame.units.unitsabstract.Melee;

public class Swordsman extends Melee {
    private static final int
            HP = 500, ARMOR = 250, INITIATIVE = 6, CRITCHANCE = 1, ACCURACY = 60;
    private static final int[]
            BASEDMG = new int[]{30,40};

    protected Swordsman(int x, int y) {
        super(HP, ARMOR, INITIATIVE, x, y, DamageType.sharp, BASEDMG, CRITCHANCE, ACCURACY);
    }

    public void raiseShield(){
        this.initiative *= 1.5;
        this.accuracy *= +.8;
        this.armor += 150;
    }

    public void lowerShield(){
        this.initiative *= INITIATIVE;
        this.accuracy *= ACCURACY;
        this.armor = Math.max(0, this.armor - 150); // если основную броню уже погрызли
    }
}
