package com.example.nointurn.Company.model;

import com.example.nointurn.Category.entity.CompanyAbility;
import com.example.nointurn.Company.entity.CompanyApply;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class PostCompanyReq {
    private String name;
    private String location;
    private String age;
    private String phone;
    private String context;
    private String imageURL;

    private String career;
    private String wage;
    private String period;
}
