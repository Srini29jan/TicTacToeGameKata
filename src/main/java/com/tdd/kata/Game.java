package com.tdd.kata;

public class Game {

    private static final int GRID_SIZE = 3;
    private static final char PLAYER_X = 'X';
    private final char[][] board = new char[GRID_SIZE][GRID_SIZE];
    private char previousPlayer;

    public char getPlayerAt(int row, int column) {
        return board[row][column];
    }

    public void playAt(int row, int column) {
        char currentPlayer = previousPlayer == PLAYER_X ? 'O' : PLAYER_X;
        board[row][column] = currentPlayer;
        previousPlayer = currentPlayer;
    }
}