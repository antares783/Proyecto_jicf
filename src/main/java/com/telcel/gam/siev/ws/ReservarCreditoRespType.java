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
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para ReservarCreditoRespType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="ReservarCreditoRespType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="idReserva" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="limiteCredito" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/&gt;
 *         &lt;element name="creditoRestante" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/&gt;
 *         &lt;element name="creditoUtilizado" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ReservarCreditoRespType", namespace = "http://www.amx.com.mx/mexico/telcel/di/sds/gds/dcol/safinservices", propOrder = {
    "idReserva",
    "limiteCredito",
    "creditoRestante",
    "creditoUtilizado"
})
public class ReservarCreditoRespType {

    protected Integer idReserva;
    protected Double limiteCredito;
    protected Double creditoRestante;
    protected Double creditoUtilizado;

    /**
     * Obtiene el valor de la propiedad idReserva.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIdReserva() {
        return idReserva;
    }

    /**
     * Define el valor de la propiedad idReserva.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIdReserva(Integer value) {
        this.idReserva = value;
    }

    /**
     * Obtiene el valor de la propiedad limiteCredito.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getLimiteCredito() {
        return limiteCredito;
    }

    /**
     * Define el valor de la propiedad limiteCredito.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setLimiteCredito(Double value) {
        this.limiteCredito = value;
    }

    /**
     * Obtiene el valor de la propiedad creditoRestante.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getCreditoRestante() {
        return creditoRestante;
    }

    /**
     * Define el valor de la propiedad creditoRestante.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setCreditoRestante(Double value) {
        this.creditoRestante = value;
    }

    /**
     * Obtiene el valor de la propiedad creditoUtilizado.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getCreditoUtilizado() {
        return creditoUtilizado;
    }

    /**
     * Define el valor de la propiedad creditoUtilizado.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setCreditoUtilizado(Double value) {
        this.creditoUtilizado = value;
    }

}
