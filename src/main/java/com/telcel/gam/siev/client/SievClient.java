package com.telcel.gam.siev.client;

import javax.xml.bind.JAXBElement;
import javax.xml.datatype.DatatypeConfigurationException;

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
 * Clase general para llenar los request de SAFIN y CreditCheck, obtener su response de los respectivos llamados
 * @author VI8G023
 *
 */

public class SievClient extends WebServiceGatewaySupport {

	private static final int CREDITCHECK = 1;
	private static final int SAFIN = 2;
	
	//WSLD's SAFIN
	private static final String SAFINWsdl = "http://localhost:8098/mockSafinServicesSoapBinding?WSDL";
//	private static final String SAFINWsdl = "http://10.188.92.250:8082/SAFIN-WEB/app/services/SafinServices?wsdl ";
	
	//WSDL's CreditCheck
	private static final String CreditCheckWsdl = "http://localhost:8088/mockCreditCheckWSPortBinding?WSDL";
//	private static final String CreditCheckWsdl = "http://191.9.3.249:9080/CreditCheckWS/service/CreditCheckWS.wsdl";

	/**
	 * Metodo para invocar la consulta del cliente al ws de SAFIN
	 * 
	 * @param SafinPojo pojo
	 * @return jaxbelement ConsultarCreditoResponse
	 * @throws DatatypeConfigurationException
	 */
	public Object callWebServiceConsultaCliente(SievPojo pojo) {

		ConsultarCreditoPetType consultarCreditoPetType = new ConsultarCreditoPetType();

		/**
		 * TODO
		 * obtener usuario y contraseña
		 */
		consultarCreditoPetType.setUsuario("ECAC");
		consultarCreditoPetType.setPassw("3c4C!#");
		
		
		consultarCreditoPetType.setRfc(pojo.getRfc().trim());
		consultarCreditoPetType.setNombre(pojo.getNombre().trim());
		consultarCreditoPetType.setApellidos(pojo.getApellidos());
		consultarCreditoPetType.setIdSistema(Integer.parseInt(pojo.getIdSistema()));
		consultarCreditoPetType
				.setRegion(com.telcel.gam.siev.util.SievUtil.getRegionBySistema(pojo.getRegion(), SAFIN));
		consultarCreditoPetType.setClasificacionCLiente(pojo.getClasificacionCliente());
		consultarCreditoPetType.setClasificacionBuro(pojo.getClasificacionBuro());
        consultarCreditoPetType.setIdFormaPago(pojo.getFormaPago());
		consultarCreditoPetType.setIcc(pojo.getIcc());
		consultarCreditoPetType.setBcScore(pojo.getScoreBuro());

		ConsultarCredito consultarCredito = new ConsultarCredito();
		consultarCredito.setConsultarCliente(consultarCreditoPetType);

		ObjectFactory of = new ObjectFactory();
		JAXBElement<ConsultarCredito> reqjxb = of.createConsultarCredito(consultarCredito);
		@SuppressWarnings("unchecked")
		JAXBElement<ConsultarCreditoResponse> element = (JAXBElement<ConsultarCreditoResponse>) getWebServiceTemplate()
				.marshalSendAndReceive(SAFINWsdl, reqjxb);
		return element;
	}

	@SuppressWarnings("unchecked")
	public Object callWebServiceOfertaCliente(SievPojo pojo) {

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
        ofertarClientePetType.setIdCanal(Integer.parseInt(pojo.getIdCanal()));
		ofertarClientePetType.setIdMercado(Integer.parseInt(pojo.getIdMercado()));
		ofertarClientePetType.setCostoBaseEquipo(pojo.getCostoBase());
		ofertarClientePetType.setSobrePrecio(pojo.getSobrePrecio());
		ofertarClientePetType.setClasificacionCLiente(pojo.getClasificacionCliente());
        ofertarClientePetType.setIdFormaPago(pojo.getFormaPago());
		ofertarClientePetType.setIdSistema(Integer.parseInt(pojo.getIdSistema()));
		ofertarClientePetType.setCveMarca(pojo.getCveMarca().toString());
		ofertarClientePetType.setCveModelo(pojo.getCveModelo());
		ofertarClientePetType.setNumeroEmpleado(pojo.getNumEmpleado());
		ofertarClientePetType.setFuerzaVenta(pojo.getFuerzaVenta());
		ofertarClientePetType.setTelefono(pojo.getTelefono());
		ofertarClientePetType.setIcc(pojo.getIcc());
		ofertarClientePetType.setBcScore(pojo.getScoreBuro());
		ofertarClientePetType.setCostoAmigoKit(pojo.getCostoAmigoKit());

		OfertarCliente ofertarCliente = new OfertarCliente();
		ofertarCliente.setOfertarCliente(ofertarClientePetType);
		ofertarCliente.setControlData(com.telcel.gam.siev.util.SievUtil.getControlDataRequestType());

		ObjectFactory of = new ObjectFactory();

		JAXBElement<OfertarCliente> reqjxb = of.createOfertarCliente(ofertarCliente);
		return (JAXBElement<OfertarClienteResponse>) getWebServiceTemplate().marshalSendAndReceive(SAFINWsdl,reqjxb);
	}

	@SuppressWarnings("unchecked")
	public Object callWebServiceRecalcularOferta(SievPojo pojo) {

		RecalcularOfertaPetType recalcularOfertaPetType = new RecalcularOfertaPetType();
		recalcularOfertaPetType.setIdOferta(pojo.getIdOferta());
		recalcularOfertaPetType.setAportacionVol(pojo.getAportacionVoluntaria());
		recalcularOfertaPetType.setRegion(
				Integer.parseInt(com.telcel.gam.siev.util.SievUtil.getRegionBySistema(pojo.getRegion(), SAFIN)));
		recalcularOfertaPetType.setIdSistema(Integer.parseInt(pojo.getIdSistema()));

		RecalcularOferta recalcularOferta = new RecalcularOferta();
		recalcularOferta.setControlData(com.telcel.gam.siev.util.SievUtil.getControlDataRequestType());
		recalcularOferta.setRecalcularOfertPetType(recalcularOfertaPetType);

		ObjectFactory of = new ObjectFactory();

		JAXBElement<RecalcularOferta> reqjxb = of.createRecalcularOferta(recalcularOferta);
		return (JAXBElement<RecalcularOferta>) getWebServiceTemplate().marshalSendAndReceive(SAFINWsdl,reqjxb);
	}

	@SuppressWarnings("unchecked")
	public Object callWebServiceEvaluacionTramite(SievPojo pojo) {

		String request = com.telcel.gam.siev.util.RequestCredCheck.getRequestCreditCheck(pojo);

		EvaluacionTramite evaluacionTramite = new EvaluacionTramite();
		evaluacionTramite.setXml(request);

		ObjectFactory of = new ObjectFactory();

		JAXBElement<EvaluacionTramite> reqjxb = of.createEvaluacionTramite(evaluacionTramite);

		return (JAXBElement<EvaluacionTramiteResponse>) getWebServiceTemplate()
				.marshalSendAndReceive(CreditCheckWsdl, reqjxb);
	}
}