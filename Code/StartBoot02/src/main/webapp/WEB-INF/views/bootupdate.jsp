<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Update</h1>
	<form action="updateres" method="post">
	<input type="hidden" name="myno" value="${dto.myno }">
		<table border="1">
			<tr>
				<th>제목</th>
				<td><input type="text" name="mytitle" value="${dto.mytitle }" ></td>
			</tr>
			<tr>
				<th>작성자</th>
				<td><input type="text" name="myname" value="${dto.myname }" readonly></td>
			</tr>
			<tr>
				<th>제목</th>
				<td><textarea cols="60" rows="10" name="mycontent">${dto.mycontent }</textarea></td>
			</tr>
			<tr>
				<td colspan="2" align="right">
					<input type="button" value="취소" onclick="location.href='detail?myno=${dto.myno}'">
					<input type="submit" value="수정">	
				</td>
			</tr>
		</table>
	</form>
</body>
</html>