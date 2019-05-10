package com.telcel.gam.siev.configuration;

import javax.xml.bind.JAXBElement;
import javax.xml.datatype.DatatypeConfigurationException;


import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.telcel.gam.siev.SafinConfig;
import com.telcel.gam.siev.client.SafinClient;
import com.telcel.gam.siev.pojos.SafinPojo;
import com.telcel.gam.siev.ws.ConsultarCreditoResponse;


@Scope(value = "session")
@Component(value = "safinViewController")
@ELBeanName(value = "safinViewController")
//@Join(path = "/",to = "/safinpage.xhtml")
public class SafinViewController {

	private SafinPojo safinPojo = new SafinPojo();
    
    private String responseWS = "";
    
    public String getResponseWS() {
		return responseWS;
	}
	public void setResponseWS(String responseWS) {
		this.responseWS = responseWS;
	}
	public SafinPojo getSafinPojo() {
		return safinPojo;
	}
	public void setSafinPojo(SafinPojo safinPojo) {
		this.safinPojo = safinPojo;
	}

	
	public String haceAlgo() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SafinConfig.class);
		SafinClient client = context.getBean(SafinClient.class);
		try {
			@SuppressWarnings("unchecked")
			JAXBElement<ConsultarCreditoResponse> response = (JAXBElement<ConsultarCreditoResponse>) client.callWebServiceConsultaCliente(null);
			
			responseWS = "---------------Respuesta Consulta Cliente Safin------------------------------\n" +
						"Código: " + response.getValue().getDetailResponse().getCode() + "\n" +
						"Nivel de Severidad: " + response.getValue().getDetailResponse().getSeverityLevel() + "\n" +
						"Descripción: " + response.getValue().getDetailResponse().getDescription() + "\n" + 
						"Actor: " + response.getValue().getDetailResponse().getActor() + "\n" +
						"Significado Negocio: " + response.getValue().getDetailResponse().getBusinessMeaning() + "\n" + 
						"Id Consulta: " + response.getValue().getConsultarCreditoResponse().getIdConsulta() + "\n" +
						"Límite de Crédito: " + response.getValue().getConsultarCreditoResponse().getLimiteCredito() + "\n" +
						"Crédito Restante: " + response.getValue().getConsultarCreditoResponse().getCreditoUtilizado() + "\n";
			
			
		}catch(DatatypeConfigurationException dt) {context.close();}
		return "/safinpage.xhtml?faces-redirect=true";
		
	}
	
	public String limpiarDatos() {
		safinPojo = new SafinPojo();
		responseWS = "";
		return "/safinpage.xhtml?faces-redirect=true";
	}
	
}
