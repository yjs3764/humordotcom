<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
td {
	border: 1px solid; black;
	width: 200px;
	text-align: center;
}
</style>
</head>
<body>
	<jsp:include page="/header.jsp" />
	<form action="ManageMemberServlet" method="post">
		<input type="hidden" name="command" value="login">
		<table align="center">
			<tr>
				<td colspan="2" align="center">로그인</td>
			</tr>
			<tr>
				<td align="center">아이디</td>
				<td><input type="text" name="id"></td>
			</tr>
			<tr>
				<td align="center">비밀번호</td>
				<td><input type="password" name="pwd"></td>
			</tr>

			<tr align="center">
				<td colspan="2">
					<input type="submit" value="로그인">
					<input type="button" value="회원가입"
					onclick="location.href='/boardproject/ManageMemberServlet?command=joinform'">
					<input type="button"
					onclick="location.href='/boardproject/ManageMemberServlet?command=searchidform'"
					value="아이디찾기"> <input type="button"
					onclick="location.href='/boardproject/ManageMemberServlet?command=searchpwform'"
					value="비밀번호 찾기">
				</td>
			</tr>
		</table>
		<div style="color: red; text-align: center;">${message}</div>
	</form>
	<jsp:include page="/footer.jsp" />
</body>
</html>