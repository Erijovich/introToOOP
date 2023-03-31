package org.somegame.units;

import org.somegame.units.unitsabstract.Melee;

public class Thief extends Melee {

    private static final int HP, AP, INITIATIVE, CRITCHANCE, ACCURACY,EVASION;
    private static final int[] BASEDMG;

    static {
        HP = 200;
        AP = 150;
        INITIATIVE = 1;
        CRITCHANCE = 30;
        ACCURACY = 80;
        EVASION = 30;
        BASEDMG = new int[]{10,50};
    }

    protected Thief(int x, int y) {
        super(HP, AP, INITIATIVE, x, y, DamageType.sharp, BASEDMG, CRITCHANCE, ACCURACY, EVASION);
    }
    public Thief(){this(1,1);}

    /**
     * Режим скрытности:
     * увеличение точности, критического шанса и уклонения за счёт экстремального уменьшения здоровья и брони
     */
    @Override
    public void doSpecial() {
        this.initiative *= 3;
        this.accuracy *= 2;
        this.critChance *= 1.5;
        this.evasion = 65;
        this.hp *= 0.1;
        this.ap *= 0.2;
    }

    /** возврат к базовым настройкам */
    @Override
    public void undoSpecial() {
        this.initiative = INITIATIVE;
        this.accuracy = ACCURACY;
        this.critChance = CRITCHANCE;
        this.evasion = EVASION;
        this.hp /= 0.1;
        this.ap /= 0.2;
    }
}
