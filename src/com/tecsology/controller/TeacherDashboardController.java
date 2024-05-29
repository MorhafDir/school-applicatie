package com.tecsology.controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import com.tecsology.view.*;

public class TeacherDashboardController {

    public static ActionListener lessonManagementListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(null, "Opening Lesson Management...");
            LessonManagementScreen lessonManagementScreen = new LessonManagementScreen();
            lessonManagementScreen.setVisible(true);
        }
    };

    public static ActionListener assignmentTrackingListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(null, "Opening Assignment Tracking...");
            AssignmentTrackingScreen assignmentTrackingScreen = new AssignmentTrackingScreen();
            assignmentTrackingScreen.setVisible(true);
        }
    };

}