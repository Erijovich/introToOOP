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

    protected Peasant(Position pos) {super(HP, ARMOR, ArmorType.naked, INITIATIVE, EVASION, pos);}
//    public Peasant(){this(1,1);}

    public void takeStuff (){
    }
    public void giveStuff(BaseUnit ally){
        if (ally.unitType().equals("Snipr") || ally.unitType().equals("Arbst")) {

        }
    }

    @Override
    public String unitType() {
        return "Pesnt";
    }

    @Override
    public void action(Army armyAlly, Army armyEnemy) {
        int cnt = 0;
        for (BaseUnit ally: armyAlly.getArmy()) {
            if (position.distance(ally.getPosition()) <= 3*Math.sqrt(2)) { // крестьянин работает в радиусе трёх клеток
                this.giveStuff(ally);
                cnt++;
            }
        }
        if (cnt < 3) move(findFarestUnit(armyAlly).getPosition()); // иди к самому дальнему другу от тебя
    }

}
