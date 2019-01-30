<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>디시아웃사이드</title>
<link rel="stylesheet" type="text/css"
	href="/boardproject/style/common.css">
<link rel="stylesheet" type="text/css"
	href="/boardproject/style/header.css">
<link rel="stylesheet" type="text/css"
	href="/boardproject/style/footer.css">
<link rel="stylesheet" type="text/css"
	href="/boardproject/style/board_left.css">
<link rel="stylesheet" type="text/css"
	href="/boardproject/style/board_list_main.css">
</head>
<body>
	<jsp:include page="/header.jsp" />
	<div id="wrap">




		<section id="main">
			<img src="img/comm.gif">
			<h2 id="board_title">자유 게시판</h2>


			<div id="total_search">
				<!-- <div id="total">▷ 총 5개의 게시물이 있습니다.</div> -->


				<div id="total_search">
					<!-- <FORM name='frm1' method='GET'> action='./real_board_list.jsp' -->
					<!-- <ASIDE style='float: right;'> -->
					<form action="BoardServlet">
					<input type="hidden" name="command" value="board_list">
						<SELECT name='col'>
							<!-- 검색 컬럼 -->
							<OPTION value='none'>전체 목록</OPTION>
							<OPTION value='rname'>글쓴이</OPTION>
							<OPTION value='title'>제목</OPTION>
							<OPTION value='content'>내용</OPTION>
							<!-- <OPTION value='ost'>OST</OPTION> -->
							<OPTION value='title_content'>제목+내용</OPTION>
						</SELECT> <input type='text' name='word' value=''
							placeholder="특수문자는 사용할수 없습니다.">
						<button type="submit">검색</button>
					</form>

				</div>
			</div>
			<table>
				<tr>
					<th>번 호</th>
					<th>제 목</th>
					<th>글 쓴 이</th>
					<th>날 짜</th>
					<th>조 회</th>
					<th>추 천</th>
				</tr>
				<c:forEach var="board" items="${boardList}">
					<tr>
						<td class="col1">${board.boardnum}</td>
						<td class="col2"><a
							href="BoardServlet?command=board_view&boardnum=${board.boardnum}">
								${board.boardtitle}</a></td>
						<td class="col3">${board.usernick}</td>
						<td class="col4">${board.boarddate}</td>
						<td class="col5">${board.readcount}</td>
						<td class="col6">${board.recomm}</td>
					</tr>



				</c:forEach>
			</table>

			<div id="buttons">
				<div class="col1">
					<a href=#>◀ 이전</a> <a href=#>1</a> <a href=#>다음 ▶</a>
				</div>
				<div class="col2">
					<a href="BoardServlet?command=board_write_form"><img
						src="img/write.png"></a>


				</div>
			</div>
		</section>
		<!-- section main -->
		<div class="clear"></div>
	</div>
	<!-- wrap -->
	<jsp:include page="/footer.jsp" />

</body>
</html>