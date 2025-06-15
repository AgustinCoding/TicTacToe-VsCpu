package com.tateti.controller;

import com.tateti.model.Bot;
import com.tateti.model.Game;
import com.tateti.view.GameWindow;
import com.tateti.view.LoginView;
import com.tateti.view.RegisterView;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

// Game controller es la clase principal
// Se encarga de manejar eventos mediante inputs de GameWindow -> Game
// Contiene el metodo main
// Instancia las clases GameController y GameWindow


/*
TODO - 1: Implementar panel de registro y login + SQLite
 */

public class GameController {
    static char actualPlayer;

    public static void main(String[] args) {

        String[] options = {"Jugador vs Jugador", "Jugador vs CPU"};

        // Dialogo para solicitar modo de juego mediante OptionPane - OptionDialog
        int selectedMode = JOptionPane.showOptionDialog(
                null,
                "Selecciona modo de juego:",
                "Modo de juego",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]
        );

        boolean vsCpu = (selectedMode == 1);

        Game game = new Game(); // Instancia de la clase Game - model
        GameWindow gameWndw = new GameWindow(); // Instancia de la clase GameWindow - view
        Bot bot = new Bot(game);
        int boardLength = game.getBoardLength();


        char initialTurn = game.getTurn(); // Default turno para jugador en j vs cpu
        bot.setTurn(initialTurn == 'X' ? 'O' : 'X');
        char botTurn = bot.getTurn();

        JOptionPane.showMessageDialog(gameWndw, ("Comienza el jugador: " + initialTurn));

        JButton[][] buttons = gameWndw.getButtons();

        for (int i = 0; i < boardLength; i++) {
            for (int j = 0; j < boardLength; j++) {
                final int row = i;
                final int col = j;
                buttons[i][j].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (!game.isGameEnded()) {
                            char player = game.getTurn();
                            actualPlayer = player;
                            boolean successfullMove = game.makeMove(row, col);
                            if (successfullMove) {

                                buttons[row][col].setText(String.valueOf(player));
                                buttons[row][col].setEnabled(false);

                                if (game.getMoveCounter() <= 8 && vsCpu && (!game.isGameEnded())) {
                                    actualPlayer = game.getTurn();
                                    bot.randomMove();
                                    int[] botMoves = bot.getLastMove();
                                    buttons[botMoves[0]][botMoves[1]].setText(String.valueOf(botTurn));
                                    buttons[botMoves[0]][botMoves[1]].setEnabled(false);
                                }

                                System.out.println("[debug] board: " + Arrays.deepToString(game.getBoard()));
                            }

                            if (game.isGameEnded()) {
                                String message = "Error";
                                if (game.isDraw()) {
                                    message = "Empate!";
                                } else {
                                    message = "Ganó " + actualPlayer + "!";
                                }

                                JOptionPane.showMessageDialog(gameWndw, message);
                            }
                        }
                    }
                });
            }
        }
    }
}
