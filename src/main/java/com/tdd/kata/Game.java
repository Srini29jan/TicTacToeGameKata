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
                || isAnyColumnFilledByPlayer(PLAYER_X)) {
            winner = PLAYER_X;
        }

        if (isAnyRowFilledByPlayer(PLAYER_O)
                || isAnyColumnFilledByPlayer(PLAYER_O)) {
            winner = PLAYER_O;
        }

        if (isTopLeftToBottomRightDiagonalFilledByPlayerO(PLAYER_X)) {
            winner = PLAYER_X;
        }

        if (isTopLeftToBottomRightDiagonalFilledByPlayerO(PLAYER_O)) {
            winner = PLAYER_O;
        }

        return winner;
    }

    private boolean isTopLeftToBottomRightDiagonalFilledByPlayerO(char playerO) {
        return getPlayerAt(POSITION_ZERO, POSITION_ZERO) == playerO
                && getPlayerAt(POSITION_ONE, POSITION_ONE) == playerO
                && getPlayerAt(POSITION_TWO, POSITION_TWO) == playerO;
    }

    private boolean isTopLeftToBottomRightDiagonalFilledByPlayerX() {
        return getPlayerAt(POSITION_ZERO, POSITION_ZERO) == PLAYER_X
                && getPlayerAt(POSITION_ONE, POSITION_ONE) == PLAYER_X
                && getPlayerAt(POSITION_TWO, POSITION_TWO) == PLAYER_X;
    }

    private boolean isAnyColumnFilledByPlayer(char player) {
        return isColumnFilledByPlayer(POSITION_ZERO, player)
                || isColumnFilledByPlayer(POSITION_ONE, player)
                || isColumnFilledByPlayer(POSITION_TWO, player);
    }

    private boolean isColumnFilledByPlayer(int columnPosition, char player) {
        return getPlayerAt(POSITION_ZERO, columnPosition) == player
                && getPlayerAt(POSITION_ONE, columnPosition) == player
                && getPlayerAt(POSITION_TWO, columnPosition) == player;
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