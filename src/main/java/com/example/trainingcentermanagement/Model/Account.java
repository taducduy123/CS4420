package com.example.trainingcentermanagement.Model;

public class Account {

    private int user_id;
    private String role;
    private String username;
    private String password;

    //---------------------------------------------------------

    public Account() {
    }

    public Account(int user_id, String role, String username, String password) {
        this.user_id = user_id;
        this.role = role;
        this.username = username;
        this.password = password;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
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

    @Override
    public String toString() {
        return "Account{" +
                "user_id=" + user_id +
                ", role='" + role + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
