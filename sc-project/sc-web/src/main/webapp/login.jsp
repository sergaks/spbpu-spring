<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/template"%>


<template:page>

    <c:if test="${not empty param.login_error}">
    <div class="alert-danger">
        Your login attempt was not successful, try again.<br/><br/>
        Reason: <c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}"/>.
    </div>
    </c:if>

	<div class="container">
		<form class="form-signin" role="form" action="<c:url value='j_spring_security_check'/>" method="POST">
			<h2 class="form-signin-heading">Please sign in</h2>
			<input class="form-control" name="j_username" placeholder="Username" required="" autofocus="" type="text"
				value='<c:if test="${not empty param.login_error}"><c:out value="${SPRING_SECURITY_LAST_USERNAME}"/></c:if>'/> 
			<input class="form-control" name="j_password" placeholder="Password" required="" type="password"/>
			<div class="checkbox">
				<label> <input type="checkbox"  name="_spring_security_remember_me"> Remember me
				</label>
			</div>
			<button class="btn btn-lg btn-success btn-block" type="submit">Sign in</button>
			<input type="hidden" name="<c:out value="${_csrf.parameterName}"/>" value="<c:out value="${_csrf.token}"/>" />
		</form>
	</div>
	
</template:page>
