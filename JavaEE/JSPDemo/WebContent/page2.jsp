<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Page2</title>
</head>
<body>
	<h2>This is page #2</h2>
	<div>
		<p>Session Scope: <%=session.getAttribute("sessionKey") %></p>
		<p>Request Scope: <%=request.getParameter("requestName") %></p>
	</div>
	<a href="page3.jsp">Go to Page3</a>
</body>
</html>