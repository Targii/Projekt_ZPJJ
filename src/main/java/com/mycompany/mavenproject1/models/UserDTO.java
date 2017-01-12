/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.mavenproject1.models;
import com.mycompany.mavenproject1.entity.UserEntity;
/**
 *
 * @author Adam
 */
public class UserDTO implements Map<UserEntity, UserDTO>{
    private Long id;
    private String login;
    private String firstName;
    private String lastName;
    private String email;
    
    @Override
    public UserDTO getForRestJson(UserEntity entity){
        this.id = entity.getId();
        this.login = entity.getLogin();
        this.firstName = entity.getFirstName();
        this.lastName = entity.getLastName();
        this.email = entity.getEmail();
        return this;
    }
    
    @Override
    public void getForEntity(UserEntity entity){
        entity.setLogin(login);
        entity.setFirstName(firstName);
        entity.setLastName(lastName);
        entity.setEmail(email);
    }
    
    
            
            
    public void setId(Long id) {
        this.id = id;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    
}
