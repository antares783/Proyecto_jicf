//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.11 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2019.05.14 a las 07:28:27 PM CDT 
//


package com.telcel.gam.siev.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para OfertarClienteResponse complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="OfertarClienteResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="controlData" type="{http://amx.com/mexico/telcel/esb/v1_1}ControlDataResponseType"/&gt;
 *         &lt;element name="detailResponse" type="{http://amx.com/mexico/telcel/esb/v1_1}DetailResponseType"/&gt;
 *         &lt;element name="ofertarClienteResponse" type="{http://www.amx.com.mx/mexico/telcel/di/sds/gds/dcol/safinservices}OfertarClienteRespType"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OfertarClienteResponse", namespace = "http://www.amx.com.mx/mexico/telcel/di/sds/gds/dcol/safinservices", propOrder = {
    "controlData",
    "detailResponse",
    "ofertarClienteResponse"
})
public class OfertarClienteResponse {

    @XmlElement(required = true)
    protected ControlDataResponseType controlData;
    @XmlElement(required = true)
    protected DetailResponseType detailResponse;
    @XmlElement(required = true)
    protected OfertarClienteRespType ofertarClienteResponse;

    /**
     * Obtiene el valor de la propiedad controlData.
     * 
     * @return
     *     possible object is
     *     {@link ControlDataResponseType }
     *     
     */
    public ControlDataResponseType getControlData() {
        return controlData;
    }

    /**
     * Define el valor de la propiedad controlData.
     * 
     * @param value
     *     allowed object is
     *     {@link ControlDataResponseType }
     *     
     */
    public void setControlData(ControlDataResponseType value) {
        this.controlData = value;
    }

    /**
     * Obtiene el valor de la propiedad detailResponse.
     * 
     * @return
     *     possible object is
     *     {@link DetailResponseType }
     *     
     */
    public DetailResponseType getDetailResponse() {
        return detailResponse;
    }

    /**
     * Define el valor de la propiedad detailResponse.
     * 
     * @param value
     *     allowed object is
     *     {@link DetailResponseType }
     *     
     */
    public void setDetailResponse(DetailResponseType value) {
        this.detailResponse = value;
    }

    /**
     * Obtiene el valor de la propiedad ofertarClienteResponse.
     * 
     * @return
     *     possible object is
     *     {@link OfertarClienteRespType }
     *     
     */
    public OfertarClienteRespType getOfertarClienteResponse() {
        return ofertarClienteResponse;
    }

    /**
     * Define el valor de la propiedad ofertarClienteResponse.
     * 
     * @param value
     *     allowed object is
     *     {@link OfertarClienteRespType }
     *     
     */
    public void setOfertarClienteResponse(OfertarClienteRespType value) {
        this.ofertarClienteResponse = value;
    }

}
