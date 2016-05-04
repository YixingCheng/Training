<!DOCTYPE >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Page 3</title>
</head>
<body>
	<div>
		<p>Session Scope: <%=session.getAttribute("sessionKey") %></p>
		<p>Request Scope: <%=request.getParameter("requestName") %></p>
	</div>
</body>
</html>