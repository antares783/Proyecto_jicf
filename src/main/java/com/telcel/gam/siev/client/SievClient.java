package com.telcel.gam.siev.client;

import java.io.StringWriter;

import javax.xml.bind.JAXBElement;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.transform.stream.StreamResult;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import com.telcel.gam.siev.pojos.SievPojo;
import com.telcel.gam.siev.ws.ConsultarCredito;
import com.telcel.gam.siev.ws.ConsultarCreditoPetType;
import com.telcel.gam.siev.ws.ConsultarCreditoResponse;
import com.telcel.gam.siev.ws.EvaluacionTramite;
import com.telcel.gam.siev.ws.EvaluacionTramiteResponse;
import com.telcel.gam.siev.ws.ObjectFactory;
import com.telcel.gam.siev.ws.OfertarCliente;
import com.telcel.gam.siev.ws.OfertarClientePetType;
import com.telcel.gam.siev.ws.OfertarClienteResponse;
import com.telcel.gam.siev.ws.RecalcularOferta;
import com.telcel.gam.siev.ws.RecalcularOfertaPetType;

/**
 * Clase general para llenar los request de SAFIN y CreditCheck, obtener su
 * response de los respectivos llamados
 * 
 * @author VI8G023
 *
 */

public class SievClient extends WebServiceGatewaySupport {


	// WSLD's SAFIN
	private static final String SAFINWsdl = "http://localhost:8098/mockSafinServicesSoapBinding?WSDL";
//	private static final String SAFINWsdl = "http://10.188.92.250:8082/SAFIN-WEB/app/services/SafinServices?wsdl ";

	// WSDL's CreditCheck
	private static final String CreditCheckWsdl = "http://localhost:8088/mockCreditCheckWSPortBinding?WSDL";
//	private static final String CreditCheckWsdl = "http://191.9.3.249:9080/CreditCheckWS/service/CreditCheckWS.wsdl";

	@SuppressWarnings("unchecked")
	public Object callWebServiceConsultaCliente(JAXBElement<ConsultarCredito> request) {
		return (JAXBElement<ConsultarCreditoResponse>) getWebServiceTemplate().marshalSendAndReceive(SAFINWsdl,
				request);
	}

	@SuppressWarnings("unchecked")
	public Object callWebServiceOfertaCliente(JAXBElement<OfertarCliente> reqjxb) {
		return (JAXBElement<OfertarClienteResponse>) getWebServiceTemplate().marshalSendAndReceive(SAFINWsdl, reqjxb);
	}

	@SuppressWarnings("unchecked")
	public Object callWebServiceRecalcularOferta(JAXBElement<RecalcularOferta> reqjxb) {
		return (JAXBElement<RecalcularOferta>) getWebServiceTemplate().marshalSendAndReceive(SAFINWsdl, reqjxb);
	}

	@SuppressWarnings("unchecked")
	public Object callWebServiceEvaluacionTramite(JAXBElement<EvaluacionTramite> reqjxb) {
		return (JAXBElement<EvaluacionTramiteResponse>) getWebServiceTemplate().marshalSendAndReceive(CreditCheckWsdl,
				reqjxb);
	}
}