/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.telcel.gam.siev.bo;

import javax.xml.bind.JAXBElement;
import javax.xml.datatype.DatatypeConfigurationException;


import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import com.telcel.gam.siev.SafinClient;
import com.telcel.gam.siev.SafinConfig;
import com.telcel.gam.siev.ws.ConsultarCreditoResponse;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author VI8G023
 */
@Deprecated
public class ConsultaSafinBOImpl extends WebServiceGatewaySupport {
    
//	public static void main(String args[]) {
//		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SafinConfig.class);
//		SafinClient client = context.getBean(SafinClient.class);
//		try {
//			@SuppressWarnings("unchecked")
//			JAXBElement<ConsultarCreditoResponse> response = (JAXBElement<ConsultarCreditoResponse>) client.callWebService(null);
//			System.out.println(response.getValue().getControlData().getMessageUUID());
//		}catch(DatatypeConfigurationException dt) {context.close();}
//
//	}
		
	
}
