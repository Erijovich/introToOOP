package org.somegame.units;

import org.somegame.units.unitsabstract.Ranged;

public class Sniper extends Ranged {

    private static final int HP, ARMOR, INITIATIVE, CRITCHANCE, ACCURACY, EVASION, AMMO, RANGE;
    private static final int[] BASEDMG;

    static {
        HP = 200;
        ARMOR = 100;
        INITIATIVE = 3;
        CRITCHANCE = 20;
        ACCURACY = 70;
        EVASION = 15;
        AMMO = 20;
        RANGE = 10;
        BASEDMG = new int[]{15,25};
    }

    protected Sniper(int x, int y) {
        super(HP, ARMOR, INITIATIVE, x,y, BASEDMG, CRITCHANCE, ACCURACY, EVASION, AMMO,  RANGE);
    }

    public Sniper(){this(1,1);}


    /**
     * Прицелиться:
     * на один ход увеличение точности (accuracy) за счёт уменьшения инициативы.
     * ток пока не понятно , как реализовывать
     */
    @Override
    public void doSpecial() {
        this.accuracy *= 1.3;
        this.initiative *= 2;
        this.critChance *= 1.5;
    }

    /** возврат к базовым настройкам */
    @Override
    public void undoSpecial() {
        this.accuracy = ACCURACY;
        this.initiative = INITIATIVE;
        this.critChance = CRITCHANCE;
    }
}
