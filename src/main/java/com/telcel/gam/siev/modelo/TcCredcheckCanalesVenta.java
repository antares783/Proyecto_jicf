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
@Table(name = "TC_CREDCHECK_CANALES_VENTA", catalog = "SIEV", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TcCredcheckCanalesVenta.findAll", query = "SELECT t FROM TcCredcheckCanalesVenta t"),
    @NamedQuery(name = "TcCredcheckCanalesVenta.findByCanalVenta", query = "SELECT t FROM TcCredcheckCanalesVenta t WHERE t.canalVenta = :canalVenta")})
public class TcCredcheckCanalesVenta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "CANAL_VENTA")
    private String canalVenta;

    public TcCredcheckCanalesVenta() {
    }

    public TcCredcheckCanalesVenta(String canalVenta) {
        this.canalVenta = canalVenta;
    }

    public String getCanalVenta() {
        return canalVenta;
    }

    public void setCanalVenta(String canalVenta) {
        this.canalVenta = canalVenta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (canalVenta != null ? canalVenta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TcCredcheckCanalesVenta)) {
            return false;
        }
        TcCredcheckCanalesVenta other = (TcCredcheckCanalesVenta) object;
        if ((this.canalVenta == null && other.canalVenta != null) || (this.canalVenta != null && !this.canalVenta.equals(other.canalVenta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.telcel.gam.siev.modelo.TcCredcheckCanalesVenta[ canalVenta=" + canalVenta + " ]";
    }
    
}
