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
        if (isAnyRowFilledByPlayer(PLAYER_X)) {
            winner = PLAYER_X;
        }

        if (isAnyRowFilledByPlayer(PLAYER_O)) {
            winner = PLAYER_O;
        }

        if (isFirstColumnFilledByPlayerX()) {
            winner = PLAYER_X;
        }

        if (isFirstColumnFilledByPlayerO(PLAYER_O)) {
            winner = PLAYER_O;
        }

        return winner;
    }

    private boolean isFirstColumnFilledByPlayerO(char playerO) {
        return getPlayerAt(POSITION_ZERO, POSITION_ZERO) == playerO
                && getPlayerAt(POSITION_ONE, POSITION_ZERO) == playerO
                && getPlayerAt(POSITION_TWO, POSITION_ZERO) == playerO;
    }

    private boolean isFirstColumnFilledByPlayerX() {
        return getPlayerAt(POSITION_ZERO, POSITION_ZERO) == PLAYER_X
                && getPlayerAt(POSITION_ONE, POSITION_ZERO) == PLAYER_X
                && getPlayerAt(POSITION_TWO, POSITION_ZERO) == PLAYER_X;
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