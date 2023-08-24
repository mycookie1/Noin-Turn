package com.example.nointurn.User.entity;

import com.example.nointurn.Category.entity.UserAbility;
import com.example.nointurn.common.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@Entity // 필수, Class 를 Database Table화 해주는 것이다
@Table(name = "User") // Table 이름을 명시해주지 않으면 class 이름을 Table 이름으로 대체한다.
public class User extends BaseEntity {

    @Id
    @Column(name = "userIdx", nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userIdx;
    @JsonIgnore
    @OneToMany(mappedBy = "userIdx")
    private List<UserApply> userApplyList;
    @JsonIgnore
    @OneToMany(mappedBy = "userIdx")
    private List<UserAbility> userAbilityList;
    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String location;

    @Column(nullable = false)
    private int age;
    @Column(nullable = false)
    private String phone;
    @Column(nullable = false)
    private String career;
    @Column(nullable = false)
    private String imageURL;

    @Column(nullable = false)
    private String videoURL;


    @Builder
    public User(String name, String location, int age, String phone, String career, String imageURl, String videoURL){
        this.name = name;
        this.location = location;
        this.age = age;
        this.phone = phone;
        this.career = career;
        this.imageURL = imageURl;
        this.videoURL = videoURL;
    }
}