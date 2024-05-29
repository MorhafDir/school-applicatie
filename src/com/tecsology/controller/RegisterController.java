package com.tecsology.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.tecsology.view.LoginScreen;
import com.tecsology.view.RegisterScreen;

public class RegisterController {

    private static RegisterController registerController;

    private RegisterController() {
        
    }

    public static RegisterController getInstance() {
        if (registerController == null) {
            registerController = new RegisterController();
        }
        return registerController;
    }

    public ActionListener getLoginButtonListener() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new LoginScreen().setVisible(true);
                RegisterScreen.getRegisterScreen().dispose();
            }
        };
    }

    public ActionListener getRegisterButtonListener() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userName = RegisterScreen.getUserNameField().getText();
                String password = new String(RegisterScreen.getPasswordField().getPassword());
                String role = (String) RegisterScreen.getRoleComboBox().getSelectedItem();

                if (registerUser(userName, password, role)) {
                    RegisterScreen.getStatusLabel().setText("Registration successful!");
                } else {
                    RegisterScreen.getStatusLabel().setText("Registration failed.");
                }
            }
        };
    }

    public boolean registerUser(String userName, String password, String role) {
        String table = role.equalsIgnoreCase("teacher") ? "Teacher" : "Student";

        String sql = "INSERT INTO " + table + " (userName, password, role) VALUES (?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, userName);
            pstmt.setString(2, password);
            pstmt.setString(3, role);

            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
            return false;
        }
    }
}
