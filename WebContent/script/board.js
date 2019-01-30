/**
 * 
 */

function boardCheck() {
	if (document.frm.usernick.value.length == 0) {
		alert("닉네임을 입력해주세요.");
		return false;
	}
	else if (document.frm.boardpass.value.length == 0) {
		alert("비밀번호를 입력하세요.");
		return false;
	}
	else if (document.frm.boardtitle.value.length == 0) {
		alert("제목을 입력하세요.");
		return false;
	}
	return true;
}

function commentCheck() {
	if (document.frm.comment_usernick.value.length == 0) {
		alert("닉네임을 입력하세요.");
		return false;
	}
	else if (document.frm.comment_pass.value.length == 0) {
		alert("비밀번호를 입력하세요.");
		return false;
	}
	else if (document.frm.comment_content.value.length == 0) {
		alert("댓글을 입력하세요.");
		return false;
	}
	return true;
}

function open_win(url, name) {
	window.open(url, name, "width=500, height=230");
}

function passCheck() {
	if (document.frm.boardpass.value.length == 0) {
		alert("비밀번호를 입력하세요.");
		return false;
	}
	return true;
}