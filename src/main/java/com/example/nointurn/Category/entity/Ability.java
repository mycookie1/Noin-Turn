package com.example.nointurn.Category.entity;

import com.example.nointurn.Company.entity.CompanyApply;
import com.example.nointurn.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@Entity // 필수, Class 를 Database Table화 해주는 것이다
@Table(name = "Ability") // Table 이름을 명시해주지 않으면 class 이름을 Table 이름으로 대체한다.
public class Ability extends BaseEntity {

    @Id
    @Column(name = "abilityIdx", nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long abilityIdx;

    private String categoryName;

    private String categoryDetail;



    @Builder
    public Ability(String categoryName, String categoryDetail,  String phone, String context, String imageURL){
        this.categoryName = categoryName;
        this.categoryDetail = categoryDetail;
    }
}