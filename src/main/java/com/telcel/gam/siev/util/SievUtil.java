package com.telcel.gam.siev.util;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;

import javax.xml.bind.JAXBElement;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.assertj.core.util.DateUtil;

import com.telcel.gam.siev.modelo.TcSistemasCatalogos;
import com.telcel.gam.siev.pojos.SievPojo;
import com.telcel.gam.siev.ws.ConsultarCreditoResponse;
import com.telcel.gam.siev.ws.ControlDataRequestType;

public class SievUtil {

	public static XMLGregorianCalendar getGregorianCalendar(Date fecha) throws DatatypeConfigurationException {
		fecha = DateUtil.now();
        GregorianCalendar calendario = new GregorianCalendar();
        XMLGregorianCalendar xmlCalendario = null;
        calendario.setTime(fecha);
        xmlCalendario= DatatypeFactory.newInstance().newXMLGregorianCalendar(calendario);
        return xmlCalendario;
	}
	
	public static String getRegionBySistema(String region, int sistema) {
		String re = "";
		if(sistema == 1) {//creditcheck
			re = region;
		} else { //Safin
			re = region.equals("R01")?"1"
					:region.equals("R02")?"2"
					:region.equals("R03")?"3"
					:region.equals("R04")?"4"
					:region.equals("R05")?"5"
					:region.equals("R06")?"6"
					:region.equals("R07")?"7"
					:region.equals("R08")?"8"
					:region.equals("R09")?"9":"";
		}
		return re;
	}
	
	public static String getIP() throws UnknownHostException {
		InetAddress address = InetAddress.getLocalHost();
		String sHostName = "";
		sHostName = address.getHostName();
		// Cogemos la IP 
		byte[] bIPAddress = address.getAddress();
		 
		// IP en formato String
		String sIPAddress = "";
		 
		for (int x=0; x<bIPAddress.length; x++) {
			  if (x > 0) {
			    // A todos los numeros les anteponemos
			    // un punto menos al primero    
			    sIPAddress += ".";
			  }
			  // Jugamos con los bytes y cambiamos el bit del signo
			  sIPAddress += bIPAddress[x] & 255;	   
		}
		return sIPAddress;
	}
	
	public static ControlDataRequestType getControlDataRequestType(){
		ControlDataRequestType controlDataRequestType = new ControlDataRequestType();
        
        controlDataRequestType.setMessageUUID("321321");
        
        controlDataRequestType.setSendBy("SISACT");
        controlDataRequestType.setVersion("1.1");
        try {
	        controlDataRequestType.setRequestDate(com.telcel.gam.siev.util.SievUtil.getGregorianCalendar(new Date()));
	        controlDataRequestType.setIpClient(com.telcel.gam.siev.util.SievUtil.getIP());
	        controlDataRequestType.setIpServer(com.telcel.gam.siev.util.SievUtil.getIP());
        controlDataRequestType.setUser("lromeroh");
        } catch (DatatypeConfigurationException e) {
			// TODO: handle exception
		} catch ( UnknownHostException e) {
			// TODO: handle exception
		}
        
        return controlDataRequestType;
	}
	
	
}
