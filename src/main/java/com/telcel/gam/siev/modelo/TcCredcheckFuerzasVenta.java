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
@Table(name = "TC_CREDCHECK_FUERZAS_VENTA", catalog = "SIEV", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TcCredcheckFuerzasVenta.findAll", query = "SELECT t FROM TcCredcheckFuerzasVenta t"),
    @NamedQuery(name = "TcCredcheckFuerzasVenta.findByFuerzaVenta", query = "SELECT t FROM TcCredcheckFuerzasVenta t WHERE t.fuerzaVenta = :fuerzaVenta")})
public class TcCredcheckFuerzasVenta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "FUERZA_VENTA")
    private String fuerzaVenta;

    public TcCredcheckFuerzasVenta() {
    }

    public TcCredcheckFuerzasVenta(String fuerzaVenta) {
        this.fuerzaVenta = fuerzaVenta;
    }

    public String getFuerzaVenta() {
        return fuerzaVenta;
    }

    public void setFuerzaVenta(String fuerzaVenta) {
        this.fuerzaVenta = fuerzaVenta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fuerzaVenta != null ? fuerzaVenta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TcCredcheckFuerzasVenta)) {
            return false;
        }
        TcCredcheckFuerzasVenta other = (TcCredcheckFuerzasVenta) object;
        if ((this.fuerzaVenta == null && other.fuerzaVenta != null) || (this.fuerzaVenta != null && !this.fuerzaVenta.equals(other.fuerzaVenta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.telcel.gam.siev.modelo.TcCredcheckFuerzasVenta[ fuerzaVenta=" + fuerzaVenta + " ]";
    }
    
}
