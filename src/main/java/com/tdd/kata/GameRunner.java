package com.tdd.kata;

import com.tdd.kata.io.InputScanner;

import java.util.logging.Level;
import java.util.logging.Logger;

public class GameRunner {
    private static final Logger logger = Logger.getLogger(GameRunner.class.getName());
    private final InputScanner scanner;

    public GameRunner() {
        this(new InputScanner());
    }

    public GameRunner(InputScanner scanner) {
        this.scanner = scanner;
    }

    public void play() {
        StringBuilder instruction = new StringBuilder("Welcome to TicTacToe game!!\n")
                .append("This is a game on a board of size 3x3\n")
                .append("Position of each box is represented by a combination of two numbers as below\n")
                .append("0 0, 0 1, 0 2\n")
                .append("1 0, 1 1, 1 2\n")
                .append("2 0, 2 1, 2 2\n")
                .append("Choose one of these positions on a player's turn\n")
                .append("Game always starts with player 'X'\n")
                .append("Players cannot play on a position which is already played\n")
                .append("Mark your position:\n");
        print(instruction.toString());

        scanner.nextLine();
    }

    protected void print(String message) {
        logger.log(Level.INFO, message);
    }
}