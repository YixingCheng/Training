<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>JSP Demo</title>
<script src="js/angular.min.js"></script>
<script src="js/jquery-1.12.0.min.js"></script>

<style>
	h1{
		color: red;
		text-shadow: 5px 5px 5px orange;
	}
	.round {
		border-raidus: 10px;
	}
	#error {
		color: red;
	}
</style>
</head>
<body >
	
	<h1>SpringMVC Demo02: JSP + SpringMVC ~ Hibernate</h1>
	
		<form action="hello.html" method="post">
		<table>
			<tr>
				<td>Name: </td>
				<td><input type="text" name="name" placeholder="Your Name" id="name"/></td>
				
			</tr>
			<tr>
				<td>Age: </td>
				<td><input type="text" name="age" placeholder="Your Age" id="age"/></td>
			</tr>
			<tr>
				<td></td>
				<td>
					<input type="reset" value="Clear" class="round"/>
					<input type="submit" value="Submit" class="round" id="submit"/>
				</td>
			</tr>
		</table>
	</form>
	
	
	</div>
</body>
</html>