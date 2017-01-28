/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1.endpoints;

import io.swagger.annotations.Api;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
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
@Api("Core Endpoints")
@Path("core")
public class CoreEndpoint {
    @Context
    protected HttpServletRequest servletRequest;
    
    public HttpServletRequest getServletRequest() {
        return servletRequest;
    }
    
    @Context
    private HttpHeaders headers;
    
    
    @GET
    @Path("login")
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(){
        
        return null;
    }
    
}
