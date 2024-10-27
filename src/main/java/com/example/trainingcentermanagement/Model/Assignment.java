package com.example.trainingcentermanagement.Model;

public class Assignment {

    private int assignment_id;
    private int session_id;
    private String description;
    private float weight;

    //-----------------------------------------------------

    public Assignment() {
    }

    public Assignment(int assignment_id, int session_id, String description, float weight) {
        this.assignment_id = assignment_id;
        this.session_id = session_id;
        this.description = description;
        this.weight = weight;
    }

    public int getAssignment_id() {
        return assignment_id;
    }

    public void setAssignment_id(int assignment_id) {
        this.assignment_id = assignment_id;
    }

    public int getSession_id() {
        return session_id;
    }

    public void setSession_id(int session_id) {
        this.session_id = session_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Assignment{" +
                "assignment_id=" + assignment_id +
                ", session_id=" + session_id +
                ", description='" + description + '\'' +
                ", weight=" + weight +
                '}';
    }
}
