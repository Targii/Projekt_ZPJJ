/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1.endpoints;

import com.mycompany.mavenproject1.models.NoteDTO;
import com.mycompany.mavenproject1.services.NoteService;
import java.net.URI;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Adam
 */
@RequestScoped
@Path("note")
public class NoteEndpoint extends BaseEndpoint{
    
    @Inject
    NoteService service;
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addNote(NoteDTO noteDTO){
        
        try{
            NoteDTO response = service.createNote(noteDTO);
            Response.accepted().entity(response).build();
            return Response.accepted().entity(noteDTO).build();
        }catch(Exception ex){
            return Response.serverError().build();
        }
           
    }
    
}
