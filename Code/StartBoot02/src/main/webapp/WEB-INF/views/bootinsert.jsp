<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Insert</h1>
	<form action="insertres" method="post">
		<table border="1">
			<tr>
				<th>제목</th>
				<td><input type="text" name="mytitle"></td>
			</tr>
			<tr>
				<th>작성자</th>
				<td><input type="text" name="myname"></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea cols="60" rows="10" name="mycontent"></textarea></td>
			</tr>
			<tr>
				<td>
					<input type="submit" value="글등록하기">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>