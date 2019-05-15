package com.telcel.gam.siev.client;

import java.util.Date;

import javax.xml.bind.JAXBElement;
import javax.xml.datatype.DatatypeConfigurationException;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;


import com.telcel.gam.siev.pojos.SievPojo;
import com.telcel.gam.siev.ws.ConsultarCredito;
import com.telcel.gam.siev.ws.ConsultarCreditoPetType;
import com.telcel.gam.siev.ws.ConsultarCreditoResponse;
import com.telcel.gam.siev.ws.ControlDataRequestType;
import com.telcel.gam.siev.ws.ObjectFactory;
import com.telcel.gam.siev.ws.OfertarCliente;
import com.telcel.gam.siev.ws.OfertarClientePetType;
import com.telcel.gam.siev.ws.OfertarClienteResponse;
import com.telcel.gam.siev.ws.RecalcularOferta;
import com.telcel.gam.siev.ws.RecalcularOfertaPetType;

public class SafinClient extends WebServiceGatewaySupport{
	
//	private static final int CREDITCHECK = 1;
	private static final int SAFIN = 2;

	/**
	 * Metodo para invocar la consulta del cliente al ws de SAFIN
	 * @param SafinPojo pojo 
	 * @return jaxbelement ConsultarCreditoResponse
	 * @throws DatatypeConfigurationException
	 */
	@SuppressWarnings("unchecked")
	public Object callWebServiceConsultaCliente(SievPojo pojo) throws DatatypeConfigurationException{

        ControlDataRequestType controlDataRequestType = new ControlDataRequestType();
        
        controlDataRequestType.setMessageUUID("321321");
        controlDataRequestType.setRequestDate(com.telcel.gam.siev.util.SievUtil.getGregorianCalendar(new Date()));
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
        consultarCreditoPetType.setIdSistema(Integer.parseInt(pojo.getIdSistema()));
        consultarCreditoPetType.setRegion(com.telcel.gam.siev.util.SievUtil.getRegionBySistema(pojo.getRegion(), SAFIN));
        consultarCreditoPetType.setClasificacionCLiente(pojo.getClasificacionCliente());
        consultarCreditoPetType.setClasificacionBuro(pojo.getClasificacionBuro());
//        consultarCreditoPetType.setIdFormaPago(pojo.getformaPago());
        consultarCreditoPetType.setIcc(pojo.getIcc());
        consultarCreditoPetType.setBcScore(pojo.getScoreBuro()); 
        
        ConsultarCredito consultarCredito = new ConsultarCredito();
        consultarCredito.setConsultarCliente(consultarCreditoPetType);
        consultarCredito.setControlData(controlDataRequestType);
        
        ObjectFactory of = new ObjectFactory();
        
        JAXBElement<ConsultarCredito> reqjxb = of.createConsultarCredito(consultarCredito);
        return (JAXBElement<ConsultarCreditoResponse>) getWebServiceTemplate().marshalSendAndReceive(reqjxb);
    }
	
	@SuppressWarnings("unchecked")
	public Object callWebServiceOfertaCliente(SievPojo pojo) throws DatatypeConfigurationException{

        ControlDataRequestType controlDataRequestType = new ControlDataRequestType();
        
        controlDataRequestType.setMessageUUID("321321");
        controlDataRequestType.setRequestDate(com.telcel.gam.siev.util.SievUtil.getGregorianCalendar(new Date()));
        controlDataRequestType.setSendBy("SISACT");
        controlDataRequestType.setVersion("1.1");
        controlDataRequestType.setIpClient("1.1.1.1");
        controlDataRequestType.setIpServer("1.1.1.1");
        controlDataRequestType.setUser("lromeroh");
        
        
        OfertarClientePetType ofertarClientePetType = new OfertarClientePetType();
        
        ofertarClientePetType.setUsuario("ECAC");
        ofertarClientePetType.setPassw("3c4C!#");
        ofertarClientePetType.setClasificacionCLiente(pojo.getClasificacionCliente());
        ofertarClientePetType.setRfc(pojo.getRfc().trim());
        ofertarClientePetType.setNombre(pojo.getNombre().trim());
        ofertarClientePetType.setApellidos(pojo.getApellidos());
        ofertarClientePetType.setCurp(pojo.getCurp().trim());
        ofertarClientePetType.setIdProducto(Integer.parseInt(pojo.getIdProducto()));
        ofertarClientePetType.setCvePlan(pojo.getCvePlan());
        ofertarClientePetType.setRegion(pojo.getRegion());
        ofertarClientePetType.setNumParcialidades(pojo.getParcialidades());
        ofertarClientePetType.setIdMovimiento(Integer.parseInt(pojo.getMovimiento()));
//        ofertarClientePetType.setIdCanal(Integer.parseInt(pojo.getIdCanal()));
        ofertarClientePetType.setIdMercado(Integer.parseInt(pojo.getIdMercado()));
        ofertarClientePetType.setCostoBaseEquipo(pojo.getCostoBase());
        ofertarClientePetType.setSobrePrecio(pojo.getSobrePrecio());
        ofertarClientePetType.setClasificacionCLiente(pojo.getClasificacionCliente());
//        ofertarClientePetType.setIdFormaPago(Integer.parseInt(pojo.getformaPago()));
        ofertarClientePetType.setIdSistema(Integer.parseInt(pojo.getIdSistema()));
        ofertarClientePetType.setCveMarca(pojo.getCveMarca());
        ofertarClientePetType.setCveModelo(pojo.getCveModelo());
        ofertarClientePetType.setNumeroEmpleado(pojo.getNumEmpleado());
        ofertarClientePetType.setFuerzaVenta(pojo.getFuerzaVenta());
        ofertarClientePetType.setTelefono(pojo.getTelefono());
        ofertarClientePetType.setIcc(pojo.getIcc());
        ofertarClientePetType.setBcScore(pojo.getScoreBuro());
        ofertarClientePetType.setCostoAmigoKit(pojo.getCostoAmigoKit());
        
                
        OfertarCliente ofertarCliente = new OfertarCliente();
        ofertarCliente.setOfertarCliente(ofertarClientePetType);
        ofertarCliente.setControlData(controlDataRequestType);
        
        ObjectFactory of = new ObjectFactory();
        
        JAXBElement<OfertarCliente> reqjxb = of.createOfertarCliente(ofertarCliente);
        return (JAXBElement<OfertarClienteResponse>) getWebServiceTemplate().marshalSendAndReceive(reqjxb);
    }
	
	
	@SuppressWarnings("unchecked")
	public Object callWebServiceRecalcularOferta(SievPojo pojo) throws DatatypeConfigurationException{

        ControlDataRequestType controlDataRequestType = new ControlDataRequestType();
        
        controlDataRequestType.setMessageUUID("321321");
        controlDataRequestType.setRequestDate(com.telcel.gam.siev.util.SievUtil.getGregorianCalendar(new Date()));
        controlDataRequestType.setSendBy("SISACT");
        controlDataRequestType.setVersion("1.1");
        controlDataRequestType.setIpClient("1.1.1.1");
        controlDataRequestType.setIpServer("1.1.1.1");
        controlDataRequestType.setUser("lromeroh");
        
        
        RecalcularOfertaPetType recalcularOfertaPetType = new RecalcularOfertaPetType();
        recalcularOfertaPetType.setIdOferta(pojo.getIdOferta());
        recalcularOfertaPetType.setAportacionVol(pojo.getAportacionVoluntaria());
        recalcularOfertaPetType.setRegion(Integer.parseInt(com.telcel.gam.siev.util.SievUtil.getRegionBySistema(pojo.getRegion(), SAFIN)));
        recalcularOfertaPetType.setIdSistema(Integer.parseInt(pojo.getIdSistema()));
        
        RecalcularOferta recalcularOferta = new RecalcularOferta();
        recalcularOferta.setControlData(controlDataRequestType);
        recalcularOferta.setRecalcularOfertPetType(recalcularOfertaPetType);
        
        ObjectFactory of = new ObjectFactory();
        
        JAXBElement<RecalcularOferta> reqjxb = of.createRecalcularOferta(recalcularOferta);
        return (JAXBElement<RecalcularOferta>) getWebServiceTemplate().marshalSendAndReceive(reqjxb);
    }
}