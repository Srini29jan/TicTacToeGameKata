package com.tdd.kata;

public class Game {

    private static final int GRID_SIZE = 3;
    private static final int POSITION_ZERO = 0;
    private static final int POSITION_ONE = 1;
    private static final int POSITION_TWO = 2;
    private static final char CHARACTER_NULL = '\0';
    private final char[][] board = new char[GRID_SIZE][GRID_SIZE];
    private char previousPlayer;
    private int numberOfCellsFilled = 0;

    public char getPlayerAt(int row, int column) {
        return board[row][column];
    }

    public void playAt(int row, int column) throws InvalidMoveException {
        if (row >= POSITION_ZERO && row <= POSITION_TWO) {
            char currentPlayer = getCurrentPlayer();
            board[row][column] = currentPlayer;
            numberOfCellsFilled++;
            setPreviousPlayer(currentPlayer);
        } else {
            throw new InvalidMoveException("Invalid position; please choose from position 0 or 1 or 2");
        }
    }

    private void setPreviousPlayer(char currentPlayer) {
        previousPlayer = currentPlayer;
    }

    private char getCurrentPlayer() {
        return previousPlayer == Player.PLAYER_X.getValue() ? Player.PLAYER_O.getValue() : Player.PLAYER_X.getValue();
    }

    public char getWinner() {
        char winner = CHARACTER_NULL;
        if (isGameWonByPlayer(Player.PLAYER_X.getValue())) {
            winner = Player.PLAYER_X.getValue();
        }

        if (isGameWonByPlayer(Player.PLAYER_O.getValue())) {
            winner = Player.PLAYER_O.getValue();
        }

        return winner;
    }

    private boolean isGameWonByPlayer(char player) {
        return isAnyRowFilledByPlayer(player)
                || isAnyColumnFilledByPlayer(player)
                || isAnyDiagonalFilledByPlayer(player);
    }

    private boolean isAnyDiagonalFilledByPlayer(char player) {
        return isTopLeftToBottomRightDiagonalFilledByPlayer(player)
                || isTopRightToBottomLeftDiagonalFilledByPlayer(player);
    }

    private boolean isTopRightToBottomLeftDiagonalFilledByPlayer(char player) {
        return getPlayerAt(POSITION_ZERO, POSITION_TWO) == player
                && getPlayerAt(POSITION_ONE, POSITION_ONE) == player
                && getPlayerAt(POSITION_TWO, POSITION_ZERO) == player;
    }

    private boolean isTopLeftToBottomRightDiagonalFilledByPlayer(char player) {
        return getPlayerAt(POSITION_ZERO, POSITION_ZERO) == player
                && getPlayerAt(POSITION_ONE, POSITION_ONE) == player
                && getPlayerAt(POSITION_TWO, POSITION_TWO) == player;
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

    public boolean isOver() {
        char winner = getWinner();
        return winner == Player.PLAYER_X.getValue() || winner == Player.PLAYER_O.getValue() || isDraw();
    }

    public boolean isDraw() {
        boolean isDraw = false;
        if (numberOfCellsFilled == 9 && getWinner() == CHARACTER_NULL) {
            isDraw = true;
        }
        return isDraw;
    }
}