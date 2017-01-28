/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1.models;

import com.mycompany.mavenproject1.entity.NoteEntity;



/**
 *
 * @author Adam
 */
public class NoteDTO implements Map<NoteEntity, NoteDTO>{
    private Long id;     
    private String login;
    private String title;
    private String text;
    private String ispublic;
    private String editableby;
    private String viewableby;

    @Override
    public NoteDTO getForRestJson(NoteEntity entity) {
        this.id = entity.getId();
        this.login = entity.getLogin();
        this.title = entity.getTitle();
        this.text = entity.getText();
        this.ispublic = entity.getIspublic();
        this.editableby = entity.getEditableby();
        this.viewableby = entity.getViewableby();
        return this;  
    }

    @Override
    public void getForEntity(NoteEntity entity) {
        entity.setId(id);
        entity.setLogin(login);
        entity.setTitle(title);
        entity.setText(text);
        entity.setIspublic(ispublic);
        entity.setEditableby(editableby);
        entity.setViewableby(viewableby);
        
    }
    
    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
    public void setEditableby(String editableby) {
        this.editableby = editableby;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setIspublic(String ispublic) {
        this.ispublic = ispublic;
    }

    public void setViewableby(String viewableby) {
        this.viewableby = viewableby;
    }

    public Long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getTitle() {
        return title;
    }

    public String getIspublic() {
        return ispublic;
    }

    public String getEditableby() {
        return editableby;
    }

    public String getViewableby() {
        return viewableby;
    }

}
