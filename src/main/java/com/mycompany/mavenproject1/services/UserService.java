/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1.services;

import com.mycompany.mavenproject1.db.DAO;
import com.mycompany.mavenproject1.entity.UserEntity;
import com.mycompany.mavenproject1.models.UserDTO;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Adam
 */
@Stateless
public class UserService {
    //Wstrzykiwanie DAO
    @Inject
    private DAO dao;
    
    public UserDTO createUser(UserDTO userDTO){
        UserEntity userEntity = new UserEntity();
        userDTO.getForEntity(userEntity);
        dao.create(userEntity);
        return new UserDTO().getForRestJson(userEntity);
    }
    
    public UserEntity loginUser(String login, String password){
        UserEntity user = dao.findUserbyCred(login);
        if(password.equals(user.getPassword())){
            return user;    
        }
        else {
            return null;
        }
        
        
    }
    

    
}
