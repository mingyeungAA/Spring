# 📄Spring Boot_01

### 💬특징

- 경량
- 내장 서버
- 의존성 자동 관리
- No XML



---

### 💬프로젝트 설정

**0. 프로젝트**

<img src="https://postfiles.pstatic.net/MjAyMDA5MjJfMTgz/MDAxNjAwNzcxMzk4NTYz.HAQIFCEL-kUcYipwfSdRKQkcftEXV5HY9bU2xxOHAG8g.ZHEJuks73wWK6JbkQXMkqlEsbZaAuhhgG7CFmasi30sg.PNG.mingyeung/image.png?type=w966" style="zoom:33%;" />



<img src="https://postfiles.pstatic.net/MjAyMDA5MjJfMjk4/MDAxNjAwNzcxNDg5ODE3.x-5Kz65D8Kx67LaEmk2RcBAz1tDt2gVnpEm0uppxnkQg.1DSrdnR58DuLMIY2rGXb-OXXCePsB1zbNMBfjLKMfY4g.PNG.mingyeung/image.png?type=w966" style="zoom:33%;" />



<img src="https://postfiles.pstatic.net/MjAyMDA5MjJfMjg5/MDAxNjAwNzcxNTQyMTYx.6gGJodG8CHlqORe38tAJ-IT8u2Vmjpuf9vg-Ieuari4g.Q3ljPCqNKzPCJAuUq2EHCSIcI2acJouhUt6wRkG0-5Qg.PNG.mingyeung/image.png?type=w966" style="zoom:33%;" />

<br>



**1. pom.xml 설정**

- **`tomcat-embed-jasper`** 추가  

  **👉** Spring Boot 에서는 공식문서에서도 JSP를 사용하는 것을 권하지 않고, 다른 템플릿 엔진을 추천한다. (예를들어, Thymeleaf, Freemarker 등)

  **👉 JSP를 사용하기 위해 추가한다.**

- **ojdbc6** 버전도 다시 설정한다.  

  👉 아래 `</dependencies>`가 끝나고 밖에 `<repository>`를 추가해서 매핑해준다.

- **jstl** 추가

- **`spring-boot-devtools`** 추가 

  **👉** classpath에 존재하는 파일의 변경을 감지하고, 자동으로 서버를 restart해준다.

```java
	<!-- tomcat-embed-jasper -->
	<dependency>
		<groupId>org.apache.tomcat.embed</groupId>
		<artifactId>tomcat-embed-jasper</artifactId>
	</dependency>
        
    <!-- oracle6 -->
    <dependency>
		<groupId>oracle</groupId>
		<artifactId>ojdbc6</artifactId>
		<version>11.2.0.3</version>
	</dependency>
    
    <!-- jstl -->
    <dependency>
		<groupId>javax.servlet</groupId>
		<artifactId>jstl</artifactId>
	</dependency>
	
	<!-- spring-boot-devtools -->
	<dependency>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-devtools</artifactId>
	</dependency>
```

```
	<repositories>
		<repository>
			<id>datanucleus</id>
			<url>http://www.datanucleus.org/downloads/maven2/</url>
		</repository>
	</repositories>
```



**2. application.properties**

- server port 설정
- view 설정
- resources 설정
- jdbc 설정
- mybatis alias 설정

```
# server
# 8585 or 8787
server.port=8585

# view 
# src/main/webapp/WEB-INF/views
spring.mvc.view.prefix=/WEB-INF/views/
spring.mvc.view.suffix=.jsp

# resources
# 이 코드를 씀으로서, index.html을 안거치고 바로 (resources아래 있는)index.jsp로 이동한다.
spring.mvc.static-path-pattern=/resources/**


# jdbc
spring.datasource.driver-class-name=oracle.jdbc.driver.OracleDriver
spring.datasource.url=jdbc:oracle:thin:@localhost:1521:xe
spring.datasource.username=kh
spring.datasource.password=kh


# mybatis alias
mybatis.type-aliases-package=com.boot.jdbc.model.dto.MyDto
```



**3. test.sql (src/main/resources/db/test.sql)**

```
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
VALUES(MYNOSEQ.NEXTVAL, '관리자','테스트 글','TEST1234',SYSDATE);


SELECT MYNO, MYNAME ,MYTITLE, MYCONTENT, MYDATE
FROM MYBOARD
ORDER BY MYNO DESC;


```



**4. MyBoardMapper**

- com.boot.jdbc.model.mapper (interface로 만든다.)
- **`@Mapper`** 붙이기

```
@Mapper
public interface MyBoardMapper {
	
	@Select(" SELECT MYNO, MYNAME, MYTITLE, MYCONTENT, MYDATE FROM MYBOARD ORDER BY MYNO DESC ")
	List<MyDto> selectList();
	
	@Select(" SELECT MYNO, MYNAME, MYTITLE, MYCONTENT, MYDATE FROM MYBOARD WHERE MYNO = #{myno} ")
	MyDto selectOne(int myno);
	
	@Insert(" INSERT INTO MYBOARD VALUES(MYNOSEQ.NEXTVAL, #{myname}, #{mytitle}, #{mycontent}, SYSDATE) ")
	int insert(MyDto dto);
	
	@Update(" UPDATE MYBOARD SET MYTITLE = #{mytitle}, MYCONTENT = #{mycontent} WHERE MYNO = #{myno} ")
	int update(MyDto dto);
	
	@Delete(" DELETE FROM MYBOARD WHERE MYNO = #{myno} ")
	int delete(int myno);
	
}
```



**5. dto, biz, controller 만들기**

- com.boot.jdbc.model.dto // com.boot.jdbc.model.biz

```
public interface MyBiz {
	
	public List<MyDto> selectList();
	public MyDto selectOne(int myno);
	public int insert(MyDto dto);
	public int update(MyDto dto);
	public int delete(int myno);

}
```

```
@Service
public class MyBizImpl implements MyBiz {
	
	@Autowired
	private MyBoardMapper myBoardMapper;

	@Override
	public List<MyDto> selectList() {
	
		return myBoardMapper.selectList();
	}

	@Override
	public MyDto selectOne(int myno) {
		
		return myBoardMapper.selectOne(myno);
	}

	@Override
	public int insert(MyDto dto) {
		
		return myBoardMapper.insert(dto);
	}

	@Override
	public int update(MyDto dto) {
		
		return myBoardMapper.update(dto);
	}

	@Override
	public int delete(int myno) {
		
		return myBoardMapper.delete(myno);
	}
}
```



**6. StartBoot02Mmapplication**

- **`@Controller`** 붙이기

```java
@SpringBootApplication
@Controller
public class StartBoot02MmApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(StartBoot02MmApplication.class, args);
	}
	
	//루트가 붙은 모든 것을 가져옴
	@GetMapping("/")
	public String index() {
		
		//index.jsp로 이동
		return "index";
	}

}
```



**7. webapp, WEB-INF, views 폴더 만들기**

- src/main 아래다가 webapp, webapp아래에다가 WEB-INF, WEB-INF 아래에다가 views폴더 만들기

<img src="https://postfiles.pstatic.net/MjAyMDA5MjJfMzgg/MDAxNjAwNzc1MTkzNDU1.xJ-F2T4oXUJHHc-PX1GCNrFSJXnnlCiJyHr0IQRwn4Ug.WU-qLxc9KHeUnSep_ZPSKsfGBSBcth5zmz90VnyX32Eg.PNG.mingyeung/image.png?type=w966" style="zoom:33%;" />





**8. views 폴더 안에다가 index.jsp 파일 만들기**



<br>

---

#### 💬 mybatis

#### `mybatis-spring-boot-starter`

- 독립형 application에 적합
- boilerplate code 최소화

> boilerplate code : 자주 사용되는, 반복되는 code(재사용)

> api : [mybatis](blog.mybatis.org)  ->  Products -> Spring Boot Starter

<br>

---

**🌼static  폴더 : 정적인 파일들이 담긴다. (ex. html, css, js... )**

**🌼jsp파일은 동적인 파일이다. 그래서 static폴더에 안담는다.**

<br>