/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;


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
        
    }
*/
    //Apparently this works only when the test() is available... hmm wierd... or not?
    @POST
    @Path("login")
    public Response login(@FormParam("username") String username, @FormParam("password") String password){
        try{
            if(username.equals("adatar") && password.equals("adatar")){ //this seems like a great start of wildfly usage...
                return Response.status(Response.Status.OK).entity("This is rest TEST").build(); 
            }else{
                return Response.status(Response.Status.UNAUTHORIZED).entity("unauthorized").build();
            }
            
        }catch(Exception e){
            
        }
        
   return Response.status(Response.Status.OK).entity("TRY FAILED").build();
    }
    
}


