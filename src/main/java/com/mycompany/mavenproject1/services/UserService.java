/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1.services;

import com.mycompany.mavenproject1.RestControl;
import com.mycompany.mavenproject1.db.DAO;
import com.mycompany.mavenproject1.entity.UserEntity;
import com.mycompany.mavenproject1.models.UserDTO;
import java.security.MessageDigest;
import java.sql.Timestamp;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.xml.bind.DatatypeConverter;

/**
 *
 * @author Adam
 */
@Stateless
public class UserService {

    //Wstrzykiwanie DAO
    @Inject
    private DAO dao;

    public UserDTO createUser(UserDTO userDTO) {
        UserEntity userEntity = new UserEntity();
        userDTO.getForEntity(userEntity);
        dao.create(userEntity);
        return new UserDTO().getForRestJson(userEntity);
    }

    public String loginUser(String login, String password) {
        UserEntity user = dao.findUserbyCred(login);
        String token = hashSHA(password + user.getEmail() + new Timestamp(System.currentTimeMillis()).getTime());
        user.setToken(token);
        if (hashSHA(password).equals(user.getPassword())) {
            return token;
        } else {
            return null;
        }

    }

    public static String hashSHA(String password) {
        try {
            return DatatypeConverter.printHexBinary(MessageDigest.getInstance("SHA-256").digest(password.getBytes("UTF-8")));
        } catch (Exception e) {

        }
        return null;
    }

}
