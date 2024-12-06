package com.example.trainingcentermanagement.Model;

import lombok.*;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Ins_Attend {

    private int session_id;
    private int instructor_id;
    private boolean check_attend;

    //--------------------------------------------------------------------------------
}
