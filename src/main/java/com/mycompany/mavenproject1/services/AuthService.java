/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1.services;

import com.mycompany.mavenproject1.db.DAO;
import com.mycompany.mavenproject1.entity.UserEntity;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Adam
 */
@Stateless
public class AuthService {
    
    @Inject
    private DAO dao;
    
    public String checkToken(String token){
        UserEntity user = dao.findUserByToken(token);
        return user.getLogin();
    }
    
}
