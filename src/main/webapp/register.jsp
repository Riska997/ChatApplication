<%-- 
    Document   : register
    Created on : Aug 24, 2024, 12:36:11 PM
    Author     : Riska
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registration</title>
        <link rel="stylesheet" type="text/css" href="style.css">
    </head>
    <body>

    <c:choose>
        <!-- If there is a success message, display it -->
        <c:when test="${not empty requestScope.successMessage}">
            <h1>${requestScope.successMessage}</h1>
        </c:when>
        <!-- Otherwise, display the registration form -->
        <c:otherwise>
            
            <h1>Registration</h1>

            <form action="register" method="post">
                <label for="username">Username:</label>
                <input type="text" id="username" name="username" required><br>


                <label for="password">Password:</label>
                <input type="password" id="password" name="password" required><br>

                <button type="submit">Register</button>
            </form>
        </c:otherwise>
    </c:choose>
</body>
</html>