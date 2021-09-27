# 반려동물 전문가와의 1:1상담 서비스 (4인)
+ 정보를 원하는 반려동물주에게 다양한 직종의 전문가들을 연결시켜주고 이국적인 반려동물에 대한 접근성 높은 서비스 제공
 
![프로젝트 순서](https://user-images.githubusercontent.com/37195463/134910707-44837743-2301-4e59-ac58-f4c3cf3df763.png)


## 주요내용
+ 사용자의 관심사항에 대한 데이터를 DTO(Data Transfer Object)에 입력 받아 데이터베이스(MySQL)에 저장
+ 반려동물주의 관심사항이 전문가의 상담분야에 해당할 경우 해당 전문가를 매칭
+ Ajax를 이용하여 반려동물주와 전문가 간의 1:1 채팅 시스템 제공
+ 평점시스템을 이용하여 해당 전문가에 대한 상담 신뢰도 확인

## 사용언어
+ JAVA 8
+ JavaScript
+ HTML/CSS

## 사용 라이브러리 및 프레임워크
+ Spring Boot 2.0.4.RELEASE
+ Spring Data JPA
+ MySQL
+ Ajax
+ Mustache


## 1. 첫 화면
![첫화면](https://user-images.githubusercontent.com/37195463/134910441-0dbe95ff-6a76-47b6-afd0-1ea838321c21.png)


## 2. 회원가입
> 회원가입 시에 아이디, 패스워드와 같은 개인정보와 반려동물에 대한 관심사항을 선택할 수 있다. 전문가의 경우 자격분야, 자격증, 경력 년 수 그리고 사업장 위치를 지정 할 수 있다.

![회원가입페이지3](https://user-images.githubusercontent.com/37195463/134910488-8edb897e-4298-4c94-8973-fa69c97adb2c.png)

## 3. 로그인 및 메인 페이지
> HttpSession 객체를 이용하여 로그인 유지, 외부접속 방지

```
@PostMapping("/login")
public String login(String userId, String userPassword, HttpSession session) {
    User user = userRepository.findByUserId(userId);
    ...
    session.setAttribute("sessionedUser", user);
    return "redirect:/index";
}
```
![로그인 첫화면](https://user-images.githubusercontent.com/37195463/134910500-5652ec3d-c7cc-4c81-8d70-03f83d9d26fc.png)

## 4. 전문가 매칭 후 선택화면
> 반려동물주가 전문가 매칭 서비스를 이용하게 된다면 본인의 관심동물, 관심사항과 연관되는 전문가들을 제안 받을 수 있다.

![전문가 매칭 후 선택화면](https://user-images.githubusercontent.com/37195463/134910519-791b4f76-8910-4abd-b96a-dd005ffc6892.png)

## 5. 전문가 상세정보
> 네이버지도 API를 이용하여 전문가의 사업장 위치 표현 및 상세 프로필 제공

![전문가 상세정보3](https://user-images.githubusercontent.com/37195463/134910539-c5980a7f-b738-4ae3-ac63-6548b660a0d3.png)


## 6. 1:1 채팅
> Ajax를 이용하여 반려동물주와 전문가의 1:1 채팅 시스템 제공

![pic3](https://user-images.githubusercontent.com/37195463/134910608-3b17ec62-0f21-4767-8259-dd6382ce8dd0.png)

## 7. 테이블 구조

![전문가 반려동물주 테이블 스냅샷](https://user-images.githubusercontent.com/37195463/134910650-a508e15d-2013-4fc8-a259-44d94b95ace2.png)

## 8. SPRING BOOT 구조
+ Controller
```
UserController : 반려동물주 회원가입 신청, 로그인 페이지 연결, 로그인 확인, 로그아웃, 채팅리스트 확인
ExpertController : 전문가 회원가입 신청, 로그인 페이지 연결, 로그인 확인, 로그아웃, 채팅리스트 확인
ChatController : 채팅, 채팅내역 확인
SearchController : 반려동물주와 전문가 매칭
```	
    
+ Model
```
User : 반려동물주 아이디, 비밀번호, 관심사항...
Expert : 전문가 아이디, 비밀번호, 자격사항...
Chat : 채팅내역, 채팅날짜
Grade : 평점점수, 평점 코멘트
InterestField01 : 반려동물주의 관심동물
InterestField02 : 반려동물주의 관심분야
ExpertiseField01 : 전문가의 관심동물
ExpertiseField02 : 전문가의 관심분야
```

+ Repository 
```
UserRepository
ExpertRepository 
ChatRepository
SearchRepository
InterestField01Repository
InterestField02Repository
ExpertiseField01Repository
ExpertiseField02Repository
```

## 9. 작동영상
[![Demo CountPages alpha](https://j.gifs.com/p8rxX6.gif)](https://www.youtube.com/watch?v=DRu6QQeXOZY)


## 10. 보완해야할 점
+ Service 계층을 새로 구성해야 . Controller 계층과 Service 계층의 역할을 분리하여 구현해야 함.
+ 불필요한 소스 및 클래스 정리 필요.
