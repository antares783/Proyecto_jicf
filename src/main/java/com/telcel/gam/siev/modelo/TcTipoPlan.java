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
@Table(name = "TC_TIPO_PLAN", catalog = "SIEV", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TcTipoPlan.findAll", query = "SELECT t FROM TcTipoPlan t"),
    @NamedQuery(name = "TcTipoPlan.findByClave", query = "SELECT t FROM TcTipoPlan t WHERE t.clave = :clave"),
    @NamedQuery(name = "TcTipoPlan.findByPlanDescripcion", query = "SELECT t FROM TcTipoPlan t WHERE t.planDescripcion = :planDescripcion")})
public class TcTipoPlan implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "CLAVE")
    private String clave;
    @Size(max = 30)
    @Column(name = "PLAN_DESCRIPCION")
    private String planDescripcion;
    @OneToMany(mappedBy = "tipoPlan")
    private Collection<TcPlan> tcPlanCollection;

    public TcTipoPlan() {
    }

    public TcTipoPlan(String clave) {
        this.clave = clave;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getPlanDescripcion() {
        return planDescripcion;
    }

    public void setPlanDescripcion(String planDescripcion) {
        this.planDescripcion = planDescripcion;
    }

    @XmlTransient
    public Collection<TcPlan> getTcPlanCollection() {
        return tcPlanCollection;
    }

    public void setTcPlanCollection(Collection<TcPlan> tcPlanCollection) {
        this.tcPlanCollection = tcPlanCollection;
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
        if (!(object instanceof TcTipoPlan)) {
            return false;
        }
        TcTipoPlan other = (TcTipoPlan) object;
        if ((this.clave == null && other.clave != null) || (this.clave != null && !this.clave.equals(other.clave))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.telcel.gam.siev.modelo.TcTipoPlan[ clave=" + clave + " ]";
    }
    
}
