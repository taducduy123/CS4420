package com.example.trainingcentermanagement.Utils;

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

                        SELECT student_phone.phone FROM student_phones
                        UNION ALL
                        SELECT instructor_phones.phone FROM instructor_phones
                        UNION ALL
                        SELECT managers_phones.phone FROM managers_phones;
                     """;
        return dbConnect.executeReturnPrimitiveTypeQuery(sql, String.class);
    }

}
