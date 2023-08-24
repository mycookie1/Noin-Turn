package com.example.nointurn.User.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class GetApplyJobRes {
    private Long companyIdx;
    private String name;
    private String location;
    private String imageURL;
}
