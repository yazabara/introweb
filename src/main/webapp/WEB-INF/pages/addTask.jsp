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
	<title>Home</title>
	<%@include file="blocks/headSection.jsp" %>


</head>
<body>
	<jsp:include page="blocks/header.jsp" >
		<jsp:param name="active" value="addTask" />
	</jsp:include>

	<div class="container" >

	</div>

	<%@include file="blocks/footer.jsp" %>
</body>
</html>
