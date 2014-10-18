<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/template"%>


<template:page>

	<table class="table table-striped">
		<tr>
			<td>Student Name</td>
		</tr>
		<c:forEach items="${students}" var="student">
			<tr>
				<td><a href="<c:url value="/students/${student.id}"/>"> <c:out
							value="${student.firstName} ${student.lastName}"></c:out>
				</a></td>
			</tr>
		</c:forEach>

	</table>
</template:page>
