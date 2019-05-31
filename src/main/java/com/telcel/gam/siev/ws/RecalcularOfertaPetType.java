//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.11 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2019.05.31 a las 12:10:52 PM CDT 
//


package com.telcel.gam.siev.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para RecalcularOfertaPetType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="RecalcularOfertaPetType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="usuario" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="passw" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="idOferta" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="aportacionVol" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="region" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="idSistema" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RecalcularOfertaPetType", namespace = "http://www.amx.com.mx/mexico/telcel/di/sds/gds/dcol/safinservices", propOrder = {
    "usuario",
    "passw",
    "idOferta",
    "aportacionVol",
    "region",
    "idSistema"
})
public class RecalcularOfertaPetType {

    @XmlElement(required = true)
    protected String usuario;
    @XmlElement(required = true)
    protected String passw;
    protected int idOferta;
    protected double aportacionVol;
    protected int region;
    protected int idSistema;

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
     * Obtiene el valor de la propiedad idOferta.
     * 
     */
    public int getIdOferta() {
        return idOferta;
    }

    /**
     * Define el valor de la propiedad idOferta.
     * 
     */
    public void setIdOferta(int value) {
        this.idOferta = value;
    }

    /**
     * Obtiene el valor de la propiedad aportacionVol.
     * 
     */
    public double getAportacionVol() {
        return aportacionVol;
    }

    /**
     * Define el valor de la propiedad aportacionVol.
     * 
     */
    public void setAportacionVol(double value) {
        this.aportacionVol = value;
    }

    /**
     * Obtiene el valor de la propiedad region.
     * 
     */
    public int getRegion() {
        return region;
    }

    /**
     * Define el valor de la propiedad region.
     * 
     */
    public void setRegion(int value) {
        this.region = value;
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

}
