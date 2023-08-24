package com.example.nointurn.User;


import com.example.nointurn.User.entity.User;
import com.example.nointurn.User.model.*;
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

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    /**
     * 유저조회
     * @param userIdx
     * @return
     */
    @Tag(name = "유저의 개인정보를 보는 API ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "요청에 성공하였습니다.")
    })

    @Operation(summary = "유저의 개인정보 요청 API", description = "유저의 개인정보 요청 API")
    @Parameters({
            @Parameter(name = "userIdx", description = "유저의 정보", example = "1")
    })
    @ResponseBody
    @GetMapping("/{userIdx}")
    public GetUserRes getUser(@PathVariable(required = true) Long userIdx) {
      return userService.getUser(userIdx);
    }

    /**
     * 자신과 맞는 기업 찾기
     * @param userIdx
     * @return
     */
    @Tag(name = "유저의 능력과 맞는 기업의 리스트")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "요청에 성공하였습니다.")
    })

    @Operation(summary = "유저와 능력과 기업의 요청이 맞는 기업의 리스트를 보냄", description = "유저와 능력과 기업의 요청이 맞는 기업의 리스트를 보냄")
    @Parameters({
            @Parameter(name = "userIdx", description = "유저의 정보", example = "1")
    })
    @ResponseBody
    @GetMapping("find/{userIdx}")
    public List<GetFindJobRes> getJobs(@PathVariable(required = true) Long userIdx) {
        return userService.getFindJobRes(userIdx);
    }

    /**
     * 기업이 제안한 일자리
     * @param userIdx
     * @return
     */
    @Tag(name = "기업이 제안한 일자리 리스트")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "요청에 성공하였습니다.")
    })

    @Operation(summary = "기업들이 유저에게 보낸 요청 리스트", description = "기업들이 유저에게 보낸 요청 리스트")
    @Parameters({
            @Parameter(name = "userIdx", description = "유저의 정보", example = "1")
    })
    @ResponseBody
    @GetMapping("offer/{userIdx}")
    public List<GetOfferJobRes> getOffer(@PathVariable(required = true) Long userIdx) {
        return userService.getOfferJobRes(userIdx);
    }

    /**
     * 기업 디테일
     * @param companyIdx
     * @return
     */
    @Tag(name = "기업의 디테일 정보 API")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "요청에 성공하였습니다.")
    })

    @Operation(summary = "기업의 디테일 정보 API", description = "기업의 디테일 정보 API")
    @Parameters({
            @Parameter(name = "companyIdx", description = "기업의 인덱스 정보", example = "1")
    })
    @ResponseBody
    @GetMapping("company/{companyIdx}")
    public GetCompanyRes getCompanyRes(@PathVariable(required = true) Long companyIdx) {
        return userService.getCompanyRes(companyIdx);
    }

    /**
     * 내가 지원한 기업리스트
     * @param userIdx
     * @return
     */
    @Tag(name = "유저가 지원한 기업리스트")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "요청에 성공하였습니다.")
    })

    @Operation(summary = "유저가 지원한 기업리스트 API", description = "유저가 지원한 기업리스트 API")
    @Parameters({
            @Parameter(name = "userIdx", description = "유저 인덱스 정보", example = "1")
    })
    @ResponseBody
    @GetMapping("apply/{userIdx}")
    public List<GetApplyJobRes> getApplyJobRes(@PathVariable(required = true) Long userIdx) {
        return userService.getApplyJobRes(userIdx);
    }

    /**
     * 지원하기
     * @param userIdx
     * @param companyIdx
     * @return
     */
    @Tag(name = "유저가 기업에 지원하는 API")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "요청에 성공하였습니다.")
    })

    @Operation(summary = "유저가 기업에 지원하는 API", description = "유저가 기업에 지원하는 API")
    @Parameters({
            @Parameter(name = "userIdx", description = "유저 인덱스 정보", example = "1"),
            @Parameter(name = "companyIdx", description = "기업 인덱스 정보", example = "1")
    })
    @ResponseBody
    @PostMapping("apply/{userIdx}/{companyIdx}")
    public Long postApplyJob(@PathVariable Long userIdx,@PathVariable Long companyIdx) {
        return userService.postApplyJob(userIdx, companyIdx);
    }

}
