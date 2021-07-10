<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/About.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
</head>
<body>
<%@include file = "Header.jsp" %>
<div class= "main">
<div class="about-section">
<h1>About Us</h1>
<p>CoolCars is a company located in the city of Lund in southern Sweden with the ambition to become the leading car rental company in the county.<br>Address: Stora Gråbrödersgatan 5, Lund <br>If you have any questions, call us on: 0736214032</p>
</div>
<div class ="lower">
<h2>Our Team</h2><br>
<iframe id ="map" src="https://www.google.com/maps/embed?
pb=!1m18!1m12!1m3!1d71935.24572922922!2d13.12795637148307!3d55.70678147306483!2m3!1f0!2f0!3f0!3m2!1i1024!2i76
8!4f13.1!3m3!1m2!1s0x4653907c03e75a3b%3A0x4019078290e7a70!2sLund!5e0!3m2!1sen!2sse!4v1587421639334!5m2!1se
n!2sse" width="600" height="450" frameborder="0" style="border:0;" allowfullscreen="" aria-hidden="false" tabindex="0"></iframe>
<div class="card">
<h3>Alexander Kvarnmark</h3>
<p class="title">Marketing Manager</p>
<P>Email: Alexander@gmail.com</p>
</div>
<br>
<div class="card">
<h3>Andreas Berg</h3>
<p class="title">Customer Service</p>
<P>Email: Andreas@gmail.com</p>
</div>
<br>
<div class="card">
<h3>Jakob Andersson</h3>
<p class="title">Founder</p>
<P>Email: Jakob@gmail.com</p>
</div>
<br>
<div class="card">
<h3>Rasmus Holmqvist</h3>
<p class="title">Accountant</p>
<P>Email: Rasmus@gmail.com</p>
</div>
</div>
</div>
<br>
</body>
<footer>
  &copy; 2020 CoolCars Lund
</footer>
</html>