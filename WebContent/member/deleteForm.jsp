<%@ page contentType="text/html; charset=euc-kr"%>

<html>
<head>
<title>회원 탈퇴</title>
</head>
<link href="style.css" rel="stylesheet" type="text/css">
<script language="javascript">
	function begin() {
		document.myform.passwd.focus();
	}

	function checkIt() {
		if (!document.myform.passwd.value) {
			alert("비밀번호를 입력하지 않으셨습니다.");
			document.myform.passwd.focus();
			return false;
		}
	}
</script>

<body onload="begin()">
	<form name="myform" action="ManageMemberServlet" method="post"
		onSubmit="return checkIt()">
		<input type="hidden" name="command" value="delete">
		<table cellspacing="1" cellpadding="1" width="260" border="1"
			align="center">
			<tr height="30">
				<td colspan="2" align="middle"><font size="+1"><b>회원
							탈퇴</b></font></td>
			</tr>
			<tr>
				<td width="110" align="center">비밀번호</td>
				<td width="150" align="center"><input type="password"
					name="passwd" size="15" maxlength="12"></td>
			</tr>
			<tr height="30">
				<td colspan="2" align="middle"><input type="submit"
					value="회원탈퇴">
			</tr>
		</table>
	</form>
</body>
</html>