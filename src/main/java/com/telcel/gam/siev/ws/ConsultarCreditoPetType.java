//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.11 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
<<<<<<< HEAD
// Generado el: 2019.05.31 a las 12:10:52 PM CDT 
=======
// Generado el: 2019.05.24 a las 02:05:34 PM CDT 
>>>>>>> branch 'master' of https://github.com/antares783/Proyecto_jicf.git
//


package com.telcel.gam.siev.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para ConsultarCreditoPetType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="ConsultarCreditoPetType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="usuario" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="passw" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="rfc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="nombre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="apellidos" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="curp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="idSistema" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="region" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="clasificacionCLiente" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="clasificacionBuro" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="idFormaPago" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="icc" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="bcScore" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ConsultarCreditoPetType", namespace = "http://www.amx.com.mx/mexico/telcel/di/sds/gds/dcol/safinservices", propOrder = {
    "usuario",
    "passw",
    "rfc",
    "nombre",
    "apellidos",
    "curp",
    "idSistema",
    "region",
    "clasificacionCLiente",
    "clasificacionBuro",
    "idFormaPago",
    "icc",
    "bcScore"
})
public class ConsultarCreditoPetType {

    @XmlElement(required = true)
    protected String usuario;
    @XmlElement(required = true)
    protected String passw;
    protected String rfc;
    protected String nombre;
    protected String apellidos;
    protected String curp;
    protected Integer idSistema;
    protected String region;
    protected String clasificacionCLiente;
    protected String clasificacionBuro;
    protected String idFormaPago;
    protected Integer icc;
    protected Integer bcScore;

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
     * Obtiene el valor de la propiedad idSistema.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIdSistema() {
        return idSistema;
    }

    /**
     * Define el valor de la propiedad idSistema.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIdSistema(Integer value) {
        this.idSistema = value;
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

}
