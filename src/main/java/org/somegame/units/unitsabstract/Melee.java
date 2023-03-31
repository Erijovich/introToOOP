package org.somegame.units.unitsabstract;

public abstract class Melee extends BaseArmyUnit{

    protected Melee(float hp, int armor, int initiative, int x, int y, DamageType dmgType, int[] baseDmg, int critChance, int accuracy, int evasion) {
        super(hp, armor, ArmorType.heavy, initiative, x, y, dmgType, baseDmg, critChance, accuracy, evasion);
    }

}
