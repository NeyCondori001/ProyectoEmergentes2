/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.emergentes.entidades;

import java.io.Serializable;
import java.util.ArrayList;
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
@Table(name = "seguimientoempresas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Seguimientoempresa.findAll", query = "SELECT s FROM Seguimientoempresa s"),
    @NamedQuery(name = "Seguimientoempresa.findById", query = "SELECT s FROM Seguimientoempresa s WHERE s.id = :id"),
    @NamedQuery(name = "Seguimientoempresa.findByNombres", query = "SELECT s FROM Seguimientoempresa s WHERE s.nombres = :nombres"),
    @NamedQuery(name = "Seguimientoempresa.findByApellidos", query = "SELECT s FROM Seguimientoempresa s WHERE s.apellidos = :apellidos"),
    @NamedQuery(name = "Seguimientoempresa.findByDireccion", query = "SELECT s FROM Seguimientoempresa s WHERE s.direccion = :direccion"),
    @NamedQuery(name = "Seguimientoempresa.findByCiudad", query = "SELECT s FROM Seguimientoempresa s WHERE s.ciudad = :ciudad"),
    @NamedQuery(name = "Seguimientoempresa.findByEmail", query = "SELECT s FROM Seguimientoempresa s WHERE s.email = :email"),
    @NamedQuery(name = "Seguimientoempresa.findByCelular", query = "SELECT s FROM Seguimientoempresa s WHERE s.celular = :celular"),
    @NamedQuery(name = "Seguimientoempresa.findByDescripcion", query = "SELECT s FROM Seguimientoempresa s WHERE s.descripcion = :descripcion")})
public class Seguimientoempresa implements Serializable {

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
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 50)
    @Column(name = "email")
    private String email;
    @Column(name = "celular")
    private Integer celular;
    @Size(max = 200)
    @Column(name = "descripcion")
    private String descripcion;
    @JoinColumn(name = "empresa_id", referencedColumnName = "id")
    @ManyToOne
    private Empresa empresaId;
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    @ManyToOne
    private Usuario usuarioId;

    public Seguimientoempresa() {
        this.id = 0;
        this.nombres = "";
        this.apellidos = "";
        this.direccion = "";
        this.ciudad = "";
        this.email = "";
        this.celular = 0;
        this.descripcion = "";
        this.empresaId = new Empresa();
        this.usuarioId = new Usuario();
    }

    public Seguimientoempresa(Integer id) {
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Empresa getEmpresaId() {
        return empresaId;
    }

    public void setEmpresaId(Empresa empresaId) {
        this.empresaId = empresaId;
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
        if (!(object instanceof Seguimientoempresa)) {
            return false;
        }
        Seguimientoempresa other = (Seguimientoempresa) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Seguimientoempresa{" + "id=" + id + ", nombres=" + nombres + ", apellidos=" + apellidos + ", direccion=" + direccion + ", ciudad=" + ciudad + ", email=" + email + ", celular=" + celular + ", descripcion=" + descripcion + ", empresaId=" + empresaId + ", usuarioId=" + usuarioId + '}';
    }
}
