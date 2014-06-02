<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setBundle basename=""/>

<nav role="navigation" class="navbar navbar-inverse navbar-fixed-top">
	<div class="container">
		<div class="navbar-header">
			<button type="button" data-toggle="collapse"
					data-target=".navbar-collapse"
					class="navbar-toggle collapsed">
				<span class="sr-only">Questioner</span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<a href="${pageContext.request.contextPath}/home" class="navbar-brand">Questioner</a>
		</div>
		<div class="navbar-collapse collapse">
			<ul class="nav navbar-nav">
				<c:choose>
					<c:when test="${param.active == 'Home'}">
						<li class="active"><a href="${pageContext.request.contextPath}/home">
							<fmt:message key="page.home"/>
						</a></li>
						<li><a href="${pageContext.request.contextPath}/questions">Questions</a></li>
						<li><a href="${pageContext.request.contextPath}/contact">Contact</a></li>
						<li><a href="${pageContext.request.contextPath}/addTask">Add new task</a></li>
					</c:when>
					<c:when test="${param.active == 'Questions'}">
						<li><a href="${pageContext.request.contextPath}/home">Home</a></li>
						<li class="active"><a href="${pageContext.request.contextPath}/questions">Questions</a></li>
						<li><a href="${pageContext.request.contextPath}/contact">Contact</a></li>
						<li><a href="${pageContext.request.contextPath}/addTask">Add new task</a></li>
					</c:when>
					<c:when test="${param.active == 'addTask'}">
						<li><a href="${pageContext.request.contextPath}/home">Home</a></li>
						<li><a href="${pageContext.request.contextPath}/questions">Questions</a></li>
						<li><a href="${pageContext.request.contextPath}/contact">Contact</a></li>
						<li class="active"><a href="${pageContext.request.contextPath}/addTask">Add new task</a></li>
					</c:when>
					<c:otherwise>
						<li><a href="${pageContext.request.contextPath}/home">Home</a></li>
						<li><a href="${pageContext.request.contextPath}/questions">Questions</a></li>
						<li class="active"><a href="${pageContext.request.contextPath}/contact">Contact</a></li>
						<li><a href="${pageContext.request.contextPath}/addTask">Add new task</a></li>
					</c:otherwise>
				</c:choose>
			</ul>
			<form class="navbar-form navbar-right" role="form">
				<div class="form-group">
					<input type="text" placeholder="Question" class="form-control">
				</div>
				<button type="submit" class="btn btn-success">find</button>
			</form>
		</div>


	</div>
</nav>