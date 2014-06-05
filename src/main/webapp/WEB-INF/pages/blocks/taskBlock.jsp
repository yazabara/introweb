<%@ page import="com.zabara.introweb.domain.Task" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%
	Task task = (Task)request.getAttribute("task");
%>
<c:set var="editable" value="${not empty param.editable ? param.editable : false}"/>

<div class="input-group">
	<span class="input-group-addon">?</span>
	<input type="text"
		   name="question"
		   class="form-control"
		   placeholder="Question"
		   value="${not empty task && not empty task.question ? task.question : ''}"
		   <c:if test="${!editable}">disabled="disabled"</c:if>/>
</div>


<ul class="list-unstyled">
	<c:set var="defauleSize" value="4"/>
	<c:set var="variantsSize"
		   value="${(not empty task && not empty task.variants && fn:length(task.variants) > 0) ? fn:length(task.variants) : defauleSize}"/>

	<input type="text"
		   name="variantsSize"
		   class="hidden"
		   value="${variantsSize}">
	<input type="text"
		   name="id"
		   class="hidden"
		   value="${(not empty task && not empty task.id) ? task.id : -1}">

	<c:forEach var="index" begin="0" end="${variantsSize-1}">
		<li>
			<div class="input-group">
				<span class="input-group-addon">${index}</span>
					<span class="input-group-addon">
						<input type="radio"
							   name="options${task.id}"
							   id="option${index}"
							   value="${index}"
							   checked="${(not empty task && not empty task.answerIndex && index == task.answerIndex)? 'checked' : ''}">
					</span>
				<input type="text"
					   class="form-control"
					   name="variant${index}"
					   placeholder="variant"
					   value="${not empty task && not empty task.variants ? task.variants[index] : ''}"
					   <c:if test="${!editable}">disabled="disabled"</c:if>/>
			</div>
		</li>
	</c:forEach>

</ul>

