<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
table {
	border-collapse: collapse;
	text-align: center;
	align-self: center;
}

td {
	width: 150px;
}

#title {
	width: 400px;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<div>
	<jsp:include page="/header.jsp" />
	<table border="1" align="center">
		<tr>
			<th>글번호</th>
			<th>제목</th>
			<th>닉네임</th>
			<th>게시일자</th>
			<th>조회수</th>
			
		</tr>

		<c:forEach var="board" items="${boardList}">
			<tr>
			<td>${board.boardnum}</td>
				<td>
				<a href="BoardServlet?command=board_view&boardnum=
				${board.boardnum}">${board.boardtitle}</a>
				</td>
				<td>${board.usernick}</td>
				<td><fmt:formatDate value="${board.boarddate}"/></td>
 				<td>${board.readcount}</td>
			</tr>
		</c:forEach>

	</table>
	
	<jsp:include page="/footer.jsp" />
	</div>
</body>
</html>