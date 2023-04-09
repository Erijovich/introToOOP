package org.somegame.units.unitsabstract;

import org.somegame.units.Army;
import org.somegame.units.service.Position;

public abstract class Ranged extends BaseArmyUnit{

    int ammo, maxAmmo;
    int range;

    /**
     * тип брони - лёгкая
     * тип урона - острый
     */
    protected Ranged(float hp, int armor, int initiative, Position pos, int[] baseDmg, int critChance, int accuracy, int evasion, int ammo, int range) {
        super(hp, armor, ArmorType.light, initiative, pos, DamageType.sharp, baseDmg, critChance, accuracy, evasion);
        this.ammo = this.maxAmmo = ammo;
        this.range = range;
    }

    @Override
    public String unitInfo() {
        return String.format("%s  Ammo: %2d/%-2d  Range: %-2d",super.unitInfo(), this.ammo, this.maxAmmo, this.range);
    }

    @Override
    public void action(Army ally, Army enemy) {
        if (state == State.dead) return;
        if (ammo <= 0) return;
        shoot(findNearestUnit(enemy));
    }

    private void shoot(BaseUnit enemy) {
        enemy.takeDamage(calculateDamage(enemy));
        ammo--;
    }

    public int getAmmo(){return this.ammo;}
}


