/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;

import com.mycompany.mavenproject1.entity.UserEntity;
import com.mycompany.mavenproject1.models.UserDTO;
import com.mycompany.mavenproject1.services.UserService;
import java.net.URI;
import java.security.MessageDigest;
import java.util.Arrays;
import javax.inject.Inject;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import javax.xml.bind.DatatypeConverter;


/**
 *
 * @author Adam
 *
 */
@Path("/")
public class RestControl {
    /*
    @GET
    @Path("/")
    public Response test(){
        return Response.status(200).entity("test").build();
                try{
            if(username.equals("adatar") && password.equals("adatar")){ //this seems like a great start of wildfly usage...
                return Response.status(Response.Status.OK).entity("This is rest TEST").build(); 
            }else{
                return Response.seeOther(URI.create("../login.html")).build();
            }
            
        }catch(Exception e){
            
        }
    }
*/
    //Apparently this works only when the test() is available... hmm wierd... or not?
    @POST
    @Path("login")
    public Response login(@FormParam("username") String username, @FormParam("password") String password){
        try{
            UserEntity response = service.loginUser(username, password);
            if(response != null){
            return Response.seeOther(URI.create("../page.html")).build();
            }else{
               
                return Response.seeOther(URI.create("../error.html")).build();
            }
        }catch(Exception ex){
            return Response.seeOther(URI.create("../error.html")).build();
        }
        
        

        
   
    }
    
    @Inject
    UserService service;
    
    
    @POST
    @Path("all")
    public Response signup(@FormParam("login") String login, @FormParam("firstName") 
            String firstName, @FormParam("lastName") String lastName, @FormParam("email") String email ,@FormParam("password") String password){
        
        UserDTO userDTO = new UserDTO();
                
        userDTO.setEmail(email);
        userDTO.setFirstName(firstName);
        userDTO.setLastName(lastName);
        userDTO.setLogin(login);
        userDTO.setPassword(UserService.hashSHA(password));
                
        try{
            UserDTO response = service.createUser(userDTO);
            return Response.seeOther(URI.create("../created.html")).build();
        }catch(Exception ex){
            return Response.serverError().build();
        }
        
        
        
    }

    
}


