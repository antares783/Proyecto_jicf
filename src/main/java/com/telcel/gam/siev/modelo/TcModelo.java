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
@Table(name = "TC_MODELO", catalog = "SIEV", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TcModelo.findAll", query = "SELECT t FROM TcModelo t"),
    @NamedQuery(name = "TcModelo.findById", query = "SELECT t FROM TcModelo t WHERE t.id = :id"),
    @NamedQuery(name = "TcModelo.findByClaveM2k", query = "SELECT t FROM TcModelo t WHERE t.claveM2k = :claveM2k"),
    @NamedQuery(name = "TcModelo.findByDescripcion", query = "SELECT t FROM TcModelo t WHERE t.descripcion = :descripcion"),
    @NamedQuery(name = "TcModelo.findByNombre", query = "SELECT t FROM TcModelo t WHERE t.nombre = :nombre"),
    @NamedQuery(name = "TcModelo.findByDispoDeur", query = "SELECT t FROM TcModelo t WHERE t.dispoDeur = :dispoDeur"),
    @NamedQuery(name = "TcModelo.findByDispoR9", query = "SELECT t FROM TcModelo t WHERE t.dispoR9 = :dispoR9")})
public class TcModelo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Short id;
    @Size(max = 30)
    @Column(name = "CLAVE_M2K")
    private String claveM2k;
    @Size(max = 70)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Size(max = 70)
    @Column(name = "NOMBRE")
    private String nombre;
    @Column(name = "DISPO_DEUR")
    private Character dispoDeur;
    @Column(name = "DISPO_R9")
    private Character dispoR9;
    @JoinColumn(name = "ID_MARCA", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private TcMarca idMarca;

    public TcModelo() {
    }

    public TcModelo(Short id) {
        this.id = id;
    }

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public String getClaveM2k() {
        return claveM2k;
    }

    public void setClaveM2k(String claveM2k) {
        this.claveM2k = claveM2k;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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

    public TcMarca getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(TcMarca idMarca) {
        this.idMarca = idMarca;
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
        if (!(object instanceof TcModelo)) {
            return false;
        }
        TcModelo other = (TcModelo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.telcel.gam.siev.modelo.TcModelo[ id=" + id + " ]";
    }
    
}
