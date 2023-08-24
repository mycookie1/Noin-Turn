package com.example.nointurn.common.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@OpenAPIDefinition(
        info = @io.swagger.v3.oas.annotations.info.Info(title = "demo 서비스 API 명세서",
                description = "스프링부트 demo 서비스 CRUD 실습 API 명세서",
                version = "v1"),
        security = {
                @SecurityRequirement(name = "X-ACCESS-TOKEN"),
        })
//@SecuritySchemes({
//        @SecurityScheme(name = "X-ACCESS-TOKEN",
//                type = SecuritySchemeType.APIKEY,
//                description = "소셜로그인 후 발급받은 jwt 를 여기에 입력합니다.",
//                in = SecuritySchemeIn.HEADER,
//                paramName = "X-ACCESS-TOKEN"),
//})
@RequiredArgsConstructor
@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .components(new Components())
                .info(apiInfo());
    }

    private Info apiInfo() {
        return new Info()
                .title("Springdoc 테스트")
                .description("Springdoc을 사용한 Swagger UI 테스트")
                .version("2.0.2");
    }
}