package com.tecsology.view;

import com.tecsology.controller.LoginController;

import javax.swing.*;
import java.awt.*;

public class LoginScreen extends JFrame {

    private static JLabel statusLabel;
    private static JTextField userNameField;
    private static JPasswordField passwordField;
    private JButton registerButton;

    private static LoginScreen loginScreen;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            loginScreen = new LoginScreen();
            loginScreen.setSize(500, 500);
            loginScreen.createUserInterface();
            loginScreen.setLocationRelativeTo(null);
            loginScreen.setVisible(true);
        });
    }

    private void createUserInterface() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container contentPanel = getContentPane();
        contentPanel.setBackground(Color.black);
        contentPanel.setLayout(new BorderLayout());
        contentPanel.add(createMainPanel(), BorderLayout.CENTER);
    }

    private JPanel createMainPanel() {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setPreferredSize(new Dimension(500, 500));
        mainPanel.setBackground(Color.gray);

        JPanel wrapper = new JPanel();
        wrapper.setLayout(new BorderLayout());
        wrapper.setPreferredSize(new Dimension(500, 500));
        wrapper.setBackground(Color.black);

        wrapper.add(createLoginField(), BorderLayout.CENTER);
        statusLabel = new JLabel();
        statusLabel.setForeground(Color.WHITE);
        statusLabel.setHorizontalAlignment(SwingConstants.CENTER);
        wrapper.add(statusLabel, BorderLayout.SOUTH);

        mainPanel.add(wrapper, BorderLayout.CENTER);

        return mainPanel;
    }

    private JPanel createLoginField() {
        JPanel loginFieldPanel = new JPanel();
        loginFieldPanel.setLayout(new BoxLayout(loginFieldPanel, BoxLayout.Y_AXIS));
        loginFieldPanel.setPreferredSize(new Dimension(300, 300));
        loginFieldPanel.setBackground(Color.darkGray);
        loginFieldPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        userNameField = new JTextField();
        userNameField.setPreferredSize(new Dimension(275, 40));
        userNameField.setMaximumSize(userNameField.getPreferredSize());

        passwordField = new JPasswordField();
        passwordField.setPreferredSize(new Dimension(275, 40));
        passwordField.setMaximumSize(passwordField.getPreferredSize());

        JButton loginButton = new JButton("Inloggen");
        loginButton.setMargin(new Insets(10, 10, 10, 10));
        loginButton.setBackground(Color.YELLOW);
        loginButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        loginButton.addActionListener(LoginController.buttonListener);

        registerButton = new JButton("Register");
        registerButton.setMargin(new Insets(10, 10, 10, 10));
        registerButton.setBackground(Color.GREEN);
        registerButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        registerButton.addActionListener(LoginController.registerButtonListener);

        
        addComponentWithSpacing(loginFieldPanel, new JLabel("Username:"));
        addComponentWithSpacing(loginFieldPanel, userNameField);
        addComponentWithSpacing(loginFieldPanel, new JLabel("Password:"));
        addComponentWithSpacing(loginFieldPanel, passwordField);
        addComponentWithSpacing(loginFieldPanel, loginButton);
        addComponentWithSpacing(loginFieldPanel, registerButton);

        return loginFieldPanel;
    }

    private void addComponentWithSpacing(JPanel panel, JComponent component) {
        panel.add(component);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
    }

    public static JLabel getStatusLabel() {
        return statusLabel;
    }

    public static JTextField getUserNameField() {
        return userNameField;
    }

    public static JPasswordField getPasswordField() {
        return passwordField;
    }

    public static LoginScreen getLoginScreen() {
        return loginScreen;
    }
}
