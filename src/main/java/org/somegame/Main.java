package org.somegame;

import org.somegame.units.*;
import org.somegame.units.service.Field;
import org.somegame.units.service.View;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        System.out.println();
        int armySize = 10;
        Field.setSize(armySize - 1); // fixme не нравятся цифры тут

        Army armyOne = new Army("Good Guys", armySize, true);
        Army armyTwo = new Army("Bad Guys", armySize, false);

//        System.out.println(armyOne);
//        System.out.println();
//        System.out.println(armyTwo);
//        System.out.println();

//        armyOne.getArmy().forEach(unit -> System.out.println(unit.unitInfo()));
//        System.out.println();
//
//        armyOne.getArmy().get(9).action(armyOne, armyTwo);
//        System.out.println("Did some special");
//        System.out.println(armyOne.getArmy().get(9).unitInfo());
////
//        Sniper s = new Sniper(new Position(0,0));
//        System.out.println(s.getClass().getSimpleName());
//        if (s.getClass().getSimpleName().equals("Sniper")) System.out.println("yes");
//        else System.out.println("fock you");
//        System.out.println(s.unitInfo());

        // ------------
//        System.out.println();
//        Army.fillPriorityList(armyOne,armyTwo);
//        Army.getPriorityList().forEach(unit -> System.out.println(unit.unitStats()));
//        System.out.println();
//
//        Army.sortPriorityList();
//        Army.getPriorityList().forEach(unit -> System.out.println(unit.unitStats()));
//        Army.getPriorityList().forEach(unit ->  { unit.action(armyOne,armyTwo);}); // if (unit.getState() == BaseUnit.State.dead) сделать isAlive() true/false
//        System.out.println();
//        Army.getPriorityList().forEach(unit -> System.out.println(unit.unitStats()));



        Army.fillPriorityList(armyOne,armyTwo);
        Scanner sc = new Scanner(System.in);
        while (armyOne.isAlive() & armyTwo.isAlive()) {
            Army.sortPriorityList(); // выставление очередности хода
            View.view(Army.getPriorityList(), armyOne, armyTwo);
            sc.nextLine();
            Army.getPriorityList().forEach(unit -> {
                unit.action(armyOne, armyTwo);
            }); // if (unit.getState() == BaseUnit.State.dead) сделать isAlive() true/false
            // fixme !!! нет проверки на живого юнита
        }
        if (armyTwo.isAlive())System.out.println("army one win");
        else System.out.println("army two win");



//        init();
//        Scanner input = new Scanner(System.in);
//        while (true){
//            allTeam = sortTeam();
//            View.view();  // отображение в консоль
//            input.nextLine();
//            for (BaseHero human: allTeam) {
//                if (holyTeam.contains(human)) human.step(holyTeam, darkTeam);
//                else human.step(darkTeam, holyTeam);
//            }
    }
}

//    BaseUnit snp = new Sniper();
//        ((Sniper) snp).doSpecial();
//                System.out.println(snp.unitInfo());
//
//                System.out.println(((Sniper)snp).getAmmo());
//                snp.die();
//
////        ((Sniper) units.get(1)).aim();
////        System.out.println(units.get(1).doS);
//                System.out.println(((Sniper)units.get(1)).getAmmo());
//
//                System.out.println();
//                Army armyOne = new Army("Good Guys", 10);
//                Army armyTwo = new Army("Bad Guys", 10);
//
//                System.out.println(armyOne);
//                System.out.println();
//
//                armyOne.getArmy().forEach(unit -> System.out.println(unit.unitInfo()));
//                System.out.println();
//
////        armyOne.getArmy().get(9).action(, );
//                System.out.println("Did some special");
//                System.out.println(armyOne.getArmy().get(9).unitInfo());
//
//                Sniper s = new Sniper(new Position(0,0));
//                System.out.println(s.getClass().getSimpleName());
//                if (s.getClass().getSimpleName().equals("Sniper")) System.out.println("yes");
//                else System.out.println("fock you");