# 📄SpringBoot_02_Thymeleaf

## 💬Thymeleaf

- MVC 구조에서 view에 해당하는 라이브러리이다.
- JAVA 템플릿 엔진
- html파일을 가져와서 파싱해서 분석후, 정해진 위치에 데이터를 치환해서 웹 페이지를 생성한다.
- 자바코드를 사용할 수 없다.

<br>

🌼템플릿 엔진 : 동적 컨텐츠를 생성하는 방법. 주로 view를 만드는데 사용한다. (정적 컨텐츠 생성x)

🌼Spring Boot에서는 JSP를 권장하지 않는다. JAR패키징 할때는 동작하지 않고 WAR패키징을 해야하기 때문이다.

🌼Spring Boot 다른 템플릿 엔진 : Freemarker, Groovy, Mustache, Thymeleaf

---

### 💬 Thymeleaf 문법   [나머지 문법은 여기 참고](https://www.thymeleaf.org/doc/tutorials/3.0/usingthymeleaf.html#standard-expression-syntax)

**🍍expressions**

- ${ } 👉 variable 표현
- *{ } 👉object의 field 값 표현
- #{ } 👉 message 표현
- @{ } 👉 link(url) 값 표현
- ~{ } 👉 표현식 조각(참조 가능)

<br>

**🍍Common**

	- th:text 👉 화면에 값을 출력할 때 사용
	- th:if 👉 조건문
	- th:block 👉 th:if조건에 만족하는 경우에만 th:block대그가 실행된다. html태그없이 단독으로 사용해서 th:if 나 th:switch를 표현할 수 있다.
	- th:switch, th:case 👉 switch-case문
	- th:unless 👉 else표현
	- th:each 👉 반복문

<br>

**🍍form**

- th:action 👉 form태그 사용시, 해당 경로로 요청을 보낼때 사용.
- th:object 👉 form submit을 할때, form의 데이터가 th:object에 설정해준 객체로 받아진다.

<br>

**🍍Utility**

- **#**을 붙여 사용한다.

  - objects

  - dates

  - calendars

  - numbers

  - strings

  - arrays

  - lists

  - sets

  - maps

    ..

<br>

<br>