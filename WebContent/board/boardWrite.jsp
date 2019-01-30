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
	<div>
		<!-- 	<div id="wrap" align="center"> -->
		<jsp:include page="/header.jsp" />
		<h1>게시글 등록</h1>
		<form name="frm" method="post" action="BoardServlet">
			<input type="hidden" name="command" value="board_write">
			<table>
				<tr>
					<th>닉네임</th>
					<c:choose>
						<c:when test="${loginUser == null}">
							<td><input type="text" name="usernick"> * 필수 <input
								type="hidden" name="ismember" value="0"></td>
						</c:when>
						<c:otherwise>
							<td>${loginUser.userNick}(${loginUser.userId})<input
								type="hidden" name="usernick"
								value="${loginUser.userId}"> <input
								type="hidden" name="ismember" value="1"> <input
								type="hidden" name="boardpass" value="0">
							</td>
						</c:otherwise>
					</c:choose>
				</tr>
				<c:choose>
					<c:when test="${loginUser == null}">
						<tr>
							<th>비밀번호</th>
							<td><input type="password" name="boardpass"> * 필수
								(게시물 수정 삭제시 필요합니다.)</td>
						</tr>
					</c:when>
					<c:otherwise>
					</c:otherwise>
				</c:choose>
				<!-- <tr>
					<th>이메일</th>
					<td><input type="text" name="email"></td>
				</tr> -->
				<tr>
					<th>제목</th>
					<td><input type="text" size="70" name="boardtitle"> *
						필수</td>
				</tr>
				<tr>
					<th>내용</th>
					<td><textarea cols="70" rows="15" name="boardcontent"></textarea></td>
				</tr>
				<tr>
					<th>첨부파일</th>
					<td><input type="text" name="boardfile"></td>
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