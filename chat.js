// chat.js

var socket;

function connect() {
    socket = new WebSocket("ws://" + window.location.host + window.contextPath + "/chat");
    socket.onmessage = function(event) {
        var chatArea = document.getElementById("chatArea");
        chatArea.value += event.data + "\n";
    };
}

function sendMessage() {
    var messageInput = document.getElementById("messageInput");
    var username = window.username;
    var message = username + ": " + messageInput.value;
    socket.send(message);
    messageInput.value = "";
}

window.onload = function() {
    connect();
};
