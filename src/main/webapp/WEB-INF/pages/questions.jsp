<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head>
    <title>Questions</title>
	<%@include file="blocks/headSection.jsp" %>
</head>
<body>

<jsp:include page="blocks/header.jsp">
	<jsp:param name="active" value="addTask"/>
</jsp:include>

<div class="container content-wrapper">

	<div id='tab2' class="panel panel-default" style="width: 100%">

		<display:table export="true"  id="data" name="${questionList}" pagesize="3" sort="list" uid="two" requestURI="questions" class="table">
			<display:column property="id" title="id" sortable="true" />
			<display:column property="question" title="question" sortable="true"   />
			<display:column property="owner.firstName" title="Author" sortable="true"  />
		</display:table>
	</div>

</div>

<%@include file="blocks/footer.jsp" %>
</body>
</html>
