package com.example.nointurn.Company;

import com.example.nointurn.Company.model.PostCompanyReq;
import com.example.nointurn.User.model.GetCompanyRes;
import com.example.nointurn.User.model.GetUserRes;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/company")
public class CompanyController {
    private final CompanyService companyService;
    /**
     * 회사 디테일
     * @param companyIdx
     * @return
     */
    @ResponseBody
    @GetMapping("/detail/{companyIdx}")
    public GetCompanyRes getCompanyDetail(@PathVariable Long companyIdx) {
        return companyService.getCompany(companyIdx);
    }

    /**
     * 유저 전화번호
     * @param userIdx
     * @return
     */
    @ResponseBody
    @GetMapping("/phone/{companyIdx}/{userIdx}")
    public String getPhone(@PathVariable Long companyIdx, @PathVariable Long userIdx) {
        return companyService.getPhone(companyIdx, userIdx);
    }

    /**
     * 지원자 리스트
     * @param companyIdx
     * @return
     */
    @ResponseBody
    @GetMapping("/apply/{companyIdx}")
    public List<GetUserRes> getApplyRes(@PathVariable Long companyIdx) {
        return companyService.getApplyRes(companyIdx);
    }

    /**
     * 기업이 제의한 유저 목록
     * @param companyIdx
     * @return
     */
    @ResponseBody
    @GetMapping("/contact/{companyIdx}")
    public List<GetUserRes> getContact(@PathVariable Long companyIdx) {
        return companyService.getContact(companyIdx);
    }

    /**
     * 기업과 맞는 유저들 리스트
     * @param companyIdx
     * @return
     */
    @ResponseBody
    @GetMapping("/match/{companyIdx}")
    public List<GetUserRes> getUser(@PathVariable Long companyIdx) {
        return companyService.getUser(companyIdx);
    }



}
