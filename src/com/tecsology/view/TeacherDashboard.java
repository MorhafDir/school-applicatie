package com.tecsology.view;

import javax.swing.*;

import com.tecsology.controller.TeacherDashboardController;

import java.awt.*;
import java.awt.event.*;

public class TeacherDashboard extends JFrame {
    private static final long serialVersionUID = 1L;
    private ActionListener assignmentTrackingListener;

    public TeacherDashboard() {
        setTitle("Teacher Dashboard");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        createUserInterface();
    }

    private void createUserInterface() {
        Container contentPanel = getContentPane();
        contentPanel.setBackground(Color.black);
        contentPanel.setLayout(new BorderLayout());

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setPreferredSize(new Dimension(800, 600));
        mainPanel.setBackground(Color.gray);

        JButton lessonManagementButton = new JButton("Lesson Management");
        lessonManagementButton.addActionListener(TeacherDashboardController.lessonManagementListener);

        JButton assignmentTrackingButton = new JButton("Assignment Tracking");
        assignmentTrackingButton.addActionListener(TeacherDashboardController.assignmentTrackingListener);

        mainPanel.add(lessonManagementButton, BorderLayout.NORTH);
        mainPanel.add(assignmentTrackingButton, BorderLayout.SOUTH);

        contentPanel.add(mainPanel, BorderLayout.CENTER);
    }


    public void setAssignmentTrackingListener(ActionListener listener) {
        this.assignmentTrackingListener = listener;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TeacherDashboard teacherDashboard = new TeacherDashboard();
            teacherDashboard.setVisible(true);
        });
    }
}
