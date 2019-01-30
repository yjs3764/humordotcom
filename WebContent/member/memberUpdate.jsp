<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="script/member.js"></script>
<jsp:include page="/header.jsp" />

</head>
<body>
	<h2 align="center">회원수정</h2>
	<form action="memberUpdate.do" method="post" name="frm">
		<table align="center">

			<tr>
				<td>이름</td>
				<td><input type="text" name="name" size="20"
					value="${mVo.userName }" readonly></td>
			</tr>

			<tr>
				<td>아이디</td>
				<td><input type="text" name="userid" size="20"
					value="${mVo.userId }" readonly></td>
			</tr>
			<tr>
				<td>닉네임</td>
				<td><input type="text" name="nick" size="20"
					value="${mVo.userNick }"></td>
			</tr>

			<tr>
				<td>암호</td>
				<td><input type="password" name="pwd" size="20">*</td>
			</tr>


			<tr height="30">
				<td width="80">암호확인</td>
				<td><input type="password" name="pwd_check" size="20">*</td>
			</tr>

			<tr>
				<td>이메일</td>
				<td><input type="text" name="email" size="20"
					value="${mVo.userEmail }"></td>
			</tr>

			<tr>
				<td>전화번호</td>
				<td><input type="text" name="phone" size="20"
					value="${mVo.userPhone }"></td>
			</tr>

			<tr>
				<td colspan="2" align="center"><input type="submit" value="확인"
					onclick="return joinCheck()">
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="reset" value="취소">
			</tr>
		</table>
	</form>
	<input type="button" value="회원탈퇴" onclick="location.href='/boardproject/ManageMemberServlet?command=deleteform'">
</body>
<jsp:include page="/footer.jsp" />

</html>