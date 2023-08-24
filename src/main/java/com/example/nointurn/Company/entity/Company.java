package com.example.nointurn.Company.entity;

import com.example.nointurn.Category.entity.CompanyAbility;
import com.example.nointurn.User.entity.UserApply;
import com.example.nointurn.common.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@Entity // 필수, Class 를 Database Table화 해주는 것이다
@Table(name = "Company") // Table 이름을 명시해주지 않으면 class 이름을 Table 이름으로 대체한다.
public class Company extends BaseEntity {

    @Id
    @Column(name = "companyIdx", nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long companyIdx;
    @JsonIgnore
    @OneToMany(mappedBy = "companyIdx")
    private List<CompanyApply> companyApplyList;
    @JsonIgnore
    @OneToMany(mappedBy = "companyIdx")
    private List<CompanyAbility> companyAbilityList;
    private String name;

    private String location;

    private String phone;

    private String context;

    private String imageURL;
    private String age;
    private String career;
    private String wage;
    private String period;

    @Builder
    public Company(String name, String location,  String phone, String context, String imageURL, String age, String career
    , String wage, String period){
        this.name = name;
        this.location = location;
        this.phone = phone;
        this.context = context;
        this.imageURL = imageURL;
        this.career = career;
        this.age = age;
        this.wage = wage;
        this.period = period;
    }
}