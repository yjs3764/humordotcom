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
	<button onclick="location.href='/boardproject/admin/manageuserclass.jsp'">회원등급 관리</button>
	<button onclick="location.href='/boardproject/admin/manageuserinfo.jsp'">회원정보 수정</button>
	<button onclick="location.href='/boardproject/admin/manageip.jsp'">ip주소 차단</button>
	<jsp:include page="/footer.jsp" />
</body>
</html>