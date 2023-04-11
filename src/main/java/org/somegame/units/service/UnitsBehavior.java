package org.somegame.units.service;

import org.somegame.units.Army;
import org.somegame.units.unitsabstract.BaseUnit;

public interface UnitsBehavior {

    String unitInfo();
    String unitStats();
    void action(Army ally, Army enemy);
    String unitType();
    void die();

    //    void takeDamage();
//    void action();

    /**
     *
     * @param position - позиция (координаты) куда надо совершить шаг
     */
    void move(Position position);

}
