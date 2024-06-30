/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.emergentes.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author HP VICTUS
 */
@Entity
@Table(name = "seguimientotrabajos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Seguimientotrabajo.findAll", query = "SELECT s FROM Seguimientotrabajo s"),
    @NamedQuery(name = "Seguimientotrabajo.findById", query = "SELECT s FROM Seguimientotrabajo s WHERE s.id = :id"),
    @NamedQuery(name = "Seguimientotrabajo.findByNombres", query = "SELECT s FROM Seguimientotrabajo s WHERE s.nombres = :nombres"),
    @NamedQuery(name = "Seguimientotrabajo.findByApellidos", query = "SELECT s FROM Seguimientotrabajo s WHERE s.apellidos = :apellidos"),
    @NamedQuery(name = "Seguimientotrabajo.findByDireccion", query = "SELECT s FROM Seguimientotrabajo s WHERE s.direccion = :direccion"),
    @NamedQuery(name = "Seguimientotrabajo.findByCiudad", query = "SELECT s FROM Seguimientotrabajo s WHERE s.ciudad = :ciudad"),
    @NamedQuery(name = "Seguimientotrabajo.findByEstado", query = "SELECT s FROM Seguimientotrabajo s WHERE s.estado = :estado"),
    @NamedQuery(name = "Seguimientotrabajo.findByEmail", query = "SELECT s FROM Seguimientotrabajo s WHERE s.email = :email"),
    @NamedQuery(name = "Seguimientotrabajo.findByCelular", query = "SELECT s FROM Seguimientotrabajo s WHERE s.celular = :celular"),
    @NamedQuery(name = "Seguimientotrabajo.findByDescripcion1", query = "SELECT s FROM Seguimientotrabajo s WHERE s.descripcion1 = :descripcion1"),
    @NamedQuery(name = "Seguimientotrabajo.findByDescripcion2", query = "SELECT s FROM Seguimientotrabajo s WHERE s.descripcion2 = :descripcion2")})
public class Seguimientotrabajo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 50)
    @Column(name = "nombres")
    private String nombres;
    @Size(max = 50)
    @Column(name = "apellidos")
    private String apellidos;
    @Size(max = 50)
    @Column(name = "direccion")
    private String direccion;
    @Size(max = 50)
    @Column(name = "ciudad")
    private String ciudad;
    @Size(max = 50)
    @Column(name = "estado")
    private String estado;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 50)
    @Column(name = "email")
    private String email;
    @Column(name = "celular")
    private Integer celular;
    @Size(max = 200)
    @Column(name = "descripcion1")
    private String descripcion1;
    @Size(max = 200)
    @Column(name = "descripcion2")
    private String descripcion2;
    @JoinColumn(name = "area1_id", referencedColumnName = "id")
    @ManyToOne
    private Area1 area1Id;
    @JoinColumn(name = "area2_id", referencedColumnName = "id")
    @ManyToOne
    private Area2 area2Id;
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    @ManyToOne
    private Usuario usuarioId;

    public Seguimientotrabajo() {
        this.id = 0;
        this.nombres = "";
        this.apellidos = "";
        this.direccion = "";
        this.ciudad = "";
        this.estado = "";
        this.email = "";
        this.celular = 0;
        this.descripcion1 = "";
        this.descripcion2 = "";
        this.area1Id = new Area1();
        this.area2Id = new Area2();
        this.usuarioId = new Usuario();
    }

    public Seguimientotrabajo(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getCelular() {
        return celular;
    }

    public void setCelular(Integer celular) {
        this.celular = celular;
    }

    public String getDescripcion1() {
        return descripcion1;
    }

    public void setDescripcion1(String descripcion1) {
        this.descripcion1 = descripcion1;
    }

    public String getDescripcion2() {
        return descripcion2;
    }

    public void setDescripcion2(String descripcion2) {
        this.descripcion2 = descripcion2;
    }

    public Area1 getArea1Id() {
        return area1Id;
    }

    public void setArea1Id(Area1 area1Id) {
        this.area1Id = area1Id;
    }

    public Area2 getArea2Id() {
        return area2Id;
    }

    public void setArea2Id(Area2 area2Id) {
        this.area2Id = area2Id;
    }

    public Usuario getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Usuario usuarioId) {
        this.usuarioId = usuarioId;
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
        if (!(object instanceof Seguimientotrabajo)) {
            return false;
        }
        Seguimientotrabajo other = (Seguimientotrabajo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Seguimientotrabajo{" + "id=" + id + ", nombres=" + nombres + ", apellidos=" + apellidos + ", direccion=" + direccion + ", ciudad=" + ciudad + ", estado=" + estado + ", email=" + email + ", celular=" + celular + ", descripcion1=" + descripcion1 + ", descripcion2=" + descripcion2 + ", area1Id=" + area1Id + ", area2Id=" + area2Id + ", usuarioId=" + usuarioId + '}';
    }  
}
