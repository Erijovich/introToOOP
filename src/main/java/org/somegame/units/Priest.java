package org.somegame.units;

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

    protected Priest(int x, int y) {
        super(HP, ARMOR, INITIATIVE, x, y, BASEDMG, CRITCHANCE, ACCURACY,EVASION, MANA, MANAREG);
        this.armType = ArmorType.unarmored;
    }

    public Priest(){this(1,1);}

    /**
     * Варианты: оживить, каст заклинания, бафф союзника (но как это отслеживать???)
     */
    @Override
    public void doSpecial() {
    }

    /** возврат к базовым настройкам */
    @Override
    public void undoSpecial() {
    }
}
