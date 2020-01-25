<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer Login Page</title>

<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
		 

<script>
     function Project()
	{
		var Name = document.forms["myForm"]["name"];
		var TableID = document.forms["myForm"]["table_id"];
		var MobileNo = document.forms["myForm"]["mobile_no"];
	 	
		if(Name.value == "")
		{
			window.alert("Please enter your name.");
			Name.focus();
			return false;
		}
        if(MobileNo.value == "")
		{
			window.alert("Please enter your Mobile No.");
			MobileNo.focus();
			return false;
		}

		if(TableID.value == "0")
		{
			window.alert("Please enter Table No.");
			TableID.focus();
			return false;
		}

		
		

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
				<div class="col-3 txt-light pt-3">				
						<a href="/user/" class="btn btn-info border-light" role="button">Role Based Login</a>
				</div>	
		</div>

		<div class="row bg-light">
			<div class="col-3"></div>
			<div class="col-6" align="center">
				<div class="jumbotron">
					<h4>Customer Login </h4>
					<form action="custLogin" name="myForm" onsubmit="return Project()"  method="post">
						<input type="text" class="mb-2 rounded" name="name"  placeholder="Enter Name"><br> 
						<input type="text" maxlength="10" pattern="[0-9]{10}" class="mb-2 rounded" name="mobile_no" placeholder="Enter Mobile Number" ><br>
												<p>
							Table ID <select class="rounded mb-2"
								name="table_id">
								<option value="0">Type</option>
								<option value="1">Table 1</option>
								<option value="2">table 2</option>
								<option value="3">table 3</option>
								<option value="4">table 4</option>
								<option value="5">table 5</option>
							</select> <br>
						
						<input type="submit" class="btn rounded text-dark border-dark" value="Submit"><br>

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
