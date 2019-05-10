//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.11 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2019.05.10 a las 11:50:20 AM CDT 
//


package com.telcel.gam.siev.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para OfertarClientePetType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="OfertarClientePetType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="usuario" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="passw" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="clasificacionCLiente" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="rfc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="nombre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="apellidos" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="curp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="idProducto" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="cvePlan" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="region" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="numParcialidades" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="idMovimiento" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="idCanal" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="idMercado" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="costoBaseEquipo" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/&gt;
 *         &lt;element name="sobrePrecio" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/&gt;
 *         &lt;element name="clasificacionBuro" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="idFormaPago" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="idSistema" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="cveMarca" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="cveModelo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="numeroEmpleado" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="fuerzaVenta" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="telefono" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="icc" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="bcScore" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="costoAmigoKit" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OfertarClientePetType", namespace = "http://www.amx.com.mx/mexico/telcel/di/sds/gds/dcol/safinservices", propOrder = {
    "usuario",
    "passw",
    "clasificacionCLiente",
    "rfc",
    "nombre",
    "apellidos",
    "curp",
    "idProducto",
    "cvePlan",
    "region",
    "numParcialidades",
    "idMovimiento",
    "idCanal",
    "idMercado",
    "costoBaseEquipo",
    "sobrePrecio",
    "clasificacionBuro",
    "idFormaPago",
    "idSistema",
    "cveMarca",
    "cveModelo",
    "numeroEmpleado",
    "fuerzaVenta",
    "telefono",
    "icc",
    "bcScore",
    "costoAmigoKit"
})
public class OfertarClientePetType {

    @XmlElement(required = true)
    protected String usuario;
    @XmlElement(required = true)
    protected String passw;
    protected String clasificacionCLiente;
    protected String rfc;
    protected String nombre;
    protected String apellidos;
    protected String curp;
    protected Integer idProducto;
    protected String cvePlan;
    @XmlElement(required = true)
    protected String region;
    protected int numParcialidades;
    protected int idMovimiento;
    protected int idCanal;
    protected int idMercado;
    protected Double costoBaseEquipo;
    protected Double sobrePrecio;
    protected String clasificacionBuro;
    protected String idFormaPago;
    protected int idSistema;
    protected String cveMarca;
    protected String cveModelo;
    protected String numeroEmpleado;
    protected String fuerzaVenta;
    protected String telefono;
    protected Integer icc;
    protected Integer bcScore;
    protected Double costoAmigoKit;

    /**
     * Obtiene el valor de la propiedad usuario.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * Define el valor de la propiedad usuario.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUsuario(String value) {
        this.usuario = value;
    }

    /**
     * Obtiene el valor de la propiedad passw.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPassw() {
        return passw;
    }

    /**
     * Define el valor de la propiedad passw.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPassw(String value) {
        this.passw = value;
    }

    /**
     * Obtiene el valor de la propiedad clasificacionCLiente.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClasificacionCLiente() {
        return clasificacionCLiente;
    }

    /**
     * Define el valor de la propiedad clasificacionCLiente.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClasificacionCLiente(String value) {
        this.clasificacionCLiente = value;
    }

    /**
     * Obtiene el valor de la propiedad rfc.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRfc() {
        return rfc;
    }

    /**
     * Define el valor de la propiedad rfc.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRfc(String value) {
        this.rfc = value;
    }

    /**
     * Obtiene el valor de la propiedad nombre.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Define el valor de la propiedad nombre.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombre(String value) {
        this.nombre = value;
    }

    /**
     * Obtiene el valor de la propiedad apellidos.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * Define el valor de la propiedad apellidos.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApellidos(String value) {
        this.apellidos = value;
    }

    /**
     * Obtiene el valor de la propiedad curp.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurp() {
        return curp;
    }

    /**
     * Define el valor de la propiedad curp.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurp(String value) {
        this.curp = value;
    }

    /**
     * Obtiene el valor de la propiedad idProducto.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIdProducto() {
        return idProducto;
    }

    /**
     * Define el valor de la propiedad idProducto.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIdProducto(Integer value) {
        this.idProducto = value;
    }

    /**
     * Obtiene el valor de la propiedad cvePlan.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCvePlan() {
        return cvePlan;
    }

    /**
     * Define el valor de la propiedad cvePlan.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCvePlan(String value) {
        this.cvePlan = value;
    }

    /**
     * Obtiene el valor de la propiedad region.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRegion() {
        return region;
    }

    /**
     * Define el valor de la propiedad region.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRegion(String value) {
        this.region = value;
    }

    /**
     * Obtiene el valor de la propiedad numParcialidades.
     * 
     */
    public int getNumParcialidades() {
        return numParcialidades;
    }

    /**
     * Define el valor de la propiedad numParcialidades.
     * 
     */
    public void setNumParcialidades(int value) {
        this.numParcialidades = value;
    }

    /**
     * Obtiene el valor de la propiedad idMovimiento.
     * 
     */
    public int getIdMovimiento() {
        return idMovimiento;
    }

    /**
     * Define el valor de la propiedad idMovimiento.
     * 
     */
    public void setIdMovimiento(int value) {
        this.idMovimiento = value;
    }

    /**
     * Obtiene el valor de la propiedad idCanal.
     * 
     */
    public int getIdCanal() {
        return idCanal;
    }

    /**
     * Define el valor de la propiedad idCanal.
     * 
     */
    public void setIdCanal(int value) {
        this.idCanal = value;
    }

    /**
     * Obtiene el valor de la propiedad idMercado.
     * 
     */
    public int getIdMercado() {
        return idMercado;
    }

    /**
     * Define el valor de la propiedad idMercado.
     * 
     */
    public void setIdMercado(int value) {
        this.idMercado = value;
    }

    /**
     * Obtiene el valor de la propiedad costoBaseEquipo.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getCostoBaseEquipo() {
        return costoBaseEquipo;
    }

    /**
     * Define el valor de la propiedad costoBaseEquipo.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setCostoBaseEquipo(Double value) {
        this.costoBaseEquipo = value;
    }

    /**
     * Obtiene el valor de la propiedad sobrePrecio.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getSobrePrecio() {
        return sobrePrecio;
    }

    /**
     * Define el valor de la propiedad sobrePrecio.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setSobrePrecio(Double value) {
        this.sobrePrecio = value;
    }

    /**
     * Obtiene el valor de la propiedad clasificacionBuro.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClasificacionBuro() {
        return clasificacionBuro;
    }

    /**
     * Define el valor de la propiedad clasificacionBuro.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClasificacionBuro(String value) {
        this.clasificacionBuro = value;
    }

    /**
     * Obtiene el valor de la propiedad idFormaPago.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdFormaPago() {
        return idFormaPago;
    }

    /**
     * Define el valor de la propiedad idFormaPago.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdFormaPago(String value) {
        this.idFormaPago = value;
    }

    /**
     * Obtiene el valor de la propiedad idSistema.
     * 
     */
    public int getIdSistema() {
        return idSistema;
    }

    /**
     * Define el valor de la propiedad idSistema.
     * 
     */
    public void setIdSistema(int value) {
        this.idSistema = value;
    }

    /**
     * Obtiene el valor de la propiedad cveMarca.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCveMarca() {
        return cveMarca;
    }

    /**
     * Define el valor de la propiedad cveMarca.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCveMarca(String value) {
        this.cveMarca = value;
    }

    /**
     * Obtiene el valor de la propiedad cveModelo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCveModelo() {
        return cveModelo;
    }

    /**
     * Define el valor de la propiedad cveModelo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCveModelo(String value) {
        this.cveModelo = value;
    }

    /**
     * Obtiene el valor de la propiedad numeroEmpleado.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumeroEmpleado() {
        return numeroEmpleado;
    }

    /**
     * Define el valor de la propiedad numeroEmpleado.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumeroEmpleado(String value) {
        this.numeroEmpleado = value;
    }

    /**
     * Obtiene el valor de la propiedad fuerzaVenta.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFuerzaVenta() {
        return fuerzaVenta;
    }

    /**
     * Define el valor de la propiedad fuerzaVenta.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFuerzaVenta(String value) {
        this.fuerzaVenta = value;
    }

    /**
     * Obtiene el valor de la propiedad telefono.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Define el valor de la propiedad telefono.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTelefono(String value) {
        this.telefono = value;
    }

    /**
     * Obtiene el valor de la propiedad icc.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIcc() {
        return icc;
    }

    /**
     * Define el valor de la propiedad icc.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIcc(Integer value) {
        this.icc = value;
    }

    /**
     * Obtiene el valor de la propiedad bcScore.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getBcScore() {
        return bcScore;
    }

    /**
     * Define el valor de la propiedad bcScore.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setBcScore(Integer value) {
        this.bcScore = value;
    }

    /**
     * Obtiene el valor de la propiedad costoAmigoKit.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getCostoAmigoKit() {
        return costoAmigoKit;
    }

    /**
     * Define el valor de la propiedad costoAmigoKit.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setCostoAmigoKit(Double value) {
        this.costoAmigoKit = value;
    }

}
