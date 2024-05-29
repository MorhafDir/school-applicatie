package com.tecsology.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import com.tecsology.view.LoginScreen;
import com.tecsology.view.StudentDashboard;
import com.tecsology.view.SubmitAssignmentsScreen;
import com.tecsology.view.ViewAssignmentsScreen;

public class StudentDashboardController {

    public static ActionListener viewAssignmentsListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            
            JOptionPane.showMessageDialog(null, "Viewing assignments...");
            new ViewAssignmentsScreen().setVisible(true);
            
        }
    };
    
    
    public static ActionListener submitAssignmentsListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            
            JOptionPane.showMessageDialog(null, "Submitting assignments...");
            
            SubmitAssignmentsScreen submitAssignmentsScreen = new SubmitAssignmentsScreen();
            
            new SubmitAssignmentsController(submitAssignmentsScreen);
            
        }
    };
    

    public static ActionListener viewProgressListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            
            JOptionPane.showMessageDialog(null, "Viewing progress...");
        }
    };

    public static ActionListener logoutListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            LoginScreen loginScreen = new LoginScreen();
            loginScreen.setVisible(true);
            StudentDashboard.getDashboardFrame().dispose();
        }
    };
    
    
    

}
