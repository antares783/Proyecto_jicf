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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "TC_PLAN", catalog = "SIEV", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TcPlan.findAll", query = "SELECT t FROM TcPlan t"),
    @NamedQuery(name = "TcPlan.findById", query = "SELECT t FROM TcPlan t WHERE t.id = :id"),
    @NamedQuery(name = "TcPlan.findByClaveM2k", query = "SELECT t FROM TcPlan t WHERE t.claveM2k = :claveM2k"),
    @NamedQuery(name = "TcPlan.findByClaveGrupo", query = "SELECT t FROM TcPlan t WHERE t.claveGrupo = :claveGrupo"),
    @NamedQuery(name = "TcPlan.findByNombre", query = "SELECT t FROM TcPlan t WHERE t.nombre = :nombre"),
    @NamedQuery(name = "TcPlan.findByDispoDeur", query = "SELECT t FROM TcPlan t WHERE t.dispoDeur = :dispoDeur"),
    @NamedQuery(name = "TcPlan.findByDispoR9", query = "SELECT t FROM TcPlan t WHERE t.dispoR9 = :dispoR9")})
public class TcPlan implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "CLAVE_M2K")
    private String claveM2k;
    @Size(max = 100)
    @Column(name = "CLAVE_GRUPO")
    private String claveGrupo;
    @Size(max = 100)
    @Column(name = "NOMBRE")
    private String nombre;
    @Column(name = "DISPO_DEUR")
    private Character dispoDeur;
    @Column(name = "DISPO_R9")
    private Character dispoR9;
    @JoinColumn(name = "TIPO_PLAN", referencedColumnName = "CLAVE")
    @ManyToOne
    private TcTipoPlan tipoPlan;
    @JoinColumn(name = "TIPO_PLAZO", referencedColumnName = "CLAVE")
    @ManyToOne
    private TcTipoPlazo tipoPlazo;

    public TcPlan() {
    }

    public TcPlan(Integer id) {
        this.id = id;
    }

    public TcPlan(Integer id, String claveM2k) {
        this.id = id;
        this.claveM2k = claveM2k;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClaveM2k() {
        return claveM2k;
    }

    public void setClaveM2k(String claveM2k) {
        this.claveM2k = claveM2k;
    }

    public String getClaveGrupo() {
        return claveGrupo;
    }

    public void setClaveGrupo(String claveGrupo) {
        this.claveGrupo = claveGrupo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Character getDispoDeur() {
        return dispoDeur;
    }

    public void setDispoDeur(Character dispoDeur) {
        this.dispoDeur = dispoDeur;
    }

    public Character getDispoR9() {
        return dispoR9;
    }

    public void setDispoR9(Character dispoR9) {
        this.dispoR9 = dispoR9;
    }

    public TcTipoPlan getTipoPlan() {
        return tipoPlan;
    }

    public void setTipoPlan(TcTipoPlan tipoPlan) {
        this.tipoPlan = tipoPlan;
    }

    public TcTipoPlazo getTipoPlazo() {
        return tipoPlazo;
    }

    public void setTipoPlazo(TcTipoPlazo tipoPlazo) {
        this.tipoPlazo = tipoPlazo;
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
        if (!(object instanceof TcPlan)) {
            return false;
        }
        TcPlan other = (TcPlan) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.telcel.gam.siev.modelo.TcPlan[ id=" + id + " ]";
    }
    
}
