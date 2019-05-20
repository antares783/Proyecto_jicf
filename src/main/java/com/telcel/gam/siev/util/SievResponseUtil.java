package com.telcel.gam.siev.util;

import javax.xml.bind.JAXBElement;

import com.telcel.gam.siev.ws.ConsultarCreditoResponse;
import com.telcel.gam.siev.ws.OfertarClienteResponse;
import com.telcel.gam.siev.ws.RecalcularOfertaResponse;

public class SievResponseUtil {

	public static String getResponseConsultarCredito(JAXBElement<ConsultarCreditoResponse> responseConsultarCredito) {
		String resConsultarCredito = "-----------------------------Respuesta Consulta Cliente Safin------------------------------\n";
		if(responseConsultarCredito.getValue() != null) {
			if(responseConsultarCredito.getValue().getDetailResponse() != null) { //si el detail response es nulo
				resConsultarCredito = resConsultarCredito + "Código: " + responseConsultarCredito.getValue().getDetailResponse().getCode() + "\n" +
					"Nivel de Severidad: " + responseConsultarCredito.getValue().getDetailResponse().getSeverityLevel()  + "\n" +
					"Descripción: " + responseConsultarCredito.getValue().getDetailResponse().getDescription() + "\n" + 
					"Actor: " + responseConsultarCredito.getValue().getDetailResponse().getActor() + "\n" +
					"Significado Negocio: " + responseConsultarCredito.getValue().getDetailResponse().getBusinessMeaning()  + "\n"; 
			}	
			if(responseConsultarCredito.getValue().getConsultarCreditoResponse() != null) {//si el consultar credito es nulo
				resConsultarCredito = resConsultarCredito + "Id Consulta: " + responseConsultarCredito.getValue().getConsultarCreditoResponse().getIdConsulta()  + "\n" +
				"Límite de Crédito: " + responseConsultarCredito.getValue().getConsultarCreditoResponse().getLimiteCredito()  + "\n" +
				"Crédito Restante: " + responseConsultarCredito.getValue().getConsultarCreditoResponse().getCreditoUtilizado() + "\n";
			}
		}
		return resConsultarCredito;
	}
	
	public static String getResponseOfertaCliente(JAXBElement<OfertarClienteResponse> responseOfertaCliente) {
		String resOfertarCliente ="---------------------------Respuesta Oferta Cliente Safin------------------------------------\n";
		if(responseOfertaCliente.getValue().getDetailResponse() != null) { //si el detail response es nulo
			resOfertarCliente = "Código: " + responseOfertaCliente.getValue().getDetailResponse().getCode()  + "\n" +
					"Nivel de Severidad: " + responseOfertaCliente.getValue().getDetailResponse().getSeverityLevel() + "\n" +
					"Descripción: " + responseOfertaCliente.getValue().getDetailResponse().getDescription() + "\n" + 
					"Actor: " + responseOfertaCliente.getValue().getDetailResponse().getActor() + "\n" +
					"Significado Negocio: " + responseOfertaCliente.getValue().getDetailResponse().getBusinessMeaning() + "\n";
		}
		if(responseOfertaCliente.getValue().getOfertarClienteResponse() != null && responseOfertaCliente.getValue().getOfertarClienteResponse().getOferta() != null) {
			resOfertarCliente = resOfertarCliente +"Límite de Crédito: $" + responseOfertaCliente.getValue().getOfertarClienteResponse().getOferta().getLimiteCredito()  + "\n" +
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
		
		return resOfertarCliente;
	}
	
	public static String getResponseRecalcularOferta(JAXBElement<RecalcularOfertaResponse> responseRecalcular) {
		String resRecalcularOfertaResponse = "-----------------------------Respuesta Recalcular Oferta Safin----------------------------------\n";
		
		if(responseRecalcular.getValue().getDetailResponse() != null) { //si el detail response es nulo
			resRecalcularOfertaResponse = "Código: " + responseRecalcular.getValue().getDetailResponse().getCode()  + "\n" +
					"Nivel de Severidad: " + responseRecalcular.getValue().getDetailResponse().getSeverityLevel() + "\n" +
					"Descripción: " + responseRecalcular.getValue().getDetailResponse().getDescription()  + "\n" + 
					"Actor: " + responseRecalcular.getValue().getDetailResponse().getActor() +  "\n" +
					"Significado Negocio: " + responseRecalcular.getValue().getDetailResponse().getBusinessMeaning() + "\n";
		}
		
		if(responseRecalcular.getValue().getRecalcularOfertaRespType() != null && responseRecalcular.getValue().getRecalcularOfertaRespType().getOferta() != null) {
			resRecalcularOfertaResponse = resRecalcularOfertaResponse + "Límite de Crédito: $" + responseRecalcular.getValue().getRecalcularOfertaRespType().getOferta().getLimiteCredito()  + "\n" +
					"Monto Enganche: $" + responseRecalcular.getValue().getRecalcularOfertaRespType().getOferta().getMontoEnganche()  + "\n" +
					"Monto Financiado: $" + responseRecalcular.getValue().getRecalcularOfertaRespType().getOferta().getMontoFinanciado()  + "\n" +
					"Monto Parcialidad: $" + responseRecalcular.getValue().getRecalcularOfertaRespType().getOferta().getMontoParcialidad()  + "\n" +
					"Monto SobrePrecio: $" + responseRecalcular.getValue().getRecalcularOfertaRespType().getOferta().getMontoSobrePrecio()  + "\n" +
					"Monto Total: $" + responseRecalcular.getValue().getRecalcularOfertaRespType().getOferta().getMontoTotal() + "\n" +
					"Porcentaje Enganche: " + responseRecalcular.getValue().getRecalcularOfertaRespType().getOferta().getPctEnganche()  + "\n" + 
					"Id Oferta: " + responseRecalcular.getValue().getRecalcularOfertaRespType().getOferta().getIdOferta() + "\n";
		}
		
		return resRecalcularOfertaResponse;
	}
	
}
