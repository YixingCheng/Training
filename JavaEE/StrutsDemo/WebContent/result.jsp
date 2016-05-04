<!DOCTYPE >
       
<html>
<head>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Result Page</title>
<style>
	h2 {
		color: blue;
	}
</style>
</head>
<body>
<%--<h2><%=request.getAttribute("msg")%></h2> --%>
<%@page import="com.mercury.beans.User" %>
<jsp:useBean id="userInfo" scope="request" class="com.mercury.beans.UserInfo"/>
<h2><jsp:getProperty name="userInfo" property="msg"/></h2>
<table border="1" style="width:200px">
	<tr>
		<th><bean:message key="user.name"/></th>
		<th><bean:message key="user.age"/></th>
	</tr>
	<logic:iterate id="user" name="userInfo" property="users"
		type="com.mercury.beans.User" scope="request">
		<tr>
			<td><bean:write name="user" property="name"/></td>
			<td><bean:write name="user" property="age"/></td>
		</tr>
	</logic:iterate>
	<%--
	<c:forEach var="user" items="${userInfo.users}">
		<tr>
			<td>${user.name}</td>
			<td>${user.age}</td>
		</tr>
	</c:forEach>
	 --%>
	
	<%--
	<%
		for (User user:userInfo.getUsers()) {
			out.print("<tr>");
			out.print("<td>" + user.getName() + "</td>");
			out.print("<td>" + user.getAge() + "</td>");
			out.print("</tr>");
		}
	%>
	--%>
	
</table>
</body>
</html>