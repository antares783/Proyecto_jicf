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
@Table(name = "TC_CREDCHECK_REGIONES", catalog = "SIEV", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TcCredcheckRegiones.findAll", query = "SELECT t FROM TcCredcheckRegiones t"),
    @NamedQuery(name = "TcCredcheckRegiones.findByClave", query = "SELECT t FROM TcCredcheckRegiones t WHERE t.clave = :clave"),
    @NamedQuery(name = "TcCredcheckRegiones.findByRegion", query = "SELECT t FROM TcCredcheckRegiones t WHERE t.region = :region")})
public class TcCredcheckRegiones implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CLAVE")
    private Short clave;
    @Size(max = 3)
    @Column(name = "REGION")
    private String region;

    public TcCredcheckRegiones() {
    }

    public TcCredcheckRegiones(Short clave) {
        this.clave = clave;
    }

    public Short getClave() {
        return clave;
    }

    public void setClave(Short clave) {
        this.clave = clave;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
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
        if (!(object instanceof TcCredcheckRegiones)) {
            return false;
        }
        TcCredcheckRegiones other = (TcCredcheckRegiones) object;
        if ((this.clave == null && other.clave != null) || (this.clave != null && !this.clave.equals(other.clave))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.telcel.gam.siev.modelo.TcCredcheckRegiones[ clave=" + clave + " ]";
    }
    
}
