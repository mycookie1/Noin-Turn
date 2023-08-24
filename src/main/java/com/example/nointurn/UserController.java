package com.example.nointurn;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {
    /**
     * 기획전 등록 API
     * [POST] /app/admin/exhibitions
     * @return BaseResponse<PostExhibitionAdminRes>
     */
    //Query String
    @ResponseBody
    @GetMapping("")
    public void userTest() {
       System.out.println("test");
    }
}
