package com.example.Greeting;

import lombok.*;

import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Greeting {

    public String name;
    public int port;
    public Long counter;
    public String lst;
    public String date;

}
