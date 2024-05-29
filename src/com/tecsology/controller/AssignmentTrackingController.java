package com.tecsology.controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import com.tecsology.view.*;
import com.tecsology.controller.DBConnection;

public class AssignmentTrackingController {

    private static AssignmentTrackingScreen assignmentTrackingScreen;

    public static void main(String[] args) {
        assignmentTrackingScreen = new AssignmentTrackingScreen();
        assignmentTrackingScreen.setVisible(true);

        loadStudents(); // Roep de methode op om studenten te laden wanneer het scherm wordt gemaakt

        assignmentTrackingScreen.setUpdateAssignmentListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String assignmentText = assignmentTrackingScreen.getAssignmentText();
                String studentUsername = (String) assignmentTrackingScreen.getStudentComboBox().getSelectedItem();
                String teacherComment = assignmentTrackingScreen.getTeacherComment();

                if (assignmentText.isEmpty() || studentUsername.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Vul alstublieft alle velden in.");
                    return;
                }

                updateAssignment(studentUsername, assignmentText, teacherComment);
            }
        });
    }

    private static void loadStudents() {
        try {
            Connection connection = DBConnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT userName FROM student");

            JComboBox<String> studentComboBox = assignmentTrackingScreen.getStudentComboBox();
            studentComboBox.removeAllItems();
            studentComboBox.addItem("");

            while (resultSet.next()) {
                String studentName = resultSet.getString("userName");
                studentComboBox.addItem(studentName);
            }

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Fout bij het laden van studenten: " + e.getMessage(), "Fout", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void updateAssignment(String studentUsername, String assignmentText, String teacherComment) {
        try (Connection connection = DBConnection.getConnection()) {
            String query = "INSERT INTO assignments (student_username, assignment_text, teacher_comment) VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, studentUsername);
            preparedStatement.setString(2, assignmentText);
            preparedStatement.setString(3, teacherComment);
            preparedStatement.executeUpdate();

            JOptionPane.showMessageDialog(null, "Opdracht is bijgewerkt.");
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Er is een fout opgetreden bij het bijwerken van de opdracht.");
        }
    }
}
