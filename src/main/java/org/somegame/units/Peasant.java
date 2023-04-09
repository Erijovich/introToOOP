package org.somegame.units;

import org.somegame.units.service.Position;
import org.somegame.units.unitsabstract.BaseUnit;

public class Peasant extends BaseUnit {
    private static final int
            HP = 100,
            ARMOR = 20,
            INITIATIVE = 5,
            EVASION = 5;
    private int capacity; // размер мешка для стрел

    protected Peasant(Position pos) {super(HP, ARMOR, ArmorType.unarmored, INITIATIVE, EVASION, pos);}
//    public Peasant(){this(1,1);}

    public void takeStuff (){
    }
    public void giveStuff(){
    }

    @Override
    public void action(Army ally, Army enemy) {
        super.action(ally, enemy);
    }

}
