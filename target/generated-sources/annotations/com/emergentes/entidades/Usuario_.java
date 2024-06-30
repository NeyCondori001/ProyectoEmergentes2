package com.emergentes.entidades;

import com.emergentes.entidades.Seguimientoempresa;
import com.emergentes.entidades.Seguimientotrabajo;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2024-06-29T00:38:01")
@StaticMetamodel(Usuario.class)
public class Usuario_ { 

    public static volatile SingularAttribute<Usuario, String> apellidos;
    public static volatile SingularAttribute<Usuario, String> nombreusuario;
    public static volatile ListAttribute<Usuario, Seguimientotrabajo> seguimientotrabajoList;
    public static volatile SingularAttribute<Usuario, String> password;
    public static volatile ListAttribute<Usuario, Seguimientoempresa> seguimientoempresaList;
    public static volatile SingularAttribute<Usuario, Date> fechanac;
    public static volatile SingularAttribute<Usuario, String> ocupacion;
    public static volatile SingularAttribute<Usuario, Integer> id;
    public static volatile SingularAttribute<Usuario, String> sexo;
    public static volatile SingularAttribute<Usuario, String> email;
    public static volatile SingularAttribute<Usuario, String> nombres;

}