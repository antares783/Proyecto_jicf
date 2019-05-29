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
 * <p>Clase Java para ReservarCreditoResponse complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="ReservarCreditoResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="controlData" type="{http://amx.com/mexico/telcel/esb/v1_1}ControlDataResponseType"/&gt;
 *         &lt;element name="detailResponse" type="{http://amx.com/mexico/telcel/esb/v1_1}DetailResponseType"/&gt;
 *         &lt;element name="reservarCreditoResponse" type="{http://www.amx.com.mx/mexico/telcel/di/sds/gds/dcol/safinservices}ReservarCreditoRespType"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ReservarCreditoResponse", namespace = "http://www.amx.com.mx/mexico/telcel/di/sds/gds/dcol/safinservices", propOrder = {
    "controlData",
    "detailResponse",
    "reservarCreditoResponse"
})
public class ReservarCreditoResponse {

    @XmlElement(required = true)
    protected ControlDataResponseType controlData;
    @XmlElement(required = true)
    protected DetailResponseType detailResponse;
    @XmlElement(required = true)
    protected ReservarCreditoRespType reservarCreditoResponse;

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
     * Obtiene el valor de la propiedad reservarCreditoResponse.
     * 
     * @return
     *     possible object is
     *     {@link ReservarCreditoRespType }
     *     
     */
    public ReservarCreditoRespType getReservarCreditoResponse() {
        return reservarCreditoResponse;
    }

    /**
     * Define el valor de la propiedad reservarCreditoResponse.
     * 
     * @param value
     *     allowed object is
     *     {@link ReservarCreditoRespType }
     *     
     */
    public void setReservarCreditoResponse(ReservarCreditoRespType value) {
        this.reservarCreditoResponse = value;
    }

}
