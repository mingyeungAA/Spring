# 📄Spring MVC_01

### 💬Spring MVC란

- 스프링 MVC 프레임워크는 스프링기반으로 사용할 수 있다.
- 스프링이 제공하는 트랜젝션 처리가 DI 및 AOP 적용 등을 쉽게 사용할 수 있도록 돕는다.
- Struts와 같은 프레임워크와 스프링 프레임워크를 연동하기 위해 추가적인 설정을 하지 않아도 된다.
- 스프링 프레임워크에서 지원하는 Spring MVC는 모델-뷰-컨트롤러 구현을 포함하여 도메인 모델코드와 웹 폼을 깔끔하게 분리할 수 있도록 하고 스프링 프레임워크의 다른 모든 기능과 통합할 수 있게 하며, DI와 선언적인 방식으로 MVC기반의 웹 프로그램 개발을 효율적으로 할 수 있도록 지원한다.

<br>

---

### 💬Spring MVC 특징

- Spring Framework의 다른 모듈과의 연계용이
- 컨트롤러, command 객체, 모델 객체, validator 등 각각의 역할에 대한 명확한 분리
- form 객체 없이 사용자 지정 가능한 데이터 바인딩과 유효성 체크 지원
- 어떠한 view기술과도 연계가 용이
- tag lib 통한 message 출력, theme 적용 등과 입력 폼을 보다 쉽게 구현

<br>

---

### 💬Spring MVC 장점

- Spring MVC Framework는 스프링 기반으로 사용할 수 있다.
- 스프링이 제공하는 트랜젝션 처리, DI 및 AOP 적용 등을 손쉽게 사용할 수 있다.
- Struts와 같은 프레임워크와 스프링프레임워크를 연동하기 위해 추가적인 설정을 하지 않아도 된다.

<br>

---

### ⭐주요 구성요소⭐

- **DispatcherServlet **(=FrontController)

  - 클라이언트의 요청을 전달 받는다. 컨트롤러에게 클라이언트의 요청을 전달하고 컨트롤러가 리턴한 결과값을 view에 전달하여 알맞은 응답을 생성한다.
  - 컨트롤러 호출
  - Dispatcher가 받은 요청은 HandlerMapping으로 넘어간다.

  **

  - 공통처리 작업을 먼저수행후, 적절한 세부컨트롤러에게 작업을 위임해주고 예외발생시, 일관된 방식으로 에러를 처리해주는 일을 한다.
  - 각 컨트롤러들 사이의 중복된 코드나 협업시 개발자들의 개발 방식이 다른경우의 문제들을 해결할 수 있다.

  - web.xml의 역할이 축소됨

    

- **HandlerMapping**

  - 클라이언트의 요청 url을 어떤 컨트롤러가 처리할지를 결정한다.

  - RequestURL과 Controller 클래스의 맵핑을 관리한다.

  - 즉, @RequestMapping("/url") 을 명시하면 해당 url에 대한 요청이 들어왔을때, 해당 클래스 또는 메서드에 mapping한다.

  - url이 누구를 호출하고 있는지 결정한 후, DispatcherServlet에 전달한다.

    

- **Controller**

  - 클라이언트의 요청을 처리한 뒤, 그 결과를 DispatcherServlet에 알려준다.
  - 비즈니스 로직을 호출하여 처리결과 ModelAndView 인스턴스를 반환한다.

  

- **ModelAndView**

  - 컨트롤러가 처리한 결과 정보 및 뷰 선택에 필요한 정보를 담는다.

  

- **ViewResolver**

  - 컨트롤러의 처리결과를 생성할 뷰를 결정한다.

  - 어떤 뷰를 응답할 건지 결정한다.

  - view name에 prefix, suffix를 적용하여 View Object를 반환한다.

    

<br>

---

- ⚡Listener⚡

  - ContextLoaderListener클래스는 DispatcherServlet클래스의 로드보다 먼저 동작한다.
  - <img src="https://postfiles.pstatic.net/MjAyMDA5MDFfMjI5/MDAxNTk4OTM4OTUwMzgx.gzoEaIafx2elqOH2MLAHO3uOafs08lor-6jnWEhH14sg.fQZ0LyuNIX1Xbk9o_ig6RSq3Xyz2YcQcLtLIdDXjkYUg.PNG.mingyeung/image.png?type=w966" style="zoom:40%;" />
  - root-container를 /WEB-INF/applicationContext.xml을 이용해 빌드하도록 구현되어있다.
  - applicationContext.xml을 설정파일로 하여, 스프링 컨테이너를 하나 빌드하고 해당 컨테이너를 모든 서블릿 컨테이너가 공유할 수 있도록 설정한다.
  - ContextLoaderListener는 web.xml에 설정파일들이 모두 load되도록 등록할때 사용되고, 서블릿 이전에 서블릿을 초기화 시켜주며, contextConfigLocation으로 설정 파일들의 위치를 지정시켜준다.
  - contextConfigLocation으로 위치를 처음에 지정해주지 않으면, 기본적으로 web.xml은 roo-context.xml로 설정파일 위치를 잡아준다.

  - 어떤 xml을 호출해야 되는지 결정한다.
  - ContextLoaderListener는 Spring IoC Container(=Application Context)를 servlet application 생명 주기에 맞춰서 바인딩해준다.

<br>

<img src="https://postfiles.pstatic.net/MjAyMDA5MDFfNTAg/MDAxNTk4OTM4Mzc3NzQw.-DODOSTcDtMt1imOCtm3bhJ14zs_bdOzCIBQUh5UEJIg.M8BjGWeWui9mBJ9kAK4_SlynzPcy7LZI5mkVH9p9O6Ig.PNG.mingyeung/image.png?type=w966" style="zoom:33%;" />

> 이 경우, 두 DispatcherServlet은 각각 별도의 WebApplicationContext를 생성하게 된다.
>
> 두 Context는 독립적이고 공유할 수 없다.

<br>

<img src="https://postfiles.pstatic.net/MjAyMDA5MDFfMjgz/MDAxNTk4OTM4NTcxNjUy.mrKFC8jKw5TIj1hBDBzazfhHO4bY0u5aByZ9p4TWsK8g.lB1cpO23kH-_1i_4TeBkLMJrrIibEbJnztH-pUCw4B8g.PNG.mingyeung/image.png?type=w966" style="zoom:33%;" />

> 위의 경우, 동시에 필요한 의존성(=공통빈)이 있어야 하는 경우에 사용한다.
>
> ContextLoaderListener와 DispatcherServlet은 각각 WebapplicationContext인스턴스를 생성하게 된다.
>
> ContextLoaderListener가 생성한 context가 root-context가 되고, DispatcherServlet이 생성한 인스턴스는 root-context를 부모로 사용하는 자식 context가 된다.

<br>

<br>

---

### 💬흐름도

<img src="https://postfiles.pstatic.net/MjAyMDA5MDFfMjYx/MDAxNTk4OTI5OTU5Mzgz._2SDuMZwlq39DmmohyLDMNFK6v8joKS7ExHoCL0ZazAg.ib-26TpORAivVAyJwToBifapbHYeYo3dChCSAj9Nkmgg.PNG.mingyeung/image.png?type=w966" style="zoom:80%;" />



1. 클라이언트가 서버에 요청을 한다. (request)

2. Listener에서 어떤 xml로 가야하는지 결정해서 DispatcherServlet에 넘겨준다.

3. DispatcherServlet은 HandlerMapping를 통해 요청에 해당하는 controller(@Controller)를 실행한다.

4. controller는 @RequestMapping을 통해 요청을 처리할 메서드에 도달한다.

5. biz(@Service) 호출

6. Dao(@Repository) 호출

7. Dao에서 값 return

8. biz에서 값 return

9. return 받은 값을 model객체에 담아서 DispatcherSerlvet에 전달한다. (=ModelAndView)

10. DispatcherServlet은 ViewResolver에게 받은 뷰의 정보를 넘긴다.

11. ViewResolver는 해당 JSP를 창아서 DispatcherServlet에 알려준다.

    (servlet-context.xml에서 suffix, prefix를 통해 /WEB-INF/views/index.jsp 로 만들어주는 것도 ViewResolver이다.)

12. 클라이언트가 요청한 view를 응답한다.

<br>

<br>

---

#### 💬인코딩 필터 설정 (web.xml)

``` java
	<filter>
		<filter-name>encodingFilter</filter-name>
		<filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>
		<init-param>
			<param-name>encoding</param-name>
			<param-value>UTF-8</param-value>
		</init-param>
		<init-param>
			<param-name>forceEncoding</param-name>
			<param-value>true</param-value>
		</init-param>
	</filter>
	
	<filter-mapping>
		<filter-name>encodingFilter</filter-name>
		<url-pattern>/* </url-pattern>
	</filter-mapping>
```

<br>

<br>

---

---

**👻출처**

- https://jeong-pro.tistory.com/96

- [https://devbox.tistory.com/entry/Spring-webxml-%EA%B8%B0%EB%B3%B8-%EC%84%A4%EC%A0%95](https://devbox.tistory.com/entry/Spring-webxml-기본-설정)
- https://m.blog.naver.com/PostView.nhn?blogId=minis24&logNo=80097770192&proxyReferer=https:%2F%2Fwww.google.com%2F
- https://iotsw.tistory.com/91
- https://gmlwjd9405.github.io/2018/12/20/spring-mvc-framework.html

<br>

<br>