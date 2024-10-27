package com.example.trainingcentermanagement.Model;

public class Student {

    private int student_id;
    private String name;
    private String email;
    private String phone;

    //--------------------------------------------------

    public Student() {
    }

    public Student(int student_id, String name, String email, String phone) {
        this.student_id = student_id;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Student{" +
                "student_id=" + student_id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
