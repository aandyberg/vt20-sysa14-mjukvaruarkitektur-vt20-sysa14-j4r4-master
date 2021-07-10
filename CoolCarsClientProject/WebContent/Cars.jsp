<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/Cars.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="js/Cars.js"></script>
</head>
<body>
<%@include file = "Header.jsp" %>
<div class="main">
<div class="introText">
<p>At CoolCars it is easy to rent an amazing car at any time. <br><br>Minimum fee for renting a car is the daily fee. <br><br>Browse our available cars below for a car you like and simply press rent.<br> <br>Note that you need to be logged in order to rent a car. <br><br>An invoice will be sent to your registered e-mail after you cancel your rental. <br><br>Happy driving!
</div>
<table id="carTable">
<thead>
<tr id="trAvailableCars">
<th colspan="4">Available cars</th></tr>
    <tr>
      <th>Model</th>
      <th>License number</th>
      <th>Price</th>
      <th></th>
    </tr>
</thead>
<tbody id="tbody">


</tbody>
</table>
</div>
</body>
<footer>
  &copy; 2020 CoolCars Lund
</footer>
</html>