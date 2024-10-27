package com.example.trainingcentermanagement.Model;

import java.time.LocalDateTime;

public class Student_attendance {

    private int session_id;
    private int student_id;
    private boolean status;
    private LocalDateTime attendance_time;

    //--------------------------------------------------------------------------

    public Student_attendance() {
    }

    public Student_attendance(int session_id, int student_id, boolean status, LocalDateTime attendance_time) {
        this.session_id = session_id;
        this.student_id = student_id;
        this.status = status;
        this.attendance_time = attendance_time;
    }

    public int getSession_id() {
        return session_id;
    }

    public void setSession_id(int session_id) {
        this.session_id = session_id;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
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
        return "Student_attendance{" +
                "session_id=" + session_id +
                ", student_id=" + student_id +
                ", status=" + status +
                ", attendance_time=" + attendance_time +
                '}';
    }
}
