package com.example.bscs_3b_group_opina.server;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View {
    private JFrame frame;
    private JTextField userField;
    private JPasswordField passField;
    private JButton loginButton;

    public View() {
        frame = new JFrame("Client Login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 150);
        frame.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        JLabel userLabel = new JLabel("Username:");
        userField = new JTextField(15);

        JLabel passLabel = new JLabel("Password:");
        passField = new JPasswordField(15);

        loginButton = new JButton("Login");

        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridx = 0;
        gbc.gridy = 0;
        frame.add(userLabel, gbc);
        gbc.gridx = 1;
        frame.add(userField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        frame.add(passLabel, gbc);
        gbc.gridx = 1;
        frame.add(passField, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        frame.add(loginButton, gbc);

        frame.setLocationRelativeTo(null);
    }

    public void show() {
        frame.setVisible(true);
    }

    public void onLogin(ActionListener listener) {
        loginButton.addActionListener(listener);
    }

    public String getUsername() {
        return userField.getText();
    }

    public String getPassword() {
        return new String(passField.getPassword());
    }
}