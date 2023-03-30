package org.somegame;

import org.somegame.units.*;
import org.somegame.units.unitsabstract.BaseUnit;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List <BaseUnit> units = new ArrayList<>();
        units.add (new Peasant());
        units.add (new Sniper());
        units.add (new Arbalester());
        units.add (new Wizard());
        units.add (new Priest());
        units.add (new Thief());
        units.add (new Swordsman());


        units.forEach(unit -> System.out.println(unit.getInfo()));

    }
}