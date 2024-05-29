package com.tecsology.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.LineBorder;
import com.tecsology.controller.AssignmentTrackingController;

public class AssignmentTrackingScreen extends JFrame {
    private static final long serialVersionUID = 1L;
    private JComboBox<String> studentComboBox;
    private JTextArea assignmentTextArea;
    private JTextArea teacherCommentTextArea;
    private JButton updateButton;

    public AssignmentTrackingScreen() {
        setTitle("Assignment Tracking");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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

        JPanel assignmentPanel = new JPanel(new BorderLayout());
        assignmentPanel.setPreferredSize(new Dimension(300, 300));
        assignmentPanel.setBackground(Color.darkGray);
        assignmentPanel.setBorder(new LineBorder(Color.white, 2));

        studentComboBox = new JComboBox<>();
        studentComboBox.setPreferredSize(new Dimension(275, 40));

        assignmentTextArea = new JTextArea();
        assignmentTextArea.setLineWrap(true);
        assignmentTextArea.setWrapStyleWord(true);
        JScrollPane assignmentScrollPane = new JScrollPane(assignmentTextArea);
        assignmentScrollPane.setPreferredSize(new Dimension(275, 100));

        teacherCommentTextArea = new JTextArea();
        teacherCommentTextArea.setLineWrap(true);
        teacherCommentTextArea.setWrapStyleWord(true);
        JScrollPane commentScrollPane = new JScrollPane(teacherCommentTextArea);
        commentScrollPane.setPreferredSize(new Dimension(275, 100));

        updateButton = new JButton("Update Assignment");
        updateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AssignmentTrackingController.updateAssignment(
                        (String) studentComboBox.getSelectedItem(),
                        assignmentTextArea.getText(),
                        teacherCommentTextArea.getText());
            }
        });

        assignmentPanel.add(new JLabel("Select Student:"), BorderLayout.NORTH);
        assignmentPanel.add(studentComboBox, BorderLayout.NORTH);
        assignmentPanel.add(new JLabel("Assignment Text:"), BorderLayout.CENTER);
        assignmentPanel.add(assignmentScrollPane, BorderLayout.CENTER);
        assignmentPanel.add(new JLabel("Teacher Comment:"), BorderLayout.CENTER);
        assignmentPanel.add(commentScrollPane, BorderLayout.CENTER);

        mainPanel.add(assignmentPanel, BorderLayout.CENTER);
        mainPanel.add(updateButton, BorderLayout.SOUTH);

        contentPanel.add(mainPanel, BorderLayout.CENTER);
    }

    public JComboBox<String> getStudentComboBox() {
        return studentComboBox;
    }

    public String getAssignmentText() {
        return assignmentTextArea.getText();
    }

    public String getTeacherComment() {
        return teacherCommentTextArea.getText();
    }
}
