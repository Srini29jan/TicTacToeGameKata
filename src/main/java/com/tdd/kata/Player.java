package com.tdd.kata;

public enum Player {
    PLAYER_X('X'), PLAYER_O('O');

    private final char value;

    Player(char value) {
        this.value = value;
    }

    public char getValue() {
        return value;
    }
}