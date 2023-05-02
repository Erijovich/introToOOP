package org.somegame.service;

import org.somegame.units.Army;
import org.somegame.units.unitsabstract.BaseUnit;

public interface UnitBehavior {

    String unitInfo();
    String unitStats();
    void action(Army ally, Army enemy);
    String unitType();
    void die();

    void recieveHelp();

    String getIcon();


    //    void takeDamage();
//    void action();

    /**
     *
     * @param position - позиция (координаты) куда надо совершить шаг
     */
    void move(BaseUnit target);

}
