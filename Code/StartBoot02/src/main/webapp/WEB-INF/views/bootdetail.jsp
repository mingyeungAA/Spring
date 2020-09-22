<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Detail</h1>
	<table border="1">
		<tr>
			<th>제목</th>
			<td><input type="text" name="mytitle" value="${dto.mytitle }" readonly></td>
		</tr>
		<tr>
			<th>작성자</th>
			<td><input type="text" name="myname" value="${dto.myname }" readonly></td>
		</tr>
		<tr>
			<th>제목</th>
			<td><textarea cols="60" rows="10" name="mycontent" readonly>${dto.mycontent }</textarea></td>
		</tr>
		<tr>
			<td colspan="2" align="right">
				<input type="button" value="삭제" onclick="location.href='delete?myno=${dto.myno}'">
				<input type="button" value="수정" onclick="location.href='update?myno=${dto.myno}'">	
				<input type="button" value="목록" onclick="location.href='list'">
			</td>
		</tr>
	</table>
</body>
</html>