package com.tdd.kata;

public class Game {

    private static final int GRID_SIZE = 3;
    private static final int POSITION_ZERO = 0;
    private static final int POSITION_ONE = 1;
    private static final int POSITION_TWO = 2;
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
        char winner = '\0';
        if (isAnyRowFilledByPlayer(PLAYER_X)
                || isFirstColumnFilledByPlayer(PLAYER_X, POSITION_ZERO)
                || isFirstColumnFilledByPlayer(PLAYER_X, POSITION_ONE)
                || isFirstColumnFilledByPlayer(PLAYER_X, POSITION_TWO)) {
            winner = PLAYER_X;
        }

        if (isAnyRowFilledByPlayer(PLAYER_O)
                || isFirstColumnFilledByPlayer(PLAYER_O, POSITION_ZERO)
                || isFirstColumnFilledByPlayer(PLAYER_O, POSITION_ONE)
                || isFirstColumnFilledByPlayer(PLAYER_O, POSITION_TWO)) {
            winner = PLAYER_O;
        }

        return winner;
    }

    private boolean isFirstColumnFilledByPlayer(char player, int positionZero) {
        return getPlayerAt(POSITION_ZERO, positionZero) == player
                && getPlayerAt(POSITION_ONE, positionZero) == player
                && getPlayerAt(POSITION_TWO, positionZero) == player;
    }

    private boolean isAnyRowFilledByPlayer(char player) {
        return isRowFilledByPlayer(POSITION_ZERO, player)
                || isRowFilledByPlayer(POSITION_ONE, player)
                || isRowFilledByPlayer(POSITION_TWO, player);
    }

    private boolean isRowFilledByPlayer(int rowPosition, char player) {
        return getPlayerAt(rowPosition, POSITION_ZERO) == player
                && getPlayerAt(rowPosition, POSITION_ONE) == player
                && getPlayerAt(rowPosition, POSITION_TWO) == player;
    }
}