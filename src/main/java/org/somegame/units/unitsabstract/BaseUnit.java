package org.somegame.units.unitsabstract;

import java.util.Random;

public abstract class BaseUnit {
    protected enum ArmorType {unarmored, light, medium, heavy}
    protected float hp, maxHp;
    protected String name;
    protected int x, y;
    protected int armor; // количество брони, будет уменьшаться при получении урона (ломаться). крестьянин сможет чинить =)
    protected ArmorType armType; // это буду использовать, если будет разный тип атаки. Может и избытчно. убрать что бы не закапываться?
    protected int initiative; // очерёдность хода , как в героях
    protected static Random rnd;

    static {
        BaseUnit.rnd = new Random();
    }

    protected BaseUnit(float hp, int armor, ArmorType armType, int initiative, int x, int y) {
        this.name = getName();
        this.armor = armor;
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
    public String getInfo() {
        return String.format("Type: %-10s  Name: %-10s  Hp: %-4.0f  Armor type: %-9s  Armor: %-3d  Initiative: %-1d",
                this.getClass().getSimpleName(), this.name, this.hp, this.armType, this.armor, this.initiative);
    }

    /**
     * Получение юнитом урона
     * @param damage нанесённый конечный урон
     */
    protected void getDamage(float damage) {
        if (this.hp - damage > 0) {
            this.hp -= damage;
        }
        // else { die(); }
    }

    protected void calculateDamage(){

    }

    /**
     * Получение юнитом лечения (можно попробовать сделать отрицательный урон и засунуть всё в метод getDamage())
     * @param Hp
     */
    public void getHeal(float Hp) {
        this.hp = Math.min(Hp + this.hp, this.maxHp);
    }

    protected void makeMove(){

    }
}