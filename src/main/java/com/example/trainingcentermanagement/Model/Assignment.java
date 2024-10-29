package com.example.trainingcentermanagement.Model;


import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Assignment {

    private int assignment_id;
    private int session_id;
    private String description;
    private float weight;

    //-----------------------------------------------------

}
