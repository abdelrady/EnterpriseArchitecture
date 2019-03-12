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

	<section class="container">
		<div class="row">
				<div class="col-sm-12" style="padding-bottom: 15px">
					<div class="thumbnail">
						<div class="caption">
							<h4>First Name: ${user.firstName}</h4>
							<h4>
								Last Name: ${user.lastName} 
							</h4>
						</div>
					</div>
				</div>
		</div>
	</section>
</body>
</html>
