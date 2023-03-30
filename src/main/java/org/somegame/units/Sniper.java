package org.somegame.units;

import org.somegame.units.unitsabstract.Ranged;

public class Sniper extends Ranged {
    private static final int
            HP = 200, ARMOR = 100, INITIATIVE = 3, CRITCHANCE = 20, ACCURACY = 70, AMMO = 20, RANGE = 10;
    private static final int[]
            BASEDMG = new int[]{10,20};
    protected Sniper() {
        super(HP, ARMOR, INITIATIVE, 0, 0, BASEDMG, CRITCHANCE, ACCURACY, AMMO,  RANGE);
    }

    /**
     * Прицелиться:
     * на один ход увеличение точности (accuracy) за счёт уменьшения инициативы.
     * ток пока не понятно , как реализовывать
     */
    public void aim(){
        this.accuracy *= 1.3;
        this.initiative *= 2;
        this.critChance *= 1.5;
    }

    /** возврат к базовым настройкам */
    public void unAim(){
        this.accuracy = ACCURACY;
        this.initiative = INITIATIVE;
        this.critChance = CRITCHANCE;
    }
}
