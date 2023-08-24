package com.example.nointurn.Company;

import com.example.nointurn.Company.entity.Company;
import com.example.nointurn.User.UserService;
import com.example.nointurn.User.entity.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/company")
public class CompanyController {
    private final CompanyService companyService;
    @ResponseBody
    @GetMapping("")
    public Company getDetailPlace() {
        return companyService.getCompany();
    }
}
