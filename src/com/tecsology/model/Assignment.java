package com.tecsology.model;

public class Assignment {
    private Student student;
    private String assignmentText;

    public Assignment(Student student, String assignmentText) {
        this.student = student;
        this.assignmentText = assignmentText;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getAssignmentText() {
        return assignmentText;
    }

    public void setAssignmentText(String assignmentText) {
        this.assignmentText = assignmentText;
    }
}
