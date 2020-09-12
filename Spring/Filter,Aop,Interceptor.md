# 📄Filter, Aop, Interceptor

##### 공통점👉공통 부분을 따로 빼서 관리한다.

---

<img src="https://postfiles.pstatic.net/MjAyMDA5MTNfMjcw/MDAxNTk5OTI4ODM1MzA5.fdaxB1mxVeuH-CPTOop1iJyo8Xq5BZwTS213oSdcD2cg.jKskPvdGgw4PxWbjDBABwbn-AFdnesYkxa_WtvCo9pgg.PNG.mingyeung/image.png?type=w966" style="zoom:50%;" />

- Filter 👉 Interceptor 👉 AOP 👉 Interceptor 👉Filter 순으로 실행된다.

<br>

### 💬Filter

[+filter](https://github.com/mingyeungAA/Spring/blob/master/Spring/Filter.md)

- **DispatcherServlet 전에** 실행됨.
- Controller 이후 자원처리가 끝난후, 응답처리에 대해서도 변경, 조작을 수행할 수 있다.
- 필터체이닝을 통해 다음 필터 혹은 서버한테 연결.
- 보통 web.xml에 등록
- 메서드
  - init() : 필터 인스턴스 초기화
  - doFilter() : 실제 처리 로직
  - destory() : 필터 인스턴스 종료

<br>

---

### 💬Interceptor

[spring.io](https://docs.spring.io/spring-framework/docs/current/javadoc-api/)

- Dispatcher와 Controller 사이에서 요청과 응답을 가로채서 처리
- spring과 무관한 자원에 대해 동작한다.
- 메소드
  - preHandler() : Controller 실행 전
  - postHandler() : Controller 실행 후 view 결정(view rendering) 이전에 실행. ModelAndView 객체에 Controller에서 넘어온 model객체가 전달됨.
  - adterConpletion()  : view결정(view rendering) 이후 맨 마지막.



<br>

---

#### 💬Filter vs. Interceptor

**차이점**

👉Filter는 웹어플리케이션 내에서만 접근 가능하고, Interceptor는 스프링내의 모든 객체에 접근 가능하다.

👉Interceptor는 주로 로그인처리에 이용된다. (중복코드가 확실히 줄어든다.)

<br>

---

### 💬Aop

[+aop](https://github.com/mingyeungAA/Spring/blob/master/Spring/AOP.md)

- Controller 처리 이후, 비지니스 로직에서 실행된다. (Biz, @Repository)
- 프로그램의 흐름에 따라 지정된 pointcut에서 spring이 외부적으로 처리해주는 것.

<br>

---

👻참고사이트

- https://velog.io/@sa833591/Spring-Filter-Interceptor-AOP-%EC%B0%A8%EC%9D%B4-yvmv4k96
- https://goddaehee.tistory.com/154
- https://rongscodinghistory.tistory.com/2

<br>

<br>