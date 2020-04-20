<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  <!-- THIS GIVES FORM ACCESS TO CONTROLLER (AKA HTML INPUT TO JAVA) -->

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register Page</title>
</head>

<body>
<h1>Registration Page</h1><br><br>
<div>
<form:form action="signUp" method="POST" modelAttribute="userRegister" >
		<label>Username</label>
		<input type="text" name="username" id="username" placeholder="Enter Valid Username" required/>
		<br><br>
		<label>Password</label>
		<input type = "password" name = "password" id="password" value = "" placeholder="Enter Valid Password" required/>
		<br><br>
		<label>First Name</label>
		<input type="text" name="firstName" id="firstName" placeholder="Enter First Name" />
		<br><br>
		<label>Last Name</label>
		<input type = "text" name = "lastName" id="lastName" value = "" placeholder="Enter Last Name" />
		<br><br>
		<input type = "submit" name = "Sign Up" value = "Sign Up" />
		
		<br><br>
		<h4>Meant to Login?<a href="Login">Click Here</a></h4>
		<h4>Or<a href="InGamePreGameGuest"> Click Here to Continue as Guest </a></h4>
</form:form>
</div>
</body>

</html>