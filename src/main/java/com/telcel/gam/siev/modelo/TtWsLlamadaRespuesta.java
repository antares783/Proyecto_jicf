/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.telcel.gam.siev.modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author VI8G023
 */
@Entity
@Table(name = "TT_WS_LLAMADA_RESPUESTA", catalog = "SIEV", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TtWsLlamadaRespuesta.findAll", query = "SELECT t FROM TtWsLlamadaRespuesta t"),
    @NamedQuery(name = "TtWsLlamadaRespuesta.findById", query = "SELECT t FROM TtWsLlamadaRespuesta t WHERE t.id = :id"),
    @NamedQuery(name = "TtWsLlamadaRespuesta.findByLlamada", query = "SELECT t FROM TtWsLlamadaRespuesta t WHERE t.llamada = :llamada"),
    @NamedQuery(name = "TtWsLlamadaRespuesta.findByUsuario", query = "SELECT t FROM TtWsLlamadaRespuesta t WHERE t.usuario = :usuario"),
    @NamedQuery(name = "TtWsLlamadaRespuesta.findByFecha", query = "SELECT t FROM TtWsLlamadaRespuesta t WHERE t.fecha = :fecha"),
    @NamedQuery(name = "TtWsLlamadaRespuesta.findByMetodoInvocado", query = "SELECT t FROM TtWsLlamadaRespuesta t WHERE t.metodoInvocado = :metodoInvocado")})
public class TtWsLlamadaRespuesta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "LlamadaSecuence")
    @SequenceGenerator(name = "LlamadaSecuence", sequenceName = "SEQUENCE_TT_WS_LLAMADA_RESPUESTA", initialValue = 1)
    private Integer id;
    @Size(max = 4600)
    @Column(name = "LLAMADA", length = 4600)
    private String llamada;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "RESPUESTA", length = 2147483647)
    private String respuesta;
    @Size(max = 15)
    @Column(name = "USUARIO", length = 15)
    private String usuario;
    @Column(name = "FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Size(max = 50)
    @Column(name = "METODO_INVOCADO", length = 50)
    private String metodoInvocado;
    @JoinColumn(name = "CLAVE_SISTEMA", referencedColumnName = "CLAVE")
    @ManyToOne
    private TcSistemas claveSistema;

    public TtWsLlamadaRespuesta() {
    }

    public TtWsLlamadaRespuesta(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLlamada() {
        return llamada;
    }

    public void setLlamada(String llamada) {
        this.llamada = llamada;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getMetodoInvocado() {
        return metodoInvocado;
    }

    public void setMetodoInvocado(String metodoInvocado) {
        this.metodoInvocado = metodoInvocado;
    }

    public TcSistemas getClaveSistema() {
        return claveSistema;
    }

    public void setClaveSistema(TcSistemas claveSistema) {
        this.claveSistema = claveSistema;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TtWsLlamadaRespuesta)) {
            return false;
        }
        TtWsLlamadaRespuesta other = (TtWsLlamadaRespuesta) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.telcel.gam.siev.modelo.TtWsLlamadaRespuesta[ id=" + id + " ]";
    }
    
}
