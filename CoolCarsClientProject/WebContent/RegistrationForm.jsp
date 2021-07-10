<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
  <link rel="stylesheet" href="css/RegistrationForm.css">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js">
  </script>
  <script src="js/RegistrationForm.js"></script>
  <title>Registration</title>
</head>
<body>
<%@include file = "Header.jsp" %>
<div class="main">
  <form action="<%= request.getContextPath() %>/CCServlet" method="post" id="registration">
  	<table id="registrationTable">
  		<tr>
  			<th id="regHead">Register new user</th>
  		</tr>
    	<tr><td><input type="text" name="textpid" id="textpid" maxlength="10" placeholder="pId 10 digits" required></td>
    	<td id="errorMessage">${requestScope.errorMessage}</td></tr>
    	<tr><td><input type="text" name="textname" id="textname" maxlength="100" placeholder="name" required></td></tr>
    	<tr><td><input type="text" name="textemail" id="textemail" maxlength="100" placeholder="email" required></td></tr>
    	<tr><td><input type="password" name="textpassword" id="textpassword" maxlength="100" placeholder="password" required></td></tr>
    	<tr><td><input type="submit" name="btnregister" id="btnregister" value="Register"></td></tr>
  	</table>
    <input type="hidden" name="operation" value="registerperson">
  </form>
  </div>
</body>
<footer>
  &copy; 2020 CoolCars Lund
</footer>
</html>
