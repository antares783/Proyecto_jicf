package com.telcel.gam.siev.util;

import java.io.IOException;
import java.io.StringWriter;
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
import javax.xml.transform.stream.StreamResult;

import org.assertj.core.util.DateUtil;
import org.springframework.oxm.XmlMappingException;

import com.telcel.gam.siev.client.SievClient;
import com.telcel.gam.siev.modelo.TcSistemasCatalogos;
import com.telcel.gam.siev.pojos.SievPojo;
import com.telcel.gam.siev.ws.ConsultarCredito;
import com.telcel.gam.siev.ws.ConsultarCreditoPetType;
import com.telcel.gam.siev.ws.ConsultarCreditoResponse;
import com.telcel.gam.siev.ws.ControlDataRequestType;
import com.telcel.gam.siev.ws.EvaluacionTramite;
import com.telcel.gam.siev.ws.EvaluacionTramiteResponse;
import com.telcel.gam.siev.ws.OfertarCliente;
import com.telcel.gam.siev.ws.OfertarClientePetType;
import com.telcel.gam.siev.ws.OfertarClienteResponse;
import com.telcel.gam.siev.ws.RecalcularOferta;
import com.telcel.gam.siev.ws.RecalcularOfertaPetType;
import com.telcel.gam.siev.ws.RecalcularOfertaResponse;

public class SievUtil {
	
	public static XMLGregorianCalendar getGregorianCalendar(Date fecha) throws DatatypeConfigurationException {
		fecha = DateUtil.now();
		GregorianCalendar calendario = new GregorianCalendar();
		XMLGregorianCalendar xmlCalendario = null;
		calendario.setTime(fecha);
		xmlCalendario = DatatypeFactory.newInstance().newXMLGregorianCalendar(calendario);
		return xmlCalendario;
	}

	public static String getRegionBySistema(String region, int sistema) {
		String re = "";
		if (sistema == 1) {// creditcheck
			re = region;
		} else { // Safin
			re = region.equals("R01") ? "1"
				: region.equals("R02") ? "2"
				: region.equals("R03") ? "3"
				: region.equals("R04") ? "4"
				: region.equals("R05") ? "5"
				: region.equals("R06") ? "6"
				: region.equals("R07") ? "7"
				: region.equals("R08") ? "8"
				: region.equals("R09") ? "9" : "";
		}
		return re;
	}
	
	public static String getMercadoBySistema(String mercado, int sistema) {
		String res = "";
		if(sistema == 1) {//Safin
			res = mercado.equals("M") ? "1"
					: mercado.equals("P") ? "2"
					: mercado.equals("C") ? "3" : "";
		} else {
			res = mercado;
		}
		return res;
	}

	public static String getIP() throws UnknownHostException {
		InetAddress address = InetAddress.getLocalHost();
		String sHostName = "";
		sHostName = address.getHostName();
		// Cogemos la IP
		byte[] bIPAddress = address.getAddress();

		// IP en formato String
		String sIPAddress = "";

		for (int x = 0; x < bIPAddress.length; x++) {
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

	public static ControlDataRequestType getControlDataRequestType() {
		ControlDataRequestType controlDataRequestType = new ControlDataRequestType();

		controlDataRequestType.setMessageUUID("321321");

		controlDataRequestType.setSendBy("SISACT");
		controlDataRequestType.setVersion("1.1");
		try {
			controlDataRequestType.setRequestDate(getGregorianCalendar(new Date()));
			controlDataRequestType.setIpClient(getIP());
			controlDataRequestType.setIpServer(getIP());
			controlDataRequestType.setUser("lromeroh");
		} catch (DatatypeConfigurationException e) {
			// TODO: handle exception
		} catch (UnknownHostException e) {
			// TODO: handle exception
		}

		return controlDataRequestType;
	}

	public static ConsultarCredito getConsultarCredito(SievPojo sievPojo) {
		ConsultarCreditoPetType consultarCreditoPetType = new ConsultarCreditoPetType();
		/**
		 * TODO obtener usuario y contraseña
		 */
		consultarCreditoPetType.setUsuario("ECAC");
		consultarCreditoPetType.setPassw("3c4C!#");
		consultarCreditoPetType.setRfc(sievPojo.getRfc().trim());
		consultarCreditoPetType.setNombre(sievPojo.getNombre().trim());
		consultarCreditoPetType.setApellidos(sievPojo.getApellidos());
		consultarCreditoPetType.setIdSistema(sievPojo.getIdSistema().intValue());
		consultarCreditoPetType.setRegion(getRegionBySistema(sievPojo.getRegion(), SystemType.SAFIN.getValor()));
		consultarCreditoPetType.setClasificacionCLiente(sievPojo.getClasificacionCliente());
		consultarCreditoPetType.setClasificacionBuro(sievPojo.getClasificacionBuro());
		consultarCreditoPetType.setIdFormaPago(sievPojo.getFormaPago());
		consultarCreditoPetType.setIcc(sievPojo.getIcc());
		consultarCreditoPetType.setBcScore(sievPojo.getScoreBuro());

		ConsultarCredito consultarCredito = new ConsultarCredito();
		consultarCredito.setControlData(getControlDataRequestType());
		consultarCredito.setConsultarCliente(consultarCreditoPetType);

		return consultarCredito;

	}
	
	public static OfertarCliente getOfertarClientePetType(SievPojo sievPojo) {
		OfertarClientePetType ofertarClientePetType = new OfertarClientePetType();

		ofertarClientePetType.setUsuario("ECAC");
		ofertarClientePetType.setPassw("3c4C!#");
		ofertarClientePetType.setClasificacionCLiente(sievPojo.getClasificacionCliente());
		ofertarClientePetType.setRfc(sievPojo.getRfc().trim());
		ofertarClientePetType.setNombre(sievPojo.getNombre().trim());
		ofertarClientePetType.setApellidos(sievPojo.getApellidos());
		ofertarClientePetType.setCurp(sievPojo.getCurp().trim());
		ofertarClientePetType.setIdProducto(sievPojo.getIdProducto().intValue());
		ofertarClientePetType.setCvePlan(sievPojo.getCvePlan().toString());
		ofertarClientePetType.setRegion(sievPojo.getRegion());
		ofertarClientePetType.setNumParcialidades(sievPojo.getParcialidades());
		ofertarClientePetType.setIdMovimiento(Integer.parseInt(sievPojo.getMovimiento()));
        ofertarClientePetType.setIdCanal(Integer.parseInt(sievPojo.getIdCanal()));
		ofertarClientePetType.setIdMercado(Integer.parseInt(getMercadoBySistema(sievPojo.getIdMercado(),SystemType.SAFIN.getValor())));
		ofertarClientePetType.setCostoBaseEquipo(sievPojo.getCostoBase());
		ofertarClientePetType.setSobrePrecio(sievPojo.getSobrePrecio());
		ofertarClientePetType.setClasificacionCLiente(sievPojo.getClasificacionCliente());
        ofertarClientePetType.setIdFormaPago(sievPojo.getFormaPago());
		ofertarClientePetType.setIdSistema(sievPojo.getIdSistema().intValue());
		ofertarClientePetType.setCveMarca(sievPojo.getCveMarca().toString());
		ofertarClientePetType.setCveModelo(sievPojo.getCveModelo());
		ofertarClientePetType.setNumeroEmpleado(sievPojo.getNumEmpleado());
		ofertarClientePetType.setFuerzaVenta(sievPojo.getFuerzaVenta());
		ofertarClientePetType.setTelefono(sievPojo.getTelefono());
		ofertarClientePetType.setIcc(sievPojo.getIcc());
		ofertarClientePetType.setBcScore(sievPojo.getScoreBuro());
		ofertarClientePetType.setCostoAmigoKit(sievPojo.getCostoAmigoKit());

		OfertarCliente ofertarCliente = new OfertarCliente();
		ofertarCliente.setOfertarCliente(ofertarClientePetType);
		ofertarCliente.setControlData(getControlDataRequestType());
		
		return ofertarCliente;

	} 
	
	public static RecalcularOferta getRecalcularOferta(SievPojo sievPojo) {
		
		RecalcularOfertaPetType recalcularOfertaPetType = new RecalcularOfertaPetType();
		recalcularOfertaPetType.setIdOferta(sievPojo.getIdOferta());
		recalcularOfertaPetType.setAportacionVol(sievPojo.getAportacionVoluntaria());
		recalcularOfertaPetType.setRegion(Integer.parseInt(getRegionBySistema(sievPojo.getRegion(), SystemType.SAFIN.getValor())));
		recalcularOfertaPetType.setIdSistema(sievPojo.getIdSistema().intValue());

		RecalcularOferta recalcularOferta = new RecalcularOferta();
		recalcularOferta.setControlData(getControlDataRequestType());
		recalcularOferta.setRecalcularOfertPetType(recalcularOfertaPetType);
		
		return recalcularOferta;
	}
	
	public static EvaluacionTramite getEvaluacionTramite(SievPojo sievPojo) {
		
		String request = com.telcel.gam.siev.util.RequestCredCheck.getRequestCreditCheck(sievPojo);
		EvaluacionTramite evaluacionTramite = new EvaluacionTramite();
		evaluacionTramite.setXml(request);
		
		return evaluacionTramite;
	}
	@SuppressWarnings("unchecked")
	public static String getRequestResponse(Object object, Integer requestResponseType, SievClient client) throws XmlMappingException, IOException {
		String result = "";
		switch (requestResponseType) {
		case 1:
			JAXBElement<ConsultarCredito> requestConsultaCredito = (JAXBElement<ConsultarCredito>) object;
			javax.xml.transform.stream.StreamResult r1 = new StreamResult(new StringWriter());
			client.getMarshaller().marshal(requestConsultaCredito, r1);
			result = r1.getWriter().toString();
			break;
		case 2:
			JAXBElement<ConsultarCreditoResponse> responseConsultaCredito = (JAXBElement<ConsultarCreditoResponse>) object;
			javax.xml.transform.stream.StreamResult r2 = new StreamResult(new StringWriter());
			client.getMarshaller().marshal(responseConsultaCredito, r2);
			result = r2.getWriter().toString();
			break;
		case 3:
			JAXBElement<OfertarCliente> requestOfertarCliente= (JAXBElement<OfertarCliente>) object;
			javax.xml.transform.stream.StreamResult r3 = new StreamResult(new StringWriter());
			client.getMarshaller().marshal(requestOfertarCliente, r3);
			result = r3.getWriter().toString();
			break;
		case 4:
			JAXBElement<OfertarClienteResponse> responseOfertarCliente= (JAXBElement<OfertarClienteResponse>) object;
			javax.xml.transform.stream.StreamResult r4 = new StreamResult(new StringWriter());
			client.getMarshaller().marshal(responseOfertarCliente, r4);
			result = r4.getWriter().toString();
			break;
		case 5:
			JAXBElement<RecalcularOferta> requestRecalcularOferta = (JAXBElement<RecalcularOferta>) object;
			javax.xml.transform.stream.StreamResult r5 = new StreamResult(new StringWriter());
			client.getMarshaller().marshal(requestRecalcularOferta, r5);
			result = r5.getWriter().toString();
			break;
		case 6:
			JAXBElement<RecalcularOfertaResponse> responseRecalcularOferta = (JAXBElement<RecalcularOfertaResponse>) object;
			javax.xml.transform.stream.StreamResult r6 = new StreamResult(new StringWriter());
			client.getMarshaller().marshal(responseRecalcularOferta, r6);
			result = r6.getWriter().toString();
			break;
		case 7:
			JAXBElement<EvaluacionTramite> requestEvaluacionTramite = (JAXBElement<EvaluacionTramite>) object;
			javax.xml.transform.stream.StreamResult r7 = new StreamResult(new StringWriter());
			client.getMarshaller().marshal(requestEvaluacionTramite, r7);
			result = r7.getWriter().toString();
			break;
		case 8:
			JAXBElement<EvaluacionTramiteResponse> responseEvaluacionTramite = (JAXBElement<EvaluacionTramiteResponse>) object;
			javax.xml.transform.stream.StreamResult r8 = new StreamResult(new StringWriter());
			client.getMarshaller().marshal(responseEvaluacionTramite, r8);
			result = r8.getWriter().toString();
			break;
		default:
			break;
		}
		
		return result;
	}

}
