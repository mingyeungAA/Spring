## Spring 특징

### DI (Dependency Injection) / IoC(Inversion of Control)

### AOP (Aspect Oriented Programming)

### OCP (Open Closed Principle)

<br>

<br>

---

### DI (Dependency Injection) 의존성 주입

- 객체간의 결합을 느슨하게 하는 스프링의 핵심 기술 (유지보수에 좋다.)
- 의존성 주입이란? = 사용자가 직업 new키워드를 사용하여 객체를 생성하지 않고, 외부(컨테이너)에서 생성된 객체를 주입받는 방식



​	※의존관계를 관리하는 방법

	1. Construction Injection : 생성자를 통한 전달.   `<constructor-arg/>` 사용
 	2. Setter Injection : setter()를 통한 전달.    `<property/>` 사용
 	3. Field Injection : 멤버변수를 통한 전달.



###### 강결합 

: 객체 간 결합도가 강한 프로그램 (클래스와 클래스가 그냥 바로 연결되어 있다. 직접 객체 생성)

-HelloApp에서 MessageBean을 직접 객체 생성하여 사용하고 있다.

-MessageBean클래스를 다른 클래스로 변경할 경우, HelloApp의 소스를 **같이 수정해 주어야 한다.**



###### 약결합

: **인터페이스**를 사용하여 객체 간 결합도를 낮춘 프로그램

(클래스와 인터페이스가 연결되어 있다. 왠만하면 약결합하려면 스프링보다는 **인터페이스를 사용하자!**)

-HelloApp은 MessageBean이라는 인터페이스를 통해 객체 사용

-일반적으로 팩토리 메서드를 활용하여, 사용할 객체를 생성한다. MessageBean이라는 이름의 MessageBeanKo의 객체가 생성되든 MessageBeanEn의 객체가 생성되든 HelloApp은 **수정될 사항이 없다.**



###### 약결합

: **스프링**을 사용하여 객체 간 결합도를 낮춘 프로그램

-프로그램에서 필요한 객체를 스프링컨테이너가 미리 생성하여 이 객체를 필요로 하는 프로그램에 생성자,setter 또는 메서드를 통해서 전달한다.

-어떠한 객체를 생성하여 전달할지는 디스크립터 파일(XML로 작성)을 사용한다.









