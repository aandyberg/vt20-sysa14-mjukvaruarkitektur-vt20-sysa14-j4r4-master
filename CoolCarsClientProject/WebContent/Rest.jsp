<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style>
</style>
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="js/Rest.js"></script>
 <link rel="stylesheet" type="text/css" href="css/Rest.css">
<meta charset="ISO-8859-1">
<title>CoolCars Rest</title>
</head>
<body>
<div class="link">
<a id="coolCars" href="Test.jsp">Go back to Cool Cars</a></div>
<header>
<p>Rest service</p>
</header>
<section id="row">
<section id="main">
<section id="content">
<article>
<fieldset id="PersonalFS">
<legend>Person:</legend>
Pid:<br>
<input type="text" name="pid" id="pid" value=""><br>
Name:<br><input type="text" name="name" id="name" value=""><br>
Email:<br>
<input type="text" name="email" id="email" value=""><br>
Password:<br>
<input type="text" name="password" id="password" value=""><br>
<br><br>
<input type="button" name="submitBtn" value="Find" id="FindBtn">
<input type="button" name="submitBtn" value="Add" id="AddBtn">
<input type="button" name="submitBtn" value="Delete" id="DeleteBtn">
<input type="button" name="submitBtn" value="Update" id="UpdateBtn">
</fieldset>
</article>
</section>
</section>
</section>
<footer>
&copy; 2020 CoolCars Lund
</footer></body></html>