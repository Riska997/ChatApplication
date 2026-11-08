<%-- 
    Document   : conversations
    Created on : Aug 25, 2024, 9:11:17 AM
    Author     : Riska
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Conversations</title>
        <link rel="stylesheet" type="text/css" href="style.css">
        <script type="text/javascript">
        window.contextPath = "${pageContext.request.contextPath}";
        window.username = "${username}";
        </script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/chat.js"></script>
    </head>
    <body>
        <h1>Welcome to the Chat, ${username}!</h1>

        <textarea id="chatArea" rows="20" cols="50" readonly></textarea><br>

        <input type="text" id="messageInput" placeholder="Type your message here..." onkeydown="if (event.keyCode === 13)
                sendMessage();">

        <button onclick="sendMessage()">Send</button>
    </body>
</html>