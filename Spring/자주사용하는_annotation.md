# 자주사용하는 @annotation

*@어노테이션 - 사용할 수 있는 곳*

#### **@Controller - 클래스**

: 컨트롤러 객체임을 명시

<br>

#### **@RequestMapping - 클래스, 메소드**

: 특정 URL에 매칭되는 클래스나 메소드임을 명시

<br>

#### **@RequestParam - 파라미터**

: 요청에서 특정한 파라미터 값을 찾아낼때 사용

<br>

@RequestHeader - 파라미터

: 요청에서 특정 HTTP 헤더 정보를 추출할 때 사용

<br>

@PathVariable - 파라미터

: 현재 URL에서 원하는 정보를 추출할 때 사용

<br>

@CookieValue - 파라미터

: 현재 사용자의 쿠키가 존재하는 경우, 쿠키의 이름을 이용해서 쿠키값 추출

<br>

#### **@ModelAttribute - 메소드, 파라미터**

: 자동으로 해당 객체를 뷰까지 전달하도록 만든 것

<br>

@SessionAttribute - 클래스

: 세션상에서 모델의 정보를 유지하고 싶은 경우

<br>

@InitBinder - 메소드

: 파라미터를 수집해서 객체로 만들경우 커스터마이징

<br>

#### **@ResponseBody - 메소드, 리턴타입**

: 리턴타입이 HTTP의 응답 메시지로 전송

<br>

#### **@RequestBody - 파라미터**

: 요청 문자열이 그대로 파라미터로 전달

<br>

#### **@Respository - 클래스**

: Dao 객체

<br>

#### **@Service - 클래스**

: biz(서비스) 객체



<br><br>

---

👻출처

- https://min-it.tistory.com/7