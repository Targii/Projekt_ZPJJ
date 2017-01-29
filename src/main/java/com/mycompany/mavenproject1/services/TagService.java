/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1.services;

import com.mycompany.mavenproject1.db.DAO;
import com.mycompany.mavenproject1.entity.NoteEntity;
import com.mycompany.mavenproject1.entity.TagEntity;
import com.mycompany.mavenproject1.models.NoteDTO;
import com.mycompany.mavenproject1.models.TagDTO;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Adam
 */
@Stateless
public class TagService {

    @Inject
    private DAO dao;

    public void createTags(String tags, Long id) {
        boolean isfound;
        List<TagEntity> tagList = dao.allTags();
        List<String> newTags = Arrays.asList(tags.split(","));
        if (tagList != null) {
            for (String newSingleTag : newTags) {
                isfound = false;
                for (TagEntity oldExistingTag : tagList) {
                    if (oldExistingTag.getTag().equals(newSingleTag)) {
                        isfound = true;
                        oldExistingTag.setNotes(oldExistingTag.getNotes() + "," + id);
                        dao.edit(oldExistingTag);
                    }
                }
                if (isfound == false) {
                    TagEntity newlyAddedTag = new TagEntity();
                    newlyAddedTag.setTag(newSingleTag);
                    newlyAddedTag.setNotes(id.toString());
                    dao.create(newlyAddedTag);
                }
            }
        } else {
            for (String newSingleTag : newTags) {
                TagEntity newlyAddedTag = new TagEntity();
                newlyAddedTag.setTag(newSingleTag);
                newlyAddedTag.setNotes(id.toString());
                dao.create(newlyAddedTag);
            }

        }
    }
    
    public List<NoteDTO> getNotesByTag(String tag){
        TagEntity te = dao.getNoteIdByTag(tag);
        List<String> notesIdList = Arrays.asList(te.getNotes().split(","));
        List<NoteDTO> noteEntitys = new ArrayList<>();;
        for(String id: notesIdList){
            noteEntitys.add(new NoteDTO().getForRestJson(dao.getNote(Long.parseLong(id))));
        }
        return noteEntitys;
        
    }
    


}
