/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.chatapplication.websocket;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.websocket.DecodeException;
import jakarta.websocket.Decoder;
import jakarta.websocket.EndpointConfig;
import java.io.StringReader;
import com.mycompany.chatapplication.models.Message;
import com.mycompany.chatapplication.models.Users;
//import jakarta.json.*;
//import jakarta.websocket.*;
import jakarta.persistence.*;

/**
 *
 * @author Riska
 */
public class MessageDecoder implements Decoder.Text<Message>{
    
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("YourPersistenceUnit");
    
    @Override
    public void init(final EndpointConfig config) {
        // Initialization logic if needed
    }

    @Override
    public void destroy() {
        // Cleanup logic if needed
    }

    @Override
    public Message decode(final String textMessage) throws DecodeException {
      JsonObject obj = Json.createReader(new StringReader(textMessage)).readObject();
        
      String senderUsername = obj.getString("sender");
        String messageContent = obj.getString("message");
        
        // Fetch the Users object
        Users sender = getUserUsername(senderUsername);
        
        
      //Objects for users and messages
       Message chatMessage = new Message();
        chatMessage.setContent(obj.getString("message"));
        chatMessage.setSender(sender);
        
        return chatMessage;
    }

    @Override
    public boolean willDecode(final String s) {
        return (s != null);
    }

    private Users getUserUsername(String username) {
        EntityManager em = emf.createEntityManager();
        
        //handling exceptions
        try {
            TypedQuery<Users> query = em.createQuery("SELECT u FROM Users u WHERE u.username = :username", Users.class);
            query.setParameter("username", username);
            return query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null; 
        } finally {
            em.close();
        }
    }
}
