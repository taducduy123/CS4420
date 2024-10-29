package com.example.trainingcentermanagement.Model;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString

public class Account {
    private int account_id;
    private String role;
    private String username;
    private String password;
}
