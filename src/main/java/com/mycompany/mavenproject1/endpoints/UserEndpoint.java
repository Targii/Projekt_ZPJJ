/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1.endpoints;

import com.mycompany.mavenproject1.models.UserDTO;
import com.mycompany.mavenproject1.services.UserService;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;


/**
 *
 * @author Adam
 */
@RequestScoped
@Path("user")
public class UserEndpoint {
    
    @Inject
    UserService service;
    
    @POST
    public Response addUser(UserDTO userDTO){
        try{
            UserDTO response = service.createUser(userDTO);
            return Response.accepted().entity(response).build();
        }catch(Exception ex){
            return Response.serverError().build();
        }
           
    }
    

    
}
