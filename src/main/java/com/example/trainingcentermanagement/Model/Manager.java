package com.example.trainingcentermanagement.Model;


import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Manager {

    private int manager_id;
    private int account_id;
    private String name;
    private String email;
    private String phone;

    //-------------------------------------------------------------
}