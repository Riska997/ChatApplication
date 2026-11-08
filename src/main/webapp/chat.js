
var socket;

// Function to establish a WebSocket connection
function connect() {
    // Construct the WebSocket URL dynamically
    socket = new WebSocket("ws://" + window.location.host + window.contextPath + "/chat");

    // Define the behavior when a message is received from the server
    socket.onmessage = function (event) {
        var chatWindow = document.getElementById("chat-window");
        var message = document.createElement("div");
        message.textContent = event.data;
        chatWindow.appendChild(message);
    };
}

// Function to send a message to the server
function sendMessage() {
    var messageInput = document.getElementById("message");
    var username = window.username || "Anonymous"; // Ensure there's a default username
    var message = {
        sender: username,
        message: messageInput.value
    };
    //socket.send(message);
    //messageInput.value = "";

    socket.send(JSON.stringify(message));
    messageInput.value = "";

}

// Establish the WebSocket connection when the page loads
window.onload = function () {
    connect();
};
