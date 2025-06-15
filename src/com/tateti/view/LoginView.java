package com.tateti.view;


import javax.swing.*;
import java.awt.*;

public class LoginView extends JFrame {

    public LoginView(){
        setTitle("Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400,200);
        setLocationRelativeTo(null);

        Render();
        setVisible(true);


    }

    private void Render(){
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2, 10, 10));

        // Username
        panel.add(new JLabel("Username:"));
        JTextField username = new JTextField();
        panel.add(username);

        // Password
        panel.add(new JLabel("Password:"));
        JPasswordField password = new JPasswordField();
        panel.add(password);

        // Login button
        JButton login = new JButton("Login");
        panel.add(login);

        this.add(panel);

    }


}
