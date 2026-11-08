<%-- 
    Document   : login
    Created on : Aug 24, 2024, 12:33:07 PM
    Author     : Riska
--%>

<<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login - Mzansi Chat Zone</title>
        <link rel="stylesheet" type="text/css" href="style.css">

    </head>
    <body>

        <div class="login-container">
            <h1>Mzansi Chat Zone</h1>
            <form action="login" method="post">
                <input type="text" placeholder="Username" name="username" required>
                <input type="password" placeholder="Password" name="password" required>
                <button type="submit" class="button login-button">Login</button><br><br>
                <a href="register.jsp" class="button register-button">Register</a>
            </form>
            <c:if test="${not empty requestScope.errorMessage}">
                <p style="color:red">${requestScope.errorMessage}</p>
            </c:if>
        </div>
    </body>
</html>
