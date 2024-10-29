package com.example.trainingcentermanagement.Model;

import lombok.*;

import javax.xml.crypto.dsig.dom.DOMValidateContext;
import java.time.LocalDateTime;



@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Registers {

    private int course_id;
    private int student_id;
    private LocalDateTime register_day;

    //-------------------------------------------------------------
}
