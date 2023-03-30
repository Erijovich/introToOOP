package org.somegame.units;

import org.somegame.units.unitsabstract.BaseUnit;

public class Peasant extends BaseUnit {
    private static final int ARMOR = 20, INITIATIVE = 5;
    private static final float HP = 100;
    private int capacity; // размер мешка для стрел

    protected Peasant(int x, int y) {
        super(HP, ARMOR, ArmorType.unarmored, INITIATIVE, x, y);
    }
    public void takeStuff (){

    }
    public void giveStuff(){

    }
}