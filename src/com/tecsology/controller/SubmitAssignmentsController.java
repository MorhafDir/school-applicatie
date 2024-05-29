package com.tecsology.controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.tecsology.model.Assignment;
import com.tecsology.model.Student;
import com.tecsology.view.SubmitAssignmentsScreen;

public class SubmitAssignmentsController {
    private SubmitAssignmentsScreen submitAssignmentsScreen;

    public SubmitAssignmentsController(SubmitAssignmentsScreen submitAssignmentsScreen) {
        this.submitAssignmentsScreen = submitAssignmentsScreen;
        this.submitAssignmentsScreen.setSubmitListener(new SubmitListener());
    }

    private class SubmitListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String assignmentText = submitAssignmentsScreen.getAssignmentField();

            Student student = getCurrentStudent(); 
            Assignment assignment = new Assignment(student, assignmentText);

            boolean submissionSuccessful = saveAssignmentToDatabase(assignment);
            if (submissionSuccessful) {
                JOptionPane.showMessageDialog(null, "Assignment submitted successfully!");
            } else {
                JOptionPane.showMessageDialog(null, "Failed to submit assignment. Please try again later.");
            }
        }
    }
    
    

    private Student getCurrentStudent() {
        return LoginController.getCurrentStudent();
    }


    private boolean saveAssignmentToDatabase(Assignment assignment) {
        String sql = "INSERT INTO assignments (student_username, assignment_text) VALUES (?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, assignment.getStudent().getUserName());
            pstmt.setString(2, assignment.getAssignmentText());

            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
