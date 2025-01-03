package com.example.trainingcentermanagement.Model;


import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Session {

    private int session_id;
    private String course_id;
    private String title;
    private String content;

    //----------------------------------------------------
}
