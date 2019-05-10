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
@Table(name = "TC_CREDCHECK_ESTADOS", catalog = "SIEV", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TcCredcheckEstados.findAll", query = "SELECT t FROM TcCredcheckEstados t"),
    @NamedQuery(name = "TcCredcheckEstados.findByClave", query = "SELECT t FROM TcCredcheckEstados t WHERE t.clave = :clave"),
    @NamedQuery(name = "TcCredcheckEstados.findByEstado", query = "SELECT t FROM TcCredcheckEstados t WHERE t.estado = :estado")})
public class TcCredcheckEstados implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "CLAVE")
    private String clave;
    @Size(max = 20)
    @Column(name = "ESTADO")
    private String estado;

    public TcCredcheckEstados() {
    }

    public TcCredcheckEstados(String clave) {
        this.clave = clave;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
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
        if (!(object instanceof TcCredcheckEstados)) {
            return false;
        }
        TcCredcheckEstados other = (TcCredcheckEstados) object;
        if ((this.clave == null && other.clave != null) || (this.clave != null && !this.clave.equals(other.clave))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.telcel.gam.siev.modelo.TcCredcheckEstados[ clave=" + clave + " ]";
    }
    
}
