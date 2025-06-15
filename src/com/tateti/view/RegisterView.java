package com.tateti.view;

import javax.swing.*;
import java.awt.*;

public class RegisterView extends JFrame {


    public RegisterView() {
        setTitle("Register");
        setSize(400,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        Render();


        setVisible(true);

    }

    private void Render(){
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2, 10, 10));

        // Username
        panel.add(new JLabel("Usuario:"));
        JTextField username = new JTextField();
        panel.add(username);

        // Password
        panel.add(new JLabel("Password:"));
        JPasswordField password = new JPasswordField();
        panel.add(password);

        // Register button
        JButton registerButton = new JButton("Registrar");
        panel.add(registerButton);

        this.add(panel);
    }

}
