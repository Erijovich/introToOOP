package org.somegame.units.service;

public enum SpellBook {
    healOne(1, 1);

    private final int power, cost;

    SpellBook(int power, int cost) {
        this.power = power;
        this.cost = cost;
    }

    public int getCost() {
        return cost;
    }

    public int getPower() {
        return power;
    }

}