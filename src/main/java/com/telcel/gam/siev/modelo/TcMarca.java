/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.telcel.gam.siev.modelo;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(name = "TC_MARCA", catalog = "SIEV", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TcMarca.findAll", query = "SELECT t FROM TcMarca t"),
    @NamedQuery(name = "TcMarca.findById", query = "SELECT t FROM TcMarca t WHERE t.id = :id"),
    @NamedQuery(name = "TcMarca.findByClave", query = "SELECT t FROM TcMarca t WHERE t.clave = :clave"),
    @NamedQuery(name = "TcMarca.findByDescripcion", query = "SELECT t FROM TcMarca t WHERE t.descripcion = :descripcion"),
    @NamedQuery(name = "TcMarca.findByDispoDeur", query = "SELECT t FROM TcMarca t WHERE t.dispoDeur = :dispoDeur"),
    @NamedQuery(name = "TcMarca.findByDispoR9", query = "SELECT t FROM TcMarca t WHERE t.dispoR9 = :dispoR9"),
    @NamedQuery(name = "TcMarca.findByNombre", query = "SELECT t FROM TcMarca t WHERE t.nombre = :nombre")})
public class TcMarca implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Short id;
    @Size(max = 30)
    @Column(name = "CLAVE")
    private String clave;
    @Size(max = 220)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Column(name = "DISPO_DEUR")
    private Character dispoDeur;
    @Column(name = "DISPO_R9")
    private Character dispoR9;
    @Size(max = 90)
    @Column(name = "NOMBRE")
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMarca")
    private Collection<TcModelo> tcModeloCollection;

    public TcMarca() {
    }

    public TcMarca(Short id) {
        this.id = id;
    }

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public Collection<TcModelo> getTcModeloCollection() {
        return tcModeloCollection;
    }

    public void setTcModeloCollection(Collection<TcModelo> tcModeloCollection) {
        this.tcModeloCollection = tcModeloCollection;
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
        if (!(object instanceof TcMarca)) {
            return false;
        }
        TcMarca other = (TcMarca) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.telcel.gam.siev.modelo.TcMarca[ id=" + id + " ]";
    }
    
}
