<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Page 1</title>
</head>
<body>
	<h2>This is page #1</h2>
	<%
		session.setAttribute("sessionKey", "This is a session");
	%>
	<form action="page2.jsp">
		<input type="text" name="requestName"/>
		<input type="submit" value="submit"/>
	</form>
</body>
</html>