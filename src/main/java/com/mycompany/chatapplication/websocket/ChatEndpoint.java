package com.mycompany.chatapplication.websocket;

/*import jakarta.websocket.OnClose;
import jakarta.websocket.OnMessage;
import jakarta.websocket.OnOpen;
import jakarta.websocket.Session;
import jakarta.websocket.server.ServerEndpoint;*/
import jakarta.websocket.*;
import jakarta.websocket.server.ServerEndpoint;
//import jakarta.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Riska
 */

@ServerEndpoint(
        value = "/chat",
        encoders = {MessageEncoder.class},
        decoders = {MessageDecoder.class}
)

public class ChatEndpoint {
    
     private static Set<Session> clients = new CopyOnWriteArraySet<>();

    @OnOpen
    public void onOpen(Session session) {
        clients.add(session);
    }

    @OnMessage
    public void onMessage(String message, Session session) throws IOException {
        // Broadcast the message to all connected clients
        for (Session s : clients) {
            if (!s.equals(session)) {
                try {
                    s.getBasicRemote().sendObject(message);
                } catch (IOException | EncodeException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @OnClose
    public void onClose(Session session) {
        clients.remove(session);
    }

    @OnError
    public void onError(Session session, Throwable throwable) {
        // Handle error
        throwable.printStackTrace();
    }

    private void broadcastMessage(String message, Session senderSession) throws IOException {
        for (Session session : clients) {
            if (session.isOpen() && !session.equals(senderSession)) {
                session.getBasicRemote().sendText(message);
            }
        }
    }
    
}
