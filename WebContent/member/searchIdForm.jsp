<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<head>
<title>아이디 찾기</title>
</head>
<body>
	<jsp:include page="/header.jsp" />
	<form action="ManageMemberServlet">
		<input type="hidden" name="command" value="searchid">
		<table border="1">
			<tr height="30">
				<td width="110" align="center">이름</td>
				<td width="150" align="center"><input type="text" name="name" size="18"></td>
			</tr>
			<tr height="30">
				<td width="110" align="center">휴대폰번호</td>
				<td width="150" align="center"><input type="text" name="phone" size="18" maxlength="11"></td>
			</tr>
			<tr height="30">
				<td colspan="2">
					<input type="submit" value="찾기">
					<br> ${message}
				</td>
			</tr>
		</table>
	</form>
	<jsp:include page="/footer.jsp" />
</body>
</html>