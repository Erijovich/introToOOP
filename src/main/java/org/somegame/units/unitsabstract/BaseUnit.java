package org.somegame.units.unitsabstract;

import java.util.Random;

public abstract class BaseUnit implements UnitsBehavior{
    protected enum ArmorType {unarmored, light, medium, heavy}
    public String name;
    protected float hp, maxHp;
    protected int x, y;
    protected int ap; // количество брони, будет уменьшаться при получении урона (ломаться). крестьянин сможет чинить =)
    protected ArmorType armType; // это буду использовать, если будет разный тип атаки. Может и избытчно. убрать что бы не закапываться?
    protected int initiative; // очерёдность хода , как в героях
    protected static Random rnd;

    static {
        rnd = new Random();
    }

    protected BaseUnit(float hp, int ap, ArmorType armType, int initiative, int x, int y) {
        this.name = getName();
        this.ap = ap;
        this.armType = armType;
        this.initiative = initiative;
        this.hp = this.maxHp = hp;
        this.x = x;
        this.y = y;
    }

    /** Получаем рандомом имя юнита */
    private String getName() {
        return UnitNames.values()[rnd.nextInt(UnitNames.values().length)].toString();
    }

    /** статы юнита, классы наследника будут расширять этот метод своими уникальными значениями */
    @Override
    public String getInfo() {
        return String.format("%-10s  (%-11s  HP:%4.0f/%-4.0f AP: %-3d  %-9s  Initiative: %-1d",
                this.name, this.getClass().getSimpleName() + ")", this.hp, this.maxHp, this.ap, this.armType, this.initiative);
    }

    @Override
    public void die() {
        System.out.println(String.format("%s %s tragically passed away", this.getClass().getSimpleName(), this.name));
        System.out.println(String.format("%s %s did a little dance to mock an enemy", this.getClass().getSimpleName(), this.name));

    }

    @Override
    public void doSpecial() {
        System.out.println(String.format("%s %s did a special dance to mock an enemy", this.getClass().getSimpleName(), this.name));
    }

    @Override
    public void undoSpecial() {
        System.out.println(String.format("%s %s undid a special dance to mock an enemy", this.getClass().getSimpleName(), this.name));
    }

    /**
     * Получение юнитом урона
     * @param damage нанесённый конечный урон
     */
    protected void takeDamage(float damage) {
        if (this.hp - damage > 0) {
            this.hp -= damage;
        }
//        else { die(); }
    }

    protected void calculateDamage(){

    }

    /**
     * Получение юнитом лечения (можно попробовать сделать отрицательный урон и засунуть всё в метод takeDamage())
     * @param Hp
     */
    public void getHeal(float Hp) {
        this.hp = Math.min(Hp + this.hp, this.maxHp);
    }

    protected void makeMove(){

    }


}