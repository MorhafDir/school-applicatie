package com.tecsology.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.LineBorder;

import com.tecsology.controller.StudentDashboardController;

public class StudentDashboard extends JFrame {
    private static final long serialVersionUID = 1L;
    private static StudentDashboard dashboardFrame;

    public StudentDashboard() {
        dashboardFrame = this;
        setTitle("Student Dashboard");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        createUserInterface();
        setVisible(true);
    }

    private void createUserInterface() {
        Container contentPanel = getContentPane();
        contentPanel.setBackground(Color.black);
        contentPanel.add(createMainPanel());
    }

    private JPanel createMainPanel() {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new FlowLayout());
        mainPanel.setPreferredSize(new Dimension(800, 600));
        mainPanel.setBackground(Color.gray);

        JPanel wrapper = new JPanel();
        wrapper.setLayout(new FlowLayout());
        wrapper.setPreferredSize(new Dimension(800, 600));
        wrapper.setBackground(Color.black);

        wrapper.add(createDashboardContent());
        mainPanel.add(wrapper);

        return mainPanel;
    }

    private JPanel createDashboardContent() {
        JPanel dashboardPanel = new JPanel();
        dashboardPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        dashboardPanel.setPreferredSize(new Dimension(600, 400));
        dashboardPanel.setBackground(Color.darkGray);

        JLabel welcomeLabel = new JLabel("Welcome to the Student Dashboard");
        welcomeLabel.setForeground(Color.WHITE);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 18));

        JButton viewAssignmentsButton = new JButton("View Assignments");
        viewAssignmentsButton.setMargin(new Insets(10, 10, 10, 10));
        viewAssignmentsButton.setBackground(Color.yellow);
        viewAssignmentsButton.addActionListener(StudentDashboardController.viewAssignmentsListener);

        JButton submitAssignmentsButton = new JButton("Submit Assignments");
        submitAssignmentsButton.setMargin(new Insets(10, 10, 10, 10));
        submitAssignmentsButton.setBackground(Color.yellow);
        submitAssignmentsButton.addActionListener(StudentDashboardController.submitAssignmentsListener);

        JButton viewProgressButton = new JButton("View Progress");
        viewProgressButton.setMargin(new Insets(10, 10, 10, 10));
        viewProgressButton.setBackground(Color.yellow);
        viewProgressButton.addActionListener(StudentDashboardController.viewProgressListener);

        JButton logoutButton = new JButton("Logout");
        logoutButton.setMargin(new Insets(10, 10, 10, 10));
        logoutButton.setBackground(Color.red);
        logoutButton.addActionListener(StudentDashboardController.logoutListener);

        try {
            ImageIcon icon = new ImageIcon("images/student_icon.png");
            JLabel studentIcon = new JLabel(icon);
            JPanel iconPanel = new JPanel();
            iconPanel.setLayout(new FlowLayout());
            iconPanel.setPreferredSize(new Dimension(270, 100));
            iconPanel.setBackground(Color.darkGray);
            iconPanel.setBorder(new LineBorder(Color.white, 3, true));
            iconPanel.add(studentIcon);
            dashboardPanel.add(iconPanel);
        } catch (Exception e) {
            System.err.println("Icon file not found: images/student_icon.png");
        }

        dashboardPanel.add(welcomeLabel);
        dashboardPanel.add(viewAssignmentsButton);
        dashboardPanel.add(submitAssignmentsButton);
        dashboardPanel.add(viewProgressButton);
        dashboardPanel.add(logoutButton);

        return dashboardPanel;
    }

    public static StudentDashboard getDashboardFrame() {
        return dashboardFrame;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new StudentDashboard();
        });
    }
}
