//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.11 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2019.05.24 a las 02:05:34 PM CDT 
//


package com.telcel.gam.siev.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para OfertaType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="OfertaType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="limiteCredito" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/&gt;
 *         &lt;element name="montoEnganche" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/&gt;
 *         &lt;element name="montoFinanciado" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/&gt;
 *         &lt;element name="montoParcialidad" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/&gt;
 *         &lt;element name="montoSobrePrecio" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/&gt;
 *         &lt;element name="montoTotal" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/&gt;
 *         &lt;element name="pctEnganche" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/&gt;
 *         &lt;element name="idOferta" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="creditoRestante" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/&gt;
 *         &lt;element name="creditoUtilizado" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/&gt;
 *         &lt;element name="montoEngancheIva" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/&gt;
 *         &lt;element name="montoFinanciadoIva" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/&gt;
 *         &lt;element name="montoParcialidadIva" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/&gt;
 *         &lt;element name="montoSobrePrecioIva" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/&gt;
 *         &lt;element name="montoTotalIva" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/&gt;
 *         &lt;element name="cat" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OfertaType", namespace = "http://www.amx.com.mx/mexico/telcel/di/sds/gds/dcol/safinservices", propOrder = {
    "limiteCredito",
    "montoEnganche",
    "montoFinanciado",
    "montoParcialidad",
    "montoSobrePrecio",
    "montoTotal",
    "pctEnganche",
    "idOferta",
    "creditoRestante",
    "creditoUtilizado",
    "montoEngancheIva",
    "montoFinanciadoIva",
    "montoParcialidadIva",
    "montoSobrePrecioIva",
    "montoTotalIva",
    "cat"
})
public class OfertaType {

    protected Double limiteCredito;
    protected Double montoEnganche;
    protected Double montoFinanciado;
    protected Double montoParcialidad;
    protected Double montoSobrePrecio;
    protected Double montoTotal;
    protected Double pctEnganche;
    protected Integer idOferta;
    protected Double creditoRestante;
    protected Double creditoUtilizado;
    protected Double montoEngancheIva;
    protected Double montoFinanciadoIva;
    protected Double montoParcialidadIva;
    protected Double montoSobrePrecioIva;
    protected Double montoTotalIva;
    protected Double cat;

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
     * Obtiene el valor de la propiedad montoEnganche.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getMontoEnganche() {
        return montoEnganche;
    }

    /**
     * Define el valor de la propiedad montoEnganche.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setMontoEnganche(Double value) {
        this.montoEnganche = value;
    }

    /**
     * Obtiene el valor de la propiedad montoFinanciado.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getMontoFinanciado() {
        return montoFinanciado;
    }

    /**
     * Define el valor de la propiedad montoFinanciado.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setMontoFinanciado(Double value) {
        this.montoFinanciado = value;
    }

    /**
     * Obtiene el valor de la propiedad montoParcialidad.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getMontoParcialidad() {
        return montoParcialidad;
    }

    /**
     * Define el valor de la propiedad montoParcialidad.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setMontoParcialidad(Double value) {
        this.montoParcialidad = value;
    }

    /**
     * Obtiene el valor de la propiedad montoSobrePrecio.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getMontoSobrePrecio() {
        return montoSobrePrecio;
    }

    /**
     * Define el valor de la propiedad montoSobrePrecio.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setMontoSobrePrecio(Double value) {
        this.montoSobrePrecio = value;
    }

    /**
     * Obtiene el valor de la propiedad montoTotal.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getMontoTotal() {
        return montoTotal;
    }

    /**
     * Define el valor de la propiedad montoTotal.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setMontoTotal(Double value) {
        this.montoTotal = value;
    }

    /**
     * Obtiene el valor de la propiedad pctEnganche.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getPctEnganche() {
        return pctEnganche;
    }

    /**
     * Define el valor de la propiedad pctEnganche.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setPctEnganche(Double value) {
        this.pctEnganche = value;
    }

    /**
     * Obtiene el valor de la propiedad idOferta.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIdOferta() {
        return idOferta;
    }

    /**
     * Define el valor de la propiedad idOferta.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIdOferta(Integer value) {
        this.idOferta = value;
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

    /**
     * Obtiene el valor de la propiedad montoEngancheIva.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getMontoEngancheIva() {
        return montoEngancheIva;
    }

    /**
     * Define el valor de la propiedad montoEngancheIva.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setMontoEngancheIva(Double value) {
        this.montoEngancheIva = value;
    }

    /**
     * Obtiene el valor de la propiedad montoFinanciadoIva.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getMontoFinanciadoIva() {
        return montoFinanciadoIva;
    }

    /**
     * Define el valor de la propiedad montoFinanciadoIva.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setMontoFinanciadoIva(Double value) {
        this.montoFinanciadoIva = value;
    }

    /**
     * Obtiene el valor de la propiedad montoParcialidadIva.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getMontoParcialidadIva() {
        return montoParcialidadIva;
    }

    /**
     * Define el valor de la propiedad montoParcialidadIva.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setMontoParcialidadIva(Double value) {
        this.montoParcialidadIva = value;
    }

    /**
     * Obtiene el valor de la propiedad montoSobrePrecioIva.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getMontoSobrePrecioIva() {
        return montoSobrePrecioIva;
    }

    /**
     * Define el valor de la propiedad montoSobrePrecioIva.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setMontoSobrePrecioIva(Double value) {
        this.montoSobrePrecioIva = value;
    }

    /**
     * Obtiene el valor de la propiedad montoTotalIva.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getMontoTotalIva() {
        return montoTotalIva;
    }

    /**
     * Define el valor de la propiedad montoTotalIva.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setMontoTotalIva(Double value) {
        this.montoTotalIva = value;
    }

    /**
     * Obtiene el valor de la propiedad cat.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getCat() {
        return cat;
    }

    /**
     * Define el valor de la propiedad cat.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setCat(Double value) {
        this.cat = value;
    }

}
