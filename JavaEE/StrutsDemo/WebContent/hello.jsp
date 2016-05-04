<!DOCTYPE>
<html>
<head>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>JSP Demo</title>
<style>
	h1{
		color: red;
		text-shadow: 5px 5px 5px orange;
	}
	.round {
		border-raidus: 10px;
	}
</style>
</head>
<body>
	<h1>This is a Struts MVC Demo</h1>
	<html:form action="/hello">
		<table>
			<tr>
				<td><bean:message key="user.name"/>: </td>
				<td><html:text property="name"/></td>
			</tr>
			<tr>
				<td><bean:message key="user.age"/>: </td>
				<td><html:text property="age"/></td>
			</tr>
			<tr>
				<td></td>
				<td>
					<html:reset value="Clear"/>
					<html:submit value="Submit"/>
				</td>
			</tr>
		</table>
	</html:form>
</body>
</html>