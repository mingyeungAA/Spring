## Spring 특징

### DI (Dependency Injection) / IoC(Inversion of Control)

### AOP (Aspect Oriented Programming)

### OCP (Open Closed Principle)

<br>

---

<br>

### AOP (Aspect Oriented Programming)

: 관점지향 프로그래밍 (OOP와 다르지 않다.)



> **cc** (core concern) : 주 관심사항 (ccc빼고 남은것)
>
> **ccc** (cross cutting concern) : 공통 관심사항 (공통된 것들을 묶는다.)



: 문제를 해결하기 위한 핵심관심사항과 전체에 적용되는 공통관심사항을 기준으로 프로그래밍함으로써,

  공통모듈을 여러 코드에 쉽게 적용할 수 있도록 지원하는 기술

: 공통으로 사용하는 기능들을 모듈화하고 해당 기능을 프로그램 코드에서 직접 명시하지 않고 선언적으로

  처리하여 필요한 컴포넌트에 계층적으로 다양한 기능들을 적용한다.

<br>

<img src="https://postfiles.pstatic.net/MjAyMDA4MThfMjU0/MDAxNTk3NzYwNDQxOTA2.MwWuxDZ88iCMcFgfk3gIKuVr58ynaAuOVzjkczGjwuQg.X6cTSu-OdrOmK_jPkLN8i1zVq262g90nnWXTvFTYaN0g.PNG.mingyeung/AOP.png?type=w966" alt="aop">

<br>

<br>

|           용어           |                             설명                             |
| :----------------------: | :----------------------------------------------------------: |
| 결합점<br />(Join Point) | 인스턴스의 생성시점. 메소드를 호출하는 시점. Exception이 발생하는 시점과 같이 애플리케이션이 실행될때 특정 작업이 실행되는 시점을 의미한다. <br />(Aspect를 플러그인 할 수 있는 애플리케이션의 실행시점) |
|  교차점<br />(Pointcut)  | 충고가 어떤 결합점에 적용되어야 하는지 정의. 명시적인 클래스의 이름, 메소드의 이름이나 클래스나 메소드의 이름과 패턴이 일치하는 결합점이 지정 가능토록 해준다.<br />(스프링 설정파일 안에 XML로 작성) (=ccc를 어디다가 붙일것인지 알려주는) |
|    충고<br />(Advice)    | 교차점에서 지정한 결합점에서 실행(삽입)되어야 하는 코드. Aspect의 실제 구현체<br />(=잘라놓은 실제 코드 = ccc) |
|  에스펙트<br />(Aspect)  | 에스펙트는 AOP의 중심단위. Advice와 pointcut을 합친것이다. 구현하고자 하는 횡단 관심사의 기능,애플리케이션의 모듈화 하고자 하는 부분. |
|   엮기<br />(Weaving)    | 에스펙트를 대상 객체에 적용하여 새로운 프록시 객체를 생성하는 과정을 말한다.<br />Aspect는 대상 객체의 지정된 결합점에 엮인다. <br />(=하나로 묶여서 잘 실행회는 것 = ccc+cc) |

**Advisor(Aspect) = Advice(=ccc공통사항) + pointcut**





<br>

<br>

---

### AOP 구현 방식

1. **XML기반의 POJO클래스를 이용한 AOP구현**

   - Advice클래스를 작성한다.

   - XML설정 파일에서 `<aop:config>`를 이용해서 Aspect를 설정한다.

     (즉, Advice(=ccc공통사항)와 pointcut을 설정한다.)

     <br>

2. **@Aspect 어노테이션을 이용한 AOP구현**

   - @Aspect 어노테이션을 이용해서 Aspect클래스를 작성한다.

   - 이때, Aspect클래스는 Advice(=ccc공통사항)를 구현하는 메서드와 pointcut을 포함한다.

   - XML설정 파일에서 `<aop:aspectj-autoproxy>`를 설정한다.

     <br>

     <br>

---

##### 설정 구조

`<aop:config>`

   `<aop:pointcut/>`                     :  pointcut 설정

   `<aop:aspect>`                            : aspect 설정

​      `<aop:befor/>`                         : method(=target=주관심사) 실행전

​      `<aop:after-returning/>`    : method 정상 실행 후

​      `<aop:after-throwing/>`      : method 예외 발생 시

​      `<aop:after/>`                         : method 실행 후 (예외 발생 여부 상관 없음)

​      `<aop:around/>`                       : 모든 시점 적용 가능

   `</aop:aspect>`

`</aop:config>`

<br>

before -> method실행  -> after-returning -> (예외발생시)after-throwing -> after

<br>

---

<br>

#### Proxy

: target을 감싸서 target의 요청을 대신 받아주는 랩핑 오브젝트이다.

: proxy는 advice(=ccc공통사항)를 target객체에 적용하면서 생성되는 객체이다.

: 클라이언트(호출자)에서 target을 호출하게 되면, target이 아닌 target을 감싸고 있는 proxy가 호출되어

  target메소드 실행전에 선처리, target메소드 실행 후, 후처리를 실행시키도록 구성되어 있다.

: AOP에서 proxy는 호출을 가로챈 후, advice(=ccc공통사항)에 등록된 기능을 수행 후, target메소드를 호출한다.

<br>

<br>

#### target

: cc (주관심사)

<br>

---

### Advice 종류

- **@Before**

   : target메소드가 호출되기 전에 advice(=ccc공통사항)기능을 수행

- **@After** 

  : target메소드의 결과에 상관없이 target메소드가 완료되면 advice(=ccc공통사항)기능을 수행

- **@After-Returning** 

  : target메소드가 정상적으로 동작한 후, 결과값을 리턴한 후에 advice(=ccc공통사항)기능을 수행

- **@After-Throwing** 

  : target메소드가 수행중에 비정상적으로(예외가 발생하면) 동작하면, advice(=ccc공통사항)기능을 수행

<br>

ex)@Before("pointcut")  ->  `@Before("execution(public * *(..))")`



