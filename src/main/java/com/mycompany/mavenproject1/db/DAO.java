/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1.db;

import java.io.Serializable;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Adam
 */
@Stateless
public class DAO {
    @PersistenceContext
    protected EntityManager em;
    
    //Stworzenie w bazie
    public void create(Serializable entity){
        em.persist(entity);
    }
    
    public <T> T find(long id, Class<T> clazz){
        return em.find(clazz, id);
    }
    
}
