/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1.endpoints;

/**
 *
 * @author Adam
 */


import com.mycompany.mavenproject1.models.NoteDTO;
import com.mycompany.mavenproject1.services.TagService;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@RequestScoped
@Path("tag")
@Produces(MediaType.APPLICATION_JSON)
public class TagEndpoint extends BaseEndpoint{
    
    @Context
    private HttpHeaders headers;
    
    @Inject
    TagService tagservice;
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("searchtags")
    public Response getByTag(){
        String token = headers.getHeaderString("Session-token");
        String tag = headers.getHeaderString("Tag-Content");
        
        List<NoteDTO> response = tagservice.getNotesByTag(tag);
        
        return Response.accepted().entity(response).build();
    }
    
}
