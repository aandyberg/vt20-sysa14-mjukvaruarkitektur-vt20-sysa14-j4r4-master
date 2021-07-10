<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/Homepage.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
</head>
<%@include file = "Header.jsp" %>
<body>
<h1>Welcome to Cool Cars!</h1>
<p>We are the best car rental agency in Lund <br><br> Browse our car collection here <br> <br> <br>
<a href ="Cars.jsp" class="buttons">Browse our car collection</a>
<c:if test="${empty sessionScope.user}">
<a href ="RegistrationForm.jsp" class="buttons">Register now</a>
						</c:if>
</p>
</body>
<footer>
  &copy; 2020 CoolCars Lund
</footer>
</html>
