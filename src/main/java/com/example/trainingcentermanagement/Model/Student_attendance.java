package com.example.trainingcentermanagement.Model;

import lombok.*;

import java.time.LocalDateTime;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Student_attendance {

    private int session_id;
    private int student_id;
    private boolean status;
    private LocalDateTime attendance_time;

    //--------------------------------------------------------------------------
}
