/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.chatapplication.utils;

import jakarta.persistence.*;
/*import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;*/

/**
 *
 * @author Riska
 */
public class DBManager {
    
    // Declaration of EntityManagerFactory
    private static final EntityManagerFactory em = Persistence.createEntityManagerFactory("chat-unit");

    // Method to create EntityManager
    public static EntityManager getEntityManager() {
        return em.createEntityManager();
    }

    // Method to close EntityManager
    public static void closeEntityManager(EntityManager em) {
        if (em != null) {
            em.close();
        }
    }

    /* Method to close EntityManagerFactory
    public static void closeEntityManagerFactory() {
        if (emf != null && emf.isOpen()) {
            emf.close();
        }
    }*/
    
}
