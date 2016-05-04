<!DOCTYPE>
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Hello Page</title>
<style>
	h2 {
		color: red;
		text-shadow: 5px 5px 5px orange;
	}
</style>
</head>
<body>
	<h2>This is a Struts 2 Demo</h2>
	<s:form action="hello" theme="simple">
		<table>
			<tr>
				<td>Name: </td>
				<td><s:textfield name="name" label="Name"/></td>
			</tr>
			<tr>
				<td>Age: </td>
				<td><s:textfield name="age" label="Age"/></td>
			</tr>
			<tr>
				<td></td>
				<td>
					<s:reset value="Clear"/>
					<s:submit value="Submit"/>
				</td>
			</tr>
		</table>
	</s:form>
</body>
</html>