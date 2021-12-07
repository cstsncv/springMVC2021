package com.csts.spring.mvc.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    private Integer id;

    private String lastName;

    private String email;
    //1 male, 0 female
    private Integer gender;
}
