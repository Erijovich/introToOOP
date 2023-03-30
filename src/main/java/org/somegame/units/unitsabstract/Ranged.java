package org.somegame.units.unitsabstract;

public abstract class Ranged extends BaseArmyUnit{

    int ammo, maxAmmo;
    int range;

    /**
     * тип брони - лёгкая
     * тип урона - острый
     */
    protected Ranged(float hp, int armor, int initiative, int x, int y, int[] baseDmg, int critChance, int accuracy, int ammo, int range) {
        super(hp, armor, ArmorType.light, initiative, x, y, DamageType.sharp, baseDmg, critChance, accuracy);
        this.ammo = this.maxAmmo = ammo;
        this.range = range;
    }
}


