/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1.models;

/**
 *
 * @author Adam
 */
public interface Map<S,T> {
    public T getForRestJson(S entity);
    public void getForEntity(S entity);
    
}
