package com.example.trainingcentermanagement.Utils;

public class UserContext {

    private static UserContext instance;

    private String role;
    private String username;
    private String password;
    private int user_id;
    private String user_name;
    private String email;
    private String phone;

    //-----------------------------------------------------------------------

    private UserContext() {
        this.role = null;
        this.username = null;
        this.password = null;
        this.user_id = -1;
        this.email = null;
        this.phone = null;
    }

    public static  UserContext getInstance() {
        if (instance == null) {
            instance = new UserContext();
        }
        return instance;
    }

    public void clearContext() {
        this.role = null;
        this.username = null;
        this.user_id = -1;
    }


    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
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
        return "UserContext{" +
                "role='" + role + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", user_id='" + user_id + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
