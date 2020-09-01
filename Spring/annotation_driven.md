# 📄annotation-driven

### 💬mvc:annotation-driven

- Spring MVC 컴포넌트들을 디폴트 설정을 통해 활성화한다.
- Spring MVC @Controller에 요청을 보내기 위해 필요한 HandlerMapping과 HandlerAdapter를 bean으로 등록한다.
  - HandlerMapping : HTTP 요청정보를 이용해서 컨트롤러를 찾아주는 기능
  - HandlerAdapter : HandlerMapping을 통해 찾은 컨트롤러를 직접 실행하는 기능을 수행
- Bean을 생성하기 위해 xml 파일에 context:component-scan을 명시하면 이 태그를 포함하지 않아도 MVC 어플리케이션을 작동한다.

<br>

---

### 💬context:component-scan

- 특정 패키지 내의 클래스를 스캔하고 Annotation(@Component, @Controller, @Service, @Repository)을 확인한 후 bean인스턴스로 생성한다.
- 이를 이용하면 @Autowired 와 @Qulifier Annotation을 인식할 수 있다.
- context:component-scan을 선언했다면 context:annotation-config를 선언할 필요가 없다.

<br>

---

### 💬context:annotation-config

- ApplicationContext안에 이미 등록된 bean들의 annotation을 활성화하기 위해 사용된다.
- Component-scan과의 차이점은 이 설정은 bean을 등록하는 작업을 수행하지 않는다는 것이다.