package com.example.nointurn.User;


import com.example.nointurn.User.entity.User;
import com.example.nointurn.User.model.*;
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
    @ResponseBody
    @GetMapping("apply/{userIdx}")
    public List<GetApplyJobRes> getApplyJobRes(@PathVariable(required = true) Long userIdx) {
        return userService.getApplyJobRes(userIdx);
    }


}
