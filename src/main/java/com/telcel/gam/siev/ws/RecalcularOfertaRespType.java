//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.11 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2019.05.14 a las 07:28:27 PM CDT 
//


package com.telcel.gam.siev.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para RecalcularOfertaRespType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="RecalcularOfertaRespType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="oferta" type="{http://www.amx.com.mx/mexico/telcel/di/sds/gds/dcol/safinservices}OfertaType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RecalcularOfertaRespType", namespace = "http://www.amx.com.mx/mexico/telcel/di/sds/gds/dcol/safinservices", propOrder = {
    "oferta"
})
public class RecalcularOfertaRespType {

    protected OfertaType oferta;

    /**
     * Obtiene el valor de la propiedad oferta.
     * 
     * @return
     *     possible object is
     *     {@link OfertaType }
     *     
     */
    public OfertaType getOferta() {
        return oferta;
    }

    /**
     * Define el valor de la propiedad oferta.
     * 
     * @param value
     *     allowed object is
     *     {@link OfertaType }
     *     
     */
    public void setOferta(OfertaType value) {
        this.oferta = value;
    }

}
