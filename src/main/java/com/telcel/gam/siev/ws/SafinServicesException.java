//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.11 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2019.05.20 a las 01:27:28 PM CDT 
//


package com.telcel.gam.siev.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para SafinServicesException complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="SafinServicesException"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="controlData" type="{http://amx.com/mexico/telcel/esb/v1_1}ControlDataResponseType"/&gt;
 *         &lt;element name="detailFail" type="{http://amx.com/mexico/telcel/esb/v1_1}DetailFailType"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SafinServicesException", namespace = "http://www.amx.com.mx/mexico/telcel/di/sds/gds/dcol/safinservices", propOrder = {
    "controlData",
    "detailFail"
})
public class SafinServicesException {

    @XmlElement(required = true)
    protected ControlDataResponseType controlData;
    @XmlElement(required = true)
    protected DetailFailType detailFail;

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
     * Obtiene el valor de la propiedad detailFail.
     * 
     * @return
     *     possible object is
     *     {@link DetailFailType }
     *     
     */
    public DetailFailType getDetailFail() {
        return detailFail;
    }

    /**
     * Define el valor de la propiedad detailFail.
     * 
     * @param value
     *     allowed object is
     *     {@link DetailFailType }
     *     
     */
    public void setDetailFail(DetailFailType value) {
        this.detailFail = value;
    }

}
