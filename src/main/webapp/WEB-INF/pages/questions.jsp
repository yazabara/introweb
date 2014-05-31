<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Questions</title>
</head>
<body>
    <TABLE>
        <c:forEach items="${questionList}" var="task">
            <tr>
                <td><c:out value="${task.question}"/></td>
                <td><c:out value="${task.owner.firstName}"/></td>
            </tr>
        </c:forEach>
    </TABLE>
</body>
</html>
