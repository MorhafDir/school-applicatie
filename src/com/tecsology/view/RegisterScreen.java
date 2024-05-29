package com.tecsology.view;

import com.tecsology.controller.RegisterController;

import javax.swing.*;
import java.awt.*;

public class RegisterScreen extends JFrame {

    private static JLabel statusLabel;
    private static JTextField userNameField;
    private static JPasswordField passwordField;
    private static JComboBox<String> roleComboBox;
    private JButton loginButton;

    private static RegisterScreen registerScreen;

    public RegisterScreen() {
        setSize(500, 500);
        createUserInterface();
        setLocationRelativeTo(null);
        setVisible(true);
        registerScreen = this;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(RegisterScreen::new);
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

        wrapper.add(createRegisterField(), BorderLayout.CENTER);
        statusLabel = new JLabel();
        statusLabel.setForeground(Color.WHITE);
        statusLabel.setHorizontalAlignment(SwingConstants.CENTER);
        wrapper.add(statusLabel, BorderLayout.SOUTH);

        mainPanel.add(wrapper, BorderLayout.CENTER);

        return mainPanel;
    }

    private JPanel createRegisterField() {
        JPanel registerFieldPanel = new JPanel();
        registerFieldPanel.setLayout(new BoxLayout(registerFieldPanel, BoxLayout.Y_AXIS));
        registerFieldPanel.setPreferredSize(new Dimension(300, 300));
        registerFieldPanel.setBackground(Color.darkGray);
        registerFieldPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        userNameField = new JTextField();
        userNameField.setPreferredSize(new Dimension(275, 40));
        userNameField.setMaximumSize(userNameField.getPreferredSize());

        passwordField = new JPasswordField();
        passwordField.setPreferredSize(new Dimension(275, 40));
        passwordField.setMaximumSize(passwordField.getPreferredSize());

        String[] roles = { "student", "teacher" };
        roleComboBox = new JComboBox<>(roles);
        roleComboBox.setPreferredSize(new Dimension(275, 40));
        roleComboBox.setMaximumSize(roleComboBox.getPreferredSize());

        JButton registerButton = new JButton("Register");
        registerButton.setMargin(new Insets(10, 10, 10, 10));
        registerButton.setBackground(Color.YELLOW);
        registerButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        registerButton.addActionListener(RegisterController.getInstance().getRegisterButtonListener());

        loginButton = new JButton("Login");
        loginButton.setMargin(new Insets(10, 10, 10, 10));
        loginButton.setBackground(Color.CYAN);
        loginButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        loginButton.addActionListener(RegisterController.getInstance().getLoginButtonListener());

        
        addComponentWithSpacing(registerFieldPanel, new JLabel("Username:"));
        addComponentWithSpacing(registerFieldPanel, userNameField);
        addComponentWithSpacing(registerFieldPanel, new JLabel("Password:"));
        addComponentWithSpacing(registerFieldPanel, passwordField);
        addComponentWithSpacing(registerFieldPanel, new JLabel("Role:"));
        addComponentWithSpacing(registerFieldPanel, roleComboBox);
        addComponentWithSpacing(registerFieldPanel, registerButton);
        addComponentWithSpacing(registerFieldPanel, loginButton);

        return registerFieldPanel;
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

    public static JComboBox<String> getRoleComboBox() {
        return roleComboBox;
    }

    public static RegisterScreen getRegisterScreen() {
        return registerScreen;
    }
}
