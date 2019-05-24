/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.telcel.gam.siev.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author VI8G023
 */
@Entity
@Table(name = "TC_SISTEMAS_CATALOGOS", catalog = "SIEV", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TcSistemasCatalogos.findAll", query = "SELECT t FROM TcSistemasCatalogos t"),
    @NamedQuery(name = "TcSistemasCatalogos.findByClaveSistema", query = "SELECT t FROM TcSistemasCatalogos t WHERE t.tcSistemasCatalogosPK.claveSistema = :claveSistema"),
    @NamedQuery(name = "TcSistemasCatalogos.findByCampo", query = "SELECT t FROM TcSistemasCatalogos t WHERE t.tcSistemasCatalogosPK.campo = :campo"),
    @NamedQuery(name = "TcSistemasCatalogos.findByClaveValor", query = "SELECT t FROM TcSistemasCatalogos t WHERE t.tcSistemasCatalogosPK.claveValor = :claveValor"),
    @NamedQuery(name = "TcSistemasCatalogos.findByValor", query = "SELECT t FROM TcSistemasCatalogos t WHERE t.valor = :valor")})
public class TcSistemasCatalogos implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TcSistemasCatalogosPK tcSistemasCatalogosPK;
    @Size(max = 50)
    @Column(name = "VALOR")
    private String valor;

    public TcSistemasCatalogos() {
    }

    public TcSistemasCatalogos(TcSistemasCatalogosPK tcSistemasCatalogosPK) {
        this.tcSistemasCatalogosPK = tcSistemasCatalogosPK;
    }

    public TcSistemasCatalogos(short claveSistema, String campo, String claveValor) {
        this.tcSistemasCatalogosPK = new TcSistemasCatalogosPK(claveSistema, campo, claveValor);
    }

    public TcSistemasCatalogosPK getTcSistemasCatalogosPK() {
        return tcSistemasCatalogosPK;
    }

    public void setTcSistemasCatalogosPK(TcSistemasCatalogosPK tcSistemasCatalogosPK) {
        this.tcSistemasCatalogosPK = tcSistemasCatalogosPK;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tcSistemasCatalogosPK != null ? tcSistemasCatalogosPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TcSistemasCatalogos)) {
            return false;
        }
        TcSistemasCatalogos other = (TcSistemasCatalogos) object;
        if ((this.tcSistemasCatalogosPK == null && other.tcSistemasCatalogosPK != null) || (this.tcSistemasCatalogosPK != null && !this.tcSistemasCatalogosPK.equals(other.tcSistemasCatalogosPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.telcel.gam.siev.modelo.TcSistemasCatalogos[ tcSistemasCatalogosPK=" + tcSistemasCatalogosPK + " ]";
    }
    
}
