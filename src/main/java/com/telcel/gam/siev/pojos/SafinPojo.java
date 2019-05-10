/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.telcel.gam.siev.pojos;

import java.io.Serializable;

/**
 *
 * @author VI8G023
 */

public class SafinPojo implements Serializable{
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private String rfc;
    private String nombre;
    private String apellidos;
    private String curp;
    private String idSistema;
    private String region;
    private String clasificacionCliente;
    private String clasificacionBuro;
    private String formaPago;
    private String cvePlan;
    private Integer parcialidades;
    private String movimiento;
    private String idCanal;
    private String idMercado;
    private Double costoBase;
    private Double sobrePrecio;
    private String cveMarca;
    private String cveModelo;
    private String numEmpleado;
    private String fuerzaVenta;
    private String telefono;
    private Double costoAmigoKit;
    private Double aportacionVoluntaria;
    private Integer idOferta;
    private int    icc;
    private int    scoreBuro;
    private String idProducto;

    public SafinPojo() {}
    
    
    
//    public SafinPojo(String rfc, String nombre, String apellidos, String curp, int idSistema, int region,
//			String clasificacionCliente, String clasificacionBuro, String formaPago, String cvePlan,
//			Double parcialidades, String movimiento, String canal, String mercado, Double costoBase, Double sobrePrecio,
//			String cveMarca, String cveModelo, String numEmpleado, String fuerzaVenta, String telefono,
//			Double costoAmigoKit, Double aportacionVoluntaria, String idOferta, int icc, int scoreBuro) {
//		super();
//		this.rfc = rfc;
//		this.nombre = nombre;
//		this.apellidos = apellidos;
//		this.curp = curp;
//		this.idSistema = idSistema;
//		this.region = region;
//		this.clasificacionCliente = clasificacionCliente;
//		this.clasificacionBuro = clasificacionBuro;
//		this.formaPago = formaPago;
//		this.cvePlan = cvePlan;
//		this.parcialidades = parcialidades;
//		this.movimiento = movimiento;
//		this.canal = canal;
//		this.mercado = mercado;
//		this.costoBase = costoBase;
//		this.sobrePrecio = sobrePrecio;
//		this.cveMarca = cveMarca;
//		this.cveModelo = cveModelo;
//		this.numEmpleado = numEmpleado;
//		this.fuerzaVenta = fuerzaVenta;
//		this.telefono = telefono;
//		this.costoAmigoKit = costoAmigoKit;
//		this.aportacionVoluntaria = aportacionVoluntaria;
//		this.idOferta = idOferta;
//		this.icc = icc;
//		this.scoreBuro = scoreBuro;
//	}
    
    
	public String getRfc() {
        return rfc;
    }

    public String getIdProducto() {
		return idProducto;
	}



	public void setIdProducto(String idProducto) {
		this.idProducto = idProducto;
	}



	public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public String getIdSistema() {
        return idSistema;
    }

    public void setIdSistema(String idSistema) {
        this.idSistema = idSistema;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getClasificacionCliente() {
        return clasificacionCliente;
    }

    public void setClasificacionCliente(String clasificacionCliente) {
        this.clasificacionCliente = clasificacionCliente;
    }

    public String getClasificacionBuro() {
        return clasificacionBuro;
    }

    public void setClasificacionBuro(String clasificacionBuro) {
        this.clasificacionBuro = clasificacionBuro;
    }

    public String getformaPago() {
        return formaPago;
    }

    public void setformaPago(String formaPago) {
        this.formaPago = formaPago;
    }

    public int getIcc() {
        return icc;
    }

    public void setIcc(int icc) {
        this.icc = icc;
    }

    public int getScoreBuro() {
        return scoreBuro;
    }

    public void setScoreBuro(int scoreBuro) {
        this.scoreBuro = scoreBuro;
    }

    public String getCvePlan() {
        return cvePlan;
    }

    public void setCvePlan(String cvePlan) {
        this.cvePlan = cvePlan;
    }

    public Integer getParcialidades() {
        return parcialidades;
    }

    public void setParcialidades(Integer parcialidades) {
        this.parcialidades = parcialidades;
    }

    public String getMovimiento() {
        return movimiento;
    }

    public void setMovimiento(String movimiento) {
        this.movimiento = movimiento;
    }

    public String getIdCanal() {
        return idCanal;
    }

    public void setIdCanal(String idCanal) {
        this.idCanal = idCanal;
    }

    public String getIdMercado() {
        return idMercado;
    }

    public void setIdMercado(String idMercado) {
        this.idMercado = idMercado;
    }

    public Double getCostoBase() {
        return costoBase;
    }

    public void setCostoBase(Double costoBase) {
        this.costoBase = costoBase;
    }

    public Double getSobrePrecio() {
        return sobrePrecio;
    }

    public void setSobrePrecio(Double sobrePrecio) {
        this.sobrePrecio = sobrePrecio;
    }

    public String getCveMarca() {
        return cveMarca;
    }

    public void setCveMarca(String cveMarca) {
        this.cveMarca = cveMarca;
    }

    public String getCveModelo() {
        return cveModelo;
    }

    public void setCveModelo(String cveModelo) {
        this.cveModelo = cveModelo;
    }

    public String getNumEmpleado() {
        return numEmpleado;
    }

    public void setNumEmpleado(String numEmpleado) {
        this.numEmpleado = numEmpleado;
    }

    public String getFuerzaVenta() {
        return fuerzaVenta;
    }

    public void setFuerzaVenta(String fuerzaVenta) {
        this.fuerzaVenta = fuerzaVenta;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Double getCostoAmigoKit() {
        return costoAmigoKit;
    }

    public void setCostoAmigoKit(Double costoAmigoKit) {
        this.costoAmigoKit = costoAmigoKit;
    }

    public Double getAportacionVoluntaria() {
        return aportacionVoluntaria;
    }

    public void setAportacionVoluntaria(Double aportacionVoluntaria) {
        this.aportacionVoluntaria = aportacionVoluntaria;
    }

    public Integer getIdOferta() {
        return idOferta;
    }

    public void setIdOferta(Integer idOferta) {
        this.idOferta = idOferta;
    }
        
}
