### autowire 속성

1. **default** : 생성자에 할당할 type이 있는지 확인후 (constructor)

   ​                -> 없으면, setter에서 type이 있는지 확인하여 할당 (byType)

   **만일 기본 생성자가 있으면, 기본 생성자 호출

   **@Autowired 라는 어노테이션이 이 방식으로 동작

2. **byName** : setter와 같은 이름(id/name)의 bean을 찾아서 자동 할당

3. **byType** : setter와 같은 type의 bean을 찾아서 자동 할당

   (하나만 인식 가능하다.)

4. **constructor** : 생성자의 parameter와 같은 type, 같은 이름의 bean을 찾아서 자동할당



<br>

<br>

---

### @Autowired

: 의존관계를 자동설정할 때 사용한다.

: byType을 찾은 다음에 byName을 찾는다.

: 값 하나만 땡겨와서 연결할 수 있다.

: 해당 타입의 빈 객체가 존재하지 않거나 빈 객체가 두개 이상 존재할 경우, 예외가 발생한다.

<br>

- 해당 타입의 빈 객체가 존재하지 않는 경우, 예외 처리 방법

  - `@AutoWired(required=false)`로 지정 

    : 기본값은 `@Autowired(required=true)`이다.

    : false로 하면 빈 객체가 존재하지 않더라도 예외처리를 발생시키지 않는다.

    <br>

- 동일한 타입의 빈 객체가 두 개 이상 존재하는 경우, 예외처리 방법

  - `@Qualifier("설정파일에서 지정한 값")`으로 지정