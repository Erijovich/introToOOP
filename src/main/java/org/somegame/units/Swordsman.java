package org.somegame.units;

import org.somegame.units.unitsabstract.Melee;

public class Swordsman extends Melee {

    private static final int HP, ARMOR, INITIATIVE, CRITCHANCE, ACCURACY, EVASION;
    private static final int[] BASEDMG;

    static {
        HP = 500;
        ARMOR = 250;
        INITIATIVE = 6;
        CRITCHANCE = 1;
        ACCURACY = 60;
        EVASION = 5;
        BASEDMG = new int[]{30,40};
    }

    protected Swordsman(int x, int y) {
        super(HP, ARMOR, INITIATIVE, x, y, DamageType.sharp, BASEDMG, CRITCHANCE, ACCURACY,EVASION);
    }
    public Swordsman(){this(1,1);}


    /**
     * Поднять щит:
     * увеличение брони за счёт уменьшения инициативы и точности.
     */
    @Override
    public void doSpecial() {
        this.initiative *= 1.5;
        this.accuracy *= +.8;
        this.ap += 150;
    }

    /** возврат к базовым настройкам */
    @Override
    public void undoSpecial() {
        this.initiative *= INITIATIVE;
        this.accuracy *= ACCURACY;
        this.ap = Math.max(0, this.ap - 150); // если основную броню уже погрызли
    }

}
