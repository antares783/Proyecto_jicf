/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.telcel.gam.siev.vista;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.telcel.gam.siev.pojos.CreditCheckPojo;

/**
 *
 * @author VI8G023
 */
@Component("creditCheckController")
@Scope("request")
@Deprecated
public class CreditCheckController {
    
    @Getter @Setter
    private CreditCheckPojo creditCheckPojo;
    
    public void init(){
    
        creditCheckPojo = new CreditCheckPojo();
        
    }
    
}
