package com.example.trainingcentermanagement.Model;

public class Instructor {

    private int instructor_id;
    private String name;
    private float level;
    private String email;
    private String phone;

    //------------------------------------------------------------------

    public Instructor() {
    }

    public Instructor(int instructor_id, String name, float level, String email, String phone) {
        this.instructor_id = instructor_id;
        this.name = name;
        this.level = level;
        this.email = email;
        this.phone = phone;
    }

    public int getInstructor_id() {
        return instructor_id;
    }

    public void setInstructor_id(int instructor_id) {
        this.instructor_id = instructor_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getLevel() {
        return level;
    }

    public void setLevel(float level) {
        this.level = level;
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
        return "Instructor{" +
                "instructor_id=" + instructor_id +
                ", name='" + name + '\'' +
                ", level=" + level +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
