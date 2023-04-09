package org.somegame.units;

import org.somegame.units.service.Field;
import org.somegame.units.service.Position;
import org.somegame.units.unitsabstract.BaseUnit;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Army {
    public String name;
//    protected int size;
    protected List<BaseUnit> units;
    protected boolean side;

    public Army(String name, int size, boolean side) {
        this.name = name;
//        this.size = size;
        this.side = side;

        Random r = new Random();
        units = new ArrayList<>(size);

        for (int i = 0; i < size; i++) {
            Position pos = Field.nextPosition(side);
            int nextUnit;
            if (side) nextUnit = r.nextInt(4); // первая трогйка - одна сторона, крест - ноль или десять
            else nextUnit = r.nextInt(10,14); // начиная сдесятков - другая сторона. Можно добавлять юнитов

            switch (nextUnit) {
                case (1) -> units.add (new Swordsman(pos));
                case (2) -> units.add (new Arbalester(pos));
                case (3) -> units.add (new Priest(pos));

                case (11) -> units.add (new Thief(pos));
                case (12) -> units.add (new Sniper(pos));
                case (13) -> units.add (new Wizard(pos));
                default -> units.add (new Peasant(pos));
            }
        }
    }


    public int getSize(){return units.size();}

    /**
     * возвращает конкретного юнита из армии. Если индекса нет в списке - возвращает первого юнита из списка
     * @param i
     * @return
     */
    public BaseUnit getUnit(int i){
        if (i < 0 || i > units.size()) i = 0;
        return units.get(i);
    }

    public List<BaseUnit> getArmy() {
        return units;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        units.forEach(unit -> sb.append(unit.getClass().getSimpleName())
                                .append(" ")
                                .append(unit.getName())
                                .append(". "));
        return sb.toString();
    }
}
