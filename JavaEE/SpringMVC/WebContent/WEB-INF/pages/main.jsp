<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Main Page</title>
<script src="js/jquery-1.12.0.min.js"></script>
<script>
	$(document).ready(function() {
		$("#btn").on("click", function(){
			$.ajax({
				url: "data.html",
				type: "get",
				//data: param,
				dataType: "html",
				success: function(resp){
					console.log(resp);
					$("#para").html(resp);
				}
			})
		})
	});
</script>
<style>
	h2 {
		color:green;
	}
</style>
</head>
<body>
<h2>This is a main page</h2>
<h2>From ModelMap: ${message} </h2>
<hr>
<button id="btn">Get Data</button>
<p id="para">No Data</p>
</body>
</html>