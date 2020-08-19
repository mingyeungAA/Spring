## Annotation

#### @Component

- `<context:component-scan>` 태그를 추가하면 어노테이션이 적용된 클래스를 빈으로 등록하게 된다.

- ex) `<context:component-scan base-package="com.test01.anno"/>`
  	package하위에 @Component로 선언된 클래스를 bean으로 자동등록

  ​    (해당 클래스 이름, 첫글자는 소문자로)

<br>

---

#### @Autowired





<br>

---

#### @Qualifier

- @Autowired 동일 타입의 빈 객체가 존재시, 특정 빈을 삽입할 수 있게 설정





<br>

---

