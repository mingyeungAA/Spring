<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>👽글 수정페이지👽</h1>

	<form action="updateres.do" method="post">
		<input type="hidden" name="mno" value="${dto.mno }">
		<table border="1">
			<tr>
				<th>제목</th>
				<td><input type="text" name="title" value="${dto.title }" ></td>
			</tr>
			<tr>
				<th>작성자</th>
				<td><input type="text" name="name" value="${dto.name}" readonly></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea cols="60" rows="10" name="content" >${dto.content }</textarea></td>
			</tr>
			<tr>
				<td colspan="2" align="right">
					<input type="button" value="취소" onclick="location.href='detail.do?mno=${dto.mno}'" />
					<input type="submit" value="수정완료!"> 
				</td>
			</tr>
		</table>
	</form>
</body>
</html>