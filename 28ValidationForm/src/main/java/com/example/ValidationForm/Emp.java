package com.example.ValidationForm;

import lombok.*;

import javax.validation.constraints.NotEmpty;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Emp {

    public int id;
    @NotEmpty(message = "name can not be empty")
    public String name;
    @NotEmpty(message = "name can not be empty")
    public String age;
}
