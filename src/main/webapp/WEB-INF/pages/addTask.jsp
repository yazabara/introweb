<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%--
  Created by IntelliJ IDEA.
  User: Yaroslav_Zabara
  Date: 5/30/2014
  Time: 10:59 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>Add task</title>
	<%@include file="blocks/headSection.jsp" %>
</head>
<body>
<jsp:include page="blocks/header.jsp">
	<jsp:param name="active" value="addTask"/>
</jsp:include>

<div class="container content-wrapper">

	<c:choose>
		<%--Task was added--%>
		<c:when test="${not empty success}">
			<jsp:include page="blocks/success.jsp">
				<jsp:param name="success" value="${success}"/>
			</jsp:include>
			<div class="jumbotron">
				<div class="container">
					<h1>Your task</h1>
				</div>
			</div>
		</c:when>
	</c:choose>

	<c:if test="${not empty errors}">
		<jsp:include page="blocks/errors.jsp">
			<jsp:param name="errors" value="${errors}"/>
		</jsp:include>
	</c:if>

	<form action="addTask" method="post">
		<div class="input-group">
			<span class="input-group-addon">?</span>
			<input type="text" name="question" class="form-control" placeholder="Question" value="${task.question}">
		</div>
		<ul class="list-unstyled">
			<c:set var="variantsSize" value="4"/>
			<input type="text" name="variantsSize" class="hidden"  value="${(not empty task.variants && fn:length(task.variants) > 0) ? fn:length(task.variants) : variantsSize}">
			<%--TODO загрлушка--%>
			<input type="text" name="rightAnswer" class="hidden" value="${(not empty task.answerIndex && task.answerIndex >= 0) ? task.answerIndex : 0}">
			<input type="text" name="id" class="hidden" value="${(not empty task.id) ? task.id : -1}">
			<c:forEach var="index" begin="0" end="${variantsSize-1}">
				<li>
					<div class="input-group">
						<span class="input-group-addon">${index}</span>
						<input type="text" class="form-control" name="variant${index}" placeholder="variant" value="${task.variants[index]}">
					</div>
				</li>
			</c:forEach>

		</ul>
		<input type="submit" class="btn btn-primary btn-lg" role="button" value="Submit"/>
	</form>


</div>

<%@include file="blocks/footer.jsp" %>
</body>
</html>
