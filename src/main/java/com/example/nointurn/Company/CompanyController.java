package com.example.nointurn.Company;

import com.example.nointurn.Company.model.PostCompanyReq;
import com.example.nointurn.User.model.GetCompanyRes;
import com.example.nointurn.User.model.GetUserRes;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:3000")
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
    @Tag(name = "회사 디테일 API")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "요청에 성공하였습니다.")
    })

    @Operation(summary = "회사 디테일 API", description = "회사 디테일 API")
    @Parameters({
            @Parameter(name = "companyIdx", description = "기업 인덱스 정보", example = "1")
    })
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
    @Tag(name = "연락하기 API")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "요청에 성공하였습니다.")
    })

    @Operation(summary = "연락하기 API", description = "유저의 전화번호 + 기업이 유저에게 보낸 요청리스트에 추가")
    @Parameters({
            @Parameter(name = "userIdx", description = "유저 인덱스 정보", example = "1")
    })
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
    @Tag(name = "기업에 지원한 지원자 리스트 API")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "요청에 성공하였습니다.")
    })

    @Operation(summary = "기업에 지원한 지원자 리스트 API", description = "기업에 지원한 지원자 리스트 API")
    @Parameters({
            @Parameter(name = "companyIdx", description = "기업 인덱스 정보", example = "1")
    })
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
    @Tag(name = "기업이 요청보낸 지원자 리스트 API")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "요청에 성공하였습니다.")
    })

    @Operation(summary = "기업이 요청보낸 지원자 리스트 API", description = "기업이 요청보낸 지원자 리스트 API")
    @Parameters({
            @Parameter(name = "companyIdx", description = "기업 인덱스 정보", example = "1")
    })
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
    @Tag(name = "기업의 요청과 유저의 경력이 일치하는 리스트 API")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "요청에 성공하였습니다.")
    })

    @Operation(summary = "기업의 요청과 유저의 경력이 일치하는 리스트 API", description = "기업의 요청과 유저의 경력이 일치하는 리스트 API")
    @Parameters({
            @Parameter(name = "companyIdx", description = "기업 인덱스 정보", example = "1")
    })
    @ResponseBody
    @GetMapping("/match/{companyIdx}")
    public List<GetUserRes> getUser(@PathVariable Long companyIdx) {
        return companyService.getUser(companyIdx);
    }



}
