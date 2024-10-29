package com.example.trainingcentermanagement.Repository;

import com.example.trainingcentermanagement.Model.Account;
import com.example.trainingcentermanagement.Model.Instructor;
import com.example.trainingcentermanagement.Model.Manager;
import com.example.trainingcentermanagement.Model.Student;
import com.example.trainingcentermanagement.Utils.DBConnect;
import com.example.trainingcentermanagement.Utils.UserContext;

import java.util.List;

public class AccountRepo {

    private DBConnect dbConnect = DBConnect.getInstance();

    //--------------------------------------------------------------------------

    public AccountRepo() {
    }



    // Tìm ra thông tin của student có username = "A" và password = "B"
    public Student getStudentBy_UsernameAndPassword(String username, String password) {
        String sql = """
                        SELECT s.*
                        FROM account a, student s
                        WHERE (a.account_id, a.username, a.password) = (s.account_id, ?, ?);
                     """;

        List<Student> result = dbConnect.executeReturnQuery(sql, Student.class, username, password);
        if (result.size() > 1) {
            throw new RuntimeException("Database Design Error: " +
                                            "SQL: getStudentBy_UsernameAndPassword returns > 1 tuple");
        }


        if(result.size() == 0) {
            return null;
        }
        return result.get(0);
    }



    // Tìm ra thông tin của instructor có username = "A" và password = "B"
    public Instructor getInstructorBy_UsernameAndPassword(String username, String password) {
        String sql = """
                        SELECT i.*
                        FROM account a, instructor i
                        WHERE (a.account_id, a.username, a.password) = (i.account_id, ?, ?);
                     """;

        List<Instructor> result = dbConnect.executeReturnQuery(sql, Instructor.class, username, password);
        if (result.size() > 1) {
            throw new RuntimeException("Database Design Error: " +
                    "SQL: getInstructorBy_UsernameAndPassword returns > 1 tuple");
        }


        if(result.isEmpty()) {
            return null;
        }
        return result.get(0);
    }



    // Tìm ra thông tin của manager có username = "A" và password = "B"
    public Manager getManagerBy_UsernameAndPassword(String username, String password) {

        String sql = """
                        SELECT m.*
                        FROM account a, manager m
                        WHERE (a.account_id, a.username, a.password) = (m.account_id, ?, ?);
                     """;

        // Execute SQL
        List<Manager> result = dbConnect.executeReturnQuery(sql, Manager.class, username, password);
        if (result.size() > 1) {
            throw new RuntimeException("Database Design Error: " +
                    "SQL: getManagerBy_UsernameAndPassword returns > 1 tuple");
        }


        if(result.isEmpty()) {
            return null;
        }
        return result.get(0);
    }






    public static void main(String[] args) {

    }
}
