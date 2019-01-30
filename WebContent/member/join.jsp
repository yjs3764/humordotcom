<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<jsp:include page="/header.jsp" />

<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Insert title here</title>

<script type="text/javascript" src="/boardproject/script/member.js"></script>
<script>
function loginCheck()
{
	if (document.frm.userid.value.length == 0)
	{
		alert("아이디를 써주세요");
		from.userid.focus();
		return false;
	}
	if (document.frm.pwd.value == "")
	{
		alert("암호를 입력해주세요");
		frm.pwd.focus();
		return false;
	}
	return true;
}

function idCheck()
{
	if (document.frm.userid.value == "")
	{
		alert("아이디를 입력해주쇼");
		document.frm.userid.focus();
		return;
	}
	alert("ㅇㅇㅇㅇ");
	var url = "/boardproject/ManageMemberServlet?command=idcheck&userid=" + document.frm.userid.value;
	window.open(url, "_blank_1", "toolbar = no,menubar=no,scrollbars=yes,resizable = no,width =450,height =200");
}

function idok()
{
	opener.frm.userid.value = document.frm.userid.value;
	opener.frm.reid.value = document.frm.userid.value;
	self.close();
}

function joinCheck()
{
	if (document.frm.name.value.length == 0)
	{
		alert("이름을 써");
		frm.name.focus();
		return false;
	}
	if (document.frm.userid.value.length == 0)
	{
		alert("아이디를 써주세요");
		frm.userid.focus();
		return false;
	}
	if (document.frm.userid.value.length < 4)
	{
		alert("아이디는 4글자 이상이여야 합니다.");
		frm.userid.focus();
		return false;
	}
	if (document.frm.pwd.value == "")
	{
		alert("암호를 입력해주세요");
		frm.pwd.focus();
		return false;
	}
	if (document.frm.pwd.value != document.frm.pwd.value)
	{
		alert("암호가 일치하지 않습니다.");
		frm.pwd.focus();
		return false;
	}
	if (document.frm.reid.value.length == 0)
	{
		alert("중복체크를 하지 않았습니다");
		frm.userid.focus();
		return false;
	}	
	return true;
} 

</script>

</head>

<body>

	<h2 align="center">회원가입!!!</h2>

	<h4 align="center">'*'표시항목은 필수입력항목입니다</h4>

	<form action="ManageMemberServlet" method="post" name="frm">
		<input type="hidden" name="command" value="join">

		<table align="center">

			<tr>

				<td>이름</td>

				<td><input type="text" name="name" size="20">*</td>

			</tr>

			<tr>

				<td>아이디</td>

				<td><input type="text" name="userid" size="20" id="userid">*

					<input type="hidden" name="reid" size="20"> <input
					type="button" value="중복 체크" onclick="idCheck()"></td>

			</tr>

			<tr>

				<td>닉네임</td>

				<td><input type="text" name="nick" size="20">*</td>

			</tr>

			<tr>

				<td>비밀번호</td>

				<td><input type="password" name="pwd" size="20">*</td>

			</tr>

			<tr>

				<td>비밀번호 확인</td>

				<td><input type="password" name="pwd_check" size="20">*</td>

			</tr>

			<tr>

				<td>이메일</td>

				<td><input type="text" name="email" size="20"></td>

			</tr>

			<tr>

				<td>전화번호</td>

				<td><input type="text" name="phone" size="20"></td>

			</tr>

			<tr>

				<td></td>

				<td><input type="submit" value="확인"
					onclick="return joinCheck()"> <input type="reset"
					value="취소"></td>

			</tr>

		</table>
		<jsp:include page="/footer.jsp" />

	</form>

</body>

</html>