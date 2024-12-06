package com.example.trainingcentermanagement.Utils;

import com.example.trainingcentermanagement.Model.Instructor;
import com.example.trainingcentermanagement.Model.Student;

import java.util.List;

public class DoesExistChecker {

    private static DBConnect dbConnect = DBConnect.getInstance();
    //----------------------------------------------------------
    public DoesExistChecker() {

    }

    public static boolean doesEmailExist(String email) {
        List<String> allEmails = findAllEmails();
        for (String e : allEmails) {
            if (e.compareTo(email) == 0) {
                return true;
            }
        }
        return false;
    }


    private static List<String> findAllEmails(){
        String sql = """
                        WITH student_emails AS
                            (SELECT email FROM student),
                        instructor_emails AS
                            (SELECT email FROM instructor),
                        managers_emails AS
                            (SELECT email FROM manager)
                            
                        SELECT student_emails.email FROM student_emails
                        UNION ALL
                        SELECT instructor_emails.email FROM instructor_emails
                        UNION ALL
                        SELECT managers_emails.email FROM managers_emails;
                     """;
        return dbConnect.executeReturnPrimitiveTypeQuery(sql, String.class);
    }



    public static boolean doesPhoneNumberExist(String phone) {
        List<String> allPhones = findAllPhones();
        for (String p : allPhones) {
            if (p.compareTo(phone) == 0) {
                return true;
            }
        }
        return false;
    }

    private static List<String> findAllPhones(){
        String sql = """
                        WITH student_phones AS
                            (SELECT phone FROM student),
                        instructor_phones AS
                            (SELECT phone FROM instructor),
                        managers_phones AS
                            (SELECT phone FROM manager)

                        SELECT student_phones.phone FROM student_phones
                        UNION ALL
                        SELECT instructor_phones.phone FROM instructor_phones
                        UNION ALL
                        SELECT managers_phones.phone FROM managers_phones;
                     """;
        return dbConnect.executeReturnPrimitiveTypeQuery(sql, String.class);
    }


    public static boolean doesStudentID_EXIST(String student_id){
        String sql = """
                        select *
                        from student
                        where student_id = ?
                     """;
        List<Student> students = dbConnect.executeReturnQuery(sql, Student.class, student_id);
        if (students.size() > 1) {
            throw new RuntimeException("Database Design Error: " +
                    "SQL: doesStudentID_EXIST returns > 1 tuple");
        }
        if(students.isEmpty()){
            return false;
        }
        return true;
    }


    public static boolean doesInstructorID_EXIST(String instructor_id){
        String sql = """
                        select *
                        from instructor
                        where instructor_id = ?
                     """;
        List<Instructor> instructors = dbConnect.executeReturnQuery(sql, Instructor.class, instructor_id);
        if (instructors.size() > 1) {
            throw new RuntimeException("Database Design Error: " +
                    "SQL: doesInstructorID_EXIST returns > 1 tuple");
        }
        if(instructors.isEmpty()){
            return false;
        }
        return true;
    }

}
