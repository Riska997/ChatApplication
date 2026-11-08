/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.chatapplication.websocket;

import jakarta.json.Json;
//import jakarta.websocket.EncodeException;
//import jakarta.websocket.EndpointConfig;
import com.mycompany.chatapplication.models.Message;
import jakarta.websocket.*;

/**
 *
 * @author Riska
 */
public class MessageEncoder implements Encoder.Text<Message> {
    
    @Override
    public void init(final EndpointConfig config) {
        // Initialization logic if needed
    }

    @Override
    public void destroy() {
        // Cleanup logic if needed
    }

    @Override
    public String encode(final Message chatMessage) throws EncodeException {
        // Access the username from the Users object within Message
        String username = chatMessage.getSender() != null ? chatMessage.getSender().getUsername() : "unknown";
        
        return Json.createObjectBuilder()
                .add("message", chatMessage.getContent())
                .add("sender",  username)
                .build()
                .toString();
    }
    
}
