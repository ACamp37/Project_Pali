<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import = "com.casestudy.controller.InGameController ,com.casestudy.models.InGameWord, com.casestudy.dao.InGameDAO, 
com.casestudy.services.InGameWordServices"  %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>InGame PostGame</title>
</head>

<body>
<h1>Here are your results, Thanks for playing</h1>
<h2>Score: <c:out value="${recentScore}"></c:out></h2>
<h2><a href="InGameGuestURI">Play Again</a></h2><br>
<h2><a href="HomePageGuest">Return Home</a></h2>
</body>

</html>