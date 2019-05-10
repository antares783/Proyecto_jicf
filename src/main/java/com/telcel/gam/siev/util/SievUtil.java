package com.telcel.gam.siev.util;

import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.assertj.core.util.DateUtil;

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
	
}
