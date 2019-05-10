package com.telcel.gam.siev;

import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.bind.JAXBElement;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.assertj.core.util.DateUtil;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import com.telcel.gam.siev.pojos.SafinPojo;
import com.telcel.gam.siev.ws.ConsultarCredito;
import com.telcel.gam.siev.ws.ConsultarCreditoPetType;
import com.telcel.gam.siev.ws.ConsultarCreditoResponse;
import com.telcel.gam.siev.ws.ControlDataRequestType;
import com.telcel.gam.siev.ws.ObjectFactory;

@Deprecated
public class SafinClient extends WebServiceGatewaySupport{

	@SuppressWarnings("unchecked")
	public Object callWebService(SafinPojo pojo) throws DatatypeConfigurationException{
		
		//*************************************************************
        Date fecha = DateUtil.now();
        GregorianCalendar calendario = new GregorianCalendar();
        XMLGregorianCalendar xmlCalendario = null;
        calendario.setTime(fecha);
        xmlCalendario= DatatypeFactory.newInstance().newXMLGregorianCalendar(calendario);
        //**************************************************************
        ControlDataRequestType controlDataRequestType = new ControlDataRequestType();
        
        controlDataRequestType.setMessageUUID("321321");
        controlDataRequestType.setRequestDate(xmlCalendario);
        controlDataRequestType.setSendBy("SISACT");
        controlDataRequestType.setVersion("1.1");
        controlDataRequestType.setIpClient("1.1.1.1");
        controlDataRequestType.setIpServer("1.1.1.1");
        controlDataRequestType.setUser("lromeroh");
        
        
        ConsultarCreditoPetType consultarCreditoPetType = new ConsultarCreditoPetType();
        
        consultarCreditoPetType.setUsuario("ECAC");
        consultarCreditoPetType.setPassw("3c4C!#");
        consultarCreditoPetType.setRfc(pojo.getRfc().trim());
        consultarCreditoPetType.setNombre(pojo.getNombre().trim());
        consultarCreditoPetType.setApellidos(pojo.getApellidos());
//        consultarCreditoPetType.setIdSistema(pojo.getIdSistema());
        consultarCreditoPetType.setRegion(pojo.getRegion());
        consultarCreditoPetType.setClasificacionCLiente(pojo.getClasificacionCliente());
        consultarCreditoPetType.setClasificacionBuro(pojo.getClasificacionBuro());
        consultarCreditoPetType.setIdFormaPago(pojo.getformaPago());
        consultarCreditoPetType.setIcc(pojo.getIcc());
        consultarCreditoPetType.setBcScore(pojo.getScoreBuro()); 
        
        ConsultarCredito consultarCredito = new ConsultarCredito();
        consultarCredito.setConsultarCliente(consultarCreditoPetType);
        consultarCredito.setControlData(controlDataRequestType);
        
        ObjectFactory of = new ObjectFactory();
        
        JAXBElement<ConsultarCredito> reqjxb = of.createConsultarCredito(consultarCredito);
        return (JAXBElement<ConsultarCreditoResponse>) getWebServiceTemplate().marshalSendAndReceive(reqjxb);
    }
	
}
