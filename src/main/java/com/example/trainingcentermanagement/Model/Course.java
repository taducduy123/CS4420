package com.example.trainingcentermanagement.Model;

public class Course {

    private int course_id;
    private String name;
    private String description;
    private float rate;

    //---------------------------------------------------------


    public Course() {
    }

    public Course(int course_id, String name, String description, float rate) {
        this.course_id = course_id;
        this.name = name;
        this.description = description;
        this.rate = rate;
    }

    public int getcourse_id() {
        return course_id;
    }

    public void setcourse_id(int course_id) {
        this.course_id = course_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    @Override
    public String toString() {
        return "Course{" +
                "course_id=" + course_id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", rate=" + rate +
                '}';
    }
}
