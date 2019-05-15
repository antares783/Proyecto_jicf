package com.telcel.gam.siev.client;

import javax.xml.bind.JAXBElement;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import com.telcel.gam.siev.pojos.SievPojo;
import com.telcel.gam.siev.ws.EvaluacionTramite;
import com.telcel.gam.siev.ws.EvaluacionTramiteResponse;
import com.telcel.gam.siev.ws.ObjectFactory;

public class CreditCheckClient extends WebServiceGatewaySupport {

	@SuppressWarnings("unchecked")
	public Object callWebServiceEvaluacionTramite(SievPojo pojo) {
		
		String request = com.telcel.gam.siev.util.RequestCredCheck.getRequestCreditCheck(pojo);
		
		EvaluacionTramite evaluacionTramite = new EvaluacionTramite();
		evaluacionTramite.setXml(request);
		
		ObjectFactory of = new ObjectFactory();
		 
		JAXBElement<EvaluacionTramite> reqjxb = of.createEvaluacionTramite(evaluacionTramite);
		 
		return (JAXBElement<EvaluacionTramiteResponse>) getWebServiceTemplate().marshalSendAndReceive(reqjxb);
	}
	
}
