package com.example.nointurn.Company;

import com.example.nointurn.Company.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CompanyRepository extends JpaRepository<Company,Long> {
    Optional<Company> findByCompanyIdx(Long companyIdx);

}
