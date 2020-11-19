# @RestController

> @Controller와 @RestController의 차이점은 HTTP Response  Body가 생성되는 방식이다.

### @Controller (Spring MVC Controller)

- 주로 View를 반환하기 위해 사용한다.
- Data를 반환해야 하는 경우도 있다.
  - 데이터를 반환하기 위해 @ResponseBody 어노테이션을 활용해주어야 한다.
  - 이러면 Controller에서도 json형태로 데이터를 반환할 수 있다.

<br>

### @RestController (Spring Restful Controller)

- Spring MVC Controller에서 @ResponseBody가 추가된 것이다.
- 객체를 반환할 대 객체 테이터는 바로 json/xml타입의 HTTP응답을 직접 리턴한다.

<br>

---

참고

- https://mangkyu.tistory.com/49
- https://lkg3796.tistory.com/58

<br>