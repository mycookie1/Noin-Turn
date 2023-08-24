package com.example.nointurn.Company;

import com.example.nointurn.Company.entity.Company;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@RequiredArgsConstructor
@Service
public class CompanyService {
    @Autowired
    private CompanyRepository companyRepository;

    @Transactional(readOnly = true)
    public Company getCompany() {
        Company newCompany = companyRepository.findByCompanyIdx(1l).get();
        return newCompany;
    }
}
