/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1.endpoints;

import com.mycompany.mavenproject1.models.NoteDTO;
import com.mycompany.mavenproject1.services.NoteService;
import com.sun.net.httpserver.Headers;
import java.net.URI;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Adam
 */
@RequestScoped
@Path("note")
@Produces(MediaType.APPLICATION_JSON)
public class NoteEndpoint extends BaseEndpoint{
    
    @Context
    private HttpHeaders headers;
    
    @Inject
    NoteService service;
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addNote(NoteDTO noteDTO){
        
        
        try{
            String token = headers.getHeaderString("Session-token");
            
            NoteDTO response = service.createNote(noteDTO,token);
            
            Response.accepted().entity(response).build();
            return Response.accepted().entity(noteDTO).build();
        }catch(Exception ex){
            return Response.serverError().build();
        }
           
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("mynotes")
    public Response listMyNotes(){
        String token = headers.getHeaderString("Session-token");
        List<NoteDTO> response = service.listnotes(token);
        return Response.accepted().entity(response).build();
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("onenote")
    public Response myNote(){
        String token = headers.getHeaderString("Session-token");
        Long id = Long.parseLong(headers.getHeaderString("Note-id"));
        NoteDTO noteDTO = service.myNote(id);
        return Response.accepted().entity(noteDTO).build();
    }
    
    
}
