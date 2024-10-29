package com.example.trainingcentermanagement.Model;


import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Student {

    private int student_id;
    private int account_id;
    private String name;
    private String email;
    private String phone;

    //--------------------------------------------------

}
