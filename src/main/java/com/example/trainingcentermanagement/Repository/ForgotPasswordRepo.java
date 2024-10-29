package com.example.trainingcentermanagement.Repository;

import com.example.trainingcentermanagement.Model.Account;
import com.example.trainingcentermanagement.Model.Instructor;
import com.example.trainingcentermanagement.Model.Manager;
import com.example.trainingcentermanagement.Model.Student;
import com.example.trainingcentermanagement.Utils.DBConnect;

import java.util.List;

public class ForgotPasswordRepo {

    private DBConnect dbConnect = DBConnect.getInstance();

    //-------------------------------------------------------------

    public ForgotPasswordRepo() {

    }


    // Tìm ra thông tin của student có username = "A" và email = "B"
    public Student getStudentBy_UsernameAndEmail(String username, String email) {
        String sql = """
                        SELECT s.*
                        FROM account a, student s
                        WHERE (a.account_id, a.username, s.email) = (s.account_id, ?, ?);
                     """;

        List<Student> result = dbConnect.executeReturnQuery(sql, Student.class, username, email);
        if (result.size() > 1) {
            throw new RuntimeException("Database Design Error: " +
                    "SQL: getStudentBy_UsernameAndEmail returns > 1 tuple");
        }


        if(result.size() == 0) {
            return null;
        }
        return result.get(0);
    }



    // Tìm ra thông tin của instructor có username = "A" và email = "B"
    public Instructor getInstructorBy_UsernameAndEmail(String username, String email) {
        String sql = """
                        SELECT i.*
                        FROM account a, instructor i
                        WHERE (a.account_id, a.username, i.email) = (i.account_id, ?, ?);
                     """;

        List<Instructor> result = dbConnect.executeReturnQuery(sql, Instructor.class, username, email);
        if (result.size() > 1) {
            throw new RuntimeException("Database Design Error: " +
                    "SQL: getInstructorBy_UsernameAndEmail returns > 1 tuple");
        }


        if(result.isEmpty()) {
            return null;
        }
        return result.get(0);
    }


    // Tìm ra thông tin của manager có username = "A" và email = "B"
    public Manager getManagerBy_UsernameAndEmail(String username, String email) {

        String sql = """
                        SELECT m.*
                        FROM account a, manager m
                        WHERE (a.account_id, a.username, m.email) = (m.account_id, ?, ?);
                     """;

        // Execute SQL
        List<Manager> result = dbConnect.executeReturnQuery(sql, Manager.class, username, email);
        if (result.size() > 1) {
            throw new RuntimeException("Database Design Error: " +
                    "SQL: getManagerBy_UsernameAndEmail returns > 1 tuple");
        }


        if(result.isEmpty()) {
            return null;
        }
        return result.get(0);
    }



    public void updateStudentPassword(String username, String newPassword) {
        String sql = """
                        UPDATE account a
                        SET password = ?
                        WHERE (a.role, a.username) = ('student', ?);
                        """;

        dbConnect.executeVoidQuery(sql, newPassword, username);
    }


    public void updateInstructorPassword(String username, String newPassword) {
        String sql = """
                        UPDATE account a
                        SET password = ?
                        WHERE (a.role, a.username) = ('instructor', ?);
                        """;

        dbConnect.executeVoidQuery(sql, newPassword, username);
    }


    public void updateManagerPassword(String username, String newPassword) {
        String sql = """
                        UPDATE account a
                        SET password = ?
                        WHERE (a.role, a.username) = ('manager', ?);
                        """;

        dbConnect.executeVoidQuery(sql, Account.class, newPassword, username);
    }

}
