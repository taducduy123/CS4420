package com.example.trainingcentermanagement.Model;

public class Grading {

    private int assignment_id;
    private int student_id;
    private float score;
    private String feedback;

    //------------------------------------------------------------------

    public Grading() {
    }

    public Grading(int assignment_id, int student_id, float score, String feedback) {
        this.assignment_id = assignment_id;
        this.student_id = student_id;
        this.score = score;
        this.feedback = feedback;
    }

    public int getAssignment_id() {
        return assignment_id;
    }

    public void setAssignment_id(int assignment_id) {
        this.assignment_id = assignment_id;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    @Override
    public String toString() {
        return "Grading{" +
                "assignment_id=" + assignment_id +
                ", student_id=" + student_id +
                ", score=" + score +
                ", feedback='" + feedback + '\'' +
                '}';
    }
}
