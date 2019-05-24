/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.telcel.gam.siev.modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author VI8G023
 */
@Embeddable
public class TcSistemasCatalogosPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "CLAVE_SISTEMA")
    private short claveSistema;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "CAMPO")
    private String campo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "CLAVE_VALOR")
    private String claveValor;

    public TcSistemasCatalogosPK() {
    }

    public TcSistemasCatalogosPK(short claveSistema, String campo, String claveValor) {
        this.claveSistema = claveSistema;
        this.campo = campo;
        this.claveValor = claveValor;
    }

    public short getClaveSistema() {
        return claveSistema;
    }

    public void setClaveSistema(short claveSistema) {
        this.claveSistema = claveSistema;
    }

    public String getCampo() {
        return campo;
    }

    public void setCampo(String campo) {
        this.campo = campo;
    }

    public String getClaveValor() {
        return claveValor;
    }

    public void setClaveValor(String claveValor) {
        this.claveValor = claveValor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) claveSistema;
        hash += (campo != null ? campo.hashCode() : 0);
        hash += (claveValor != null ? claveValor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TcSistemasCatalogosPK)) {
            return false;
        }
        TcSistemasCatalogosPK other = (TcSistemasCatalogosPK) object;
        if (this.claveSistema != other.claveSistema) {
            return false;
        }
        if ((this.campo == null && other.campo != null) || (this.campo != null && !this.campo.equals(other.campo))) {
            return false;
        }
        if ((this.claveValor == null && other.claveValor != null) || (this.claveValor != null && !this.claveValor.equals(other.claveValor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.telcel.gam.siev.modelo.TcSistemasCatalogosPK[ claveSistema=" + claveSistema + ", campo=" + campo + ", claveValor=" + claveValor + " ]";
    }
    
}
