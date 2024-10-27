package com.example.trainingcentermanagement.Model;

import javax.xml.crypto.dsig.dom.DOMValidateContext;
import java.time.LocalDateTime;

public class Registers {

    private int course_id;
    private int student_id;
    private LocalDateTime register_day;

    //-------------------------------------------------------------

    public Registers() {
    }

    public Registers(int course_id, int student_id, LocalDateTime register_day) {
        this.course_id = course_id;
        this.student_id = student_id;
        this.register_day = register_day;
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

    public LocalDateTime getRegister_day() {
        return register_day;
    }

    public void setRegister_day(LocalDateTime register_day) {
        this.register_day = register_day;
    }

    @Override
    public String toString() {
        return "Registers{" +
                "course_id=" + course_id +
                ", student_id=" + student_id +
                ", register_day=" + register_day +
                '}';
    }
}
