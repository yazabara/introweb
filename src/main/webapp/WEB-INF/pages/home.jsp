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
		<jsp:param name="active" value="Home" />
	</jsp:include>

	<div class="jumbotron">
		<div class="container">
			<h1>Questioner for you</h1>
			<p>This is a template for a simple marketing or informational website. It includes a large callout called a jumbotron and three supporting pieces of content. Use it as a starting point to create something more unique.</p>
			<p><a class="btn btn-primary btn-lg" role="button">Ask me!</a></p>
		</div>
	</div>

	<div class="container" >

	</div>

	<%@include file="blocks/footer.jsp" %>
</body>
</html>
