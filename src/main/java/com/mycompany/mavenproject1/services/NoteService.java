/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1.services;

import com.mycompany.mavenproject1.db.DAO;
import com.mycompany.mavenproject1.entity.NoteEntity;
import com.mycompany.mavenproject1.entity.UserEntity;
import com.mycompany.mavenproject1.models.NoteDTO;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Adam
 */
@Stateless
public class NoteService {

    @Inject
    private DAO dao;

    public NoteDTO createNote(NoteDTO noteDTO, String token) {
        NoteEntity noteEntity = new NoteEntity();
        UserEntity user = dao.findUserByToken(token);
        noteDTO.setLogin(user.getLogin());
        noteDTO.getForEntity(noteEntity);

        dao.create(noteEntity);
        return new NoteDTO().getForRestJson(noteEntity);
    }

    public List<NoteDTO> listnotes(String token) {
        UserEntity user = dao.findUserByToken(token);
        List<NoteEntity> notes = dao.getUserNotes(user.getLogin());
        List<NoteDTO> notesDTO = new ArrayList<>();
        //notes.forEach(note -> notesDTO.add(new NoteDTO().getForRestJson(note)));  <-- Not supported for source 1.7
        for (NoteEntity x : notes) {
            notesDTO.add(new NoteDTO().getForRestJson(x));
        }

        return notesDTO;
    }

    public NoteDTO myNote(Long id) {
        NoteEntity note = dao.getNote(id);
        return new NoteDTO().getForRestJson(note);
    }

}
