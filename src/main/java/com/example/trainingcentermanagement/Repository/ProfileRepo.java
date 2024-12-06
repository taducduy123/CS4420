package com.example.trainingcentermanagement.Repository;

import com.example.trainingcentermanagement.Utils.DBConnect;

import java.util.List;

public class ProfileRepo {

    private DBConnect dbConnect = DBConnect.getInstance();

    //---------------------------------------------------------------------

    public ProfileRepo() {

    }



    public void updateStudentName(int user_id, String first_name, String middle_name, String last_name) {
        String sql = """
                        UPDATE student
                        SET first_name = ?,
                            middle_name = ?,
                            last_name = ?
                        WHERE student_id = ?;
                     """;
        dbConnect.executeVoidQuery(sql, first_name, middle_name, last_name, user_id);
    }


    public void updateInstructorName(int user_id, String first_name, String middle_name, String last_name) {
        String sql = """
                        UPDATE instructor
                        SET first_name = ?,
                            middle_name = ?,
                            last_name = ?
                        WHERE instructor_id = ?;
                     """;
        dbConnect.executeVoidQuery(sql, first_name, middle_name, last_name, user_id);
    }


    public void updateManagerName(int user_id, String first_name, String middle_name, String last_name) {
        String sql = """
                        UPDATE manager
                        SET first_name = ?,
                            middle_name = ?,
                            last_name = ?
                        WHERE manager_id = ?;
                     """;
        dbConnect.executeVoidQuery(sql, first_name, middle_name, last_name, user_id);
    }



    public void updateStudentEmail(int user_id, String newEmail) {
        String sql = """
                        UPDATE student
                        SET email = ?
                        WHERE student_id = ?;
                     """;
        dbConnect.executeVoidQuery(sql, newEmail, user_id);
    }


    public void updateInstructorEmail(int user_id, String newEmail) {
        String sql = """
                        UPDATE instructor
                        SET email = ?
                        WHERE instructor_id = ?;
                     """;
        dbConnect.executeVoidQuery(sql, newEmail, user_id);
    }


    public void updateManagerEmail(int user_id, String newEmail) {
        String sql = """
                        UPDATE manager
                        SET email = ?
                        WHERE manager_id = ?;
                     """;
        dbConnect.executeVoidQuery(sql, newEmail, user_id);
    }



    public void updateStudentPhone(int user_id, String newPhone) {
        String sql = """
                        UPDATE student
                        SET phone = ?
                        WHERE student_id = ?;
                     """;
        dbConnect.executeVoidQuery(sql, newPhone, user_id);
    }


    public void updateInstructorPhone(int user_id, String newPhone) {
        String sql = """
                        UPDATE instructor
                        SET phone = ?
                        WHERE instructor_id = ?;
                     """;
        dbConnect.executeVoidQuery(sql, newPhone, user_id);
    }


    public void updateManagerPhone(int user_id, String newPhone) {
        String sql = """
                        UPDATE manager
                        SET phone = ?
                        WHERE manager_id = ?;
                     """;
        dbConnect.executeVoidQuery(sql, newPhone, user_id);
    }





    public static void main(String[] args) {

    }
}
