<!DOCTYPE>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Hello page</title>
<style>
	h1 {
		color:green;
	}
</style>
</head>
<body>
<h1>Welcome ${sessionScope.username} to Spring security</h1>
<a href="<c:url value='/j_spring_security_logout'/>">Log out</a>
</body>
</html>