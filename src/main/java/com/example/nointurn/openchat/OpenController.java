package com.example.nointurn.openchat;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;


public class OpenController {
    private static final String ENDPOINT = "https://api.openai.com/v1/chat/completions";
    /**
     * OpenAI 키워드  - 키워드 입력 시 penAI 조회 API
     * @param keyword 글 작성 시 포함하고 싶은 내용
     * @return OpenAI 결과 String
     */

    public void getOpenAI(String keyword)  {

        // 프로프트 생성
        String prompt = keyword +"{이름과 나이},{거주지역},{능력과 특기},{경력}을  String 형태로 보내줘";

        // header 등록: Content-Type, Authorization(API KEY), Message
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        //TODO: 시크릿키 등록
        headers.set("Authorization", "Bearer " + "secretKey");

        Map<String, Object> requestBody = new HashMap<>();

        // Message: model, role
        requestBody.put("model", "gpt-3.5-turbo");
        Message message = new Message("user", prompt);
        Message[] messages = {message};
        requestBody.put("messages", messages);

        HttpEntity<Map<String, Object>> requestEntity = new HttpEntity<>(requestBody, headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Map> response = restTemplate.postForEntity(ENDPOINT, requestEntity, Map.class);
            // answer 추출
        System.out.println("openai로 추출 "+response.getBody().toString());



    }
}