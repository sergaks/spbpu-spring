<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/template"%>


<template:page>
	<div class="well">
		<div>
			<h2>Student Profile</h2>
		</div>

		<p>
			<b>ID: </b>${student.id}
		</p>
		<p>
			<b>Name: </b>${student.firstName} ${student.lastName}
		</p>
		<p>
			<b>BirthDate: </b>${student.birthDate}
		</p>
		<p>
			<b>Start year: </b>${student.startYear}
		</p>
		<p>
			<b>Graduation year: </b>${student.graduationYear}
		</p>
	</div>
</template:page>
