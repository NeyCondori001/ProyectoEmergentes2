package com.emergentes.entidades;

import com.emergentes.entidades.Empresa;
import com.emergentes.entidades.Usuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2024-06-29T00:38:01")
@StaticMetamodel(Seguimientoempresa.class)
public class Seguimientoempresa_ { 

    public static volatile SingularAttribute<Seguimientoempresa, String> apellidos;
    public static volatile SingularAttribute<Seguimientoempresa, String> descripcion;
    public static volatile SingularAttribute<Seguimientoempresa, Empresa> empresaId;
    public static volatile SingularAttribute<Seguimientoempresa, String> ciudad;
    public static volatile SingularAttribute<Seguimientoempresa, String> direccion;
    public static volatile SingularAttribute<Seguimientoempresa, Integer> celular;
    public static volatile SingularAttribute<Seguimientoempresa, Integer> id;
    public static volatile SingularAttribute<Seguimientoempresa, Usuario> usuarioId;
    public static volatile SingularAttribute<Seguimientoempresa, String> email;
    public static volatile SingularAttribute<Seguimientoempresa, String> nombres;

}