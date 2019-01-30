<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>전체 게시글</title>
    
 <style type="text/css">
        #wrap {
            width: 800px;
            margin: 0 auto 0 auto;
        }
        #topForm{
            text-align :right;
        }
        #board, #pageForm, #searchForm{
            text-align :center;
        }
        
        #bList{
            text-align :center;
        }
    </style>
    
    <script type="text/javascript">
        function writeForm(){
            location.href="boardWrite.jsp";
        }
    </script>
    
</head>
<body>    
 <jsp:include page="/header.jsp"/>
 
<div id="wrap">
 
    <!-- 글목록 위 부분-->
    <br>
    <div id="topForm">
        <c:if test="${sessionScope.sessionID!=null}">
            <input type="button" value="글쓰기" onclick="writeForm()">
        </c:if>    
    </div>
    
    <!-- 게시글 목록 부분 -->
    <br>
    <div id="board">
        <table id="bList" width="800" border="3" bordercolor="lightgray">
            <tr height="30">
                <td>글번호</td>
                <td>제목</td>
                <td>작성자</td>
                <td>작성일</td>
                <td>조회수</td>
            </tr>
        <c:forEach var="board" items="${boardList}">
            <tr>
                <td>${board.boardnum}</td>
                <td>
                    <a href="BoardServlet?command=board_view&num=${board.boardnum}&pageNum=${pageNum}">
                    ${board.boardtitle}
                    </a>
                </td>
                <td>
                    <a href="#">
                    ${board.usernick}
                    </a>
                </td>
                <td>${board.boarddate}</td>
                <td>${board.readcount}</td>
            </tr>
        </c:forEach>
        </table>
    </div>
    
    <!-- 페이지 넘버 부분 -->
    <br>
    <div id="pageForm">
        <c:if test="${startPage != 1}">
            <a href="BoardServlet?command=board_view&num=${startPage-1}">[ 이전 ]</a>
        </c:if>
        
        <c:forEach var="pageNum" begin="${startPage}" end="${endPage}">
            <c:if test="${pageNum == spage}">
                ${pageNum}&nbsp;
            </c:if>
            <c:if test="${pageNum != spage}">
                <a href="BoardServlet?command=board_view&num=${pageNum}">${pageNum}&nbsp;</a>
            </c:if>
        </c:forEach>
        
        <c:if test="${endPage != maxPage }">
            <a href="BoardServlet?command=board_view&num=${endPage+1}">[다음]</a>
        </c:if>
    </div>
    
    <!--  검색 부분 -->
    <br>
    <div id="searchForm">
        <form action="BoardServlet" name="frm" method="get">
        <input type="hidden" name="command" value="board_search">
<%-- 		<input type="hidden" name="num" value="${param.num}"> --%>
            <select name="opt">
                <option value="0">제목</option>
                <option value="1">내용</option>
                <option value="2">제목+내용</option>
                <option value="3">글쓴이</option>
            </select>
            <input type="text" size="20" name="condition"/>&nbsp;
            <input type="submit" value="검색"/>
        </form>    
    </div>
</div>    
 
 <jsp:include page="/footer.jsp"/>


</body>
</html>