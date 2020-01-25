<html>
<head>
<meta charset="ISO-8859-1">
<title>Register Page</title>
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
</head>
<body>

<%
response.setHeader("Cache-Control", "no-cache,no-store,must-invalidate");
response.setHeader("Pragma", "no-cache");
response.setHeader("Expires", "0");
%>
	<div class="container-flud  ">
		
		<div class="row bg-dark pt-3">
				<div class="col-1 "></div>
				<div class="col-10  text-light ">
					<h1>RESTAURANT 15</h1>
				</div>
				<div class="col-1 text-light">				
					<a href="/user/logout" class="btn btn-danger border-light" role="button">logout</a>
				</div>
		</div>

		<div class="row bg-light">
			<div class="col-3"></div>
			<div class="col-6" align="center">
				<div class="jumbotron">
					<h1>WELCOME ADMINISTRATOR</h1>
				</div>				
			</div>
			<div class="col-3"></div>
		</div>
		

		
		<div class="row bg-light">
			<div class="col-3"></div>
			<div class="col-2">
			
					<a href="/user/register" class="btn btn-info border-dark" role="button">Add Employee</a>
			
			</div>

			<div class=" col-2">
			
					<a href="/user/showemp" class="btn btn-info border-dark" role="button">Employee Info</a>
			
			</div>
			<div class="col-2"></div>
			<div class="col-3"></div>
			
		</div>
			
	
		
		
		
		<div class="row ">
			<div class="col-1 "></div>
			<div class="col-11 text-dark ">
				<footer>&copy; Copyright 2020 CDAC</footer>
			</div>
		</div>
	</div>

</body>
</html>
