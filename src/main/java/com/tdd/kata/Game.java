package com.tdd.kata;

public class Game {

    private final char[][] board = new char[3][3];
    private char previousPlayer;

    public char getPlayerAt(int row, int column) {
        return board[row][column];
    }

    public void playAt(int row, int column) {
        char currentPlayer = previousPlayer == 'X' ? 'O' : 'X';
        board[row][column] = currentPlayer;
        previousPlayer = currentPlayer;
    }
}