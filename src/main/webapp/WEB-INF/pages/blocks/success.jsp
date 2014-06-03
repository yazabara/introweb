<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:forEach var="successMessage" items="${param.success}">
	<div class="alert alert-success">
		<strong>success!</strong> ${successMessage}
	</div>
</c:forEach>