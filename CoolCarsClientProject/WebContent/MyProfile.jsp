<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.coolcars.ejb.Person" %>
<!DOCTYPE html>
<html>
<head>

<meta name="viewport" content="width=device-width, initial-scale=1.0">
 <link rel="stylesheet" type="text/css" href="css/MyProfile.css">
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
 <script src="js/MyProfile.js"></script>
  
  

<meta charset="ISO-8859-1">

</head>
<title>My profile</title>

<%@include file = "Header.jsp" %>
<body>
<div class="main">
<div id="userProfile">
<form action="<%= request.getContextPath() %>/CCServlet" method="POST" id="userinformation">
<fieldset>
	<span class="label"> Logged in as</span>
	<input type="text" class="readonly" name ="userPid" value="${sessionScope.user.pId}" readonly><br>
	<span class="label">Name</span>
	<input type="text" name ="userName" id="textname" value="${sessionScope.user.name}"><br>
	<span class="label">Email</span>
	<input type="text" name ="userEmail" id="textemail" value="${sessionScope.user.email}"><br>
	<input type="hidden" name="operation" value="updateProfile">
	<input type="submit" name="updateUser" value="Update information">
	</fieldset>
</form>

</div>
<h1>Your current rentals</h1>
<table id="userCars">
<thead>
<tr>
<th>Model</th>
<th>License number</th>
<th>Price</th>
</tr>
</thead>
<tbody>
<c:forEach items="${sessionScope.user.getCars()}" var="car">
	<tr id="row"${car.licenseNbr}>
		<td>${car.brand}</td>
        <td>${car.licenseNbr}</td>
        <td>${car.price} kr/day</td>
        <td>
            <form action="CCServlet" method="post">
                <input type="hidden" name="licenseNbr" value="${car.licenseNbr}">
                <input type="submit" name="operation" value="Cancel rent" id="btnCancel">
            </form>
        </td>
   </tr>
</c:forEach>
</tbody>
</table>

</div>
</body>
<footer>
  &copy; 2020 CoolCars Lund
</footer>
</html>
