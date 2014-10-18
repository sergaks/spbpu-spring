<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ attribute name="pageTitle" required="false" rtexprvalue="true"%>
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
					<li class="active"><a href="<c:url value="/"/>">Home</a></li>
					<li><a href="<c:url value="/students"/>">Students</a></li>
				</ul>

				<form class="navbar-form navbar-right" role="form">
					<div class="form-group">
						<input type="text" placeholder="Email" class="form-control">
					</div>
					<div class="form-group">
						<input type="password" placeholder="Password" class="form-control">
					</div>
					<button type="submit" class="btn btn-success">Sign in</button>
				</form>
			</div>
		</div>

	</div>

	<div class="container">


		<div class="jumbotron">
			<h1>Spring Course Web Application</h1>
			<p>This is example application to demonstrate Spring and other
				cool technologies</p>
		</div>

		<%-- Inject the page body here --%>
		<jsp:doBody />
	</div>
</body>

