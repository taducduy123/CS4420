package com.example.trainingcentermanagement.Model;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Billing {
    private int student_id;
    private String first_name;
    private String middle_name;
    private String last_name;
    private String course_id;
    private String course_name;
    private double course_rate;
    private int  numAttend;
    private double total;

    //---------------------------------
}
