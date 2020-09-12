<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>🎂🌹글 상세페이지🎂🌹</h1>
	
	<table border="1">
		<tr>
			<th>제목</th>
			<td><input type="text" name="title" value="${dto.title }" readonly></td>
		</tr>
		<tr>
			<th>작성자</th>
			<td><input type="text" name="name" value="${dto.name}" readonly></td>
		</tr>
		<tr>
			<th>내용</th>
			<td><textarea cols="60" rows="10" name="content" readonly>${dto.content }</textarea></td>
		</tr>
		<tr>
			<td colspan="2" align="right">
				<input type="button" value="삭제하기" onclick="location.href='delete.do?mno=${dto.mno}'">
				<input type="button" value="수정하기" onclick="location.href='update.do?mno=${dto.mno}'">
				<input type="button" value="목록" onclick="location.href='list.do'"/>
			</td>
		</tr>
	</table>
</body>
</html>