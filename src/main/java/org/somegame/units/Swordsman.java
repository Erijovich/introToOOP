package org.somegame.units;

import org.somegame.units.service.Position;
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

    protected Swordsman(Position pos){
        super(HP, ARMOR, INITIATIVE, pos, DamageType.sharp, BASEDMG, CRITCHANCE, ACCURACY,EVASION);
    }
//    public Swordsman(){this(1,1);}

    @Override
    public String unitType() {
        return "Sword";
    }

//    @Override
//    public void action(List<BaseUnit> ally, List<BaseUnit> enemy) {
//        super.action(ally, enemy);
//    },


    /**
     * Поднять щит:
     * увеличение брони за счёт уменьшения инициативы и точности.
     */

    public void raiseShield() {
        this.initiative *= 1.5;
        this.accuracy *= +.8;
        this.ap += 150;
    }

    /** возврат к базовым настройкам */
    public void lowerShield() {
        this.initiative *= INITIATIVE;
        this.accuracy *= ACCURACY;
        this.ap = Math.max(0, this.ap - 150); // если основную броню уже погрызли
    }

}
