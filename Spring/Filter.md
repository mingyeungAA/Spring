# 📄Filter

- 클라이언트와 서버사이에서 request와 response를 처리하고 filterchain으로 연결해주는
- DispatcherServlet 이전에 실행되며, 요청내용을 변경하거나 여러가지 체크를 수행한다.
- 처리가 끝난 후에도 응답내용에 대해서도 변경할 수 있다.

![](https://postfiles.pstatic.net/MjAyMDA5MDdfMTcy/MDAxNTk5NDczMjcyMzE0.SHK6STv0IgZEa2plnHpkhdmrP8DSJxR2_4jYwVAR43kg.3VmvPlY4vDKZR-jrHQGdiQ0wDRQnzIYlqc3K7-tv3_Ig.PNG.mingyeung/image.png?type=w966)

<br>

---

### 💬javax.servlet.Filter

- **`public void init(FilterConfig filgerConfig) throws ServletException`**

  : 필터를 웹컨테이너 내에 생성한 후 **_초기화_**할 때 호출한다.

- **`public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws java.io.IOException, ServletException`**

  : 체인을 따라 다음에 존재하는 필터로 이동한다. 체인의 가장 마지막에는 클라이언트가 요청한 최종 자원이 위치한다.

- **`public void destroy()`**

  : 필터가 웹컨테이너에서 삭제될 때 호출된다.

<br>

---

### 💬doFilter()

```java
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		
		String remoteAddr = req.getRemoteAddr();   //클라이언트의 ip주소
		String uri = req.getRequestURI();
		String url = req.getRequestURL().toString();
		String queryString = req.getQueryString();
		
		String referer = req.getHeader("referer");   //이전페이지(보내는 페이지) url
		String agent = req.getHeader("User-Agent");  //사용자 정보 (brower, os,..)
		
		StringBuffer sb = new StringBuffer();
		sb.append("* remoteAddr : "+remoteAddr+"\n")
		.append("* uri : "+uri+"\n")
		.append("* url : "+url+"\n")
		.append("* queryString : "+queryString+"\n")
		.append("* referer : "+referer+"\n")
		.append("* agent : "+agent);
		
		System.out.println("LogFilter");
		System.out.println(sb);
		
		chain.doFilter(request, response);

	}
```

🌼**FilterChain**

- FilterChain을 사용함으로써 filter는 체인에 있는 다음 필터에 변경한 요청과 응답을 건내준다.

- 클라이언트에서 서블릿으로 넘어올때, 그 사이에 필터가 있다.

- 필터와 필터 혹은 필터와 서블릿을 연결해준다.

  <br>

---

### 💬web.xml

```
<!-- LogFilter -->
<!-- url-pattern : web.xml파일에 표기된 순서대로 필터 체인을 형성한다. (여기서는 요청이 있을때마다 필터 체인을 형성한다라는 의미) -->
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

---

#### 💬공통부분을 처리할 수 있는 것

- Filter
- Interceptor
- AOP

---

---

👻출처

- https://yzlosmik.tistory.com/24
- https://goddaehee.tistory.com/154