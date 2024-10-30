package com.example.trainingcentermanagement.Repository;

import com.example.trainingcentermanagement.Utils.DBConnect;

public class ChangePasswordRepo {

    DBConnect dbConnect = DBConnect.getInstance();


    //----------------------------------------------------------

    public ChangePasswordRepo() {

    }


    public void updateStudentPasswordByUsername(String username, String newPassword) {
        String sql = """
                        UPDATE account a
                        SET a.password = ?
                        WHERE (a.role, a.username) = ('student', ?);
                     """;

        dbConnect.executeVoidQuery(sql, newPassword, username);
    }


    public void updateInstructorPasswordByUsername(String username, String newPassword) {
        String sql = """
                        UPDATE account a
                        SET a.password = ?
                        WHERE (a.role, a.username) = ('instructor', ?);
                     """;

        dbConnect.executeVoidQuery(sql, newPassword, username);
    }


    public void updateManagerPasswordByUsername(String username, String newPassword) {
        String sql = """
                        UPDATE account a
                        SET a.password = ?
                        WHERE (a.role, a.username) = ('manager', ?);
                     """;

        dbConnect.executeVoidQuery(sql, newPassword, username);
    }
}
