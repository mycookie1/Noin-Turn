# Noin-Turn
해커톤
# Gardener_Server(대상)

<img width="1309" alt="image" src="https://github.com/mycookie1/Noin-Turn/assets/103025266/b200bf7d-1022-47c5-a508-5174ed732bc9">

# [2023_SOCIAL_IMPACT_HACKTHON]

## 노인 일자리 문제 해결

#### Project Name : NOIN-TURN

#### Problem : 노년인구의 경제활동은 증가하지만 개인이 갖고 있는 재능을 살리지 못하고 다른일을 하고 있는 상황이다.

#### Subject : 노인의 재능 적성에 맞게 알맞는 일을 찾아주자

#### Project execution period : 2023.08.24 ~ 2023.08.25

#### Contributors : [@유종건](https://github.com/mycookie1) 
------------------------
## 개발 환경
<img width="879" alt="image" src="https://github.com/mycookie1/Noin-Turn/assets/103025266/65e9322d-89be-4288-8141-900e95492e30">

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
 <img src = "https://github.com/mycookie1/Noin-Turn/assets/103025266/f7d4d3d0-a847-4971-a30b-fe9e3b99309d" width = "100%" height = "100%">
 
- (노인)동영상에서 키워드 뽑아서 개인정보 등록
- (회사)노인에게 원하는 키워드를 등록
- 회사와 사용자 사이에 키워드로 매칭

---------------
## 동영상에서 키워드 추출
- Naver SPEECH를 사용한 텍스트 추출
- SPEECH에서 추출한 text에서 유효한 텍스트를 구분
- OpenAI를 사용해 키워드 추출
- 등록
<img src = "https://github.com/mycookie1/Noin-Turn/assets/103025266/a455acb9-b250-4eb6-bd2c-3c901a32800e" width = "100%" height = "100%">

--------------------
### 파일 구조
