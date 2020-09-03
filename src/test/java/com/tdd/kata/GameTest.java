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
    private static final char PLAYER_X = 'X';
    private static final char PLAYER_O = 'O';
    private static final char CHARACTER_NULL = '\0';
    private Game game;

    @Before
    public void initializeGame() {
        game = new Game();
    }

    @Test
    public void getPlayerAtShouldReturnXAfterFirstTurn() {
        game.playAt(POSITION_ZERO, POSITION_ZERO);

        assertThat(game.getPlayerAt(POSITION_ZERO, POSITION_ZERO), is(PLAYER_X));
    }

    @Test
    public void getPlayerAtShouldReturnOAfterSecondTurn() {
        game.playAt(POSITION_ZERO, POSITION_ZERO);
        game.playAt(POSITION_ZERO, POSITION_ONE);

        assertThat(game.getPlayerAt(POSITION_ZERO, POSITION_ONE), is(PLAYER_O));
    }

    @Test
    public void getWinnerShouldReturnXIfXFillsFirstRow() {
        game.playAt(POSITION_ZERO, POSITION_ZERO);
        game.playAt(POSITION_ONE, POSITION_ZERO);
        game.playAt(POSITION_ZERO, POSITION_ONE);
        game.playAt(POSITION_ONE, POSITION_ONE);
        game.playAt(POSITION_ZERO, POSITION_TWO);

        assertThat(game.getWinner(), is(PLAYER_X));
    }

    @Test
    public void getWinnerShouldReturnOIfOFillsFirstRow() {
        game.playAt(POSITION_TWO, POSITION_ZERO);
        game.playAt(POSITION_ZERO, POSITION_ZERO);
        game.playAt(POSITION_ONE, POSITION_ZERO);
        game.playAt(POSITION_ZERO, POSITION_ONE);
        game.playAt(POSITION_ONE, POSITION_ONE);
        game.playAt(POSITION_ZERO, POSITION_TWO);

        assertThat(game.getWinner(), is(PLAYER_O));
    }

    @Test
    public void getWinnerShouldReturnEmptyCharacterIfFirstRowIsNotFilledBySamePlayer() {
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
    public void getWinnerShouldReturnXIfXFillsSecondRow() {
        game.playAt(POSITION_ONE, POSITION_ZERO);
        game.playAt(POSITION_ZERO, POSITION_ZERO);
        game.playAt(POSITION_ONE, POSITION_ONE);
        game.playAt(POSITION_ZERO, POSITION_ONE);
        game.playAt(POSITION_ONE, POSITION_TWO);

        assertThat(game.getWinner(), is(PLAYER_X));
    }

    @Test
    public void getWinnerShouldReturnOIfOFillsSecondRow() {
        game.playAt(POSITION_TWO, POSITION_TWO);
        game.playAt(POSITION_ONE, POSITION_ZERO);
        game.playAt(POSITION_ZERO, POSITION_ZERO);
        game.playAt(POSITION_ONE, POSITION_ONE);
        game.playAt(POSITION_ZERO, POSITION_ONE);
        game.playAt(POSITION_ONE, POSITION_TWO);

        assertThat(game.getWinner(), is(PLAYER_O));
    }

    @Test
    public void getWinnerShouldReturnXIfXFillsThirdRow() {
        game.playAt(POSITION_TWO, POSITION_ZERO);
        game.playAt(POSITION_ZERO, POSITION_ZERO);
        game.playAt(POSITION_TWO, POSITION_ONE);
        game.playAt(POSITION_ZERO, POSITION_ONE);
        game.playAt(POSITION_TWO, POSITION_TWO);

        assertThat(game.getWinner(), is(PLAYER_X));
    }

    @Test
    public void getWinnerShouldReturnOIfOFillsThirdRow() {
        game.playAt(POSITION_ONE, POSITION_ONE);
        game.playAt(POSITION_TWO, POSITION_ZERO);
        game.playAt(POSITION_ZERO, POSITION_ZERO);
        game.playAt(POSITION_TWO, POSITION_ONE);
        game.playAt(POSITION_ZERO, POSITION_ONE);
        game.playAt(POSITION_TWO, POSITION_TWO);

        assertThat(game.getWinner(), is(PLAYER_O));
    }

    @Test
    public void getWinnerShouldReturnXIfXFillsFirstColumn() {
        game.playAt(POSITION_ZERO, POSITION_ZERO);
        game.playAt(POSITION_ZERO, POSITION_ONE);
        game.playAt(POSITION_ONE, POSITION_ZERO);
        game.playAt(POSITION_ZERO, POSITION_TWO);
        game.playAt(POSITION_TWO, POSITION_ZERO);

        assertThat(game.getWinner(), is(PLAYER_X));
    }

    @Test
    public void getWinnerShouldReturnOIfOFillsFirstColumn() {
        game.playAt(POSITION_TWO, POSITION_TWO);
        game.playAt(POSITION_ZERO, POSITION_ZERO);
        game.playAt(POSITION_ZERO, POSITION_ONE);
        game.playAt(POSITION_ONE, POSITION_ZERO);
        game.playAt(POSITION_ZERO, POSITION_TWO);
        game.playAt(POSITION_TWO, POSITION_ZERO);

        assertThat(game.getWinner(), is(PLAYER_O));
    }

    @Test
    public void getWinnerShouldReturnXIfXFillsSecondColumn() {
        game.playAt(POSITION_ZERO, POSITION_ONE);
        game.playAt(POSITION_ZERO, POSITION_ZERO);
        game.playAt(POSITION_ONE, POSITION_ONE);
        game.playAt(POSITION_ZERO, POSITION_TWO);
        game.playAt(POSITION_TWO, POSITION_ONE);

        assertThat(game.getWinner(), is(PLAYER_X));
    }

    @Test
    public void getWinnerShouldReturnOIfOFillsSecondColumn() {
        game.playAt(POSITION_TWO, POSITION_ZERO);
        game.playAt(POSITION_ZERO, POSITION_ONE);
        game.playAt(POSITION_ZERO, POSITION_TWO);
        game.playAt(POSITION_ONE, POSITION_ONE);
        game.playAt(POSITION_ZERO, POSITION_ZERO);
        game.playAt(POSITION_TWO, POSITION_ONE);

        assertThat(game.getWinner(), is(PLAYER_O));
    }

    @Test
    public void getWinnerShouldReturnXIfXFillsThirdColumn() {
        game.playAt(POSITION_ZERO, POSITION_TWO);
        game.playAt(POSITION_ZERO, POSITION_ZERO);
        game.playAt(POSITION_ONE, POSITION_TWO);
        game.playAt(POSITION_ZERO, POSITION_ONE);
        game.playAt(POSITION_TWO, POSITION_TWO);

        assertThat(game.getWinner(), is(PLAYER_X));
    }

    @Test
    public void getWinnerShouldReturnOIfOFillsThirdColumn() {
        game.playAt(POSITION_ONE, POSITION_ONE);
        game.playAt(POSITION_ZERO, POSITION_TWO);
        game.playAt(POSITION_ZERO, POSITION_ZERO);
        game.playAt(POSITION_TWO, POSITION_TWO);
        game.playAt(POSITION_ZERO, POSITION_ONE);
        game.playAt(POSITION_ONE, POSITION_TWO);

        assertThat(game.getWinner(), is(PLAYER_O));
    }

    @Test
    public void getWinnerShouldReturnXIfXFillsTopLeftToBottomRightDiagonal() {
        game.playAt(POSITION_ZERO, POSITION_ZERO);
        game.playAt(POSITION_ZERO, POSITION_TWO);
        game.playAt(POSITION_ONE, POSITION_ONE);
        game.playAt(POSITION_ZERO, POSITION_ONE);
        game.playAt(POSITION_TWO, POSITION_TWO);

        assertThat(game.getWinner(), is(PLAYER_X));
    }

    @Test
    public void getWinnerShouldReturnOIfOFillsTopLeftToBottomRightDiagonal() {
        game.playAt(POSITION_ONE, POSITION_ZERO);
        game.playAt(POSITION_ZERO, POSITION_ZERO);
        game.playAt(POSITION_ZERO, POSITION_TWO);
        game.playAt(POSITION_ONE, POSITION_ONE);
        game.playAt(POSITION_ZERO, POSITION_ONE);
        game.playAt(POSITION_TWO, POSITION_TWO);

        assertThat(game.getWinner(), is(PLAYER_O));
    }

    @Test
    public void getWinnerShouldReturnXIfXFillsTopRightToBottomLeftDiagonal() {
        game.playAt(POSITION_TWO, POSITION_ZERO);
        game.playAt(POSITION_ZERO, POSITION_ONE);
        game.playAt(POSITION_ONE, POSITION_ONE);
        game.playAt(POSITION_TWO, POSITION_TWO);
        game.playAt(POSITION_ZERO, POSITION_TWO);

        assertThat(game.getWinner(), is(PLAYER_X));
    }

    @Test
    public void getWinnerShouldReturnOIfOFillsTopRightToBottomLeftDiagonal() {
        game.playAt(POSITION_ONE, POSITION_TWO);
        game.playAt(POSITION_TWO, POSITION_ZERO);
        game.playAt(POSITION_ZERO, POSITION_ONE);
        game.playAt(POSITION_ONE, POSITION_ONE);
        game.playAt(POSITION_TWO, POSITION_TWO);
        game.playAt(POSITION_ZERO, POSITION_TWO);

        assertThat(game.getWinner(), is(PLAYER_O));
    }

    @Test
    public void getWinnerShouldReturnNullIfAllCellsAreFilledAndNeitherPlayerWon() {
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
    public void isDrawShouldReturnTrueIfAllCellsAreFilledAndNeitherPlayerWon() {
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
    public void isOverShouldReturnTrueIfPlayerXWon() {
        game.playAt(POSITION_ZERO, POSITION_ZERO);
        game.playAt(POSITION_ONE, POSITION_ZERO);
        game.playAt(POSITION_ZERO, POSITION_ONE);
        game.playAt(POSITION_ONE, POSITION_ONE);
        game.playAt(POSITION_ZERO, POSITION_TWO);

        assertTrue(game.isOver());
    }

    @Test
    public void isOverShouldReturnTrueIfPlayerOWon() {
        game.playAt(POSITION_TWO, POSITION_ZERO);
        game.playAt(POSITION_ZERO, POSITION_ZERO);
        game.playAt(POSITION_ONE, POSITION_ZERO);
        game.playAt(POSITION_ZERO, POSITION_ONE);
        game.playAt(POSITION_ONE, POSITION_ONE);
        game.playAt(POSITION_ZERO, POSITION_TWO);

        assertTrue(game.isOver());
    }
}