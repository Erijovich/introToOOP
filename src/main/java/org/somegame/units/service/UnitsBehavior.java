package org.somegame.units.service;

import org.somegame.units.Army;

public interface UnitsBehavior {

    String unitInfo();
    void action(Army ally, Army enemy);
    void die();

    //    void takeDamage();
//    void action();
//    void move();

}
