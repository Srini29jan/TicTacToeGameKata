# Tic Tac Toe Game
 This kata is developed in Java programming language by following TDD (Test Driven Development) approach.

# Rules
 The rules are described below :
 
 - X always goes first.
 - Players cannot play on a played position.
 - Players alternate placing X’s and O’s on the board until either:
 	- One player has three in a row, horizontally, vertically or diagonally
 	- All nine squares are filled.
 - If a player is able to draw three X’s or three O’s in a row, that player wins.
 - If all nine squares are filled and neither player has three in a row, the game is a draw.

# Prerequisite
 ~~~
 Java 1.8+
 Junit 4.11+
 Maven 3.6.3+
 Mockito 1.10.19+
 ~~~
# Set up application
## IDE
1. Clone the repository https://github.com/Srini29jan/TicTacToeGameKata
2. Add as Maven project
3. Select Project SDK as JDK 1.8

## command prompt
1. Clone repository from GIT 'https://github.com/Srini29jan/TicTacToeGameKata'
2. Run `mvn clean install`

# Run Test Cases
## IDE
1. Navigate to Maven Toolbar
2. Select `test` under lifecycle menu and click on play symbol

## Command Prompt
1. Go to the directory where you have cloned the Tennis program (C:\Study\Workspace\TennisGame)
2. Run `mvn test`
