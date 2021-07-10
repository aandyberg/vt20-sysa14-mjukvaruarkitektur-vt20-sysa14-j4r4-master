<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/Test.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src=""></script>
</head>
<body>
<%@include file = "Header.jsp" %>
<div class="main">
<div class="link">
<a id ="restService" href="Rest.jsp">Rest service</a></div>
<p>Select and run test<br><br></p>
<form action="TestServlet" method="get" name="youPickItForm">
<select id="suite" name="suite" size="1" multiple>
<option value="com.coolcars.test.CCTest"> Facade test</option>
</select>
<div>
<input type="submit" value="Run"/>
</div>
</form>
</div>
</body>
<footer>
  &copy; 2020 CoolCars Lund
</footer>
</html>