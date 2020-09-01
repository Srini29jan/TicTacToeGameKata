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
        if (isFirstRowFilledByPlayer(PLAYER_X)
                || isSecondRowFilledByPlayer(PLAYER_X)) {
            winner = PLAYER_X;
        }

        if (isFirstRowFilledByPlayer(PLAYER_O)
                || isSecondRowFilledByPlayer(PLAYER_O)) {
            winner = PLAYER_O;
        }

        if (isThirdRowFilledByPlayerX()) {
            winner = PLAYER_X;
        }

        if (isThirdRowFilledByPlayerO()) {
            winner = PLAYER_O;
        }

        return winner;
    }

    private boolean isThirdRowFilledByPlayerO() {
        return getPlayerAt(POSITION_TWO, POSITION_ZERO) == PLAYER_O
                && getPlayerAt(POSITION_TWO, POSITION_ONE) == PLAYER_O
                && getPlayerAt(POSITION_TWO, POSITION_TWO) == PLAYER_O;
    }

    private boolean isThirdRowFilledByPlayerX() {
        return getPlayerAt(POSITION_TWO, POSITION_ZERO) == PLAYER_X
                && getPlayerAt(POSITION_TWO, POSITION_ONE) == PLAYER_X
                && getPlayerAt(POSITION_TWO, POSITION_TWO) == PLAYER_X;
    }

    private boolean isSecondRowFilledByPlayer(char player) {
        return getPlayerAt(POSITION_ONE, POSITION_ZERO) == player
                && getPlayerAt(POSITION_ONE, POSITION_ONE) == player
                && getPlayerAt(POSITION_ONE, POSITION_TWO) == player;
    }

    private boolean isFirstRowFilledByPlayer(char player) {
        return getPlayerAt(POSITION_ZERO, POSITION_ZERO) == player
                && getPlayerAt(POSITION_ZERO, POSITION_ONE) == player
                && getPlayerAt(POSITION_ZERO, POSITION_TWO) == player;
    }
}