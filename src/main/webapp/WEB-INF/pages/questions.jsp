<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head>
    <title>Questions</title>
	<%@include file="headSection.jsp" %>
</head>
<body>
	<div id='tab1' class="tab_content" style="width: 100%">
		<h3>Table 2</h3>
		<p>This is forEach </p>
		<TABLE>
			<c:forEach items="${questionList}" var="task">
				<tr>
					<td><c:out value="${task.question}"/></td>
					<td><c:out value="${task.owner.firstName}"/></td>
				</tr>
			</c:forEach>
		</TABLE>
	</div>

	<div id='tab2' class="tab_content" style="width: 100%">
		<h3>Table 2</h3>
		<p>This is display:table </p>

		<display:table export="true"  id="data" name="${questionList}" pagesize="3" sort="list" uid="two" requestURI="/questions">
			<display:column property="question" title="question" sortable="true"   />
			<display:column property="owner.firstName" title="Name" sortable="true"  />
		</display:table>
	</div>
</body>
</html>
