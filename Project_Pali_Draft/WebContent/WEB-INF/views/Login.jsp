<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  <!-- THIS GIVES FORM ACCESS TO CONTROLLER (AKA HTML INPUT TO JAVA) -->

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Project Pali Login</title>
</head>
<!-- THIS JSP IS WHERE WE INVALIDATE AKA END THE SESSION! -->
<!-- session.invalidate -->
<body>

<div>
	<!-- header -->
	<h2>Project Pali</h2>
</div>
	
	<!-- form action will become "loggedIn" -->
	<h4>- User accounts are currently in development. Please "Continue as Guest".</h4>
	<div>
	<form:form action = "#" method="POST" modelAttribute="userLogin">
		<label>Username</label>
		<form:input type="text" path="username" id="username" placeholder="Enter Valid Username"/>
		<form:errors path="username"/>
		<br><br>
		<label>Password</label>
		<input type = "password" name = "password" id="password" value = "" placeholder="Enter Valid Password" required/>
		<br><br>
		<input type = "submit" name = "Sign In" value = "Sign In"/>
		<br>
		</form:form>
		<h3>No Account?<a href="Register"> Register Here</a></h3><br><br>
		<h3>Or <a href="HomePageGuest"> Continue as Guest</a></h3>
	</div>
</body>

</html>