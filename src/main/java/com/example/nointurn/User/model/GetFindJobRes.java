package com.example.nointurn.User.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class GetFindJobRes {
    private Long companyIdx;
    private Long userIdx;
    private String name;
    private String location;
    private String imageURL;
    private String context;
    private String age;
    private String career;
    private String ability;
    private String wage;
    private String period;
}
