<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ attribute name="pageTitle" required="false" rtexprvalue="true"%>
<%@ attribute name="active" required="false"%>

<!DOCTYPE html>
<head>
<title>${pageTitle}</title>
<%-- Meta Content --%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
<link href="<c:url value="/resources/vendor/bootstrap/css/bootstrap.css" />" rel="stylesheet">

</head>

<body>

	<div class="navbar navbar-inverse navbar-static-top" role="navigation">
		<div class="container">
			<a class="navbar-brand" href="<c:url value="/"/>">Spring Course Application</a>

			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li <c:if test="${active == 'Home'}">class="active"</c:if>><a href="<c:url value="/"/>">Home</a>
					<li <c:if test="${active == 'Students'}">class="active"</c:if>><a href="<c:url value="/students"/>">Students</a></li>
					<li <c:if test="${active == 'Teachers'}">class="active"</c:if>><a href="<c:url value="/teachers"/>">Teachers</a></li>
				</ul>

				<sec:authorize access="isAuthenticated()">
					<sec:authentication var="user" property="principal.user" />
					<ul class="nav navbar-nav navbar-right">
        				<li><a href="#">Signed in as ${user.firstName} ${user.lastName}</a></li>
        				<li>
	        				<form method="get" action="<c:url value='/logout' />">
								<button type="submit" class="btn btn-success navbar-btn">Log out</button>
							</form>
						</li>
					</ul>
				</sec:authorize>

				<sec:authorize access="!isAuthenticated()">
					<form class="navbar-form navbar-right" role="form" action="<c:url value='j_spring_security_check'/>" method="POST">
						<div class="form-group">
							<input type="text" name="j_username" placeholder="Username" class="form-control">
						</div>
						<div class="form-group">
							<input type="password" name="j_password" placeholder="Password" class="form-control">
						</div>
						<button type="submit" class="btn btn-success">Sign in</button>
						<input type="hidden" name="<c:out value="${_csrf.parameterName}"/>" value="<c:out value="${_csrf.token}"/>" />
					</form>
				</sec:authorize>
			</div>
		</div>

	</div>

	<div class="container">


		<div class="jumbotron">
			<h1>Spring Course Web Application</h1>
			<p>This is example application to demonstrate Spring and other
				cool technologies. To login use: ivan_ivanov/password</p>
		</div>

		<%-- Inject the page body here --%>
		<jsp:doBody />
	</div>
	<div class="footer">
	
	</div>
</body>

