package org.somegame.units;

import org.somegame.units.unitsabstract.Mage;

public class Wizard extends Mage {

    private static final int HP, ARMOR, INITIATIVE, CRITCHANCE, ACCURACY, EVASION, MANA, MANAREG;
    private static final int[] BASEDMG;

    static {
        HP = 150;
        ARMOR = 100;
        INITIATIVE = 3;
        CRITCHANCE = 20;
        ACCURACY = 70;
        EVASION = 3;
        MANA = 100;
        MANAREG = 10;
        BASEDMG = new int[]{5,15};
    }

    protected Wizard(int x, int y) {
        super(HP, ARMOR, INITIATIVE, x, y, BASEDMG, CRITCHANCE, ACCURACY, EVASION, MANA, MANAREG);
    }
    public Wizard(){this(1,1);}

    /**
     * варианты: дебафф врага, атака по площади, удвоение маны. А может просто каст заклинания?
     */
    @Override
    public void doSpecial() {

    }

    /** возврат к базовым настройкам */
    @Override
    public void undoSpecial() {

    }
}

