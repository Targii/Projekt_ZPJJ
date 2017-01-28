/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Adam
 */
@Entity
@Table(schema = "web", name = "notes")
      
public class NoteEntity implements Serializable{
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    
    @Column(name = "login")
    private String login;
    
    @Column(name = "title")
    private String title;
    
    @Column(name = "text")
    private String text;

    @Column(name = "ispublic")
    private String ispublic;

    @Column(name = "editableby")
    private String editableby;

    @Column(name = "viewableby")
    private String viewableby;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
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

    public void setEditableby(String editableyy) {
        this.editableby = editableby;
    }

    public void setViewableby(String viewableby) {
        this.viewableby = viewableby;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
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
