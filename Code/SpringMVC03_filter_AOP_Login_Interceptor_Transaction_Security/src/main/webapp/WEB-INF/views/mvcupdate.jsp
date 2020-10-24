<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<h1>🎨수정페이지🎨</h1>
	<form action="updateres.do" method="post">
	<input type="hidden" name="myno" value="${dto.myno }">
		<table border="1">
			<tr>
				<th>번호</th>
				<td><input type="text" name="myno" value="${dto.myno }" readonly></td>
			</tr>
			<tr>
				<th>작성자</th>
				<td><input type="text" name="myname" value="${dto.myname }" readonly></td>
			</tr>
			<tr>
				<th>제목</th>
				<td><input type="text" name="mytitle" value="${dto.mytitle }"></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea cols="60" rows="10" name="mycontent">${dto.mycontent }</textarea></td>
			</tr>
			<tr>
				<td colspan="2" align="right">
					<input type="button" value="취소" onclick="location.href='detail.do?myno=${dto.myno}'">
					<input type="submit" value="수정완료!">
				</td>
			</tr>
		</table>
	</form>
	
</body>
</html>