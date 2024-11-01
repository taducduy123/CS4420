package com.example.trainingcentermanagement.Model;


import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Instructor {

    private int instructor_id;
    private int account_id;
    private String name;
    private float level;
    private String email;
    private String phone;

    //------------------------------------------------------------------

}
