<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
form {
	text-align: center;
}
</style>
</head>
<body>
	<jsp:include page="/header.jsp" />
	<form method="get" action="/boardproject/AdminServlet">
	<input type = "hidden" name="command" value="manage_user_class">
		회원아이디를 입력하세요 <input type="text" name="userid"><br> 변경할
		회원등급을 선택하세요 <select name="userclass" size="1">
			<option value="1">관리자
			<option value="0">일반회원
			<option value="-1">강등회원
		</select><br> <input type="submit" value="확인">
	</form>
	<jsp:include page="/footer.jsp" />
</body>
</html>