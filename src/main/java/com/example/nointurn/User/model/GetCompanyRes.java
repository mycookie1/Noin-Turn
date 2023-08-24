package com.example.nointurn.User.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class GetCompanyRes {
    private Long companyIdx;
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
