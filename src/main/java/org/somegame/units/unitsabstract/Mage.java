package org.somegame.units.unitsabstract;

public abstract class Mage extends BaseArmyUnit{
    int mp, maxMp;
    int mpRegSpeed;


    protected Mage(float hp, int armor, int initiative, int x, int y, int[] baseDmg, int critChance, int accuracy, int evasion, int mp, int mpRegSpeed) {
        super(hp, armor, ArmorType.light, initiative, x, y, DamageType.magic, baseDmg, critChance, accuracy, evasion);
        this.mp = this.maxMp = mp;
        this.mpRegSpeed = mpRegSpeed;
    }

    @Override
    public String getInfo() {
        return  String.format("%s  MP: %3d/%-3d  Mana regen: %-3dper turn",super.getInfo(), this.mp, this.maxMp, this.mpRegSpeed);
    }

    public void castSpell() {

    }

}
