/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;

import com.mycompany.mavenproject1.endpoints.UserEndpoint;
import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
/**
 *
 * @author Adam
 */
@ApplicationPath("rest")
public class JaxRsActivator extends Application{
    
    @Override
    public Set<Class<?>> getClasses(){
        Set<Class<?>> s = new HashSet<>();
        addRestResourceClasses(s);
        return s;
    }
    
    private void addRestResourceClasses(Set<Class<?>> resources){
        //resources.add(com.mycompany.mavenproject1.RestControl.class);
        resources.add(com.mycompany.mavenproject1.RestControl.class);
        resources.add(com.mycompany.mavenproject1.endpoints.CoreEndpoint.class);
        resources.add(com.mycompany.mavenproject1.endpoints.UserEndpoint.class);
        resources.add(com.mycompany.mavenproject1.providers.JacksonJsonProvider.class);
    }
    
    
    
}
