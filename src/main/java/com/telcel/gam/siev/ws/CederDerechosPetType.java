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
 * <p>Clase Java para CederDerechosPetType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="CederDerechosPetType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="usuario" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="passw" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="idSistema" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="clienteCedente" type="{http://www.amx.com.mx/mexico/telcel/di/sds/gds/dcol/safinservices}Cliente"/&gt;
 *         &lt;element name="clienteCesionario" type="{http://www.amx.com.mx/mexico/telcel/di/sds/gds/dcol/safinservices}Cliente"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CederDerechosPetType", namespace = "http://www.amx.com.mx/mexico/telcel/di/sds/gds/dcol/safinservices", propOrder = {
    "usuario",
    "passw",
    "idSistema",
    "clienteCedente",
    "clienteCesionario"
})
public class CederDerechosPetType {

    @XmlElement(required = true)
    protected String usuario;
    @XmlElement(required = true)
    protected String passw;
    protected int idSistema;
    @XmlElement(required = true)
    protected Cliente clienteCedente;
    @XmlElement(required = true)
    protected Cliente clienteCesionario;

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
     * Obtiene el valor de la propiedad clienteCedente.
     * 
     * @return
     *     possible object is
     *     {@link Cliente }
     *     
     */
    public Cliente getClienteCedente() {
        return clienteCedente;
    }

    /**
     * Define el valor de la propiedad clienteCedente.
     * 
     * @param value
     *     allowed object is
     *     {@link Cliente }
     *     
     */
    public void setClienteCedente(Cliente value) {
        this.clienteCedente = value;
    }

    /**
     * Obtiene el valor de la propiedad clienteCesionario.
     * 
     * @return
     *     possible object is
     *     {@link Cliente }
     *     
     */
    public Cliente getClienteCesionario() {
        return clienteCesionario;
    }

    /**
     * Define el valor de la propiedad clienteCesionario.
     * 
     * @param value
     *     allowed object is
     *     {@link Cliente }
     *     
     */
    public void setClienteCesionario(Cliente value) {
        this.clienteCesionario = value;
    }

}
