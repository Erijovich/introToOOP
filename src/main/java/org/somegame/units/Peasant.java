package org.somegame.units;

import org.somegame.units.unitsabstract.BaseUnit;

public class Peasant extends BaseUnit {
    private static final int
            HP = 100,
            ARMOR = 20,
            INITIATIVE = 5;
//    private static final float HP = 100;
    private int capacity; // размер мешка для стрел

    protected Peasant(int x, int y) {super(HP, ARMOR, ArmorType.unarmored, INITIATIVE, x, y);}
    public Peasant(){this(1,1);}

    public void takeStuff (){
    }
    public void giveStuff(){
    }

    @Override
    public void doSpecial() {
        super.doSpecial();
    }

    @Override
    public void undoSpecial() {
        super.undoSpecial();
    }
}
