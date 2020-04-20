<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import = "com.casestudy.controller.*,com.casestudy.models.Home, 
com.casestudy.dao.HomeDAO, com.casestudy.services.HomeServices" %>
 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
</head>

<body>
<h1>Project Pali </h1>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<h3><a href="Login">Login</a></h3>

<br>
<a href="InGamePreGameGuest">Play Game</a><br><br>
<h2>Good luck and have a good time</h2><br>

<h4>A verse from the Good Book: <br><c:out value = "${hs.toString()}"></c:out></h4>
<br>

</body>

</html>