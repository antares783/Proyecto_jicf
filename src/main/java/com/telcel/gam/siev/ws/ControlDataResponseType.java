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


/**
 * <p>Clase Java para ControlDataResponseType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="ControlDataResponseType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="messageUUID" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="responseDate" type="{http://www.w3.org/2001/XMLSchema}anySimpleType"/&gt;
 *         &lt;element name="sendBy" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="latency" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="version" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ControlDataResponseType", namespace = "http://amx.com/mexico/telcel/esb/v1_1", propOrder = {
    "messageUUID",
    "responseDate",
    "sendBy",
    "latency",
    "version"
})
public class ControlDataResponseType {

    @XmlElement(namespace = "http://amx.com/mexico/telcel/esb/v1_1", required = true)
    protected String messageUUID;
    @XmlElement(namespace = "http://amx.com/mexico/telcel/esb/v1_1", required = true)
    @XmlSchemaType(name = "anySimpleType")
    protected Object responseDate;
    @XmlElement(namespace = "http://amx.com/mexico/telcel/esb/v1_1", required = true)
    protected String sendBy;
    @XmlElement(namespace = "http://amx.com/mexico/telcel/esb/v1_1")
    protected Long latency;
    @XmlElement(namespace = "http://amx.com/mexico/telcel/esb/v1_1", required = true)
    protected String version;

    /**
     * Obtiene el valor de la propiedad messageUUID.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMessageUUID() {
        return messageUUID;
    }

    /**
     * Define el valor de la propiedad messageUUID.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMessageUUID(String value) {
        this.messageUUID = value;
    }

    /**
     * Obtiene el valor de la propiedad responseDate.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getResponseDate() {
        return responseDate;
    }

    /**
     * Define el valor de la propiedad responseDate.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setResponseDate(Object value) {
        this.responseDate = value;
    }

    /**
     * Obtiene el valor de la propiedad sendBy.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSendBy() {
        return sendBy;
    }

    /**
     * Define el valor de la propiedad sendBy.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSendBy(String value) {
        this.sendBy = value;
    }

    /**
     * Obtiene el valor de la propiedad latency.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getLatency() {
        return latency;
    }

    /**
     * Define el valor de la propiedad latency.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setLatency(Long value) {
        this.latency = value;
    }

    /**
     * Obtiene el valor de la propiedad version.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVersion() {
        return version;
    }

    /**
     * Define el valor de la propiedad version.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVersion(String value) {
        this.version = value;
    }

}
