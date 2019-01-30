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
	<form method="post" action="/boardproject/AdminServlet?command=manage_ip">
		차단할 IP주소 : <input type="text" name="ipnum"> <input
			type="submit" value="확인">
	</form>
	<jsp:include page="/footer.jsp" />
</body>
</html>