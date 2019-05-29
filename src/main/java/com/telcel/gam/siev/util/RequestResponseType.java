package com.telcel.gam.siev.util;

public enum RequestResponseType {
	
	CONSULTAR_CREDITO_REQUEST(1), 
	CONSULTAR_CREDITO_RESPONSE(2),
	OFERTAR_CLIENTE_REQUEST(3),
	OFERTAR_CLIENTE_RESPONSE(4),
	RECALCULAR_OFERTA_REQUEST(5),
	RECALCULAR_OFERTA_RESPONSE(6),
	EVALUACION_TRAMITE_REQUEST(7),
	EVALUACION_TRAMITE_RESPONSE(8);
	
	private Integer valor;
	
	RequestResponseType(Integer valor){
		this.valor = valor;
	}
	
	public Integer getValor() {
		return valor;
	}
}
