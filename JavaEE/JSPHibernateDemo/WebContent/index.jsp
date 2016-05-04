<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Index Page</title>
</head>
<body>
<%-- 
<jsp:forward page="hello.jsp"/>
--%>
<%
	response.sendRedirect("hello.jsp");
%>
</body>
</html>