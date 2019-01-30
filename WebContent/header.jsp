<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="com.html.dto.BoardUserVO"%>
<%
	BoardUserVO uVo = (BoardUserVO) session.getAttribute("loginUser");
%>
<style>
@import url('/boardproject/style/header_style.css');
</style>
<script src="/script/Menu_Script.js"></script>
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="JQ/jquery-1.9.1.min.js"
	integrity="sha256-JmvOoLtYsmqlsWxa7mDSLMwa6dZ9rrIdtrrVYRnDRH0="
	crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.0.0.min.js"
	integrity="sha256-JmvOoLtYsmqlsWxa7mDSLMwa6dZ9rrIdtrrVYRnDRH0="
	crossorigin="anonymous"></script>
<script type="text/javascript" src="JQ/jquery.easing.1.3.min.js"></script>
<header>
	<!--로고바와 개인정보메뉴-->
	<div id="logo_bar">
		<div>
			<a href="/boardproject/index.jsp"><img
				src="/boardproject/img/hum.PNG"></a>
		</div>

		<c:choose>
			<c:when test="${loginUser == null}">
				<ul id="personal_menu">
					<li>
						<!-- <form method="get" action="login.do"> --> <a
						href='/boardproject/ManageMemberServlet?command=loginform'><button
								class=fun-btn>로그인</button></a> <!--/form-->
					</li>
					<li><a
						href='/boardproject/ManageMemberServlet?command=joinform'><button
								class=fun-btn>회원가입</button></a>
				</ul>
			</c:when>
			<c:otherwise>
			<ul>
            	<li>	안녕하세요 ${loginUser.userNick}(${loginUser.userId})님</li>
            		<!-- form action="/boardproject/ManageMemberServlet" align="right"-->
					<!-- input type="hidden" name="command" value="logout"-->
					 
					 <li><a href = '/boardproject/ManageMemberServlet?command=logout'>
					<button class = fun-btn > 로그아웃</button></a></li>
<%-- 				
<input type="submit" value="로그아웃">&nbsp;
		  <input type="button" value="회원정보변경"  
						onclick="location.href='ManageMemberServlet?command=updateform&userid=${loginUser.userId}'">
 --%>
					<li><a href = '/boardproject/ManageMemberServlet?command=updateform&userid=${loginUser.userId}'>
					<button class = fun-btn> 회원정보변경</button></a></li>  

					<li><c:if test="${loginUser.userClass == 1}">
						<input type="button" value="관리자페이지"
							onclick="location.href='/boardproject/AdminServlet?command=manage_user'">
					
					</c:if>
					</li>
					</ul>
				<!--/form-->
			</c:otherwise>
		</c:choose>
	</div>
	<!--로고바와 로고텍스트 표시-->

	<!----------------------------------------내비게이션바 메뉴------------------------------------------------------->
	<nav id="nav-main">
		<ul>
			<li><a href="main.html">메인</a></li>
			<li><a href="/boardproject/BoardServlet?command=board_list&col=none&word=">유머게시판</a></li>
			<li><a href="product.html">베스트유머</a></li>
			<li><a href="recruit.html">만든사람들</a></li>
		</ul>
	</nav>
	<div id="nav-trigger">
		<!--내비게이션 트리거-->
		<span>메뉴</span>
	</div>
	<nav id="nav-mobile"></nav>
	<!--내비게이션 모바일-->
</header>