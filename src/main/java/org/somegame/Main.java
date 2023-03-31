package org.somegame;

import org.somegame.units.*;
import org.somegame.units.unitsabstract.BaseUnit;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

//        BaseUnit snp = new Sniper();
//        ((Sniper) snp).doSpecial();
//        System.out.println(snp.getInfo());
//
//        System.out.println(((Sniper)snp).getAmmo());
//        snp.die();
//
////        ((Sniper) units.get(1)).aim();
////        System.out.println(units.get(1).doS);
//        System.out.println(((Sniper)units.get(1)).getAmmo());

        System.out.println();
        Army armyOne = new Army("Good Guys", 10);
        Army armyTwo = new Army("Bad Guys", 10);

        System.out.println(armyOne);
        System.out.println();

        armyOne.getArmy().forEach(unit -> System.out.println(unit.getInfo()));
        System.out.println();

        armyOne.getArmy().get(9).doSpecial();
        System.out.println("Did some special");
        System.out.println(armyOne.getArmy().get(9).getInfo());

    }
}