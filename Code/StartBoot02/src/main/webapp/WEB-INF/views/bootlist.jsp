<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>List</h1>
	
	<table border="1">
		<col width="50">
		<col width="100">
		<col width="500">
		<col width="200">
		<tr>
			<th>번호</th>
			<th>작성자</th>
			<th>제목</th>
			<th>작성일</th>
		</tr>
		<c:choose>
			<c:when test="${empty list }">
				<tr>
					<th colspan="4">------------글이없다 애미야~-----------</th>
				</tr>	
			</c:when>
			<c:otherwise>
				<c:forEach items="${list }" var="dto">
					<tr>
						<td>${dto.myno }</td>
						<td>${dto.myname }</td>
						<td><a href="detail?myno=${dto.myno }">${dto.mytitle }</a></td>
						<td>${dto.mydate }</td>
					</tr>
				</c:forEach>
			</c:otherwise>	
		</c:choose>
		<tr>
			<td colspan="4" align="right">
				<input type="button" value="글작성" onclick="location.href='insert'">
			</td>
		</tr>
	</table>
</body>
</html>