<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>JSP Demo</title>
<script src="js/angular.min.js"></script>
<script src="js/jquery-1.12.0.min.js"></script>
<script>
	var app = angular.module("mainApp", []);
	
	app.controller("mainCtrl", function($scope, $http, $q) {
		//console.log("lose scope");
		$scope.data = {
				name: null
		}
		$scope.myShow = false;
		$scope.validate = function() {
			//console.log($scope.name);
			$http.get("validation", {params: $scope.data})
			.success(function(resp) {
				if (resp == "true"){
					console.log("return true");
					$scope.myShow = true;
				} else{
					console.log("return false");
					$scope.myShow = false;
				}		
			});
		};
	});

	/*
	$(document).ready(function() {
		$("#error").hide();
		$("#name").on("blur", function() {
			var name = $(this).val();
			
			$.get({
				url: "validation",
				dataType: "html",
				data: {name: name},
				success: function(result) {
					if (result == "true"){
						$("#error").show();
					} else{
						$("#error").hide();
					}
				}
			});
			
			$.ajax({
					url: "validation",
					type: "get",
					data: {name: name},
					dataType: "html",
					success: function(resp) {
						if (resp == "true"){
							$("#error").show();
						} else{
							$("#error").hide();
						}		
					}
					
			});
			
		});
	});
	*/
</script>
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
<body ng-app="mainApp">
	
	<h1>This is a JSP+Hibernate Demo</h1>
	<%--
		<form action="HelloServlet" method="post">
		<table>
			<tr>
				<td>Name: </td>
				<td><input type="text" name="name" placeholder="Your Name" id="name"/></td>
				<td><b id="error">Name already exists!</b></td>
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
	 --%>
	<div ng-controller="mainCtrl">
		<form action="HelloServlet" method="post">
		  <table>
			<tr>
				<td>Name: </td>
				<td><input type="text" name="name" placeholder="Your Name" ng-model="data.name" ng-blur="validate()"/></td>
				<td><b id="error" ng-show="myShow">Name already exists!</b></td>
			</tr>
			<tr>
				<td>Age: </td>
				<td><input type="text" name="age" placeholder="Your Age"/></td>
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