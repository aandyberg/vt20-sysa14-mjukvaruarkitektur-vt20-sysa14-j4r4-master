<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/Login.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="js/login.js"></script>
</head>
<%@include file = "Header.jsp" %>
<body>
	<div class="main">
    <form action="<%= request.getContextPath() %>/CCServlet" method="post">
    	<h1>Login</h1>
    	<input type="text" name="textusername" id="textusername" placeholder="Username/pid" required>
        <input type="password" name="textpassword" id="textpassword" placeholder="Password" required>
        <input type="submit" name="btnlogin" id="btnlogin" value="Login">
        <input type="button" name="btnregister" id="btnregister" value="Register">
        <input type="hidden" name="operation" value="login">
    </form>
	</div>
</body>
<footer>
  &copy; 2020 CoolCars Lund
</footer>
</html>
