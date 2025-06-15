package com.tateti.model;

<<<<<<< HEAD

import java.util.Arrays;
=======
>>>>>>> 6f7bb2e615ea988c6e82f19d6adda5b51ca27608
import java.util.Random;

public class Game {

    private char[][] board; // Represents the game grid
    private char turn; // 'X' or 'O'
    private boolean gameEnded; // Game ended flag
    private final Random rnd = new Random();
    private int boardLength = 0;
    private final char[] players = {'X', 'O'};
<<<<<<< HEAD
    private int moveCounter = 0;
=======
>>>>>>> 6f7bb2e615ea988c6e82f19d6adda5b51ca27608

    public Game() {
        board = new char[3][3];
        boardLength = board.length;
        restart();
    }

    public void restart() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                board[row][col] = '\0';
            }
        }
        gameEnded = false;
        turn = getRandomPlayer();
    }

    public char getRandomPlayer() {
        return (rnd.nextInt(0, 2) == 0) ? 'X' : 'O';
    }

    /**
     * Tries to make a move on (row, col).
     * @param row: Row index
     * @param col: Column index
     * @return True if the move was successful, false otherwise
     */
    public boolean makeMove(int row, int col) {
        if (isGameEnded()) return false;
        if (board[row][col] != '\0') return false;

        board[row][col] = turn;

        if (hasWinner(row, col)) {
            gameEnded = true;
            return true;
        }

        if (isDraw()) {
            gameEnded = true;
            return true;
        }

        // Change turn if no win or draw
        turn = (turn == players[0]) ? players[1] : players[0];
<<<<<<< HEAD
        moveCounter++;
=======
>>>>>>> 6f7bb2e615ea988c6e82f19d6adda5b51ca27608
        return true;
    }

    private boolean hasWinner(int row, int col) {
        char currentSymbol = board[row][col];

        // Check row
        if (board[row][0] == currentSymbol && board[row][1] == currentSymbol && board[row][2] == currentSymbol) {
            return true;
        }

        // Check column
        if (board[0][col] == currentSymbol && board[1][col] == currentSymbol && board[2][col] == currentSymbol) {
            return true;
        }

        // Check diagonals
        if (row == col) {
            if (board[0][0] == currentSymbol && board[1][1] == currentSymbol && board[2][2] == currentSymbol) {
                return true;
            }
        }

        if (row + col == 2) {
            if (board[0][2] == currentSymbol && board[1][1] == currentSymbol && board[2][0] == currentSymbol) {
                return true;
            }
        }

        return false;
    }

    public boolean isDraw() {
        // A draw only happens if the board is full and no one has won
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if (board[row][col] == '\0') {
                    return false;
                }
            }
        }

        return true;
    }

    public char getTurn() {
        return this.turn;
    }

    public boolean isGameEnded() {
        return this.gameEnded;
    }

    public int getBoardLength(){
        return this.boardLength;
    } //Assuming the board is a square

    public char[][] getBoard(){
        return this.board;
    }
<<<<<<< HEAD

    public int getMoveCounter() {return this.moveCounter;}

    public String boardToString(){
        return Arrays.deepToString(this.board);
    }
=======
>>>>>>> 6f7bb2e615ea988c6e82f19d6adda5b51ca27608
}
