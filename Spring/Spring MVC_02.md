# 📄Spring MVC_02



<img src="https://postfiles.pstatic.net/MjAyMDA5MDNfMTgz/MDAxNTk5MTIwODg4MzAw.zr_mbLGcRg9G-wSZ7iPKWqfL_WNsAPQYH7yqhcnpSmog.gE0kL6b-_L-3Wl22l1xE3qHpBjFBNrQ0Vcxrjk58Rokg.PNG.mingyeung/image.png?type=w966" style="zoom:80%;" />

**🌼DBCP(DataBase ConnectionPool)** 

: dataSource를 가지고 디비와 서버를 연결해주는

: 디비 커넥션 객체들이 둥둥 떠다니는

<br>

---

---

### 💬순서

1. pox.xml : ojdbc6.jar, mybatis, mybatis-spring, DBCP, spring-orm

2. web.xml 

3. test.sql (/WEB-INF/spring/sqls/test.sql)

4. BoardDto, BoardDao(BoardDaoImpl), BoardBiz(BoardBizImpl), HomeController

5. mapper.xml (src/main/resources/mybatis/mapper.xml)

6. db.properties (src/main/resources/mybatis/db.properties)

7. config.xml (/WEB-INF/spring/sqls/config.xml)

8. applicationContext.xml

   <br>

---

1. **pox.xml** &nbsp; [MVNrepository](https://mvnrepository.com/)

`<dependencies>`안에 추가한다.

```java
	<!-- https://mvnrepository.com/artifact/com.oracle.database.jdbc/ojdbc6 -->
	<dependency>
	    <groupId>com.oracle.database.jdbc</groupId>
	    <artifactId>ojdbc6</artifactId>
	    <version>11.2.0.4</version>
	</dependency>
	
	<!-- Mybatis -->
	<dependency>
	  <groupId>org.mybatis</groupId>
	  <artifactId>mybatis</artifactId>
	  <version>3.5.5</version>
	</dependency>
	
	<!-- Mybatis-spring -->
	<!-- https://mvnrepository.com/artifact/org.mybatis/mybatis-spring -->
	<dependency>
	    <groupId>org.mybatis</groupId>
	    <artifactId>mybatis-spring</artifactId>
	    <version>2.0.5</version>
	</dependency>
	
	<!-- DBCP -->
	<!-- https://mvnrepository.com/artifact/commons-dbcp/commons-dbcp -->
	<dependency>
	    <groupId>commons-dbcp</groupId>
	    <artifactId>commons-dbcp</artifactId>
	    <version>1.4</version>
	</dependency>
	
	<!-- spring-orm (Object Relational Mapping) -->
	<!-- 위에 3.1.1.RELEASE 버전과 맞추기 -->
	<!-- https://mvnrepository.com/artifact/org.springframework/spring-orm -->
	<dependency>
	    <groupId>org.springframework</groupId>
	    <artifactId>spring-orm</artifactId>
	    <version>${org.springframework-version}</version>
	</dependency>
```

🌼spring-orm (Object Relational Mapping)

: 객체-관계 매핑

: 객체와 관계형 데이터베이스의 데이터를 자동으로 매핑(연결)해주는것

: 객체지향 프로그래밍은 클래스를 사용하고, 관계형 데이터베이스는 테이블을 사용한다.

: 객체모델과 관계형 모델 간에 불일치가 존재한다.

: ORM을 통해 객체간의 관계를 바탕으로 sql을 자동으로 생성하여 불일치를 해결한다.

: 객체를 통해 간접적으로 데이터베이스 데이터를 다룬다.

<br>

2. **web.xml  (DispatcherServlet, ContextLoaderListener, encodingFilter 설정)**
3. **test.sql (/WEB-INF/spring/sqls/test.sql)**

```db
DROP SEQUENCE MYNOSEQ;
DROP TABLE MYBOARD;

CREATE SEQUENCE MYNOSEQ;

CREATE TABLE MYBOARD(
	MYNO NUMBER PRIMARY KEY,
	MYNAME VARCHAR2(500) NOT NULL,
	MYTITLE VARCHAR2(1000) NOT NULL,
	MYCONTENT VARCHAR2(4000) NOT NULL,
	MYDATE DATE NOT NULL
);

INSERT INTO MYBOARD
VALUES (MYNOSEQ.NEXTVAL, '관리자', 'TEST123', 'TEST내용입니다.', SYSDATE);


SELECT MYNO, MYNAME, MYTITLE, MYCONTENT, MYDATE
FROM MYBOARD
ORDER BY MYNO DESC;

```

<br>

4. **BoardDto, BoardDao(BoardDaoImpl), BoardBiz(BoardBizImpl), HomeController 만들기** 
5. **mapper.xml (src/main/resources/mybatis/mapper.xml)**
6. **db.properties (src/main/resources/mybatis/db.properties)**

- db와 연결

- driver, url, user, password 설정

<br>

7. **config.xml (/WEB-INF/spring/sqls/config.xml)**

- `<typeAliases>`와 `<mappers>`만 작성해준다.

  ```java
  	<typeAliases>
  		<typeAlias type="com.mvc.upgrade.model.dto.BoardDto" alias="BoardDto"/>
  	</typeAliases>
  
  	<!-- resource : src/main/resources와 연결된다. -->
  	<mappers>
  		<mapper resource="/mybatis/mapper.xml"/>
  	</mappers>
  ```

- 이외 나머지는 applicationContext.xml에서 설정해준다.

<br>

8.  **applicationContext.xml (db.properties, dataSource, Mybatis, MybatisTemplate 설정)**

```java
	<!-- db.properties 설정 -->
	<!-- value는 위치, locations는 여러개의 db를 연결할 수 있음 -->
	<bean class="org.springframework.beans.factory.config.PropertyPlaceholderConfigurer">
		<property name="locations">
			<list>
				<value>classpath:mybatis/db.properties</value>
			</list>
		</property>
	</bean>
		
	<!-- dataSource : 커넥션객체 만들어준다. -->	
	<bean id="dataSource" class="org.apache.commons.dbcp.BasicDataSource">
		<property name="driverClassName" value="${driver}"></property>
		<property name="url" value="${url}"></property>
		<property name="username" value="${username}"></property>
		<property name="password" value="${password}"></property>
	</bean>
	
	<!-- Mybatis -->
	<!-- sqlsessionfactory객체만들어서 쓸거다 -->
	<bean id="sqlSession" class="org.mybatis.spring.SqlSessionFactoryBean">
		<property name="dataSource" ref="dataSource"></property>
		<property name="configLocation" value="WEB-INF/spring/sqls/config.xml"></property>
	</bean>
	
	<!-- Mybatis template -->
	<!-- sqlSessionfactory를 편하게 쓰려고 만듬 -->
	<!-- 이게 opensession, closesession등등 자동으로 다 해준다. -->
	<bean id="sqlSessionTemplate" class="org.mybatis.spring.SqlSessionTemplate">
		<constructor-arg ref="sqlSession"></constructor-arg>
	</bean>
```

🌼SqlSessionFactory

- SqlSessionFactory 인스턴스마다 하나의 DB만 연결가능하다.
- 두개의 DB을 연결하고 싶으면 두개의 SqlSessionFactory인스턴스를 만들어야 한다.

<br><br>

---

---

🌼webapp 폴더 (=WebContent. HTML, CSS, JavaScript, GIT 등 정적 웹 자원(static resource)을 두는 곳)

🌼프로젝트 기본 구조 ↓↓↓

<img src="https://blog.kakaocdn.net/dn/7bW1X/btqzIzP4aFQ/90cA6zceTunIylLqPZ6QyK/img.png" alt="프로젝트 기본 구조" style="zoom:33%;" />



<br>

---

---

👻출처

- [ORM이란](https://gmlwjd9405.github.io/2019/02/01/orm.html)
- [springMVC](https://gmlwjd9405.github.io/2018/10/29/web-application-structure.html)

<br>