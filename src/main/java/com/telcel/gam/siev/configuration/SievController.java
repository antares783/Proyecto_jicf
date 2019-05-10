/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.telcel.gam.siev.configuration;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.xml.bind.JAXBElement;
import javax.xml.datatype.DatatypeConfigurationException;

import org.ocpsoft.rewrite.annotation.RequestAction;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.ocpsoft.rewrite.faces.annotation.Deferred;
import org.ocpsoft.rewrite.faces.annotation.IgnorePostback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.telcel.gam.siev.SafinConfig;
import com.telcel.gam.siev.client.SafinClient;
import com.telcel.gam.siev.pojos.SievPojo;
import com.telcel.gam.siev.repositorio.TcSafinCanalesRepository;
import com.telcel.gam.siev.ws.ConsultarCreditoResponse;
import com.telcel.gam.siev.ws.OfertarClienteResponse;
import com.telcel.gam.siev.ws.RecalcularOfertaResponse;
import com.telcel.gam.siev.modelo.TcSafinCanales;

/**
 *
 * @author VI8G023
 */
@Scope(value = "session")
@Component(value = "sievController")
@ELBeanName(value = "sievController")
public class SievController {
    
	private SievPojo sievPojo = new SievPojo();
	
	private String responseWS = "";


	public SievPojo getSievPojo() {
		return sievPojo;
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
	
	public String submit() {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SafinConfig.class);
		SafinClient client = context.getBean(SafinClient.class);
				
		try {
			@SuppressWarnings("unchecked")
			JAXBElement<ConsultarCreditoResponse> responseConsultarCredito = (JAXBElement<ConsultarCreditoResponse>) client.callWebServiceConsultaCliente(sievPojo);
			System.out.print("PAsando por el controller");
			responseWS = "-----------------------------Respuesta Consulta Cliente Safin------------------------------\n" +
						"Código: " + responseConsultarCredito.getValue().getDetailResponse().getCode() + "\n" +
						"Nivel de Severidad: " + responseConsultarCredito.getValue().getDetailResponse().getSeverityLevel() + "\n" +
						"Descripción: " + responseConsultarCredito.getValue().getDetailResponse().getDescription() + "\n" + 
						"Actor: " + responseConsultarCredito.getValue().getDetailResponse().getActor() + "\n" +
						"Significado Negocio: " + responseConsultarCredito.getValue().getDetailResponse().getBusinessMeaning() + "\n" + 
						"Id Consulta: " + responseConsultarCredito.getValue().getConsultarCreditoResponse().getIdConsulta() + "\n" +
						"Límite de Crédito: " + responseConsultarCredito.getValue().getConsultarCreditoResponse().getLimiteCredito() + "\n" +
						"Crédito Restante: " + responseConsultarCredito.getValue().getConsultarCreditoResponse().getCreditoUtilizado() + "\n";
			
			
			@SuppressWarnings("unchecked")
			JAXBElement<OfertarClienteResponse> responseOfertaCliente = (JAXBElement<OfertarClienteResponse>) client.callWebServiceOfertaCliente(sievPojo);
			responseWS = responseWS + "---------------------------Respuesta Oferta Cliente Safin------------------------------------\n" +
						"Código: " + responseOfertaCliente.getValue().getDetailResponse().getCode() + "\n" +
						"Nivel de Severidad: " + responseOfertaCliente.getValue().getDetailResponse().getSeverityLevel() + "\n" +
						"Descripción: " + responseOfertaCliente.getValue().getDetailResponse().getDescription() + "\n" + 
						"Actor: " + responseOfertaCliente.getValue().getDetailResponse().getActor() + "\n" +
						"Significado Negocio: " + responseOfertaCliente.getValue().getDetailResponse().getBusinessMeaning() + "\n" + 
						"Límite de Crédito: $" + responseOfertaCliente.getValue().getOfertarClienteResponse().getOferta().getLimiteCredito() + "\n" +
						"Monto Enganche: $" + responseOfertaCliente.getValue().getOfertarClienteResponse().getOferta().getMontoEnganche() + "\n" +
						"Monto Financiado: $" + responseOfertaCliente.getValue().getOfertarClienteResponse().getOferta().getMontoFinanciado() + "\n" +
						"Monto Parcialidad: $" + responseOfertaCliente.getValue().getOfertarClienteResponse().getOferta().getMontoParcialidad() + "\n" +
						"Monto SobrePrecio: $" + responseOfertaCliente.getValue().getOfertarClienteResponse().getOferta().getMontoSobrePrecio() + "\n" +
						"Monto Total: $" + responseOfertaCliente.getValue().getOfertarClienteResponse().getOferta().getMontoTotal() + "\n" +
						"Porcentaje Enganche: " + responseOfertaCliente.getValue().getOfertarClienteResponse().getOferta().getPctEnganche() + "\n" + 
						"Credito Restante: $" + responseOfertaCliente.getValue().getOfertarClienteResponse().getOferta().getCreditoRestante() + "\n" +
						"Credito Utilizado: $" + responseOfertaCliente.getValue().getOfertarClienteResponse().getOferta().getCreditoUtilizado() + "\n" +
						"Monto Enganche IVA: $" + responseOfertaCliente.getValue().getOfertarClienteResponse().getOferta().getMontoEngancheIva() + "\n" +
						"Monto Financiado IVA: $" + responseOfertaCliente.getValue().getOfertarClienteResponse().getOferta().getMontoFinanciadoIva() + "\n"+
						"Monto Parcialidad IVA: $" + responseOfertaCliente.getValue().getOfertarClienteResponse().getOferta().getMontoParcialidadIva() + "\n" +
						"Monto Sobre Precio IVA: $" + responseOfertaCliente.getValue().getOfertarClienteResponse().getOferta().getMontoSobrePrecioIva() + "\n" +
						"Monto Total IVA: $" + responseOfertaCliente.getValue().getOfertarClienteResponse().getOferta().getMontoSobrePrecioIva() + "\n" +
						"CAT " + responseOfertaCliente.getValue().getOfertarClienteResponse().getOferta().getCat() + "\n" ;
			
			@SuppressWarnings("unchecked")
			JAXBElement<RecalcularOfertaResponse> responseRecalcular = (JAXBElement<RecalcularOfertaResponse>) client.callWebServiceRecalcularOferta(sievPojo);
			responseWS = responseWS + "-----------------------------Respuesta Recalcular Oferta Safin----------------------------------\n" +
						"Código: " + responseRecalcular.getValue().getDetailResponse().getCode() + "\n" +
						"Nivel de Severidad: " + responseRecalcular.getValue().getDetailResponse().getSeverityLevel() + "\n" +
						"Descripción: " + responseRecalcular.getValue().getDetailResponse().getDescription() + "\n" + 
						"Actor: " + responseRecalcular.getValue().getDetailResponse().getActor() + "\n" +
						"Significado Negocio: " + responseRecalcular.getValue().getDetailResponse().getBusinessMeaning() + "\n" + 
						"Límite de Crédito: $" + responseRecalcular.getValue().getRecalcularOfertaRespType().getOferta().getLimiteCredito() + "\n" +
						"Monto Enganche: $" + responseRecalcular.getValue().getRecalcularOfertaRespType().getOferta().getMontoEnganche() + "\n" +
						"Monto Financiado: $" + responseRecalcular.getValue().getRecalcularOfertaRespType().getOferta().getMontoFinanciado() + "\n" +
						"Monto Parcialidad: $" + responseRecalcular.getValue().getRecalcularOfertaRespType().getOferta().getMontoParcialidad() + "\n" +
						"Monto SobrePrecio: $" + responseRecalcular.getValue().getRecalcularOfertaRespType().getOferta().getMontoSobrePrecio() + "\n" +
						"Monto Total: $" + responseRecalcular.getValue().getRecalcularOfertaRespType().getOferta().getMontoTotal() + "\n" +
						"Porcentaje Enganche: " + responseRecalcular.getValue().getRecalcularOfertaRespType().getOferta().getPctEnganche() + "\n" + 
						"Id Oferta: " + responseRecalcular.getValue().getRecalcularOfertaRespType().getOferta().getIdOferta() + "\n";
					
					StringBuilder respuestaCreditCheck = new StringBuilder();
			        respuestaCreditCheck.append("---------------------------GENERAL CREDIT CHECK------------------------------------\n");
			        respuestaCreditCheck.append("Nemónico:\n");
			        respuestaCreditCheck.append("Nombre Flujo:\n");
			        respuestaCreditCheck.append("Traza:\n");
			        respuestaCreditCheck.append("Clasif Buró Crédito:\n");
			        respuestaCreditCheck.append("Clasif Móvil2000:\n");
			        respuestaCreditCheck.append("Clasif Anacr:\n");
			        respuestaCreditCheck.append("Resp Lista Negra:\n");
			        respuestaCreditCheck.append("Clase Crédito:\n");
			        respuestaCreditCheck.append("Tipo Cliente:\n");
			        respuestaCreditCheck.append("---------------------------Lista Negra------------------------------------\n");
			        respuestaCreditCheck.append("Clave Acción LN:\n");
			        respuestaCreditCheck.append("Descripcion Acción LN:\n");
			        respuestaCreditCheck.append("Acción Respuesta:\n");
			        respuestaCreditCheck.append("Mensaje:\n");
			        respuestaCreditCheck.append("Tipo Respuesta:\n");
			        respuestaCreditCheck.append("Lista Negra:\n");
			        respuestaCreditCheck.append("Móvil M2K:\n");
			        respuestaCreditCheck.append("---------------------------Histórico M2K------------------------------------\n");
			        respuestaCreditCheck.append("Clasificación:\n");
			        respuestaCreditCheck.append("Líneas Activas:\n");
			        respuestaCreditCheck.append("Líneas Canceladas:\n");
			        respuestaCreditCheck.append("Importe Total Lin Canceladas:\n");
			        respuestaCreditCheck.append("Importe Total Lin Activas:\n");
			        respuestaCreditCheck.append("Referencia Ctas Activas:\n");
			        respuestaCreditCheck.append("Referencia Ctas Caneladas:\n");
			        respuestaCreditCheck.append("Adeudo:\n");
			        respuestaCreditCheck.append("Acción Respuesta:\n");
			        respuestaCreditCheck.append("Mensaje:\n");
			        respuestaCreditCheck.append("Tipo Respuesta:\n");
			        respuestaCreditCheck.append("Histórico M2K:\n");
			        respuestaCreditCheck.append("---------------------------Adeudo M2K------------------------------------\n");
			        respuestaCreditCheck.append("Líneas Activas:\n");
			        respuestaCreditCheck.append("Líneas Canceladas:\n");
			        respuestaCreditCheck.append("Importe Total Lin Canceladas:\n");
			        respuestaCreditCheck.append("Importe Total Lin Activas:\n");
			        respuestaCreditCheck.append("Referencia Ctas Activas:\n");
			        respuestaCreditCheck.append("Referencia Ctas Caneladas:\n");
			        respuestaCreditCheck.append("Acción Respuesta:\n");
			        respuestaCreditCheck.append("Mensaje:\n");
			        respuestaCreditCheck.append("Tipo Respuesta:\n");
			        respuestaCreditCheck.append("Adeudo M2K:\n");
			        respuestaCreditCheck.append("Móvil M2K:\n");
			        respuestaCreditCheck.append("Buró Crédito:\n");
			        respuestaCreditCheck.append("---------------------------Reporte Bc------------------------------------\n");
			        respuestaCreditCheck.append("Clave Clasificación Bc:\n");
			        respuestaCreditCheck.append("Descrip Clasificación Bc:\n");
			        respuestaCreditCheck.append("Numero Líneas:\n");
			        respuestaCreditCheck.append("Valor Icc:\n");
			        respuestaCreditCheck.append("Valor Score:\n");
			        respuestaCreditCheck.append("Estatus Final:\n");
			        respuestaCreditCheck.append("Folio Bc:\n");
			        respuestaCreditCheck.append("Acción Respuesta:\n");
			        respuestaCreditCheck.append("Mensaje:\n");
			        respuestaCreditCheck.append("Tipo Respuesta:\n");
			        respuestaCreditCheck.append("Reporte Bc:\n");
			        respuestaCreditCheck.append("---------------------------Id Provider Bc------------------------------------\n");
			        respuestaCreditCheck.append("Clave Clasificación Bc:\n");
			        respuestaCreditCheck.append("Descrip Clasificación Bc:\n");
			        respuestaCreditCheck.append("Numero Líneas:\n");
			        respuestaCreditCheck.append("Valor Icc:\n");
			        respuestaCreditCheck.append("Valor Score:\n");
			        respuestaCreditCheck.append("Estatus Final:\n");
			        respuestaCreditCheck.append("Folio Bc:\n");
			        respuestaCreditCheck.append("Acción Respuesta:\n");
			        respuestaCreditCheck.append("Mensaje:\n");
			        respuestaCreditCheck.append("Tipo Respuesta:\n");
			        respuestaCreditCheck.append("Id Provider Bc:\n");
			        respuestaCreditCheck.append("---------------------------Repo Bc Icc------------------------------------\n");
			        respuestaCreditCheck.append("Clave Clasificación Bc:\n");
			        respuestaCreditCheck.append("Descrip Clasificación Bc:\n");
			        respuestaCreditCheck.append("Numero Líneas:\n");
			        respuestaCreditCheck.append("Valor Icc:\n");
			        respuestaCreditCheck.append("Valor Score:\n");
			        respuestaCreditCheck.append("Estatus Final:\n");
			        respuestaCreditCheck.append("Folio Bc:\n");
			        respuestaCreditCheck.append("Acción Respuesta:\n");
			        respuestaCreditCheck.append("Mensaje:\n");
			        respuestaCreditCheck.append("Tipo Respuesta:\n");
			        respuestaCreditCheck.append("Repo Bc Icc:\n");
			        respuestaCreditCheck.append("---------------------------Id Prov Bc Icc------------------------------------\n");
			        respuestaCreditCheck.append("Clave Clasificación Bc:\n");
			        respuestaCreditCheck.append("Descrip Clasificación Bc:\n");
			        respuestaCreditCheck.append("Numero Líneas:\n");
			        respuestaCreditCheck.append("Valor Icc:\n");
			        respuestaCreditCheck.append("Valor Score:\n");
			        respuestaCreditCheck.append("Estatus Final:\n");
			        respuestaCreditCheck.append("Folio Bc:\n");
			        respuestaCreditCheck.append("Acción Respuesta:\n");
			        respuestaCreditCheck.append("Mensaje:\n");
			        respuestaCreditCheck.append("Tipo Respuesta:\n");
			        respuestaCreditCheck.append("Id Prov Bc Icc:\n");
			        respuestaCreditCheck.append("---------------------------Repo Bc Telco Icc------------------------------------\n");
			        respuestaCreditCheck.append("Clave Clasificación Bc:\n");
			        respuestaCreditCheck.append("Descrip Clasificación Bc:\n");
			        respuestaCreditCheck.append("Numero Líneas:\n");
			        respuestaCreditCheck.append("Valor Icc:\n");
			        respuestaCreditCheck.append("Valor Score:\n");
			        respuestaCreditCheck.append("Estatus Final:\n");
			        respuestaCreditCheck.append("Folio Bc:\n");
			        respuestaCreditCheck.append("Acción Respuesta:\n");
			        respuestaCreditCheck.append("Mensaje:\n");
			        respuestaCreditCheck.append("Tipo Respuesta:\n");
			        respuestaCreditCheck.append("Repo Bc Telco Icc:\n");
			        respuestaCreditCheck.append("---------------------------Id Prov Telco Icc------------------------------------\n");
			        respuestaCreditCheck.append("Clave Clasificación Bc:\n");
			        respuestaCreditCheck.append("Descrip Clasificación Bc:\n");
			        respuestaCreditCheck.append("Numero Líneas:\n");
			        respuestaCreditCheck.append("Valor Icc:\n");
			        respuestaCreditCheck.append("Valor Score:\n");
			        respuestaCreditCheck.append("Estatus Final:\n");
			        respuestaCreditCheck.append("Folio Bc:\n");
			        respuestaCreditCheck.append("Acción Respuesta:\n");
			        respuestaCreditCheck.append("Mensaje:\n");
			        respuestaCreditCheck.append("Tipo Respuesta:\n");
			        respuestaCreditCheck.append("Id Prov Telco Icc:\n");
			        respuestaCreditCheck.append("---------------------------Buró Crédito Hst------------------------------------\n");
			        respuestaCreditCheck.append("Producto:\n");
			        respuestaCreditCheck.append("Clave Clasificación Bc:\n");
			        respuestaCreditCheck.append("Descrip Clasificación Bc:\n");
			        respuestaCreditCheck.append("Numero Líneas:\n");
			        respuestaCreditCheck.append("Valor Icc:\n");
			        respuestaCreditCheck.append("Valor Score:\n");
			        respuestaCreditCheck.append("Estatus Final:\n");
			        respuestaCreditCheck.append("Folio Bc:\n");
			        respuestaCreditCheck.append("Acción Respuesta:\n");
			        respuestaCreditCheck.append("Mensaje:\n");
			        respuestaCreditCheck.append("Tipo Respuesta:\n");
			        respuestaCreditCheck.append("Buró Crédito Hst:\n");
			        respuestaCreditCheck.append("Buró Crédito:\n");
			        respuestaCreditCheck.append("---------------------------Buró Crédito Moral------------------------------------\n");
			        respuestaCreditCheck.append("Clave Clasificación Bc:\n");
			        respuestaCreditCheck.append("Descrip Clasificación Bc:\n");
			        respuestaCreditCheck.append("Numero Líneas:\n");
			        respuestaCreditCheck.append("Valor Icc:\n");
			        respuestaCreditCheck.append("Valor Score:\n");
			        respuestaCreditCheck.append("Estatus Final:\n");
			        respuestaCreditCheck.append("Folio Bc:\n");
			        respuestaCreditCheck.append("Acción Respuesta:\n");
			        respuestaCreditCheck.append("Mensaje:\n");
			        respuestaCreditCheck.append("Tipo Respuesta:\n");
			        respuestaCreditCheck.append("Buró Crédito Moral:\n");
			        respuestaCreditCheck.append("---------------------------Score CCS------------------------------------\n");
			        respuestaCreditCheck.append("Clave Clase Crédito:\n");
			        respuestaCreditCheck.append("Descrip Clase Crédito:\n");
			        respuestaCreditCheck.append("Clave Clasificación Final:\n");
			        respuestaCreditCheck.append("Descrip Clasificación Final:\n");
			        respuestaCreditCheck.append("ClaveTipo Cliente:\n");
			        respuestaCreditCheck.append("Descrip Tipo Cliente:\n");
			        respuestaCreditCheck.append("Acción Respuesta:\n");
			        respuestaCreditCheck.append("Mensaje:\n");
			        respuestaCreditCheck.append("Tipo Respuesta:\n");
			        respuestaCreditCheck.append("ScoreCCS:\n");
			        respuestaCreditCheck.append("---------------------------Gama Plan------------------------------------\n");
			        respuestaCreditCheck.append("Acción Respuesta:\n");
			        respuestaCreditCheck.append("Mensaje:\n");
			        respuestaCreditCheck.append("Tipo Respuesta:\n");
			        respuestaCreditCheck.append("Gama Plan:\n");
			        respuestaCreditCheck.append("---------------------------Depósito Renta------------------------------------\n");
			        respuestaCreditCheck.append("Acción Respuesta:\n");
			        respuestaCreditCheck.append("Mensaje:\n");
			        respuestaCreditCheck.append("Tipo Respuesta:\n");
			        respuestaCreditCheck.append("Deposito Renta:\n");
			        respuestaCreditCheck.append("---------------------------Límite Crédito------------------------------------\n");
			        respuestaCreditCheck.append("Límite Crédito:\n");
			        respuestaCreditCheck.append("Acción Respuesta:\n");
			        respuestaCreditCheck.append("Mensaje:\n");
			        respuestaCreditCheck.append("Tipo Respuesta:\n");
			        respuestaCreditCheck.append("Límite Crédito:\n");
			        respuestaCreditCheck.append("---------------------------Financiamiento------------------------------------\n");
			        respuestaCreditCheck.append("Aplica Financiamiento:\n");
			        respuestaCreditCheck.append("Monto Enganche:\n");
			        respuestaCreditCheck.append("Monto Financiado:\n");
			        respuestaCreditCheck.append("Monto Parcialidad:\n");
			        respuestaCreditCheck.append("Monto SobrePrecio:\n");
			        respuestaCreditCheck.append("Monto Total:\n");
			        respuestaCreditCheck.append("Acción Respuesta:\n");
			        respuestaCreditCheck.append("Mensaje:\n");
			        respuestaCreditCheck.append("Tipo Respuesta:\n");
			        respuestaCreditCheck.append("Financiamiento:\n");
			        respuestaCreditCheck.append("---------------------------Cargo Interredes------------------------------------\n");
			        respuestaCreditCheck.append("Ticket:\n");
			        respuestaCreditCheck.append("IdCargo:\n");
			        respuestaCreditCheck.append("Primer Cargo:\n");
			        respuestaCreditCheck.append("Segundo Cargo:\n");
			        respuestaCreditCheck.append("Acción Respuesta:\n");
			        respuestaCreditCheck.append("Mensaje:\n");
			        respuestaCreditCheck.append("Tipo Respuesta:\n");
			        respuestaCreditCheck.append("Cargo Interredes:\n");
			        respuestaCreditCheck.append("Líneas Autorizadas:\n");
			        respuestaCreditCheck.append("---------------------------Líneas Auto Admon------------------------------------\n");
			        respuestaCreditCheck.append("Acción Respuesta:\n");
			        respuestaCreditCheck.append("Mensaje:\n");
			        respuestaCreditCheck.append("Tipo Respuesta:\n");
			        respuestaCreditCheck.append("Líneas AutoAdmon:\n");
			        respuestaCreditCheck.append("---------------------------Líneas Auto Edad------------------------------------\n");
			        respuestaCreditCheck.append("Acción Respuesta:\n");
			        respuestaCreditCheck.append("Mensaje:\n");
			        respuestaCreditCheck.append("Tipo Respuesta:\n");
			        respuestaCreditCheck.append("Líneas Auto Edad:\n");
			        respuestaCreditCheck.append("Líneas Autorizadas:\n");
			        respuestaCreditCheck.append("---------------------------Verificación Dom------------------------------------\n");
			        respuestaCreditCheck.append("Clave Modalidad Invest:\n");
			        respuestaCreditCheck.append("Descrip Modalidad Invest:\n");
			        respuestaCreditCheck.append("Genera Verificación:\n");
			        respuestaCreditCheck.append("Mensaje Verificación:\n");
			        respuestaCreditCheck.append("Acción Respuesta:\n");
			        respuestaCreditCheck.append("Mensaje:\n");
			        respuestaCreditCheck.append("Tipo Respuesta:\n");
			        respuestaCreditCheck.append("Verificación Dom:\n");
			        respuestaCreditCheck.append("Anacr:\n");
			        respuestaCreditCheck.append("---------------------------Anacr Adeudo------------------------------------\n");
			        respuestaCreditCheck.append("Nemónico:\n");
			        respuestaCreditCheck.append("Tiene Adeudo:\n");
			        respuestaCreditCheck.append("Adeudo Total Activo:\n");
			        respuestaCreditCheck.append("Adeudo Total Inactivo:\n");
			        respuestaCreditCheck.append("Líneas Activas:\n");
			        respuestaCreditCheck.append("Líneas Canceladas:\n");
			        respuestaCreditCheck.append("Referencia Ctas Activas:\n");
			        respuestaCreditCheck.append("Referencia Ctas Canceladas:\n");
			        respuestaCreditCheck.append("Acción Respuesta:\n");
			        respuestaCreditCheck.append("Mensaje:\n");
			        respuestaCreditCheck.append("Tipo Respuesta:\n");
			        respuestaCreditCheck.append("Anacr Adeudo:\n");
			        respuestaCreditCheck.append("---------------------------Anacr Hst------------------------------------\n");
			        respuestaCreditCheck.append("Acción Respuesta:\n");
			        respuestaCreditCheck.append("Mensaje:\n");
			        respuestaCreditCheck.append("Tipo Respuesta:\n");
			        respuestaCreditCheck.append("Anacr Hst:\n");
			        respuestaCreditCheck.append("Anacr:\n");
			        respuestaCreditCheck.append("Acción Respuesta:\n");
			        respuestaCreditCheck.append("Mensaje:\n");
			        respuestaCreditCheck.append("Tipo Respuesta:\n");
			        respuestaCreditCheck.append("Evaluacion Trámite:\n");
			        
			        responseWS = responseWS + respuestaCreditCheck.toString();
					
		}catch(DatatypeConfigurationException dt) {
			context.close();
		}
		return "/sievpage.xhtml?faces-redirect=true";
	}
	
	
	public String limpiarDatos() {
		sievPojo = new SievPojo();
		responseWS = "";
		return "/sievpage.xhtml?faces-redirect=true";
	}
}
