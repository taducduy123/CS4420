package com.example.trainingcentermanagement.Utils;

public class ValidInput {
    private static final String EMAIL_REGEX = "^[a-zA-Z0-9._]+@[a-zA-Z0-9._]+\\.[a-zA-Z]{2,}$";

    public static boolean isValid(String type, String value) {
        switch (type) {
            case "email":
                return value.matches(EMAIL_REGEX);
        }

        return false;
    }


    public static void main(String[] args) {
        System.out.println(isValid("email","thinh@gmai.m"));
    }
}
