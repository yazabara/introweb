<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<c:forEach var="error" items="${param.errors}">
	<div class="alert alert-danger">
		<strong>Error!</strong> ${error}
	</div>
</c:forEach>

