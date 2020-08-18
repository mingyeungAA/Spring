#### Spring Container (=Bean Factory = IoC Container)

: Spring Framework의 핵심 컴포넌트

: Container는 DI를 사용하여 응용 프로그램을 구성하는 bean객체를 관리한다.

: POJO를 이용하여 EJB이 기능을 유지하면서 복잡성을 제거하고, 객체들의 라이프사이클을 관리해준다.

<br>

- bean을 포함하고 관리하는 책임이 있다.

  - 객체(bean)를 생성하고
  - 객체들을 함께 묶고
  - 객체들을 구성하고
  - 객체들의 전체 생명주기(lifecycle)을 관리

  <br>

- Spring Container의 2가지 유형

  - BeanFactory : 주로 단순한 DI에서만 사용한다.    `XMLBeanFactory`

  - **ApplicationContext** : Resources가 제한되어 있지 않은 모든 곳에 사용한다. BeanFactory와 유사하지만 좀더 향상된 컨테이너이다.   `ClassPathXmlApplicationContext`

    <br>

- 컨테이너 생명주기

  - 생성,설정,사용, 종료로 주기를 4부분으로 나눌 수 있다.

  <img src="https://postfiles.pstatic.net/MjAyMDA4MThfMTEz/MDAxNTk3NzU3NjAxMTc5.i4hqJJ267kqyJsbeFY2mYZmaRAyFRZ2-lEdEFoK6NrYg.-fufbxlauAKTQSmqXSm72mW2gogPrF6Po2I9qgV0fbgg.PNG.mingyeung/%EC%9D%B4%EB%AF%B8%EC%A7%80_4.png?type=w966" alt="이미지_4" />

*[그림출처](https://blog.naver.com/k220j/220728925820)

