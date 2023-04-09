package org.somegame.units.unitsabstract;

import org.somegame.units.Army;
import org.somegame.units.service.Position;
import org.somegame.units.service.UnitNames;
import org.somegame.units.service.UnitsBehavior;

import java.util.Random;

public abstract class BaseUnit implements UnitsBehavior {
    protected enum ArmorType {unarmored, light, medium, heavy}
    protected enum State {ready, busy, dead}
    protected String name;
    protected float hp, maxHp;
    protected Position position;
    protected int ap; // количество брони, будет уменьшаться при получении урона (ломаться). крестьянин сможет чинить =) пока не задействовано
    protected ArmorType armType; // это буду использовать, если будет разный тип атаки. Может и избытчно. убрать что бы не закапываться?
    protected int initiative; // очерёдность хода , как в героях
    protected int evasion; // шанс уворота от атаки
    protected State state;

    protected static Random rnd;
    static {
        rnd = new Random();
    }

    protected BaseUnit(float hp, int ap, ArmorType armType, int initiative, int evasion, Position position) {
        this.name = setName();
        this.ap = ap;
        this.armType = armType;
        this.initiative = initiative;
        this.evasion = evasion;
        this.hp = this.maxHp = hp;
        this.position = position;
        this.state = State.ready;
    }

    /** Получаем рандомом имя юнита из enum UnitNames*/
    private String setName() {
        return UnitNames.values()[rnd.nextInt(UnitNames.values().length)].toString();
    }

    public Position getPosition() {return position;}
    public State getState() {return state;}
    public String getName() {return name;}

    /** статы юнита, классы наследника будут расширять этот метод своими уникальными значениями */
    @Override
    public String unitInfo() {
        return String.format("%-10s  (%-11s  position: [%2d,%2d]  HP:%4.0f/%-4.0f AP: %-3d  %-9s  Evasion: %-3d  Initiative: %-1d",
                this.name, this.getClass().getSimpleName() + ")", this.position.getX(), this.position.getY(), this.hp, this.maxHp, this.ap, this.armType, this.evasion, this.initiative);
    }

    // TODEL maybe
    @Override
    public void die() {
        System.out.println(String.format("%s %s tragically passed away", this.getClass().getSimpleName(), this.name));
    }

    @Override
    public void action(Army ally, Army enemy) {
        System.out.println(String.format("%s %s did a special dance to mock an enemy", this.getClass().getSimpleName(), this.name));
    }

    // TODEL maybe
//    public Boolean ifAlive (){return hp > 0;}

    /**
     * Получение юнитом урона
     * @param damage нанесённый конечный урон (отрицательно значение = лечение)
     */
    protected void takeDamage(float damage) {
        if (damage == 0) return; // промах
        if (damage < 0) {hp = Math.min(hp-damage, maxHp); return;} // лечение
        hp -= damage;
        if (hp <= 0) {state = State.dead;}
    }

    protected void makeMove(){
    }

    public BaseUnit findNearestUnit(Army army) {
        BaseUnit nearestUnit = army.getUnit(0);
        double distance = position.distance(nearestUnit.getPosition()); // fixme не нравится, как выглядит
        double minDistance = distance;
        for (int i = 1; i < army.getSize(); i++) {
            if (army.getUnit(i).getState() == State.dead) continue; // если рассматриваемый юнит мертв
            distance = position.distance(army.getUnit(i).getPosition());
            if (minDistance > distance) {
                minDistance = distance;
                nearestUnit = army.getUnit(i);
            }
        }
        return nearestUnit;
    }
}