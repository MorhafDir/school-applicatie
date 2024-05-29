package com.tecsology.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LessonManagementScreen extends JFrame {
    private static final long serialVersionUID = 1L;

    public LessonManagementScreen() {
        setTitle("Lesson Management");
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

        // Implementeer hier de UI voor het beheren van lessen

        contentPanel.add(mainPanel, BorderLayout.CENTER);
    }
}
