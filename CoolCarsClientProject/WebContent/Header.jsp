<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="css/HeaderFooter.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="js/HeaderFooter.js"></script>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta charset="ISO-8859-1">
    <title></title>
</head>
<body>
<header>
        <div class="upper-header">
            <aside>
                <table id="asideTable">
                    <tr>
                        <th><span id="city"></span></th>
                        <th><span></span></th>
                        <th><span></span></th>
                        <th><span id="ipNbr"></span></th>
                        </tr>
                        <tr>
                            <td><span id="degree"></span></td>
                            <td><span id="weather"></span></td>
                            <td><span></span></td>
                            <td><span></span></td>
                        </tr>
                        <tr>
                            <td colspan="4"><span id="sunrise"></span></td>
                        </tr>
                        <tr>
                            <td colspan="4"><span id="sunset"></span></td>
                        </tr>
                    </table>
                </aside>
            <div class="inner-upper-header">
            <a href ="Homepage.jsp">
                <img src="images/Cool_cars_logo_white.png" alt="CoolCars logo"></a>
            </div>
            <div class="line"></div>
            <div class="lower-header">
                <nav>
                    <ul class="navigation">
                        <li><a href=Homepage.jsp>Home</a></li>
                        <li><a href="Cars.jsp">Cars</a></li>
                        <li><a href="Test.jsp">Test</a></li>
                        <li><a href="about.jsp">About</a></li>
                    </ul>
                    <ul class="userlogin">
                        <li><a href="CCServlet?operation=myprofile">My page</a></li>
                        <c:if test="${empty sessionScope.user}">
							<li id="loginNav"><a href=Login.jsp>Login</a></li>
						</c:if>
                       	<c:if test="${not empty sessionScope.user}">
							<li id="logoutNav"><a href="CCServlet?operation=logout">Logout</a></li>
						</c:if>
                        
                    </ul>
                </nav>
            </div>
        </div>
</header>
</body>
</html>
