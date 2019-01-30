<%@ page contentType = "text/html; charset=euc-kr" %>

<html>
<head><title>비밀번호 찾기</title></head>
<link href = "style.css" rel = "stylesheet" type = "text/css">
<body>
<jsp:include page="/header.jsp" />
	<form action="ManageMemberServlet">
		<input type="hidden" name="command" value="searchpw">
		<table border="1">
			<tr height="30">
				<td width="110" align="center">아이디</td>
				<td width="150" align="center"><input type="text" name="id" size="18"></td>
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