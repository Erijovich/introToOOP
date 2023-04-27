package org.somegame.units.service;

import org.somegame.units.Army;
import org.somegame.units.unitsabstract.BaseUnit;
import java.util.Collections;
import java.util.List;

public class View {
    private static int step = 1;
    private static final int[] l = {0};
    private static final String top10 = '┌' + String.join("", Collections.nCopies(9, "─┬")) + "─┐";
    private static final String midl10 = '├' + String.join("", Collections.nCopies(9, "─┼")) + "─┤";
    private static final String bottom10 = '└' + String.join("", Collections.nCopies(9, "─┴")) + "─┘";

    private static void tabSetter(int cnt, int max) {
        int dif = max - cnt + 2;
        if (dif > 0) System.out.printf("%" + dif + "s", "|\t");
        else System.out.print(":\t");
    }


    private static String getChar(int x, int y, Army armyOne, Army armyTwo, List<BaseUnit> priorityList) {
        String out = "| ";
        for (BaseUnit unit : priorityList) {
            if (unit.getPosition().getX() == x && unit.getPosition().getY() == y) {
                if (unit.getHp() == 0) {
                    out = "|" + (AnsiColors.ANSI_RED + unit.getClass().getSimpleName().charAt(0) + AnsiColors.ANSI_RESET);
                    break;
                }
                if (armyOne.getArmy().contains(unit))
                    out = "|" + (AnsiColors.ANSI_GREEN + unit.getClass().getSimpleName().charAt(0) + AnsiColors.ANSI_RESET);
                if (armyTwo.getArmy().contains(unit))
                    out = "|" + (AnsiColors.ANSI_BLUE + unit.getClass().getSimpleName().charAt(0) + AnsiColors.ANSI_RESET);
                break;
            }
        }
        return out;
    }

    public static void view(List<BaseUnit> priorityList, Army armyOne, Army armyTwo) {
        if (step == 1) {
            System.out.print(AnsiColors.ANSI_RED + "First step" + AnsiColors.ANSI_RESET);
        } else {
            System.out.print(AnsiColors.ANSI_RED + "Step:" + step + AnsiColors.ANSI_RESET);
        }

        int len = 0;
        for (BaseUnit unit : priorityList) {
//            unit.toString().length();
            len = Math.max(len, unit.unitStats().length());

        }

        step++;
        priorityList.forEach((v) -> l[0] = Math.max(l[0], v.unitStats().length()));
        System.out.print("_".repeat(l[0] * 2));
        System.out.println();
        System.out.print(top10 + "    ");
        System.out.print("Blue side");
        //for (int i = 0; i < l[0]-9; i++)
        System.out.print(" ".repeat(l[0] - 9));
        System.out.println("|\tGreen side");
        for (int i = 0; i < 10; i++) {
            System.out.print(getChar(0, i, armyOne, armyTwo, priorityList));
        }
        System.out.print("|    ");
        System.out.print(armyOne.getUnit(0).unitStats());
        tabSetter(armyOne.getUnit(0).toString().length(), l[0]);
        System.out.println(armyTwo.getUnit(0).unitStats());
        System.out.println(midl10);

        for (int i = 1; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(getChar(i, j, armyOne, armyTwo, priorityList));
            }
            System.out.print("|    ");
            System.out.print(armyOne.getUnit(i - 1).unitStats());
            tabSetter(armyOne.getUnit(i - 1).toString().length(), l[0]);
            System.out.println(armyTwo.getUnit(i - 1).unitStats());
            System.out.println(midl10);
        }
        for (int j = 0; j < 10; j++) {
            System.out.print(getChar(9, j, armyOne, armyTwo, priorityList));
        }
        System.out.print("|    ");
        System.out.print(armyOne.getUnit(9).unitStats());
        tabSetter(armyOne.getUnit(9).toString().length(), l[0]);
        System.out.println(armyTwo.getUnit(9).unitStats());
        System.out.println(bottom10);
    }
}