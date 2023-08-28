# Noin-Turn
해커톤
# Gardener_Server(대상)
<img width="1309" alt="image" src="https://github.com/mycookie1/Noin-Turn/assets/103025266/b2f07bea-0c7b-4f31-a2df-0f3a50abb455">

# [2023_SOCIAL_IMPACT_HACKTHON]

## 노인 일자리 문제 해결

#### Project Name : NOIN-TURN

#### Problem : 노년인구의 경제활동은 증가하지만 개인이 갖고 있는 재능을 살리지 못하고 다른일을 하고 있는 상황이다.

#### Subject : 노인의 재능 적성에 맞게 알맞는 일을 찾아주자

#### Project execution period : 2023.08.24 ~ 2023.08.25

#### Contributors : [@유종건](https://github.com/mycookie1) 
------------------------
## 개발 환경
<img width="879" alt="image" src="https://github.com/mycookie1/Noin-Turn/assets/103025266/be14d828-800b-4aa6-9d4a-61b30a177d80">

- JDK 17
- Springboot
- Spring Data JPA + JPQL
- Swagger
- AWS EC2 + RDS + Route53
- MySQL
- OpenAI
- ClovaSPEECH
----------------------

# 서비스 기능
 <img src = "https://github.com/mycookie1/Noin-Turn/assets/103025266/aefb35e6-f9de-4ac4-93c0-7010a9d9225d" width = "100%" height = "100%">
 
- (노인)동영상에서 키워드 뽑아서 개인정보 등록
- (회사)노인에게 원하는 키워드를 등록
- 회사와 사용자 사이에 키워드로 매칭

---------------
## 동영상에서 키워드 추출
- Naver SPEECH를 사용한 텍스트 추출
- SPEECH에서 추출한 text에서 유효한 텍스트를 구분
- OpenAI를 사용해 키워드 추출
- 등록

<img src = "https://github.com/mycookie1/Noin-Turn/assets/103025266/fb602eda-8b6d-42b1-9618-df2102e4ec29" width = "100%" height = "100%">

--------------------
### 파일 구조
