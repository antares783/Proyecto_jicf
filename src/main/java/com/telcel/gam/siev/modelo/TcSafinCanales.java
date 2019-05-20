/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.telcel.gam.siev.modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author VI8G023
 */
@Entity
@Table(name = "TC_SAFIN_CANALES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TcSafinCanales.findAll", query = "SELECT t FROM TcSafinCanales t"),
    @NamedQuery(name = "TcSafinCanales.findByClave", query = "SELECT t FROM TcSafinCanales t WHERE t.clave = :clave"),
    @NamedQuery(name = "TcSafinCanales.findByCanal", query = "SELECT t FROM TcSafinCanales t WHERE t.canal = :canal")})
public class TcSafinCanales implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CLAVE")
    private Short clave;
    @Size(max = 15)
    @Column(name = "CANAL")
    private String canal;

    public TcSafinCanales() {
    }

    public TcSafinCanales(Short clave) {
        this.clave = clave;
    }

    public Short getClave() {
        return clave;
    }

    public void setClave(Short clave) {
        this.clave = clave;
    }

    public String getCanal() {
        return canal;
    }

    public void setCanal(String canal) {
        this.canal = canal;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (clave != null ? clave.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TcSafinCanales)) {
            return false;
        }
        TcSafinCanales other = (TcSafinCanales) object;
        if ((this.clave == null && other.clave != null) || (this.clave != null && !this.clave.equals(other.clave))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.telcel.gam.siev.modelo.TcSafinCanales[ clave=" + clave + " ]";
    }
    
}
