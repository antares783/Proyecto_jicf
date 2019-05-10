package com.telcel.gam.siev.vista;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("nuevoSafinController")
@Scope("request")
@Deprecated
public class NuevoSafinController {

	public String submit(){
        System.out.println("andamos paseando por el controller....");
        return "index.xhtml";
        
    }
	
}
