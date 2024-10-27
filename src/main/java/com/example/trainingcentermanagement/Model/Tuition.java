package com.example.trainingcentermanagement.Model;

import java.time.LocalDateTime;

public class Tuition {

    private int tuition_id;
    private int course_id;
    private int student_id;
    private float amount;
    private LocalDateTime submit_time;

    //-------------------------------------------------------------------------

    public Tuition() {
    }

    public Tuition(int tuition_id, int course_id, int student_id, float amount, LocalDateTime submit_time) {
        this.tuition_id = tuition_id;
        this.course_id = course_id;
        this.student_id = student_id;
        this.amount = amount;
        this.submit_time = submit_time;
    }

    public int getTuition_id() {
        return tuition_id;
    }

    public void setTuition_id(int tuition_id) {
        this.tuition_id = tuition_id;
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public LocalDateTime getSubmit_time() {
        return submit_time;
    }

    public void setSubmit_time(LocalDateTime submit_time) {
        this.submit_time = submit_time;
    }

    @Override
    public String toString() {
        return "Tuition{" +
                "tuition_id=" + tuition_id +
                ", course_id=" + course_id +
                ", student_id=" + student_id +
                ", amount=" + amount +
                ", submit_time=" + submit_time +
                '}';
    }
}
