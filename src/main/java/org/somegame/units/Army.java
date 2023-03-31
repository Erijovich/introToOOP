package org.somegame.units;

import org.somegame.units.unitsabstract.BaseUnit;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Army {
    public String name;
    public int size;
    protected List<BaseUnit> units;

    public Army(String name, int size) {
        this.name = name;
        this.size = size;

        Random r = new Random();
        units = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            switch (r.nextInt(size)) {
                case (0) -> units.add (new Peasant());
                case (1) -> units.add (new Sniper());
                case (2) -> units.add (new Arbalester());
                case (3) -> units.add (new Thief());
                case (4) -> units.add (new Swordsman());
                case (5) -> units.add (new Wizard());
                default -> units.add (new Priest());
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        units.forEach(unit -> sb.append(unit.getClass().getSimpleName())
                                .append(" ")
                                .append(unit.name)
                                .append(". "));
        return sb.toString();
    }

    public List<BaseUnit> getArmy() {
        return units;
    }
}
