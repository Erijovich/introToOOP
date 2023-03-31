package org.somegame.units.unitsabstract;

public abstract class Ranged extends BaseArmyUnit{

    int ammo, maxAmmo;
    int range;

    /**
     * тип брони - лёгкая
     * тип урона - острый
     */
    protected Ranged(float hp, int armor, int initiative, int x, int y, int[] baseDmg, int critChance, int accuracy, int evasion, int ammo, int range) {
        super(hp, armor, ArmorType.light, initiative, x, y, DamageType.sharp, baseDmg, critChance, accuracy, evasion);
        this.ammo = this.maxAmmo = ammo;
        this.range = range;
    }

    @Override
    public String getInfo() {
        return  String.format("%s  Ammo: %2s/%-2s  Range: %-2d",super.getInfo(), this.ammo, this.maxAmmo, this.range);

    }


    public int getAmmo(){return this.ammo;}
}


