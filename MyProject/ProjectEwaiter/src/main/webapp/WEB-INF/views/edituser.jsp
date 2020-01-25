<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<title>Edit/Remove Employee</title>
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<%
response.setHeader("Cache-Control", "no-cache,no-store,must-invalidate");
response.setHeader("Pragma", "no-cache");
response.setHeader("Expires", "0");
%>
<script>
     function Project1()
	{
		var uname = document.forms["RegForm"]["user_name"];
		var Password = document.forms["RegForm"]["password"];
		var Name = document.forms["RegForm"]["name"];
		var Salary = document.forms["RegForm"]["salary"];
		var UserType = document.forms["RegForm"]["user_type_id"];
	
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

		if(Name.value == "")
		{
			window.alert("Please enter your name.");
			Name.focus();
			return false;
		}
		if(Salary.value == "")
		{
			window.alert("Please enter salary.");
			Salary.focus();
			return false;
		}
		if(UserType.selectedIndex < 1)
		{
			alert("please select user type.");
			UserType.focus();
			return false;
		}

	}	
</script>
</head>
<body>
	<div class="container-flud  ">
		
		<div class="row bg-dark pt-3">
				<div class="col-1 "></div>
				<div class="col-9  text-light ">
					<h1>RESTAURANT 15</h1>
				</div>
				<div class="col-1 ">
				<a href="/user/showemp" class="btn btn-info border-light" role="button">GoBack</a>				
				</div>
				<div class="col-1 text-light">
						<a href="/user/logout" class="btn btn-danger border-light" role="button">Logout</a>
				</div>	
		</div>

		<div class="row bg-light">
			<div class="col-3"></div>
			<div class="col-6" align="center">
				<div class="jumbotron">
					<h4>Update an Employee</h4>
					<form name="RegForm" action="editUser" method="post" onsubmit="return Project1()">
	<input type="hidden" class="mb-2 rounded" name="user_id" value="${user.user_id }" placeholder="Enter UserName" required><br>
	<input type="text" class="mb-2 rounded" name="user_name" value="${user.user_name }" placeholder="Enter UserName" required><br>
	<input type="password" class="mb-2 rounded" name="password" value="${user.password}" placeholder="Enter Password" required><br>
	<input type="text" class="mb-2 rounded" name="name" value="${user.name}" placeholder="Enter Name" required><br>
	<input type="text"  class="mb-2 rounded" name="salary" value="${user.salary}" placeholder="Enter salary" required ><br>
	
	    <p>USER TYPE    
        <select class="mb-2"  name="user_type_id" >
          	<option value="0">Type</option>     	
  			<option value="1">Admin</option>
  			<option value="2">Manager</option>
  			<option value="3">Chef</option>
 			<option value="4">Waiter</option>
		</select>  <br>
            


	<input type="submit" class="btn text=dark rounded border-dark" value="Update"><br>

	
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
