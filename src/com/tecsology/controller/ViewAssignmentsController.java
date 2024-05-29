package com.tecsology.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.tecsology.model.Student;
import com.tecsology.view.ViewAssignmentsScreen;

public class ViewAssignmentsController {

    public static ActionListener viewAssignmentsButtonListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Haal de ingelogde student op
            Student loggedInStudent = LoginController.getCurrentStudent();
            if (loggedInStudent != null) {
                String studentUsername = loggedInStudent.getUserName();
                
                // Haal de opdrachten op voor de ingelogde student uit de database
                String assignments = getAssignmentsForStudent(studentUsername);
                
                // Update de ViewAssignmentsScreen met de opgehaalde opdrachten
                ViewAssignmentsScreen.getViewAssignmentsScreen().setAssignments(assignments);
            }
        }
    };

    public static ActionListener closeButtonListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            ViewAssignmentsScreen.getViewAssignmentsScreen().dispose();
        }
    };

    private static String getAssignmentsForStudent(String studentUsername) {
        // Query om opdrachten op te halen voor de ingelogde student
        String sql = "SELECT assignment_text FROM assignments WHERE student_username = ?";
        StringBuilder assignments = new StringBuilder();

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, studentUsername);
            ResultSet rs = pstmt.executeQuery();

            // Voeg elke opdracht toe aan de StringBuilder
            while (rs.next()) {
                assignments.append(rs.getString("assignment_text")).append("\n");
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return assignments.toString();
    }
}
