<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ page import="java.sql.Connection"%>
<%@ page import="util.DBManager"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="/boardproject/style/header.css">
<link rel="stylesheet" type="text/css"
	href="/boardproject/style/footer.css">
<link rel="stylesheet" type="text/css"
	href="/boardproject/style/board_view_main.css">
<link rel="stylesheet" type="text/css"
	href="/boardproject/style/common.css">
<link rel="stylesheet" type="text/css"
	href="/boardproject/style/board_left.css">
<script type="text/javascript" src="script/board.js"></script>
</head>
<body>
	<jsp:include page="/header.jsp" />

	<div id="wrap">
		<section id="main">

			<h2 id="board_title">유머게시판</h2>
			<div id="view_title_box">
				<ul>
					<li><span id="pre">제 목</span>&nbsp;<span id="title">${board.boardtitle}</span><span
						id="date">${board.boarddate}</span></li>
					<li><Br></li>
					<li><span id="info"><span id="pre">글쓴이</span>${board.usernick}&nbsp;&nbsp;<span id="divide">|</span>&nbsp;&nbsp;<span
							id="pre">조회수</span> ${board.readcount}&nbsp;&nbsp;<span
							id="divide">|</span>&nbsp;&nbsp;<span id="pre">추천</span>
							${board.recomm}</span>&nbsp;&nbsp;<span
							id="divide">|</span>&nbsp;&nbsp;<span id="pre">IP주소</span>
							${board.ipnum}</li>
				</ul>
			</div>
			<p id="view_content">
				${board.boardcontent}<br>
			</p>

			<div id="updown">
				<a href="BoardServlet?command=recomm_up&boardnum=${board.boardnum}"><img
					id="up" src="img/up.png"></a> <a
					href="BoardServlet?command=recomm_down&boardnum=${board.boardnum}"><img
					id="up" src="img/down.png"></a>
			</div>


			<div id="comment_box1">
				<table>
					<c:forEach var="board_comment" items="${commentList}">
						<tr>
							<td id="col1">${board_comment.comment_num}</td>
							<td id="col2">${board_comment.comment_usernick}</td>
							<td id="col3">${board_comment.comment_content}</td>
							<td id="col4"><a
								onclick="open_win('BoardServlet?command=comment_check_pass_form&boardnum=${board.boardnum}&comment_num=${board_comment.comment_num}&comment_boardpass=${board_comment.comment_pass}', 'comment_delete')">
									삭 제<img src="img/listwrite.png">
							</a></td>


						</tr>

					</c:forEach>
				</table>
			</div>

			<form name="frm" method="post" action="BoardServlet">
				<input type="hidden" name="command" value="comment_write"> <input
					type="hidden" name="boardNum" value="${board.boardnum}">
				<div id="comment_box">
					<div id="nick">
						<c:choose>
							<c:when test="${loginUser != null}">
								<input type="hidden" name="comment_usernick"
									value="${loginUser.userId}">
								${loginUser.userId}(${loginUser.userNick})
							</c:when>
							<c:otherwise>
								<input type="text" name="comment_usernick" size=10px
									placeholder="  닉네임">
							</c:otherwise>
						</c:choose>
					</div>

					<div id="pass">
						<c:choose>
							<c:when test="${loginUser != null}">
								<input type="hidden" name="comment_pass"
									value="0">
							</c:when>
							<c:otherwise>
								<input type="password" name="comment_pass" size=10px
							placeholder="  비밀번호">
							</c:otherwise>
						</c:choose>
					</div>
					<textarea name="comment_content"></textarea>
					<%-- <a href="BoardServlet?command=recomm_up&boardnum=${board.boardnum}"> --%>
					<div id="ok_ripple">
						<input type="submit" onclick="return commentCheck()"
							style="background-image: url('img/combtn.gif'); width: 70px; height: 50px;"
							value="">
					</div>
					<!--img id="ok_ripple" src="img/combtn.gif"-->
				</div>
			</form>

			<div id="buttons">
				<c:choose>
					<c:when
						test="${(loginusernick eq board.usernick && loginUser != null) || loginUser.userClass==1}">
						<a
							onclick="location.href='BoardServlet?command=board_update_form&boardnum=${board.boardnum}'">
							<img src="img/update.png">
						</a>
						<a
							onclick="location.href='BoardServlet?command=board_delete&boardnum=${param.boardnum}'">
							<img src="img/delete.png">
						</a>
					</c:when>
					<c:when test="${board.ismember == 1}">
					</c:when>
					<c:otherwise>
						<a
							onclick="open_win('BoardServlet?command=board_check_pass_form&boardnum=${board.boardnum}', 'update')">
							<img src="img/update.png">
						</a>
						<a
							onclick="open_win('BoardServlet?command=board_check_pass_form&boardnum=${board.boardnum}', 'delete')">
							<img src="img/delete.png">
						</a>
					</c:otherwise>
				</c:choose>
				<a
					onclick="location.href='/boardproject/BoardServlet?command=board_list&col=none&word='">
					<img src="img/writelist.png">
				</a> <a onclick="location.href='BoardServlet?command=board_write_form'">
					<img src="img/listwrite.png">
				</a>

			</div>

		</section>
		<!-- section main -->

		<div class="clear"></div>

		<%
			Connection conn = DBManager.getConnection();
		%>
	</div>
	<jsp:include page="/footer.jsp" />

</body>
</html>