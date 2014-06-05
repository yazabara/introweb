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

	<c:if test="${not empty success}">
		<jsp:include page="blocks/success.jsp">
			<jsp:param name="success" value="${success}"/>
		</jsp:include>
		<div class="jumbotron">
			<div class="container">
				<h1>Your task</h1>
			</div>
		</div>
	</c:if>

	<c:if test="${not empty errors}">
		<jsp:include page="blocks/errors.jsp">
			<jsp:param name="errors" value="${errors}"/>
		</jsp:include>
	</c:if>

	<form action="task" method="post">
		<jsp:include page="blocks/taskBlock.jsp">
			<jsp:param name="editable" value="${true}"/>
		</jsp:include>
		<input type="submit" class="btn btn-primary btn-lg" role="button" value="Submit"/>
	</form>


</div>

<%@include file="blocks/footer.jsp" %>
</body>
</html>
