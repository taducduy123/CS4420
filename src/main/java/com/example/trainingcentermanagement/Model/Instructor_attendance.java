package com.example.trainingcentermanagement.Model;

import lombok.*;

import java.time.LocalDateTime;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Instructor_attendance {

    private int session_id;
    private int instructor_id;
    private boolean status;
    private LocalDateTime attendance_time;

    //--------------------------------------------------------------------------------
}
