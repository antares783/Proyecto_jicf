package com.telcel.gam.siev.controller;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.PostLoad;
import javax.xml.bind.JAXBElement;
import javax.xml.datatype.DatatypeConfigurationException;

import org.ocpsoft.rewrite.annotation.RequestAction;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.ocpsoft.rewrite.faces.annotation.Deferred;
import org.ocpsoft.rewrite.faces.annotation.IgnorePostback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import com.telcel.gam.siev.CreditCheckConfig;
import com.telcel.gam.siev.SafinConfig;
import com.telcel.gam.siev.client.CreditCheckClient;
import com.telcel.gam.siev.client.SafinClient;
import com.telcel.gam.siev.pojos.SievPojo;
import com.telcel.gam.siev.repositorio.TcSafinCanalesRepository;
import com.telcel.gam.siev.ws.ConsultarCreditoResponse;
import com.telcel.gam.siev.ws.EvaluacionTramiteResponse;
import com.telcel.gam.siev.ws.OfertarClienteResponse;
import com.telcel.gam.siev.ws.RecalcularOfertaResponse;
import com.telcel.gam.siev.modelo.TcSafinCanales;

/**
 *
 * @author VI8G023
 */
@Controller
@Scope(value = "session")
@Component(value = "sievController")
@ELBeanName(value = "sievController")
public class SievController {

	/***************************Beans, variables****************************/
	
	private SievPojo sievPojo = new SievPojo();
	
	private String responseWS = "";
	
	private TcSafinCanales canales = new TcSafinCanales();
	
	private List<TcSafinCanales> lista = new ArrayList<TcSafinCanales>();
	
//	@Autowired(required = true)
//	@Qualifier(value = "canal")
	private TcSafinCanalesRepository canalesRepository;

	/***************************Constructores******************************/
	
//	public SievController() {
//	}
//	@Autowired
//	public SievController(TcSafinCanalesRepository canalesRepository) {
//		this.canalesRepository = canalesRepository;
//	}
	
	/***************************Getter y setters******************************/

	public SievPojo getSievPojo() {
		return sievPojo;
	}

//	@Autowired
	public void setCanalesRepository(TcSafinCanalesRepository canalesRepository) {
		this.canalesRepository = canalesRepository;
	}

	public TcSafinCanalesRepository getCanalesRepository() {
		return canalesRepository;
	}

	public void setSievPojo(SievPojo sievPojo) {
		this.sievPojo = sievPojo;
	}

	public String getResponseWS() {
		return responseWS;
	}

	public void setResponseWS(String responseWS) {
		this.responseWS = responseWS;
	}
	
	public TcSafinCanales getCanales() {
		return canales;
	}

	public void setCanales(TcSafinCanales canales) {
		this.canales = canales;
	}

	public List<TcSafinCanales> getLista() {
		return lista;
	}

	public void setLista(List<TcSafinCanales> lista) {
		this.lista = lista;
	}

	/*****************************************Logica de negocio********************************************/
	@PostConstruct
	public void init () {
		System.out.println("Hola desde prime facesss post construct!!!!");
		if(canalesRepository != null)
			System.out.println("Ya chingamos prros");
//		lista = canalesRepository.findAll();
//		log.debug("prueba " + lista);
		
	}
//	
//	public SievController() {
//		lista = canalesRepository.findAll();
//		System.out.println(lista);
//	}
//	
	public List<TcSafinCanales> getCanalesListaAll(){
		lista = canalesRepository.findAll();
		System.out.println(lista);
		return lista;
	}
//	
	public String submit() throws IOException {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SafinConfig.class);
		SafinClient client = context.getBean(SafinClient.class);
		
		AnnotationConfigApplicationContext contextCreditCheck = new AnnotationConfigApplicationContext(CreditCheckConfig.class);
		CreditCheckClient clientCreditCheck = contextCreditCheck.getBean(CreditCheckClient.class);
		
		try {
			@SuppressWarnings("unchecked")
			JAXBElement<ConsultarCreditoResponse> responseConsultarCredito = (JAXBElement<ConsultarCreditoResponse>) client.callWebServiceConsultaCliente(sievPojo);
			System.out.print("PAsando por el controller");
			if(responseConsultarCredito.getValue() != null) {
				responseWS = "-----------------------------Respuesta Consulta Cliente Safin------------------------------\n";
						if(responseConsultarCredito.getValue().getDetailResponse() != null) { //si el detail response es nulo
							responseWS = responseWS + "Código: " + responseConsultarCredito.getValue().getDetailResponse().getCode() + "\n" +
								"Nivel de Severidad: " + responseConsultarCredito.getValue().getDetailResponse().getSeverityLevel()  + "\n" +
								"Descripción: " + responseConsultarCredito.getValue().getDetailResponse().getDescription() + "\n" + 
								"Actor: " + responseConsultarCredito.getValue().getDetailResponse().getActor() + "\n" +
								"Significado Negocio: " + responseConsultarCredito.getValue().getDetailResponse().getBusinessMeaning()  + "\n"; 
						}	
						if(responseConsultarCredito.getValue().getConsultarCreditoResponse() != null) {//si el consultar credito es nulo
							responseWS = responseWS + "Id Consulta: " + responseConsultarCredito.getValue().getConsultarCreditoResponse().getIdConsulta()  + "\n" +
							"Límite de Crédito: " + responseConsultarCredito.getValue().getConsultarCreditoResponse().getLimiteCredito()  + "\n" +
							"Crédito Restante: " + responseConsultarCredito.getValue().getConsultarCreditoResponse().getCreditoUtilizado() + "\n";
						}
				@SuppressWarnings("unchecked")
				
				JAXBElement<OfertarClienteResponse> responseOfertaCliente = (JAXBElement<OfertarClienteResponse>) client.callWebServiceOfertaCliente(sievPojo);
				
				responseWS = responseWS + "---------------------------Respuesta Oferta Cliente Safin------------------------------------\n";
				if(responseConsultarCredito.getValue().getDetailResponse() != null) { //si el detail response es nulo
						responseWS = responseWS + "Código: " + responseOfertaCliente.getValue().getDetailResponse().getCode()  + "\n" +
							"Nivel de Severidad: " + responseOfertaCliente.getValue().getDetailResponse().getSeverityLevel() + "\n" +
							"Descripción: " + responseOfertaCliente.getValue().getDetailResponse().getDescription() + "\n" + 
							"Actor: " + responseOfertaCliente.getValue().getDetailResponse().getActor() + "\n" +
							"Significado Negocio: " + responseOfertaCliente.getValue().getDetailResponse().getBusinessMeaning() + "\n";
				}
				if(responseOfertaCliente.getValue().getOfertarClienteResponse() != null && responseOfertaCliente.getValue().getOfertarClienteResponse().getOferta() != null) {
					responseWS = responseWS +"Límite de Crédito: $" + responseOfertaCliente.getValue().getOfertarClienteResponse().getOferta().getLimiteCredito()  + "\n" +
							"Monto Enganche: $" + responseOfertaCliente.getValue().getOfertarClienteResponse().getOferta().getMontoEnganche() + "\n" +
							"Monto Financiado: $" + responseOfertaCliente.getValue().getOfertarClienteResponse().getOferta().getMontoFinanciado()  + "\n" +
							"Monto Parcialidad: $" + responseOfertaCliente.getValue().getOfertarClienteResponse().getOferta().getMontoParcialidad()  + "\n" +
							"Monto SobrePrecio: $" + responseOfertaCliente.getValue().getOfertarClienteResponse().getOferta().getMontoSobrePrecio()  + "\n" +
							"Monto Total: $" + responseOfertaCliente.getValue().getOfertarClienteResponse().getOferta().getMontoTotal() + "\n" +
							"Porcentaje Enganche: " + responseOfertaCliente.getValue().getOfertarClienteResponse().getOferta().getPctEnganche() + "\n" + 
							"Credito Restante: $" + responseOfertaCliente.getValue().getOfertarClienteResponse().getOferta().getCreditoRestante() + "\n" +
							"Credito Utilizado: $" + responseOfertaCliente.getValue().getOfertarClienteResponse().getOferta().getCreditoUtilizado() + "\n" +
							"Monto Enganche IVA: $" + responseOfertaCliente.getValue().getOfertarClienteResponse().getOferta().getMontoEngancheIva()  + "\n" +
							"Monto Financiado IVA: $" + responseOfertaCliente.getValue().getOfertarClienteResponse().getOferta().getMontoFinanciadoIva() + "\n"+
							"Monto Parcialidad IVA: $" + responseOfertaCliente.getValue().getOfertarClienteResponse().getOferta().getMontoParcialidadIva()  + "\n" +
							"Monto Sobre Precio IVA: $" + responseOfertaCliente.getValue().getOfertarClienteResponse().getOferta().getMontoSobrePrecioIva()  + "\n" +
							"Monto Total IVA: $" + responseOfertaCliente.getValue().getOfertarClienteResponse().getOferta().getMontoSobrePrecioIva()  + "\n" +
							"CAT " + responseOfertaCliente.getValue().getOfertarClienteResponse().getOferta().getCat()  + "\n" ;
				}
				
				@SuppressWarnings("unchecked")
				JAXBElement<RecalcularOfertaResponse> responseRecalcular = (JAXBElement<RecalcularOfertaResponse>) client.callWebServiceRecalcularOferta(sievPojo);
				responseWS = responseWS + "-----------------------------Respuesta Recalcular Oferta Safin----------------------------------\n";
				if(responseConsultarCredito.getValue().getDetailResponse() != null) { //si el detail response es nulo
					responseWS = responseWS + "Código: " + responseRecalcular.getValue().getDetailResponse().getCode()  + "\n" +
							"Nivel de Severidad: " + responseRecalcular.getValue().getDetailResponse().getSeverityLevel() + "\n" +
							"Descripción: " + responseRecalcular.getValue().getDetailResponse().getDescription()  + "\n" + 
							"Actor: " + responseRecalcular.getValue().getDetailResponse().getActor() +  "\n" +
							"Significado Negocio: " + responseRecalcular.getValue().getDetailResponse().getBusinessMeaning() + "\n";
				}
				
				if(responseRecalcular.getValue().getRecalcularOfertaRespType() != null && responseRecalcular.getValue().getRecalcularOfertaRespType().getOferta() != null) {
					responseWS = responseWS + "Límite de Crédito: $" + responseRecalcular.getValue().getRecalcularOfertaRespType().getOferta().getLimiteCredito()  + "\n" +
							"Monto Enganche: $" + responseRecalcular.getValue().getRecalcularOfertaRespType().getOferta().getMontoEnganche()  + "\n" +
							"Monto Financiado: $" + responseRecalcular.getValue().getRecalcularOfertaRespType().getOferta().getMontoFinanciado()  + "\n" +
							"Monto Parcialidad: $" + responseRecalcular.getValue().getRecalcularOfertaRespType().getOferta().getMontoParcialidad()  + "\n" +
							"Monto SobrePrecio: $" + responseRecalcular.getValue().getRecalcularOfertaRespType().getOferta().getMontoSobrePrecio()  + "\n" +
							"Monto Total: $" + responseRecalcular.getValue().getRecalcularOfertaRespType().getOferta().getMontoTotal() + "\n" +
							"Porcentaje Enganche: " + responseRecalcular.getValue().getRecalcularOfertaRespType().getOferta().getPctEnganche()  + "\n" + 
							"Id Oferta: " + responseRecalcular.getValue().getRecalcularOfertaRespType().getOferta().getIdOferta() + "\n";
				}
			}	
		}catch(DatatypeConfigurationException dt) {
			context.close();
		}
		
//			try {	
//				@SuppressWarnings("unchecked")
//				JAXBElement<EvaluacionTramiteResponse> responseEvaluacionTramite = (JAXBElement<EvaluacionTramiteResponse>) clientCreditCheck.callWebServiceEvaluacionTramite(sievPojo);
//				FileOutputStream xml = new FileOutputStream("C:\\\\Users\\\\VI8G023\\\\PETICION_DE_PRUEBA_ET__completa.xml");
//				xml.write(responseEvaluacionTramite.getValue().getXml().getBytes());
//				xml.close();
//				responseEvaluacionTramite.getValue().getXml();
//			} catch(FileNotFoundException io) {
//				contextCreditCheck.close();
//			}
//	        responseWS = responseWS + com.telcel.gam.siev.util.ReadXMLFile.getResponseCreditCheck(); 
//			        
//		
		return "/sievpage.xhtml?faces-redirect=true";
	}
	
	
	public String limpiarDatos() {
		sievPojo = new SievPojo();
		responseWS = "";
		return "/sievpage.xhtml?faces-redirect=true";
	}
	
}
