package com.example.trainingcentermanagement.Model;


import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Course {

    private int course_id;
    private String name;
    private String description;
    private float rate;

    //---------------------------------------------------------

}
