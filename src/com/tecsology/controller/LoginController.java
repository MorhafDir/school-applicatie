package com.tecsology.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

import com.tecsology.model.Student;
import com.tecsology.view.LoginScreen;
import com.tecsology.view.StudentDashboard;
import com.tecsology.view.TeacherDashboard;
import com.tecsology.view.RegisterScreen;

public class LoginController {

    public static ActionListener buttonListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String userName = LoginScreen.getUserNameField().getText();
            String password = new String(LoginScreen.getPasswordField().getPassword());

            String role = loginUser(userName, password);
            if (role != null) {
                LoginScreen.getStatusLabel().setText("Login successful!");
                if (role.equals("student")) {
                    new StudentDashboard().setVisible(true);
                } else if (role.equals("teacher")) {
                    new TeacherDashboard().setVisible(true);
                }
                LoginScreen.getLoginScreen().dispose();
            } else {
                LoginScreen.getStatusLabel().setText("Login failed. Please check your credentials.");
            }
        }
    };
    
    public static ActionListener registerButtonListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            new RegisterScreen().setVisible(true);
            LoginScreen.getLoginScreen().dispose();
        }
    };
    
    private static Student currentStudent;

    public static String loginUser(String userName, String password) {
        String sqlStudent = "SELECT * FROM student WHERE userName = ? AND password = ?";
        String sqlTeacher = "SELECT * FROM teacher WHERE userName = ? AND password = ?";

        try (Connection conn = DBConnection.getConnection()) {
            try (PreparedStatement pstmt = conn.prepareStatement(sqlStudent)) {
                pstmt.setString(1, userName);
                pstmt.setString(2, password);

                ResultSet rs = pstmt.executeQuery();
                if (rs.next()) {
                    JOptionPane.showMessageDialog(null, "Logged in as Student");
                    setCurrentStudent(new Student(rs.getString("userName"), rs.getString("password"), rs.getString("role")));
                    return "student";
                }
            }

            try (PreparedStatement pstmt = conn.prepareStatement(sqlTeacher)) {
                pstmt.setString(1, userName);
                pstmt.setString(2, password);

                ResultSet rs = pstmt.executeQuery();
                if (rs.next()) {
                    JOptionPane.showMessageDialog(null, "Logged in as Teacher");
                    return "teacher";
                }
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }

        return null;
    }

    public static Student getCurrentStudent() {
        return currentStudent;
    }

    private static void setCurrentStudent(Student student) {
        currentStudent = student;
    }

}
