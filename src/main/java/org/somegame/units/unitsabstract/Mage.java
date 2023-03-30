package org.somegame.units.unitsabstract;

public abstract class Mage extends BaseArmyUnit{
    int mana, maxMana;
    int manaRegSpeed;


    protected Mage(float hp, int armor, int initiative, int x, int y, int[] baseDmg, int critChance, int accuracy, int mana, int manaRegSpeed) {
        super(hp, armor, ArmorType.light, initiative, x, y, DamageType.magic, baseDmg, critChance, accuracy);
        this.mana = this.maxMana = mana;
        this.manaRegSpeed = manaRegSpeed;
    }

    public void castSpell() {

    }
}
