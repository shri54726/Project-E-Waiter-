<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Role Based Login</title>
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
	
	<script>
     function Project1()
	{
		var uname = document.forms["RegForm"]["user_name"];
		var Password = document.forms["RegForm"]["password"];
		


	if(uname.value == "")
		{
			window.alert("Please enter your username.");
			uname.focus();
			return false;
		}

		if(Password.value == "")
		{
			window.alert("Please enter password.");
			Password.focus();
			return false;
		}
		return true;
	}
</script>
	
</head>
<body>
	<div class="container-flud  ">
		
		<div class="row bg-dark pt-3">
				<div class="col-1 "></div>
				<div class="col-8  text-light ">
					<h1>RESTAURANT 15</h1>
				</div>
				<div class="col-3 text-light">				
						<a href="/" class="btn btn-info border-light" role="button">Customer Login</a>
				</div>	
		</div>

		<div class="row bg-light">
			<div class="col-3"></div>
			<div class="col-6" align="center">
				<div class="jumbotron">
					<h4>Role Based Login </h4>
					<form action="login" name="RegForm"  onsubmit=" return Project1() " method="post" >
						<input type="text" class="mb-2 rounded" name="user_name"placeholder="Enter Username" ><br> 
						<input type="password" minlength=8 maxlength=15 pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters" class="mb-2 rounded" name="password" placeholder="Enter Password"  required><br>
						<input type="submit" class="btn rounded text-dark border-dark" value="Login"><br>
					</form>
				</div>				
			</div>
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
