package com.example.trainingcentermanagement.Model;

import lombok.*;

import java.time.LocalDateTime;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Tuition {

    private int tuition_id;
    private int course_id;
    private int student_id;
    private float amount;
    private LocalDateTime submit_time;

    //-------------------------------------------------------------------------
}
