<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="/header.jsp" />
	<form action="BoardServlet">
		<input type="hidden" name="command" value="board_delete">
		<h1>비밀번호 확인</h1>
		<table style="width: 80%">
			<tr>
				<th>비밀번호</th>
			</tr>
			<tr>
				<td><input type="password" name="boardpass" size="20"></td>
			</tr>
		</table>
		<br> <input type="submit" value="삭제"> <br>${message}
	</form>
	<jsp:include page="/footer.jsp" />
</body>
</html>