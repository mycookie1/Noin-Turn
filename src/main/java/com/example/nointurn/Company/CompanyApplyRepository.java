package com.example.nointurn.Company;

import com.example.nointurn.Company.entity.Company;
import com.example.nointurn.Company.entity.CompanyApply;
import com.example.nointurn.User.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CompanyApplyRepository extends JpaRepository<CompanyApply,Long> {
    List<CompanyApply> findAllByUserIdx(User userIdx);
    List<CompanyApply> findAllByCompanyIdx(Company companyIdx);
}
