package com.emergentes.entidades;

import com.emergentes.entidades.Seguimientoempresa;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2024-06-29T00:38:01")
@StaticMetamodel(Empresa.class)
public class Empresa_ { 

    public static volatile SingularAttribute<Empresa, String> descripcion;
    public static volatile SingularAttribute<Empresa, String> ubicacion;
    public static volatile ListAttribute<Empresa, Seguimientoempresa> seguimientoempresaList;
    public static volatile SingularAttribute<Empresa, Integer> id;
    public static volatile SingularAttribute<Empresa, String> nombre;

}