/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.telcel.gam.siev.modelo;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author VI8G023
 */
@Entity
@Table(name = "TC_SISTEMAS", catalog = "SIEV", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TcSistemas.findAll", query = "SELECT t FROM TcSistemas t"),
    @NamedQuery(name = "TcSistemas.findByClave", query = "SELECT t FROM TcSistemas t WHERE t.clave = :clave"),
    @NamedQuery(name = "TcSistemas.findBySistema", query = "SELECT t FROM TcSistemas t WHERE t.sistema = :sistema")})
public class TcSistemas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CLAVE")
    private Short clave;
    @Size(max = 30)
    @Column(name = "SISTEMA")
    private String sistema;
    @OneToMany(mappedBy = "claveSistema")
    private Collection<TtWsLlamadaRespuesta> ttWsLlamadaRespuestaCollection;

    public TcSistemas() {
    }

    public TcSistemas(Short clave) {
        this.clave = clave;
    }

    public Short getClave() {
        return clave;
    }

    public void setClave(Short clave) {
        this.clave = clave;
    }

    public String getSistema() {
        return sistema;
    }

    public void setSistema(String sistema) {
        this.sistema = sistema;
    }

    @XmlTransient
    public Collection<TtWsLlamadaRespuesta> getTtWsLlamadaRespuestaCollection() {
        return ttWsLlamadaRespuestaCollection;
    }

    public void setTtWsLlamadaRespuestaCollection(Collection<TtWsLlamadaRespuesta> ttWsLlamadaRespuestaCollection) {
        this.ttWsLlamadaRespuestaCollection = ttWsLlamadaRespuestaCollection;
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
        if (!(object instanceof TcSistemas)) {
            return false;
        }
        TcSistemas other = (TcSistemas) object;
        if ((this.clave == null && other.clave != null) || (this.clave != null && !this.clave.equals(other.clave))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.telcel.gam.siev.modelo.TcSistemas[ clave=" + clave + " ]";
    }
    
}
