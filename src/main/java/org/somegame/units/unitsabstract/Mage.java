package org.somegame.units.unitsabstract;

import org.somegame.units.Army;
import org.somegame.units.service.Position;

public abstract class Mage extends BaseArmyUnit{
    int mp, maxMp;
    int mpRegSpeed;


    protected Mage(float hp, int armor, int initiative, Position pos, int[] baseDmg, int critChance, int accuracy, int evasion, int mp, int mpRegSpeed) {
        super(hp, armor, ArmorType.light, initiative, pos, DamageType.magic, baseDmg, critChance, accuracy, evasion);
        this.mp = this.maxMp = mp;
        this.mpRegSpeed = mpRegSpeed;
    }

    @Override
    public String unitInfo() {
        return  String.format("%s MP: %3d/%-3d REG: %-3d",super.unitInfo(), this.mp, this.maxMp, this.mpRegSpeed);
    }

    @Override
    public String unitStats() {
        return  String.format("%s MP: %3d/%-3d",super.unitStats(), this.mp, this.maxMp);
    }

    // fixme если ближайший противник на расстоянии удара , то выбор , либо отступить, либо ударить посохом // (половина урона)
    @Override
    public void action(Army ally, Army enemy) {
        if (state == State.dead) return;
        if (mp == 0)             return;
        castSpell(findNearestUnit(enemy)); // fixme продумать заклинания и на своих и на чужих
    }

    public void castSpell(BaseUnit unit) {

    }

}
