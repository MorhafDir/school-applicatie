package com.tecsology.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;


public class SubmitAssignmentsScreen extends JFrame {
    private static final long serialVersionUID = 1L;
    private JTextField assignmentField;
    private JButton submitButton;
    
    public SubmitAssignmentsScreen() {
        setTitle("Submit Assignments");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        createUI();
        setVisible(true);
    }

    private void createUI() {
        Container contentPanel = getContentPane();
        contentPanel.setBackground(Color.black);
        contentPanel.add(createMainPanel());
    }

    private JPanel createMainPanel() {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new FlowLayout());
        mainPanel.setPreferredSize(new Dimension(600, 400));
        mainPanel.setBackground(Color.gray);

        JPanel wrapper = new JPanel();
        wrapper.setLayout(new FlowLayout());
        wrapper.setPreferredSize(new Dimension(600, 400));
        wrapper.setBackground(Color.black);

        wrapper.add(createSubmissionForm());
        mainPanel.add(wrapper);

        return mainPanel;
    }

    private JPanel createSubmissionForm() {
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        formPanel.setPreferredSize(new Dimension(400, 200));
        formPanel.setBackground(Color.darkGray);

        JLabel titleLabel = new JLabel("Submit Assignments");
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));

        assignmentField = new JTextField();
        assignmentField.setPreferredSize(new Dimension(300, 30));

        submitButton = new JButton("Submit");
        submitButton.setPreferredSize(new Dimension(100, 30));

        formPanel.add(titleLabel);
        formPanel.add(new JLabel("Assignment:"));
        formPanel.add(assignmentField);
        formPanel.add(submitButton);

        return formPanel;
    }

    public String getAssignmentField() {
        return assignmentField.getText().trim();
    }

    public void setSubmitListener(ActionListener listener) {
        submitButton.addActionListener(listener);
    }
}
