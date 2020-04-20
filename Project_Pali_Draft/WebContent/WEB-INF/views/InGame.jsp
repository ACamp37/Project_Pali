<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import = "com.casestudy.controller.InGameController ,com.casestudy.models.InGameWord, com.casestudy.dao.InGameDAO, 
com.casestudy.services.InGameWordServices"  %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  <!-- THIS GIVES FORM ACCESS TO CONTROLLER (AKA HTML INPUT TO JAVA) -->

<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>Project_Pali</title>
</head>

<body>
<div>
<form:form action="InGameURI" method="POST" modelAttribute = "userInput">
	<h3>Score: <c:out value="${recentScore}"></c:out></h3>
	<h3>High Score(work in progress): <c:out value="${highScore}"></c:out></h3>
	<h3><%= InGameWordServices.gameTimeInSecs %> Seconds Remaining</h3> <!-- CAN'T ANIMATION WITHOUT JS! --><br>
	<h2>${igs}</h2>
	
	<input placeholder = "Enter Word" name = "wordName" id = "gameWord" onblur="this.focus()" autofocus required/> 
	<!-- autofocus required: AUTOFOCUS REQUIRED AFTER EACH ENTER makes focus on the input, required makes sure its not null. 
	     autofocus and required don't work when form taglib using path instead of name.  -->
	</form:form>
	</div>
</body>

</html>