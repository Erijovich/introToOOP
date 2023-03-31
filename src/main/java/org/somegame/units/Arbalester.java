package org.somegame.units;


import org.somegame.units.unitsabstract.Ranged;

public class Arbalester extends Ranged {

    private static final int HP, ARMOR, INITIATIVE, CRITCHANCE, ACCURACY, EVASION, AMMO, RANGE;
    private static final int[] BASEDMG;

    static {
        HP = 200;
        ARMOR = 100;
        INITIATIVE = 5;
        CRITCHANCE = 10;
        ACCURACY = 60;
        EVASION = 10;
        AMMO = 10;
        RANGE = 10;
        BASEDMG = new int[]{20,30};
    }

    /**
     * переопределяем тип урона на blunt, арбалетчик эффективнее против тяжёлой брони
     */
    protected Arbalester(int x, int y) {
        super(HP, ARMOR, INITIATIVE, x,y, BASEDMG, CRITCHANCE, ACCURACY, EVASION, AMMO, RANGE);
        this.armType = ArmorType.medium;
        this.dmgType = DamageType.blunt;
    }

    public Arbalester() {this(1,1);}

    /**
     * Поставить болт с урановым наконечником:
     * на один ход увеличение урона (baseDmg) за счёт уменьшения инициативы.
     */
    @Override
    public void doSpecial() {
        this.baseDmg[0] *= 1.5;
        this.baseDmg[1] *= 1.5;
        this.initiative *= 2;
        this.critChance *= 1.5;
    }

    /** возврат к базовым настройкам */
    @Override
    public void undoSpecial() {
        this.baseDmg = BASEDMG;
        this.initiative = INITIATIVE;
        this.critChance = CRITCHANCE;
    }
}
