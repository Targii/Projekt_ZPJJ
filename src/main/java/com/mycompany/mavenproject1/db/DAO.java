/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1.db;

import com.mycompany.mavenproject1.entity.NoteEntity;
import com.mycompany.mavenproject1.entity.UserEntity;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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
    
    public UserEntity findUserbyCred(String login){
        Query q = em.createNamedQuery("User.byLogin");
        q.setParameter("login", login);
        q.setMaxResults(1);
        List<UserEntity> us = q.getResultList();
        if(us.isEmpty()){
            return null;
        }else{
            return us.get(0);
        }
            
    }
    
        public UserEntity findUserByToken(String token){
            Query q = em.createNamedQuery("User.byToken");
            q.setParameter("token", token);
            q.setMaxResults(1);
            List<UserEntity> us = q.getResultList();
            if(us.isEmpty()){
                return null;
            }else{
                return us.get(0);
            }
            
    }
        public List<NoteEntity> getUserNotes(String login){
            Query q = em.createNamedQuery("Notes.byLogin");
            q.setParameter("login", login);
            List<NoteEntity> ns = q.getResultList();
            if(ns.isEmpty()){
                return null;
            }else{
                return ns;
        }
        }
        
        public NoteEntity getNote(Long id){
            Query q = em.createNamedQuery("Notes.byId");
            q.setParameter("id", id);
            q.setMaxResults(1);
            List<NoteEntity> ns = q.getResultList();
            if(ns.isEmpty()){
                return null;
            }else{
                return ns.get(0);
        }
        }
    
}
