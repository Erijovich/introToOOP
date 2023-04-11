package org.somegame.units.service;

public enum SpellBook {
    heal1(1, -1), heal10 (5,-10), heal50(15, -50),
    ressurect (60, Float.NaN),
    fire1(1, 5), fire10 (5, 30), fire50(15, 100);


    private final float power;
    private final int cost;

    SpellBook(int cost, float power) {
        this.power = power;
        this.cost = cost;
    }

    public int getCost() {
        return cost;
    }

    public float getPower() {
        return power;
    }

}