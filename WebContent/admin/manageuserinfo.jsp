<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
body {
	text-align: center
}
</style>
</head>
<body>
	<jsp:include page="/header.jsp" />
	<form method="get" action="/boardproject/AdminServlet">
		<input type="hidden" name="command" value="manage_user_info">
		정보를 수정할 회원아이디를 입력하세요<br> <input type="text" name="userid"><br>
		<input type="submit" value="수정하기">
	</form>
	<jsp:include page="/footer.jsp" />
</body>
</html>