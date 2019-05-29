package com.telcel.gam.siev.util;

public enum MethodWsType {
	CONSULTAR_CREDITO_METHOD("ConsultarCredito"),
	OFERTAR_CLIENTE_METHOD("OfertarCliente"),
	RECALCULAR_OFERTA_METHOD("RecalucularOferta"),
	EVALUACION_TRAMITE("EvaluacionTramite");
	
	private String metodo;
	
	private MethodWsType(String metodo) {
		this.metodo = metodo;
	}
	
	public String getMetodo() {
		return metodo;
	}
	
}
