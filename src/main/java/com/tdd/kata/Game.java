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
        char currentPlayer = getCurrentPlayer();
        board[row][column] = currentPlayer;
        setPreviousPlayer(currentPlayer);
    }

    private void setPreviousPlayer(char currentPlayer) {
        previousPlayer = currentPlayer;
    }

    private char getCurrentPlayer() {
        return previousPlayer == PLAYER_X ? 'O' : PLAYER_X;
    }

    public char getWinner() {
        if (getPlayerAt(0, 0) == PLAYER_X && getPlayerAt(0, 1) == PLAYER_X && getPlayerAt(0, 2) == PLAYER_X) {
            return PLAYER_X;
        }

        return 'O';
    }
}