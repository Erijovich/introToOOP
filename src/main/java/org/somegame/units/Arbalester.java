package org.somegame.units;


import org.somegame.units.unitsabstract.Ranged;

public class Arbalester extends Ranged {

    private static final int
            HP = 200, ARMOR = 100, INITIATIVE = 4, CRITCHANCE = 10, ACCURACY = 60, AMMO = 10, RANGE = 10;
    private static final int[]
            BASEDMG = new int[]{15,25};

    /**
     * переопределяем тип урона на blunt, арбалетчик эффективнее против тяжёлой брони
     */
    protected Arbalester(int x, int y) {
        super(HP, ARMOR, INITIATIVE, x,y, BASEDMG, CRITCHANCE, ACCURACY, AMMO, RANGE);
        this.armType = ArmorType.medium;
        this.dmgType = DamageType.blunt;
    }

    public Arbalester() {this(1,1);}

    /**
     * Поставить болт с урановым наконечником:
     * на один ход увеличение урона (baseDmg) за счёт уменьшения инициативы.
     */
    public void aim(){
        this.baseDmg[0] *= 1.2;
        this.baseDmg[1] *= 1.2;
        this.initiative *= 2;
        this.critChance *= 1.5;
    }

    /** возврат к базовым настройкам */
    public void unAim(){
        this.baseDmg = BASEDMG;
        this.initiative = INITIATIVE;
        this.critChance = CRITCHANCE;
    }
}
