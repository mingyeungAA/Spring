###<context: annotation-config/>  vs  <context: component-scan/>



#####<context : annotation-config/>

이미 등록된 bean에 대해서만 annotation을 활성화한다.

@Autowired 와 @Qualifier 두가지만 해결한다.

따라서 위 태그를 사용하더라도 xml에 반드시 bean을 반드시 선언해야 한다.



#####<context : component-scan/>

bean의 등록 여부와 관계없다. 스프링이 알아서 bean 스캔을 통해 Annotation을 해석하고 활성화한다.

@Autowire 와 @Qualifier 뿐만 아니라, @Service, @Component, @Controller, @Repository 등 모든 클래스를 스캔하고 bean을 작성한다.

따라서 이 태그를 사용하면 위 태그는 사용할 필요가 없다.



