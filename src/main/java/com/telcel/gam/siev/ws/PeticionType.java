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
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Clase Java para PeticionType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="PeticionType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="usuario" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="passw" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="folioSisact" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="rfc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="nombre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="numParcialidades" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="idSistema" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="idProducto" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="idMercado" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="idMovimiento" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="idCanal" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="costoBaseEquipo" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/&gt;
 *         &lt;element name="limiteDeCredito" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/&gt;
 *         &lt;element name="sobrePrecio" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/&gt;
 *         &lt;element name="pctEnganche" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/&gt;
 *         &lt;element name="region" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="fechaNacimiento" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="clasificacionCLiente" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PeticionType", namespace = "http://www.amx.com.mx/mexico/telcel/di/sds/gds/dcol/safinservices", propOrder = {
    "usuario",
    "passw",
    "folioSisact",
    "rfc",
    "nombre",
    "numParcialidades",
    "idSistema",
    "idProducto",
    "idMercado",
    "idMovimiento",
    "idCanal",
    "costoBaseEquipo",
    "limiteDeCredito",
    "sobrePrecio",
    "pctEnganche",
    "region",
    "fechaNacimiento",
    "clasificacionCLiente"
})
public class PeticionType {

    @XmlElement(required = true)
    protected String usuario;
    @XmlElement(required = true)
    protected String passw;
    protected Integer folioSisact;
    protected String rfc;
    protected String nombre;
    protected int numParcialidades;
    protected int idSistema;
    protected int idProducto;
    protected int idMercado;
    protected int idMovimiento;
    protected int idCanal;
    protected Double costoBaseEquipo;
    protected Double limiteDeCredito;
    protected Double sobrePrecio;
    protected Double pctEnganche;
    @XmlElement(required = true)
    protected String region;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaNacimiento;
    protected String clasificacionCLiente;

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
     * Obtiene el valor de la propiedad folioSisact.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getFolioSisact() {
        return folioSisact;
    }

    /**
     * Define el valor de la propiedad folioSisact.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setFolioSisact(Integer value) {
        this.folioSisact = value;
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
     * Obtiene el valor de la propiedad idProducto.
     * 
     */
    public int getIdProducto() {
        return idProducto;
    }

    /**
     * Define el valor de la propiedad idProducto.
     * 
     */
    public void setIdProducto(int value) {
        this.idProducto = value;
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
     * Obtiene el valor de la propiedad limiteDeCredito.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getLimiteDeCredito() {
        return limiteDeCredito;
    }

    /**
     * Define el valor de la propiedad limiteDeCredito.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setLimiteDeCredito(Double value) {
        this.limiteDeCredito = value;
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
     * Obtiene el valor de la propiedad pctEnganche.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getPctEnganche() {
        return pctEnganche;
    }

    /**
     * Define el valor de la propiedad pctEnganche.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setPctEnganche(Double value) {
        this.pctEnganche = value;
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
     * Obtiene el valor de la propiedad fechaNacimiento.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * Define el valor de la propiedad fechaNacimiento.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaNacimiento(XMLGregorianCalendar value) {
        this.fechaNacimiento = value;
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

}
