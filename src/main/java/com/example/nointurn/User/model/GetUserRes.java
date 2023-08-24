package com.example.nointurn.User.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class GetUserRes {
    private String name;
    private int age;
    private String location;
    private String abilities;
    private List<String> careerList;
}
