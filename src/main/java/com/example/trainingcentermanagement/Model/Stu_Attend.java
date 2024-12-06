package com.example.trainingcentermanagement.Model;
import lombok.*;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Stu_Attend {

    private int session_id;
    private int student_id;
    private boolean check_attend;

    //--------------------------------------------------
}
