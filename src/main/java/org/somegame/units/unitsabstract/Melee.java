package org.somegame.units.unitsabstract;

import org.somegame.units.Army;
import org.somegame.units.service.Position;

public abstract class Melee extends BaseArmyUnit{

    protected Melee(float hp, int armor, int initiative, Position pos, DamageType dmgType, int[] baseDmg, int critChance, int accuracy, int evasion) {
        super(hp, armor, ArmorType.heavy, initiative, pos, dmgType, baseDmg, critChance, accuracy, evasion);
    }

    @Override
    public void action(Army ally, Army enemy) {
        if (state == State.dead) return;
        BaseUnit nearestEnemy = findNearestUnit(enemy);
        if (position.distance(nearestEnemy.getPosition()) <= Math.sqrt(2)) attack(nearestEnemy);
        else move(nearestEnemy);

    }

    private void attack (BaseUnit enemy) {
        enemy.takeDamage(calculateDamage(enemy));
    }

    private void move (BaseUnit enemy) {

    }

}
