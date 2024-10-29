package com.example.trainingcentermanagement.Model;


import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString

public class Grading {

    private int assignment_id;
    private int student_id;
    private float score;
    private String feedback;

    //------------------------------------------------------------------
}
