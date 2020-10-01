<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Upload Page</h1>
	<!-- 
		modelAttribute : form에 있는 요소들의 값을 채우기 위해서 사용될 객체를 request로부터 찾을때 사용
		(파일,파일이름,파일설명)
		
	 -->
	
	<form:form method="post" enctype="multipart/form-data" modelAttribute="uploadFile" action="upload">
		file<br>
		<input type="file" name="mpfile"><br>
		<p style="color: red; font-weight: bold;"><form:errors path="mpfile"/><br>
		
		description<br>
		<textarea rows="10" cols="40" name="desc"></textarea><br>
		<input type="submit" value="send">
	</form:form>
	
	<!-- 
		form:form => spring form tag임.
		form:form, form:errors, form:input,... 지원해줌.
		
		form:errors -> Errors, BindingResult를 사용할 때 command객체의 특정 field에서 발생하는 예외에 대한 메시지를 출력가능하게 해줌.
		
		
	 -->
	
	
	<!-- 
		enctype 속성
		1. application/www-form-urlencoded : 문자들이 encoding됨.(defalut)
		2. multipart/form-data : file upload - post
		3. text/plain : 문자들을 encoding하지 않음
	 -->
	
</body>
</html>