package com.example.trainingcentermanagement.Model;

import java.time.LocalDateTime;

public class Instructor_attendance {

    private int session_id;
    private int instructor_id;
    private boolean status;
    private LocalDateTime attendance_time;

    //--------------------------------------------------------------------------------

    public Instructor_attendance() {
    }

    public Instructor_attendance(int session_id, int instructor_id, boolean status, LocalDateTime attendance_time) {
        this.session_id = session_id;
        this.instructor_id = instructor_id;
        this.status = status;
        this.attendance_time = attendance_time;
    }

    public int getSession_id() {
        return session_id;
    }

    public void setSession_id(int session_id) {
        this.session_id = session_id;
    }

    public int getInstructor_id() {
        return instructor_id;
    }

    public void setInstructor_id(int instructor_id) {
        this.instructor_id = instructor_id;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public LocalDateTime getAttendance_time() {
        return attendance_time;
    }

    public void setAttendance_time(LocalDateTime attendance_time) {
        this.attendance_time = attendance_time;
    }

    @Override
    public String toString() {
        return "Instructor_attendance{" +
                "session_id=" + session_id +
                ", instructor_id=" + instructor_id +
                ", status=" + status +
                ", attendance_time=" + attendance_time +
                '}';
    }
}
