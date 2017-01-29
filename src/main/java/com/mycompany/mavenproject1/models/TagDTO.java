/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1.models;

import com.mycompany.mavenproject1.entity.TagEntity;
import com.mycompany.mavenproject1.entity.UserEntity;

/**
 *
 * @author Adam
 */
public class TagDTO implements Map<TagEntity, TagDTO>{
    private Long id;
    private String tag;
    private String notes;
    
    @Override
    public TagDTO getForRestJson(TagEntity entity) {
        this.id = entity.getId();
        this.tag = entity.getTag();
        this.notes = entity.getNotes();
        return this;
    }

    @Override
    public void getForEntity(TagEntity entity) {
        entity.setId(id);
        entity.setTag(tag);
        entity.setNotes(notes);
    }

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    
}
