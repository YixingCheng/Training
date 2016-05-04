<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Hello Page</title>
<script src="js/angular.min.js"></script>
<script>
	var app= angular.module("mainApp", []);
	app.controller("mainCtrl", function($scope, $http) {
		console.log("hello");
		$scope.person = {};
		$scope.personList = {};
		$scope.getPerson=function(){
			console.log("hello");
			$http.get("person.html")
			.success(function(resp) {
				console.log("hello");
				console.log(resp);
				$scope.person=resp;
			})
		};
		$scope.getPersonList=function(){
			console.log("hello");
			$http.post("person.html")
			.success(function(resp) {
				console.log(resp);
				$scope.personList=resp;
			})
		};
	});
	
</script>
<style>
	h1 {
		color: green;
	}
</style>
</head>
<body ng-app="mainApp" ng-controller="mainCtrl">
<h1>${title}</h1>
<hr>
<button ng-click="getPerson()">Get Person</button>
<p>First Name: {{person.firstName}}</p>
<p>Last Name: {{person.lastName}}</p>
<hr>
<button ng-click="getPersonList()">Get Person List</button>
 <table >
				<tr>
					<th>FistName</th>
					<th>LastName</th>
				</tr>
				
					<tr ng-repeat="p in personList">
						<td>{{p.firstName}}</td>
						<td>{{p.lastName}}</td>
					</tr>
			</table>
</body>
</html>