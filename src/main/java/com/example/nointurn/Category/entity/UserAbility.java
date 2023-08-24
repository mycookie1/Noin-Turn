package com.example.nointurn.Category.entity;

import com.example.nointurn.Company.entity.Company;
import com.example.nointurn.User.entity.User;
import com.example.nointurn.common.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@Entity // 필수, Class 를 Database Table화 해주는 것이다
@Table(name = "UserAbility") // Table 이름을 명시해주지 않으면 class 이름을 Table 이름으로 대체한다.
public class UserAbility extends BaseEntity {

    @Id
    @Column(name = "userAbilityIdx", nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userAbilityIdx;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userIdx")
    private User userIdx;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "abilityIdx")
    private Ability abilityIdx;



//    @Builder
//    public UserApply(String name, String location, int age, String phone, String career, String imageURl, String videoURL){
//
//    }
}