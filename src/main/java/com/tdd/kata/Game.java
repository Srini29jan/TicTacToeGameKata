package com.tdd.kata;

public class Game {

    private static final int GRID_SIZE = 3;
    private static final int POSITION_ZERO = 0;
    private static final char PLAYER_X = 'X';
    private static final char PLAYER_O = 'O';
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
        return previousPlayer == PLAYER_X ? PLAYER_O : PLAYER_X;
    }

    public char getWinner() {
        if (getPlayerAt(POSITION_ZERO, POSITION_ZERO) == PLAYER_X && getPlayerAt(POSITION_ZERO, 1) == PLAYER_X && getPlayerAt(POSITION_ZERO, 2) == PLAYER_X) {
            return PLAYER_X;
        }

        return PLAYER_O;
    }
}