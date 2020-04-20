<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import = "com.casestudy.controller.*,com.casestudy.models.Home, 
com.casestudy.dao.HomeDAO, com.casestudy.services.HomeServices" %>
 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  <!-- THIS GIVES FORM ACCESS TO CONTROLLER (AKA HTML INPUT TO JAVA) -->


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
</head>
<body>

<h1>Project Pali </h1>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<h3>Hello: (Logged In User would go here (Work in Progress))</h3>
<h2><a href="Login">Logout: currently redirects back to login page. Takes no action (Work In Progress)</a></h2>

<br>
<a href="InGamePreGame">Play Game</a><br><br>
<a href="Settings">Settings</a><br><br>
<a href="#">Leaderboards: currently takes no action (Work In Progress)</a><br><br>
<h2>Good luck and have a good time</h2><br>

<h4>A verse from the Good Book: <br><c:out value = "${hs.toString()}"></c:out></h4>
<br>
</body>

</html>