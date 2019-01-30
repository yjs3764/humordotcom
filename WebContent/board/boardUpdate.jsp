<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/shopping.css">
<script type="text/javascript" src="script/board.js"></script>
</head>
<body>
	<div id="wrap" align="center">
		<jsp:include page="/header.jsp" />
		<h1>게시글 수정</h1>
		<form name="frm" method="post" action="BoardServlet">
			<input type="hidden" name="command" value="board_update"> <input
				type="hidden" name="boardnum" value="${board.boardnum}">
			<table>
				<tr>
					<th>작성자</th>
					<td><input type="text" size="12" name="usernick"
						value="${board.usernick}"> * 필수</td>
				</tr>
				<c:choose>
					<c:when test="${loginUser.userClass==1}">
						<input type="hidden" name="boardpass" value="${board.boardpass}">
					</c:when>
					<c:when test="${loginUser != null}">
						<input type="hidden" name="boardpass" value="${board.boardpass}">
					</c:when>
					<c:otherwise>
						<tr>
							<th>비밀번호</th>
							<td><input type="password" size="12" name="boardpass">
								* 필수 (게시물 수정 삭제시 필요합니다.)</td>
						</tr>
					</c:otherwise>
				</c:choose>

				<%-- <tr>
					<th>이메일</th>
					<td><input type="text" size="40" maxlength="50" name="email"
						value="${board.email}"></td>
				</tr> --%>
				<tr>
					<th>제목</th>
					<td><input type="text" size="70" name="boardtitle"
						value="${board.boardtitle}"></td>
				</tr>
				<tr>
					<th>내용</th>
					<td><textarea cols="70" rows="15" name="boardcontent">${board.boardcontent}</textarea></td>
				</tr>
				<tr>
					<th>첨부파일</th>
					<td><input type="text" name="boardfile"
						value="${board.boardfile}"></td>
				</tr>
			</table>
			<br> <br> <input type="submit" value="등록"
				onclick="return boardCheck()"> <input type="reset"
				value="다시 작성"> <input type="button" value="목록"
				onclick="location.href='BoardServlet?command=board_list'">
		</form>
		<jsp:include page="/footer.jsp" />
	</div>
</body>
</html>