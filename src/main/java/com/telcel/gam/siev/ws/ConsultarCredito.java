//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.11 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2019.05.29 a las 12:42:08 AM CDT 
//


package com.telcel.gam.siev.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para ConsultarCredito complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="ConsultarCredito"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="controlData" type="{http://amx.com/mexico/telcel/esb/v1_1}ControlDataRequestType"/&gt;
 *         &lt;element name="consultarCliente" type="{http://www.amx.com.mx/mexico/telcel/di/sds/gds/dcol/safinservices}ConsultarCreditoPetType"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ConsultarCredito", namespace = "http://www.amx.com.mx/mexico/telcel/di/sds/gds/dcol/safinservices", propOrder = {
    "controlData",
    "consultarCliente"
})
public class ConsultarCredito {

    @XmlElement(required = true)
    protected ControlDataRequestType controlData;
    @XmlElement(required = true)
    protected ConsultarCreditoPetType consultarCliente;

    /**
     * Obtiene el valor de la propiedad controlData.
     * 
     * @return
     *     possible object is
     *     {@link ControlDataRequestType }
     *     
     */
    public ControlDataRequestType getControlData() {
        return controlData;
    }

    /**
     * Define el valor de la propiedad controlData.
     * 
     * @param value
     *     allowed object is
     *     {@link ControlDataRequestType }
     *     
     */
    public void setControlData(ControlDataRequestType value) {
        this.controlData = value;
    }

    /**
     * Obtiene el valor de la propiedad consultarCliente.
     * 
     * @return
     *     possible object is
     *     {@link ConsultarCreditoPetType }
     *     
     */
    public ConsultarCreditoPetType getConsultarCliente() {
        return consultarCliente;
    }

    /**
     * Define el valor de la propiedad consultarCliente.
     * 
     * @param value
     *     allowed object is
     *     {@link ConsultarCreditoPetType }
     *     
     */
    public void setConsultarCliente(ConsultarCreditoPetType value) {
        this.consultarCliente = value;
    }

}
