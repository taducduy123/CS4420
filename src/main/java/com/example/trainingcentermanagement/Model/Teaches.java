package com.example.trainingcentermanagement.Model;

public class Teaches {

    private int course_id;
    private int instructor_id;

    //-----------------------------------------------------------------

    public Teaches() {
    }

    public Teaches(int course_id, int instructor_id) {
        this.course_id = course_id;
        this.instructor_id = instructor_id;
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public int getInstructor_id() {
        return instructor_id;
    }

    public void setInstructor_id(int instructor_id) {
        this.instructor_id = instructor_id;
    }

    @Override
    public String toString() {
        return "Teaches{" +
                "course_id=" + course_id +
                ", instructor_id=" + instructor_id +
                '}';
    }
}
