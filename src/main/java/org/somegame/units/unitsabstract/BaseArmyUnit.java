package org.somegame.units.unitsabstract;

public abstract class BaseArmyUnit extends BaseUnit {
    /**
     * пока пусть будет так:
     * sharp урон 2х, 1.5х, 1х, 0,5х против брони соответственно нетброни, лёгкая, средняя и тяжёла
     * blunt - наоборот против тяжёлой брони самый большой урон - Чем броня легче, тем от дубины легче увернуться
     * magic - проотив всех множитлеь 1х
     */
    protected enum DamageType {blunt, sharp, magic}
    protected DamageType dmgType;
    protected int[] baseDmg; // диапазон сырого урона мин макс
    protected int critChance; // множитель для нанесения критического (полуторного или двойного, например) урона
    protected int accuracy; // множитель (процент) успешности атаки или промаха
    protected int evasion; // шанс уворота от атаки


    protected BaseArmyUnit(float hp, int armor, ArmorType armType, int initiative, int x, int y, DamageType dmgType,
                           int[] baseDmg, int critChance, int accuracy, int evasion) {
        super(hp, armor, armType, initiative, x, y);
        this.baseDmg = baseDmg;
        this.dmgType = dmgType;
        this.critChance = critChance;
        this.accuracy = accuracy;
        this.evasion = evasion;
    }

    @Override
    public String getInfo() {
        return  String.format("%s  Damage: %2d-%-2d  %-5s  Crit chance: %-3d  Accuracy: %-3d Evasion: %-3d",
                super.getInfo(), this.baseDmg[0], this.baseDmg[1], this.dmgType, this.critChance, this.accuracy, this.evasion);

    }

    /**
     * пока метод неверный, нужен перерасчёт урона нанесённого
     * @param target
     * @param dmg
     */
//    public void attack (BaseUnit target, int[] dmg) {
//        int damage = BaseArmyUnit.rnd.nextInt(dmg[0],dmg[1]);
//        target.getDamage(damage);
//
//    }
}
