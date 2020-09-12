# 📄Spring MVC Filter+Aop+Interceptor+Transaction+Login

### 💬순서

1. pox.xml : ojdbc6.jar, Mybatis, Mybatis-spring, commones-dbcp, spring-orm
2. web.xml : DispatcherServlet, ContextLoaderListener, encodingFilter 설정
3. board.sql (/WEB-INF/spring/sqls/myboard.sql)
4. BoardDto, BoardDao(Impl), BoardBiz(Impl), BoardController
5. board-mapper.xml (src/main/resources/mybatis/board-mapper.xml) 
6. db.properties (src/main/resources/mybatis/db.properties)
7. config.xml (/WEB-INF/spring/sqls/config.xml) : typealias 와 mapper만 설정
8. applicationContext.xml : db.properties, dataSource, Mybatis, MybatisTemplate 설정

<br>

**_Filter**

9. LogFilter (com.mvc.upgrade.common.filter) -> javax.servlet.Filter 인터페이스
10. web.xml

<br>

**_AOP**

11. pom.xml : org.aspectj. (aspectjrt, aspectjweaver)
12. LogAop (com.mvc.upgrade.common.aop.LogAop)
13. aop-context.xml (WEB-INF/spring/appServlet/aop-context.xml)
14. web.xml
15. log4j.xml (src/main/resources/log4j.xml)

<br>

**_Login**

16. pom.xml : jackson-core-asl, jackson-mapper-asl (spring 4.x버전부터는 jackson-core / jackson-databind를 사용해야 한다.)
17. member.sql (WEB-INF/spring/sqls/mymember.sql)
18. MemberDto, MemberDao, MemberBiz, MemberController
19. member-mapper.xml (src/main/resources/mybatis/member-mapper.xml)
20. config.xml (WEB-INF/spring/sqls/config.xml)

<br>

**_Interceptor**

21. LoginInterceptor (com.mvc.upgrade.common.interceptor.LoginInterceptor  impl  HandlerInterceptor)
22. servlet-context.xml

<br>

**_Transaction**

23. (Board)dao, biz, controller 에 추가
24. servlet-context.xml (namespaces "tx")
25. applicationContext.xml : transactionManager

<br>

---

**1. pox.xml** &nbsp; (`<dependencies>`안에 추가하기)

=> ojdbc6.jar, Mybatis, Mybatis-spring, commones-dbcp, spring-orm, aspectjweaver (Aop), jackson-core-asl Login), jackson-mapper-asl (Login)

```
		<!-- ojdbc6.jar -->
		<!-- https://mvnrepository.com/artifact/com.oracle.database.jdbc/ojdbc6 -->
		<dependency>
			<groupId>com.oracle.database.jdbc</groupId>
			<artifactId>ojdbc6</artifactId>
			<version>11.2.0.4</version>
		</dependency>

		<!-- mybatis -->
		<!-- https://mvnrepository.com/artifact/org.mybatis/mybatis -->
		<dependency>
			<groupId>org.mybatis</groupId>
			<artifactId>mybatis</artifactId>
			<version>3.5.5</version>
		</dependency>

		<!-- mybatis-spring -->
		<!-- https://mvnrepository.com/artifact/org.mybatis/mybatis-spring -->
		<dependency>
			<groupId>org.mybatis</groupId>
			<artifactId>mybatis-spring</artifactId>
			<version>2.0.5</version>
		</dependency>

		<!-- commons-dbcp -->
		<!-- https://mvnrepository.com/artifact/commons-dbcp/commons-dbcp -->
		<dependency>
			<groupId>commons-dbcp</groupId>
			<artifactId>commons-dbcp</artifactId>
			<version>1.4</version>
		</dependency>

		<!-- spring-orm -->
		<!-- https://mvnrepository.com/artifact/org.springframework/spring-orm -->
		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-orm</artifactId>
			<version>${org.springframework-version}</version>
		</dependency>

		<!-- For AOP -->
		<!-- aspectjweaver -->
		<!-- https://mvnrepository.com/artifact/org.aspectj/aspectjweaver -->
		<dependency>
			<groupId>org.aspectj</groupId>
			<artifactId>aspectjweaver</artifactId>
			<version>${org.aspectj-version}</version>
		</dependency>

		<!-- For Login -->
		<!-- jackson-core-asl -->
		<!-- https://mvnrepository.com/artifact/org.codehaus.jackson/jackson-core-asl -->
		<dependency>
			<groupId>org.codehaus.jackson</groupId>
			<artifactId>jackson-core-asl</artifactId>
			<version>1.9.13</version>
		</dependency>


		<!-- jackson-mapper-asl -->
		<!-- https://mvnrepository.com/artifact/org.codehaus.jackson/jackson-mapper-asl -->
		<dependency>
			<groupId>org.codehaus.jackson</groupId>
			<artifactId>jackson-mapper-asl</artifactId>
			<version>1.9.13</version>
		</dependency>

		<!-- https://mvnrepository.com/artifact/org.springframework.security/spring-security-web -->
		<dependency>
			<groupId>org.springframework.security</groupId>
			<artifactId>spring-security-web</artifactId>
			<version>${org.springframework-version}</version>
		</dependency>
```

<br>

**2. web.xml**

=> DispatcherServlet, ContextListener, EncodingFilter /  LogFilter, Aop(xml) 설정

```
<!-- The definition of the Root Spring Container shared by all Servlets and Filters -->
	<context-param>
		<param-name>contextConfigLocation</param-name>
		<param-value>/WEB-INF/spring/appServlet/applicationContext.xml</param-value>
	</context-param>
	
	<!-- Creates the Spring Container shared by all Servlets and Filters -->
	<listener>
		<listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
	</listener>

	<!-- Processes application requests -->
	<servlet>
		<servlet-name>appServlet</servlet-name>
		<servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
		<init-param>
			<param-name>contextConfigLocation</param-name>
			<param-value>
				/WEB-INF/spring/appServlet/servlet-context.xml
			</param-value>
		</init-param>
		<load-on-startup>1</load-on-startup>
	</servlet>
		
	<servlet-mapping>
		<servlet-name>appServlet</servlet-name>
		<url-pattern>*.do</url-pattern>
	</servlet-mapping>
	
	<!-- EncodingFilter -->
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
		<url-pattern>/*</url-pattern>
	</filter-mapping>

	
	<!-- Logfilter -->
	<filter>
		<filter-name>LogFilter</filter-name>
		<filter-class>com.mvc.upgrade.common.filter.LogFilter</filter-class>
	</filter>
	<filter-mapping>
		<filter-name>LogFilter</filter-name>
		<url-pattern>/*</url-pattern>
	</filter-mapping>
```

<br>

**3. board.sql &nbsp; (/WEB-INF/spring/sqls/board.sql)**

```
DROP SEQUENCE NOSEQ;
DROP TABLE BOARD;

CREATE SEQUENCE NOSEQ;

CREATE TABLE BOARD(
	MNO NUMBER PRIMARY KEY,
	NAME VARCHAR2(500) NOT NULL,
	TITLE VARCHAR2(1000) NOT NULL,
	CONTENT VARCHAR2(4000) NOT NULL,
	MDATE DATE NOT NULL
);

INSERT INTO BOARD
VALUES (NOSEQ.NEXTVAL, '관리자', '테스트 글이당', '아아테스트!1234', SYSDATE);

SELECT MNO, NAME, TITLE, CONTENT, MDATE
FROM BOARD
ORDER BY MNO DESC;
```

<br>

**4. BoardDto, BoardDao(Impl), BoardBiz(Impl), BoardController**

<img src="https://postfiles.pstatic.net/MjAyMDA5MTJfMTEg/MDAxNTk5ODk4MjYzOTE5.HrVdlaqatguZ3HjbPQe52XZItLwnRkfBkqbrcty1o6wg.yU5pkZ2sqnR2oxSWZJkxTnDu_YmWg1ekf5bb3jHiXUAg.PNG.mingyeung/image.png?type=w966" style="zoom:33%;" />

**5. board-mapper.xml &nbsp; (src/main/resources/mybatis/board-mapper.xml)**

**6. db.properties &nbsp; (src/main/resources/mybatis/board-mapper.xml)**

<img src="https://postfiles.pstatic.net/MjAyMDA5MTJfMTM4/MDAxNTk5ODk4NDUwMTQ4.wMNJw52mgNINiN9JEzk8rPV6oF_PEg5diw_c0v_gWmEg.tTkLiFdx6uL4U4I4XDEE16hPfNqaOZzfmDjFFQhpI7Ug.PNG.mingyeung/image.png?type=w966" style="zoom:33%;" />

<br>

**7. config.xml &nbsp; (/WEB-INF/spring/sqls/config.xml)** 

=> typealias와 mappers만 설정!

<img src="https://postfiles.pstatic.net/MjAyMDA5MTJfMTEx/MDAxNTk5ODk4NTgxNzc4.Ai58CojI4XzyRfdXBvWhDpMRwf3h70j4aZL4ydaaC8kg.q1heCebwt3tYzXIRvAuxBhRBp_KajDJmMO9vDginmSsg.PNG.mingyeung/image.png?type=w966" style="zoom:33%;" />



<br>

**8. applicationContext.xml (= root-context.xml)**

=> db.properties, dataSource, Mybatis, sqlSessionTemplate / transactionManger  설정

```java
<!-- db.properties --> 
	<bean class="org.springframework.beans.factory.config.PropertyPlaceholderConfigurer">
		<property name="location">
			<value>classpath:mybatis/db.properties</value>
		</property>
	</bean>
	
	<!-- dataSource -->
   <bean id="dataSource" class="org.apache.commons.dbcp.BasicDataSource">
      <property name="driverClassName" value="${driver}"/>
      <property name="url" value="${url}"/>
      <property name="username" value="${username}"/>
      <property name="password" value="${password}"/>
   </bean>
   
	
	<!-- mybatis -->
	<bean id="sqlSession" class="org.mybatis.spring.SqlSessionFactoryBean">
		<property name="configLocation" value="WEB-INF/spring/sqls/config.xml"></property>
		<property name="dataSource" ref="dataSource"></property>
	</bean>
	
	<!-- mybatisTemplate -->
	<bean id="sqlSessionTemplate" class="org.mybatis.spring.SqlSessionTemplate">
		<constructor-arg ref="sqlSession"></constructor-arg>
	</bean>
	
	<!-- transactionManager -->
	<bean id="transactionManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
		<property name="dataSource" ref="dataSource"></property>
	</bean>	
```

<br>

**_Filter**

**9. LogFilter &nbsp; (com.mvc.upgrade.common.filter) 👉 javax.servelt.Filter 인터페이스**

<img src="https://postfiles.pstatic.net/MjAyMDA5MTJfNTMg/MDAxNTk5ODk4MjUwMjk5.LKs3rribzbmS2ZEpmZVqfHCErgubAlRIiEO-0_FMOGsg.F7BEnrJv1mem5Qx1BZyTYWfxIliBGwUw1vAHbzrLfSsg.PNG.mingyeung/image.png?type=w966" style="zoom:33%;" />

```
public class LogFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;

		String remoteAddr = req.getRemoteAddr();
		String uri = req.getRequestURI();
		String url = req.getRequestURL().toString();
		String queryString = req.getQueryString();

		String referer = req.getHeader("referer");
		String agent = req.getHeader("User-Agent");

		StringBuffer sb = new StringBuffer();
		sb.append("* remoteAddr : " + remoteAddr + "\n");
		sb.append("* uri : " + uri + "\n");
		sb.append("* url : " + url + "\n");
		sb.append("* queryString : " + queryString + "\n");
		sb.append("* referer : " + referer + "\n");
		sb.append("* agent : " + agent);

		System.out.println("LogFilter");
		System.out.println(sb);

		chain.doFilter(request, response);

	}

	@Override
	public void destroy() {

	}

}
```

<br>

**_AOP**

**10. LogAop &nbsp; (com.mvc.upgrade.common.aop.LogAop)**

```
public class LogAop {
	
	public void beforeLog(JoinPoint join) {
		Logger logger = LoggerFactory.getLogger(join.getTarget()+"");
		
		logger.info("----------AOP Start!----------");
		Object[] args = join.getArgs();
		
		if(args != null) {
			logger.info("method : "+join.getSignature().getName());
			for(int i=0 ; i<args.length ; i++) {
				logger.info(i+"번째 : "+args[i]);
			}
		}
	}
	
	public void afterLog(JoinPoint join) {
		
		Logger logger = LoggerFactory.getLogger(join.getTarget()+"");
		logger.info("----------AOP End----------");
		
	}
	
	public void afterThrowingLog(JoinPoint join) {
		
		Logger logger = LoggerFactory.getLogger(join.getTarget()+"");
		logger.info("---------AOP Error Log----------");
		
		logger.info("Error : "+join.getArgs());
		logger.info("Error : "+join.toString());
		
	}

}
```

<br>

**11. aop-context.xml &nbsp; (WEB-INF/spring/appServlet/aop-context.xml)**

<img src="https://postfiles.pstatic.net/MjAyMDA5MTJfMjUg/MDAxNTk5OTAxNTkxNjk1.zPy8p_XpEpJSMjFss5wVFo4mKMCxQysnp6aWRSl8hCEg.1JPBPgQ5BoPIapFI2XeMTPazEAIOmQZEMYy3IKGIIF8g.PNG.mingyeung/image.png?type=w966" style="zoom:33%;" />

<img src="https://postfiles.pstatic.net/MjAyMDA5MTJfMTA0/MDAxNTk5OTAxNjEzNjIy.BZgiFCDXE8jkDfl9l2ItK8IIsWEgrgaAti44mLWJqFsg.Ny7X1Rvgc4ecIDYKpmRqxZ3nECJUCq3_TUOJeOJvf10g.PNG.mingyeung/image.png?type=w966" style="zoom:33%;" />

<img src="https://postfiles.pstatic.net/MjAyMDA5MTJfMTk2/MDAxNTk5OTAxNjMwNzY2._Ky-jMRJbsvcvxB4d4snHyxoShfxu6t2e-il0n6azuMg.9IhPxYYI5ceT-_32CCEOOO9Dj9QHTmgYACPkSVSO4e0g.PNG.mingyeung/image.png?type=w966" style="zoom:33%;" />

```
	<bean id="logAop" class="com.mvc.upgrade.common.aop.LogAop"/>
	
	<aop:config>
		<aop:pointcut expression="execution(public * com.mvc.upgrade.model.dao.*Dao*.*(..))" id="daoPoint"/>
		<aop:aspect ref="logAop" id="logAop">
			<aop:before method="beforeLog" pointcut-ref="daoPoint"/>
			<aop:after method="afterLog" pointcut-ref="daoPoint"/>
			<aop:after-throwing method="afterThrowingLog" pointcut-ref="daoPoint"/>
		</aop:aspect>
	</aop:config>
```

<br>

**12. web.xml**

=> `/WEB-INF/spring/appServlet/aop-context.xml` 추가하기

```
<servlet>
		<servlet-name>appServlet</servlet-name>
		<servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
		<init-param>
			<param-name>contextConfigLocation</param-name>
			<param-value>
				/WEB-INF/spring/appServlet/servlet-context.xml
				/WEB-INF/spring/appServlet/aop-context.xml
			</param-value>
		</init-param>
		<load-on-startup>1</load-on-startup>
	</servlet>
```

<br>

**13. log4j.xml (src/main/resources/log4j.xml)**

=> Root Logger부분을 **"trace"**로 바꾼다.

```
	<!-- 추가 -->
	<logger name="org.ibatis">
		<level value="info" />
	</logger>
	<logger name="java.sql">
		<level value="info" />
	</logger>

	<!-- Root Logger -->
	<root>
		<priority value="trace" />
		<appender-ref ref="console" />
	</root>
```

<br>

**_Login**

**14. member.sql &nbsp; (WEB-INF/spring/sqls/member.sql)**

```
DROP SEQUENCE MEMNOSEQ;
DROP TABLE MEMBER;

CREATE SEQUENCE MEMNOSEQ;

CREATE TABLE MEMBER(
	MEMNO NUMBER PRIMARY KEY,
	MEMID VARCHAR2(500) NOT NULL,
	MEMPW VARCHAR2(500) NOT NULL,
	MEMNAME VARCHAR2(500) NOT NULL
);

INSERT INTO MEMBER
VALUES (MEMNOSEQ.NEXTVAL, 'admin', 'admin1234', '관리자');

SELECT MEMNO, MEMID, MEMPW, MEMNAME
FROM MEMBER
ORDER BY MEMNO DESC;

```

<br>

**15. MemberDto, MemberDao(Impl), MemberBiz(Impl), MemberController**

**16. member-mapper.xml &nbsp; (src/main/resources/mybatis/member-mapper.xml)**

**17. config.xml &nbsp;(WEB-INF/spring/sqls/config.xml)**

```
	<typeAliases>
		<typeAlias type="com.mvc.upgrade.model.dto.BoardDto" alias="BoardDto"/>
		<typeAlias type="com.mvc.upgrade.model.dto.MemberDto" alias="MemberDto"/>
	</typeAliases>
	
	<mappers>
		<mapper resource="/mybatis/board-mapper.xml"/>
		<mapper resource="/mybatis/member-mapper.xml"/>
	</mappers>
```

<br>

**_Interceptor**

**18. LoginInterceptor &nbsp; (com.mvc.upgrade.common.interceptor.LoginInterceptor)**

<img src="https://postfiles.pstatic.net/MjAyMDA5MTJfMTky/MDAxNTk5OTIwOTkzNDgw.zhzoZHmUFvGSn7URnV83rEls28PRbhwO4CYml08XuX8g.3fmpqoqLGld0Wb9vafmphzWLgLe4QLKu3EY0SxqeZCIg.PNG.mingyeung/image.png?type=w966" style="zoom:33%;" />

```
public class LoginInterceptor implements HandlerInterceptor {
	
	Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		logger.info("**[LoginInterceptor]** : preHandle");
		
		if(request.getRequestURI().contains("/loginform.do") || request.getRequestURI().contains("/ajaxlogin.do") || 
				request.getSession().getAttribute("login") != null) {  //이 조건일때만 controller로 넘어간다.
			
			return true;
		}
		
		if(request.getSession().getAttribute("login") == null) {  //session에 값이 없으면,
			response.sendRedirect("loginform.do");
			return false;
		}
		
		return false;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		logger.info("**[LoginInterceptor]** : postHandle");
		//logger.info(modelAndView.getViewName());  //=>어떤 view를 가져오는지 알려줌
		//=>이걸 쓰면 "통신실패" 뜸!
		//=>비동기 통신이라서, model객체에 안담겨있음 (modelAndView == null>
		
		if(modelAndView != null) {
			logger.info(modelAndView.getViewName());
		}

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
		logger.info("**[LoginInterceptor]** : afterCompletion");
	}
```

<br>

**19. servlet-contex.xml **

```
	<!-- interceptor -->
	<interceptors>
		<interceptor>
			<mapping path="/*"/>
			<beans:bean class="com.mvc.upgrade.common.interceptor.LoginInterceptor"></beans:bean>
		</interceptor>
	</interceptors>
```

<br>

**_Transaction**

```
<!-- index.html -->
<a href="test.do">test...(Transaction 확인용!)</a>
```

**20. (Board) Dao(Impl), Biz(Impl), Controller 에 추가하기**

- BoardDao

  ``` java
  public String test();
  ```

- BoardDaoImpl

  ```java
  public String test() {
  		
  	return null;
  }
  ```

- BoardBiz

  ```java
  public String transactionTest();
  ```

- BoardBizImpl

  ```java
  @Transactional
  	@Override
  	public String transactionTest() {
          
          //insert가 먼저 들어가야됨
  		boardDao.insert(new BoardDto(0, "transaction","test","insert",null));
  		
          //위에 insert가 안되면 이 코드도 실행되면 안됨!
  		String test = boardDao.test();
  		test.length();
  		
  		
  		return test;
  	}
  ```

- BoardController

  ```java
  //Transaction
  	@RequestMapping("/test.do")
  	public String transactionTest() {
  		logger.info("[test.do]");
  		
  		boardBiz.transactionTest();
  		
  		return "redirect:list.do";
  	}
  ```

<br>

**21. servlet-context.xml &nbsp; 👉 'Namespaces'에서 "tx" 추가하기**

```java
<!-- Transaction -->
<tx:annotation-driven/>
```

<br>

**22. applicationContext.xml**

=> transactionManager 추가

```
<!-- transactionManager -->
	<bean id="transactionManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
		<property name="dataSource" ref="dataSource"></property>
	</bean>	
```

<br>

🌼test링크를 누르면 500에러 뜸!

<br>

<br>

