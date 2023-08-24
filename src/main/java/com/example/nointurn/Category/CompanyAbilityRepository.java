package com.example.nointurn.Category;

import com.example.nointurn.Category.entity.Ability;
import com.example.nointurn.Category.entity.CompanyAbility;
import com.example.nointurn.Company.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CompanyAbilityRepository extends JpaRepository<CompanyAbility,Long> {
    List<CompanyAbility> findAllByCompanyIdx(Company companyIdx);
    List<CompanyAbility> findAllByAbilityIdx(Ability abilityIdx);
}
