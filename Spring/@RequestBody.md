# @RequestBody & @ResponseBody

> 웹페이지에서 json으로 reqeust한 파라미터들을 java에서 받으려면 java object로의 변환이 필요하며,
>
> 마찬가지로 response시에도 java object에서 json으로 변환이 필요하다.
>
> 이러한 작업들을 해주는 어노테이션이 바로 @RequestBody와 @ResponseBody이다.
>
> Controller에 두 어노테이션을 추가해주면, json이나 key/value 방식 xml등으로 송수신 할 수 있다.

<br>

 ### @RequestBody

- @RequestBody가 붙은 파라미터가 있으면 HTTP요청의 미디어 타입과 파라미터의 타입을 먼저 확인한다.
- 즉, @RequestBody어노테이션을 이용하면 ***HTTP요청 Body를 자바 객체로 전달받을 수 있다*.**

<br>

### @ResponseBody

- @ResponseBody가 메서드 레베에서 부여되면 메서드가 리턴하는 오브젝트는 뷰를 통해 결과를 만들어내는 모델로 사용하는 대신, 메시지 컨버터를 통해 바로 HTTP응답의 메시지 본문으로 변환된다.
- 즉, 요청한 형태에 맞춰서 메시지 변환기를 통해 결과값을 반환한다.
- @ResponseBody는 @Requestbody가 선택한 형식으로 결과값을 변환하여 반환한다고 보면된다.
- @ResponseBody를 이용하면 ***자바 객체를 HTTP응답 Body로 전송할 수 있다*.**

<br>

---

참고

- https://codelib.tistory.com/24

- https://devyj.tistory.com/3