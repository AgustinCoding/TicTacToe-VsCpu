package com.tateti.view;

import javax.swing.*;
import java.awt.*;


// GameWindow extends javax.swing.JFrame
// Esta clase esta encargada de organizar y definir la interfaz grafica del juego
public class GameWindow extends JFrame {

    private JButton[][] buttons; // Future 3x3 buttons matrix

    // Defining constructor method por GameWindow
    public GameWindow() { // no params needed
        setTitle("TaTeTi - Game"); // Window title
        setSize(400, 400); // Window size on pixels 400h 400w
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // End program when window is closed
        setLocationRelativeTo(null); // Defines where the window pops up, null: center
        InitializeBoard(); // Class method: Organizes objects in window
        setVisible(true); // Makes the window visible
    }

    private void InitializeBoard(){
        // This method creates a JPanel and sets a 3x3 GridLayout on it
        // Each grid contains a button
        JPanel gamePanel = new JPanel(); // Main panel
        gamePanel.setLayout(new GridLayout(3, 3)); // Sets a grid layout 3x3 for main panel

        // Set buttons
        buttons = new JButton[3][3]; // Define matrix range
        for(int row = 0; row < 3; row++){
            for(int col = 0; col < 3; col++){
                JButton button = new JButton();
                button.setFocusPainted(false); // Remove button highlighting
                button.setFont(new Font("Arial", Font.BOLD, 60)); // Defines the font for the text inside button ('X' || 'O')
                gamePanel.add(button); // Adds button inside JPanel object
                buttons[row][col] = button; // Instance a button object to the matrix
            }
        }
        this.add(gamePanel); // this = JFrame | Adds JPanel gamePanel on parent JFrame of class

    }

    // Getter for this.buttons
    public JButton[][] getButtons(){
        return this.buttons;
    }

}
