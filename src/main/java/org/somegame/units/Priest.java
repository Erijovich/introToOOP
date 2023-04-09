package org.somegame.units;

import org.somegame.units.service.Position;
import org.somegame.units.unitsabstract.Mage;

public class Priest extends Mage {

    private static final int HP, ARMOR, INITIATIVE, CRITCHANCE, ACCURACY, EVASION, MANA, MANAREG;
    private static final int[] BASEDMG;

    static {
        HP = 150;
        ARMOR = 100;
        INITIATIVE = 3;
        CRITCHANCE = 20;
        ACCURACY = 70;
        EVASION = 20;
        MANA = 100;
        MANAREG = 10;
        BASEDMG = new int[]{10,10};
    }

    protected Priest(Position pos) {
        super(HP, ARMOR, INITIATIVE, pos, BASEDMG, CRITCHANCE, ACCURACY,EVASION, MANA, MANAREG);
        this.armType = ArmorType.unarmored;
    }

//    public Priest(){this(1,1);}
    @Override
    public void action(Army ally, Army enemy) {
        super.action(ally, enemy);
    }

    /**
     * Варианты: оживить, каст заклинания, бафф союзника (но как это отслеживать???)
     */


}
