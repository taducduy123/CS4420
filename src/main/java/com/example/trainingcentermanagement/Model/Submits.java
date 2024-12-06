package com.example.trainingcentermanagement.Model;


import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString

public class Submits {

    private int assignment_id;
    private int student_id;
    private String solution;
    private double score;
    private String feedback;

    //------------------------------------------------------------------
}
