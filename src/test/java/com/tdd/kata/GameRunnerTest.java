package com.tdd.kata;

import com.tdd.kata.io.InputScanner;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class GameRunnerTest {

    @Mock
    private InputScanner scanner;

    @Mock
    private Game game;

    @InjectMocks
    private GameRunner gameRunner;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        when(scanner.nextLine()).thenReturn("2 0");
        when(game.isOver()).thenReturn(false, true);
    }

    @Test
    public void instructionsShouldBePrintedOnGameStart() {
        String instruction = new StringBuilder("Welcome to TicTacToe game!!\n")
                .append("This is a game on a board of size 3x3\n")
                .append("Position of each box is represented by a combination of two numbers as below\n")
                .append("0 0, 0 1, 0 2\n")
                .append("1 0, 1 1, 1 2\n")
                .append("2 0, 2 1, 2 2\n")
                .append("Choose one of these positions on a player's turn\n")
                .append("Game always starts with player 'X'\n")
                .append("Players cannot play on a position which is already played\n")
                .append("Mark your position:\n").toString();
        TestableGameRunner testableGameRunner = new TestableGameRunner(scanner, game);

        testableGameRunner.play();

        assertThat(testableGameRunner.getMessage(), is(instruction));
    }

    @Test
    public void positionInputShouldBeCollectedAfterPrintingInstructions() {
        gameRunner.play();

        verify(scanner, atLeastOnce()).nextLine();
    }

    @Test
    public void collectedPositionInputShouldBePassedToGame() {
        gameRunner.play();

        verify(game, atLeastOnce()).playAt(2, 0);
    }

    @Test
    public void gameShouldBePlayedUntilItsOver() {
        when(scanner.nextLine()).thenReturn("2 0", "1 0", "2 1");
        when(game.isOver()).thenReturn(false, false, false, true);

        gameRunner.play();

        verify(scanner, times(3)).nextLine();
        verify(game, times(3)).playAt(anyInt(), anyInt());
    }

    private class TestableGameRunner extends GameRunner {
        public TestableGameRunner(InputScanner scanner, Game game) {
            super(scanner, game);
        }

        private String message;

        @Override
        protected void print(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }
}