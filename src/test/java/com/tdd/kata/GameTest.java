package com.tdd.kata;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class GameTest {

    private static final int POSITION_ZERO = 0;
    private static final int POSITION_ONE = 1;
    private static final int POSITION_TWO = 2;
    private static final char CHARACTER_NULL = '\0';
    private Game game;

    @Before
    public void initializeGame() {
        game = new Game();
    }

    @Test
    public void getPlayerAtShouldReturnXAfterFirstTurn() throws InvalidMoveException {
        game.playAt(POSITION_ZERO, POSITION_ZERO);

        assertThat(game.getPlayerAt(POSITION_ZERO, POSITION_ZERO), is(Player.PLAYER_X.getValue()));
    }

    @Test
    public void getPlayerAtShouldReturnOAfterSecondTurn() throws InvalidMoveException {
        game.playAt(POSITION_ZERO, POSITION_ZERO);
        game.playAt(POSITION_ZERO, POSITION_ONE);

        assertThat(game.getPlayerAt(POSITION_ZERO, POSITION_ONE), is(Player.PLAYER_O.getValue()));
    }

    @Test
    public void getWinnerShouldReturnXIfXFillsFirstRow() throws InvalidMoveException {
        game.playAt(POSITION_ZERO, POSITION_ZERO);
        game.playAt(POSITION_ONE, POSITION_ZERO);
        game.playAt(POSITION_ZERO, POSITION_ONE);
        game.playAt(POSITION_ONE, POSITION_ONE);
        game.playAt(POSITION_ZERO, POSITION_TWO);

        assertThat(game.getWinner(), is(Player.PLAYER_X.getValue()));
    }

    @Test
    public void getWinnerShouldReturnOIfOFillsFirstRow() throws InvalidMoveException {
        game.playAt(POSITION_TWO, POSITION_ZERO);
        game.playAt(POSITION_ZERO, POSITION_ZERO);
        game.playAt(POSITION_ONE, POSITION_ZERO);
        game.playAt(POSITION_ZERO, POSITION_ONE);
        game.playAt(POSITION_ONE, POSITION_ONE);
        game.playAt(POSITION_ZERO, POSITION_TWO);

        assertThat(game.getWinner(), is(Player.PLAYER_O.getValue()));
    }

    @Test
    public void getWinnerShouldReturnEmptyCharacterIfFirstRowIsNotFilledBySamePlayer() throws InvalidMoveException {
        game.playAt(POSITION_ONE, POSITION_ONE);
        game.playAt(POSITION_TWO, POSITION_ZERO);
        game.playAt(POSITION_ZERO, POSITION_ZERO);
        game.playAt(POSITION_TWO, POSITION_TWO);
        game.playAt(POSITION_TWO, POSITION_ONE);
        game.playAt(POSITION_ZERO, POSITION_ONE);
        game.playAt(POSITION_ZERO, POSITION_TWO);
        game.playAt(POSITION_ONE, POSITION_TWO);
        game.playAt(POSITION_ONE, POSITION_ZERO);

        assertThat(game.getWinner(), is(CHARACTER_NULL));
    }

    @Test
    public void getWinnerShouldReturnXIfXFillsSecondRow() throws InvalidMoveException {
        game.playAt(POSITION_ONE, POSITION_ZERO);
        game.playAt(POSITION_ZERO, POSITION_ZERO);
        game.playAt(POSITION_ONE, POSITION_ONE);
        game.playAt(POSITION_ZERO, POSITION_ONE);
        game.playAt(POSITION_ONE, POSITION_TWO);

        assertThat(game.getWinner(), is(Player.PLAYER_X.getValue()));
    }

    @Test
    public void getWinnerShouldReturnOIfOFillsSecondRow() throws InvalidMoveException {
        game.playAt(POSITION_TWO, POSITION_TWO);
        game.playAt(POSITION_ONE, POSITION_ZERO);
        game.playAt(POSITION_ZERO, POSITION_ZERO);
        game.playAt(POSITION_ONE, POSITION_ONE);
        game.playAt(POSITION_ZERO, POSITION_ONE);
        game.playAt(POSITION_ONE, POSITION_TWO);

        assertThat(game.getWinner(), is(Player.PLAYER_O.getValue()));
    }

    @Test
    public void getWinnerShouldReturnXIfXFillsThirdRow() throws InvalidMoveException {
        game.playAt(POSITION_TWO, POSITION_ZERO);
        game.playAt(POSITION_ZERO, POSITION_ZERO);
        game.playAt(POSITION_TWO, POSITION_ONE);
        game.playAt(POSITION_ZERO, POSITION_ONE);
        game.playAt(POSITION_TWO, POSITION_TWO);

        assertThat(game.getWinner(), is(Player.PLAYER_X.getValue()));
    }

    @Test
    public void getWinnerShouldReturnOIfOFillsThirdRow() throws InvalidMoveException {
        game.playAt(POSITION_ONE, POSITION_ONE);
        game.playAt(POSITION_TWO, POSITION_ZERO);
        game.playAt(POSITION_ZERO, POSITION_ZERO);
        game.playAt(POSITION_TWO, POSITION_ONE);
        game.playAt(POSITION_ZERO, POSITION_ONE);
        game.playAt(POSITION_TWO, POSITION_TWO);

        assertThat(game.getWinner(), is(Player.PLAYER_O.getValue()));
    }

    @Test
    public void getWinnerShouldReturnXIfXFillsFirstColumn() throws InvalidMoveException {
        game.playAt(POSITION_ZERO, POSITION_ZERO);
        game.playAt(POSITION_ZERO, POSITION_ONE);
        game.playAt(POSITION_ONE, POSITION_ZERO);
        game.playAt(POSITION_ZERO, POSITION_TWO);
        game.playAt(POSITION_TWO, POSITION_ZERO);

        assertThat(game.getWinner(), is(Player.PLAYER_X.getValue()));
    }

    @Test
    public void getWinnerShouldReturnOIfOFillsFirstColumn() throws InvalidMoveException {
        game.playAt(POSITION_TWO, POSITION_TWO);
        game.playAt(POSITION_ZERO, POSITION_ZERO);
        game.playAt(POSITION_ZERO, POSITION_ONE);
        game.playAt(POSITION_ONE, POSITION_ZERO);
        game.playAt(POSITION_ZERO, POSITION_TWO);
        game.playAt(POSITION_TWO, POSITION_ZERO);

        assertThat(game.getWinner(), is(Player.PLAYER_O.getValue()));
    }

    @Test
    public void getWinnerShouldReturnXIfXFillsSecondColumn() throws InvalidMoveException {
        game.playAt(POSITION_ZERO, POSITION_ONE);
        game.playAt(POSITION_ZERO, POSITION_ZERO);
        game.playAt(POSITION_ONE, POSITION_ONE);
        game.playAt(POSITION_ZERO, POSITION_TWO);
        game.playAt(POSITION_TWO, POSITION_ONE);

        assertThat(game.getWinner(), is(Player.PLAYER_X.getValue()));
    }

    @Test
    public void getWinnerShouldReturnOIfOFillsSecondColumn() throws InvalidMoveException {
        game.playAt(POSITION_TWO, POSITION_ZERO);
        game.playAt(POSITION_ZERO, POSITION_ONE);
        game.playAt(POSITION_ZERO, POSITION_TWO);
        game.playAt(POSITION_ONE, POSITION_ONE);
        game.playAt(POSITION_ZERO, POSITION_ZERO);
        game.playAt(POSITION_TWO, POSITION_ONE);

        assertThat(game.getWinner(), is(Player.PLAYER_O.getValue()));
    }

    @Test
    public void getWinnerShouldReturnXIfXFillsThirdColumn() throws InvalidMoveException {
        game.playAt(POSITION_ZERO, POSITION_TWO);
        game.playAt(POSITION_ZERO, POSITION_ZERO);
        game.playAt(POSITION_ONE, POSITION_TWO);
        game.playAt(POSITION_ZERO, POSITION_ONE);
        game.playAt(POSITION_TWO, POSITION_TWO);

        assertThat(game.getWinner(), is(Player.PLAYER_X.getValue()));
    }

    @Test
    public void getWinnerShouldReturnOIfOFillsThirdColumn() throws InvalidMoveException {
        game.playAt(POSITION_ONE, POSITION_ONE);
        game.playAt(POSITION_ZERO, POSITION_TWO);
        game.playAt(POSITION_ZERO, POSITION_ZERO);
        game.playAt(POSITION_TWO, POSITION_TWO);
        game.playAt(POSITION_ZERO, POSITION_ONE);
        game.playAt(POSITION_ONE, POSITION_TWO);

        assertThat(game.getWinner(), is(Player.PLAYER_O.getValue()));
    }

    @Test
    public void getWinnerShouldReturnXIfXFillsTopLeftToBottomRightDiagonal() throws InvalidMoveException {
        game.playAt(POSITION_ZERO, POSITION_ZERO);
        game.playAt(POSITION_ZERO, POSITION_TWO);
        game.playAt(POSITION_ONE, POSITION_ONE);
        game.playAt(POSITION_ZERO, POSITION_ONE);
        game.playAt(POSITION_TWO, POSITION_TWO);

        assertThat(game.getWinner(), is(Player.PLAYER_X.getValue()));
    }

    @Test
    public void getWinnerShouldReturnOIfOFillsTopLeftToBottomRightDiagonal() throws InvalidMoveException {
        game.playAt(POSITION_ONE, POSITION_ZERO);
        game.playAt(POSITION_ZERO, POSITION_ZERO);
        game.playAt(POSITION_ZERO, POSITION_TWO);
        game.playAt(POSITION_ONE, POSITION_ONE);
        game.playAt(POSITION_ZERO, POSITION_ONE);
        game.playAt(POSITION_TWO, POSITION_TWO);

        assertThat(game.getWinner(), is(Player.PLAYER_O.getValue()));
    }

    @Test
    public void getWinnerShouldReturnXIfXFillsTopRightToBottomLeftDiagonal() throws InvalidMoveException {
        game.playAt(POSITION_TWO, POSITION_ZERO);
        game.playAt(POSITION_ZERO, POSITION_ONE);
        game.playAt(POSITION_ONE, POSITION_ONE);
        game.playAt(POSITION_TWO, POSITION_TWO);
        game.playAt(POSITION_ZERO, POSITION_TWO);

        assertThat(game.getWinner(), is(Player.PLAYER_X.getValue()));
    }

    @Test
    public void getWinnerShouldReturnOIfOFillsTopRightToBottomLeftDiagonal() throws InvalidMoveException {
        game.playAt(POSITION_ONE, POSITION_TWO);
        game.playAt(POSITION_TWO, POSITION_ZERO);
        game.playAt(POSITION_ZERO, POSITION_ONE);
        game.playAt(POSITION_ONE, POSITION_ONE);
        game.playAt(POSITION_TWO, POSITION_TWO);
        game.playAt(POSITION_ZERO, POSITION_TWO);

        assertThat(game.getWinner(), is(Player.PLAYER_O.getValue()));
    }

    @Test
    public void getWinnerShouldReturnNullIfAllCellsAreFilledAndNeitherPlayerWon() throws InvalidMoveException {
        game.playAt(POSITION_ZERO, POSITION_ZERO);
        game.playAt(POSITION_ONE, POSITION_ONE);
        game.playAt(POSITION_TWO, POSITION_ZERO);
        game.playAt(POSITION_ONE, POSITION_ZERO);
        game.playAt(POSITION_ONE, POSITION_TWO);
        game.playAt(POSITION_ZERO, POSITION_ONE);
        game.playAt(POSITION_TWO, POSITION_ONE);
        game.playAt(POSITION_TWO, POSITION_TWO);
        game.playAt(POSITION_ZERO, POSITION_TWO);

        assertThat(game.getWinner(), is(CHARACTER_NULL));
    }

    @Test
    public void isDrawShouldReturnTrueIfAllCellsAreFilledAndNeitherPlayerWon() throws InvalidMoveException {
        game.playAt(POSITION_ZERO, POSITION_ZERO);
        game.playAt(POSITION_ONE, POSITION_ONE);
        game.playAt(POSITION_TWO, POSITION_ZERO);
        game.playAt(POSITION_ONE, POSITION_ZERO);
        game.playAt(POSITION_ONE, POSITION_TWO);
        game.playAt(POSITION_ZERO, POSITION_ONE);
        game.playAt(POSITION_TWO, POSITION_ONE);
        game.playAt(POSITION_TWO, POSITION_TWO);
        game.playAt(POSITION_ZERO, POSITION_TWO);

        assertTrue(game.isDraw());
    }

    @Test
    public void isOverShouldReturnTrueIfPlayerXWon() throws InvalidMoveException {
        game.playAt(POSITION_ZERO, POSITION_ZERO);
        game.playAt(POSITION_ONE, POSITION_ZERO);
        game.playAt(POSITION_ZERO, POSITION_ONE);
        game.playAt(POSITION_ONE, POSITION_ONE);
        game.playAt(POSITION_ZERO, POSITION_TWO);

        assertTrue(game.isOver());
    }

    @Test
    public void isOverShouldReturnTrueIfPlayerOWon() throws InvalidMoveException {
        game.playAt(POSITION_TWO, POSITION_ZERO);
        game.playAt(POSITION_ZERO, POSITION_ZERO);
        game.playAt(POSITION_ONE, POSITION_ZERO);
        game.playAt(POSITION_ZERO, POSITION_ONE);
        game.playAt(POSITION_ONE, POSITION_ONE);
        game.playAt(POSITION_ZERO, POSITION_TWO);

        assertTrue(game.isOver());
    }

    @Test
    public void isOverShouldReturnTrueIfNeitherPlayerWonAndAllCellsAreFilled() throws InvalidMoveException {
        game.playAt(POSITION_ZERO, POSITION_ZERO);
        game.playAt(POSITION_ONE, POSITION_ONE);
        game.playAt(POSITION_TWO, POSITION_ZERO);
        game.playAt(POSITION_ONE, POSITION_ZERO);
        game.playAt(POSITION_ONE, POSITION_TWO);
        game.playAt(POSITION_ZERO, POSITION_ONE);
        game.playAt(POSITION_TWO, POSITION_ONE);
        game.playAt(POSITION_TWO, POSITION_TWO);
        game.playAt(POSITION_ZERO, POSITION_TWO);

        assertTrue(game.isOver());
    }

    @Test(expected = InvalidMoveException.class)
    public void playAtShouldShouldThrowExceptionIfRowIsLessThanZero() throws InvalidMoveException {
        game.playAt(-POSITION_ONE, POSITION_ZERO);
    }

    @Test(expected = InvalidMoveException.class)
    public void playAtShouldShouldThrowExceptionIfRowIsGreaterThanTwo() throws InvalidMoveException {
        game.playAt(3, POSITION_ONE);
    }

    @Test(expected = InvalidMoveException.class)
    public void playAtShouldShouldThrowExceptionIfColumnIsLessThanZero() throws InvalidMoveException {
        game.playAt(POSITION_ZERO, -POSITION_ONE);
    }

    @Test(expected = InvalidMoveException.class)
    public void playAtShouldShouldThrowExceptionIfColumnIsGreaterThanTwo() throws InvalidMoveException {
        game.playAt(POSITION_ONE, 3);
    }

    @Test(expected = InvalidMoveException.class)
    public void playAtShouldShouldThrowExceptionIfSelectedPositionIsNotNull() throws InvalidMoveException {
        game.playAt(POSITION_ONE, POSITION_ONE);
        game.playAt(POSITION_ONE, POSITION_ONE);
    }
}