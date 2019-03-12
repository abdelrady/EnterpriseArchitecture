<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Members</title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1>Members</h1>
		</div>
	</section>

	<section class="container">
		<div class="row">
			<c:forEach items="${users}" var="user">
				<div class="col-sm-6 col-md-3" style="padding-bottom: 15px">
					<div class="thumbnail">
						<div class="caption">
							<h4>First Name: ${user.firstName}</h4>
							<h4>
								Last Name: ${user.lastName}
							</h4>
							<a href="<spring:url value="/users/user/${user.id}"/>"
									class="btn btn-primary">View</a>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</section>
</body>
</html>
