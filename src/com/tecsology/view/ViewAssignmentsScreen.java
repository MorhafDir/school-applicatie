package com.tecsology.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.LineBorder;

import com.tecsology.controller.ViewAssignmentsController;

public class ViewAssignmentsScreen extends JFrame {
    private static final long serialVersionUID = 1L;
    private static ViewAssignmentsScreen viewAssignmentsScreen;

    private JTextArea assignmentsTextArea;

    public ViewAssignmentsScreen() {
        viewAssignmentsScreen = this;
        setTitle("View Assignments");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        createUserInterface();
        setVisible(true);

        // Voeg de logica toe om de opdrachten van de ingelogde student weer te geven
        ViewAssignmentsController.viewAssignmentsButtonListener.actionPerformed(null); // Roep de methode aan om de opdrachten weer te geven
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

        wrapper.add(createAssignmentsPanel());
        mainPanel.add(wrapper);

        return mainPanel;
    }

    private JPanel createAssignmentsPanel() {
        JPanel assignmentsPanel = new JPanel();
        assignmentsPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        assignmentsPanel.setPreferredSize(new Dimension(600, 400));
        assignmentsPanel.setBackground(Color.darkGray);

        assignmentsTextArea = new JTextArea();
        assignmentsTextArea.setEditable(false);
        assignmentsTextArea.setBackground(Color.lightGray);
        assignmentsTextArea.setPreferredSize(new Dimension(500, 300));
        assignmentsTextArea.setLineWrap(true);
        assignmentsTextArea.setWrapStyleWord(true);

        JScrollPane scrollPane = new JScrollPane(assignmentsTextArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        JButton closeButton = new JButton("Close");
        closeButton.setMargin(new Insets(10, 10, 10, 10));
        closeButton.setBackground(Color.red);
        closeButton.addActionListener(ViewAssignmentsController.closeButtonListener);

        assignmentsPanel.add(scrollPane);
        assignmentsPanel.add(closeButton);

        return assignmentsPanel;
    }

    public static ViewAssignmentsScreen getViewAssignmentsScreen() {
        return viewAssignmentsScreen;
    }

    public void setAssignments(String assignments) {
        assignmentsTextArea.setText(assignments);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ViewAssignmentsScreen::new);
    }
}
