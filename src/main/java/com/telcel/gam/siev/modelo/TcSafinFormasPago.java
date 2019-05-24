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
@Table(name = "TC_SAFIN_FORMAS_PAGO", catalog = "SIEV", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TcSafinFormasPago.findAll", query = "SELECT t FROM TcSafinFormasPago t"),
    @NamedQuery(name = "TcSafinFormasPago.findByClave", query = "SELECT t FROM TcSafinFormasPago t WHERE t.clave = :clave"),
    @NamedQuery(name = "TcSafinFormasPago.findByFormaPago", query = "SELECT t FROM TcSafinFormasPago t WHERE t.formaPago = :formaPago")})
public class TcSafinFormasPago implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "CLAVE")
    private String clave;
    @Size(max = 25)
    @Column(name = "FORMA_PAGO")
    private String formaPago;

    public TcSafinFormasPago() {
    }

    public TcSafinFormasPago(String clave) {
        this.clave = clave;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
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
        if (!(object instanceof TcSafinFormasPago)) {
            return false;
        }
        TcSafinFormasPago other = (TcSafinFormasPago) object;
        if ((this.clave == null && other.clave != null) || (this.clave != null && !this.clave.equals(other.clave))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.telcel.gam.siev.modelo.TcSafinFormasPago[ clave=" + clave + " ]";
    }
    
}
