/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.emergentes.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author HP VICTUS
 */
@Entity
@Table(name = "area1")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Area1.findAll", query = "SELECT a FROM Area1 a"),
    @NamedQuery(name = "Area1.findById", query = "SELECT a FROM Area1 a WHERE a.id = :id"),
    @NamedQuery(name = "Area1.findByTitulo", query = "SELECT a FROM Area1 a WHERE a.titulo = :titulo"),
    @NamedQuery(name = "Area1.findByArea", query = "SELECT a FROM Area1 a WHERE a.area = :area"),
    @NamedQuery(name = "Area1.findByTiempo", query = "SELECT a FROM Area1 a WHERE a.tiempo = :tiempo"),
    @NamedQuery(name = "Area1.findByRequisitos", query = "SELECT a FROM Area1 a WHERE a.requisitos = :requisitos"),
    @NamedQuery(name = "Area1.findByUbicacion", query = "SELECT a FROM Area1 a WHERE a.ubicacion = :ubicacion"),
    @NamedQuery(name = "Area1.findByDescripcion", query = "SELECT a FROM Area1 a WHERE a.descripcion = :descripcion")})
public class Area1 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;  ///////////////////////////////////////////////////////////////////
    @Size(max = 50)
    @Column(name = "titulo")
    private String titulo;
    @Column(name = "area")
    private Integer area;
    @Size(max = 50)
    @Column(name = "tiempo")
    private String tiempo;
    @Size(max = 50)
    @Column(name = "requisitos")
    private String requisitos;
    @Size(max = 50)
    @Column(name = "ubicacion")
    private String ubicacion;
    @Size(max = 400)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(mappedBy = "area1Id")
    private List<Seguimientotrabajo> seguimientotrabajoList;

    public Area1() {
        this.id = 0;
        this.titulo = "";
        this.area = 0;
        this.tiempo = "";
        this.requisitos = "";
        this.ubicacion = "";
        this.descripcion = "";
        seguimientotrabajoList = new ArrayList<Seguimientotrabajo>();
    }

    public Area1(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getArea() {
        return area;
    }

    public void setArea(Integer area) {
        this.area = area;
    }

    public String getTiempo() {
        return tiempo;
    }

    public void setTiempo(String tiempo) {
        this.tiempo = tiempo;
    }

    public String getRequisitos() {
        return requisitos;
    }

    public void setRequisitos(String requisitos) {
        this.requisitos = requisitos;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<Seguimientotrabajo> getSeguimientotrabajoList() {
        return seguimientotrabajoList;
    }

    public void setSeguimientotrabajoList(List<Seguimientotrabajo> seguimientotrabajoList) {
        this.seguimientotrabajoList = seguimientotrabajoList;
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
        if (!(object instanceof Area1)) {
            return false;
        }
        Area1 other = (Area1) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Area1{" + "id=" + id + ", titulo=" + titulo + ", area=" + area + ", tiempo=" + tiempo + ", requisitos=" + requisitos + ", ubicacion=" + ubicacion + ", descripcion=" + descripcion + ", seguimientotrabajoList=" + seguimientotrabajoList + '}';
    } 
}
