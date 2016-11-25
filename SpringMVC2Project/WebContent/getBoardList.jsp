<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!-- 
	JSTL(JSP Standard Tag Library)이란?
	JSP 파일에서 for, if, switch 등과 같은 자바 코드를 대체하는 표준 태그
-->

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><spring:message code="message.board.list.mainTitle"/></title>
</head>
<body>
<center>
<h1><font color="green"><spring:message code="message.board.list.mainTitle"/></font></h1>
<h3>테스트${usernameis }<spring:message code="message.board.list.welcomeMsg"/><a href="logout.do">Log-out</a></h3><!--님 환경합니다....-->

<!-- 검색 시작 -->
<form action="getBoardList.do" method="post">
	<table border="1" cellpadding="0" cellspacing="0" width="700">
	<tr>
		<td align="right">
			<select name="searchCondition">
			<option value="TITLE"><spring:message code="message.board.list.search.condition.title"/>
			<option value="CONTENT"><spring:message code="message.board.list.search.condition.content"/>
			</select>
			<input name="searchKeyword" type="text"/>
			<input type="submit" value="<spring:message code="message.board.list.search.condition.btn"/>"/>
		</td>
	</tr>
	</table>
</form>
<!-- 검색 종료 -->

<table border="1" cellpadding="0" cellspacing="0" width="700">
<tr>
	<th bgcolor="orange" width="100"><spring:message code="message.board.list.table.head.seq"/><!--순번--></th>
	<th bgcolor="orange" width="200"><spring:message code="message.board.list.table.head.title"/><!--제목--></th>
	<th bgcolor="orange" width="150"><spring:message code="message.board.list.table.head.writer"/><!--작성자--></th>
	<th bgcolor="orange" width="150"><spring:message code="message.board.list.table.head.regDate"/><!--등록일--></th>
	<th bgcolor="orange" width="100"><spring:message code="message.board.list.table.head.cnt"/><!--조회수--></th>
</tr>

<c:forEach var="board" items="${boardList }">
<tr>
	<td>${board.seq }</td>
	<td align="left"><a href="getBoard.do?seq=${board.seq }">${board.title }</a></td>
	<td>${board.writer }</td>
	<td><fmt:formatDate value="${board.regDate }" pattern="yyyy-MM-dd"/></td>
	<td>${board.cnt }</td>
</tr>
</c:forEach>

</table>
<br>
<a href="insertBoard.jsp"><spring:message code="message.board.list.link.insertBoard"/></a>
</center>
</body>
</html>



