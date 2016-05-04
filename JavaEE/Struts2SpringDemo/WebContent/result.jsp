<!DOCTYPE>
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Result Page</title>
<style>
	h2 {
		color: blue;
	}
</style>
</head>
<body>
	<h2><s:property value="message"/></h2>
	<table border="1" style="width:200px">
		<tr>
			<th>Name</th>
			<th>Age</th>
		</tr>
		<s:iterator value="users" var="user">
			<tr>
				<td><s:property value="#user.name"/></td>
				<td><s:property value="#user.age"/></td>
			</tr>
		</s:iterator>
	</table>
</body>
</html>