package com.tateti.model;

import com.tateti.model.Game;
import java.util.Random;

public class Bot {
    private final Game game;
    private final Random rand = new Random();
    private char turn;
    private int[] lastMove = new int[2];

    public Bot(Game game){
        this.game = game;
    }

    public void randomMove(){
        char[][] board = game.getBoard();
        
        while(true){
            int row = rand.nextInt(0, 3);
            int col = rand.nextInt(0, 3);
            boolean successfulMove = game.makeMove(row, col);
            if(successfulMove){
                System.out.println("[debug] Bot played " + row + " . " + col);
                lastMove[0] = row;
                lastMove[1] = col;
                break;
            }


        }

    }

    public void setTurn(char turn){
        this.turn = turn;
    }

    public char getTurn(){
        return this.turn;
    }

    public int[] getLastMove(){
        return this.lastMove;
    }


}
