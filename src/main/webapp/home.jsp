<%-- 
    Document   : home
    Created on : Aug 25, 2024, 9:10:34 AM
    Author     : Riska
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
        <link rel="stylesheet" type="text/css" href="style.css">
    </head>
    <body>
        <h1>Welcome, ${username}!</h1>
        <nav>
            <a href="conversations">Conversations</a> |
            <a href="camera">Camera</a> |
            <a href="${pageContext.request.contextPath}/home?action=logout">Logout</a>
        </nav>
    </body>
</html>
