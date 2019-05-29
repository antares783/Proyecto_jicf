package com.telcel.gam.siev.util;

public enum SystemType {
	SAFIN(1),
	CREDITCHECK(2);
	
	private Integer valor;
	
	private SystemType(Integer valor) {
		this.valor = valor;
	}
	
	public Integer getValor() {
		return valor;
	}
}
