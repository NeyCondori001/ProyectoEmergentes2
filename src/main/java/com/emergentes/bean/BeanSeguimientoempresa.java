package com.emergentes.bean;

import com.emergentes.entidades.Seguimientoempresa;
import com.emergentes.jpa.SeguimientoempresaJpaController;
import com.emergentes.jpa.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class BeanSeguimientoempresa {

 
    private EntityManager em;
    private EntityManagerFactory emf;
    private SeguimientoempresaJpaController jpaSeguimientoempresa;  //ayuda a interactuar con el controlador
    
    //constructor y asociar la unidad de persistencia al gestor de entidades
    public BeanSeguimientoempresa() {
        emf = Persistence.createEntityManagerFactory("sistemaPUN");
        jpaSeguimientoempresa = new SeguimientoempresaJpaController(emf);    //inicializado el controlador con persistencia
    }

    //crear metodos que vamos a utilizar en nuestra aplicacion
    public List<Seguimientoempresa> listarTodos() {      //recuperar todos los registros de la tabla
        return jpaSeguimientoempresa.findSeguimientoempresaEntities();
    }
   
    public void insertar(Seguimientoempresa s) {  //insertar registros de areas, crea NUEVO registro
        jpaSeguimientoempresa.create(s);
    }

    public void editar(Seguimientoempresa s) {  //editar un registro
        try {

            jpaSeguimientoempresa.edit(s);
        } catch (Exception ex) {
            Logger.getLogger(BeanSeguimientoempresa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void eliminar(Integer id) { //eliminar registro
        try {
            jpaSeguimientoempresa.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(BeanSeguimientoempresa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Seguimientoempresa buscar(Integer id) { //para buscar cualquier registro
        return jpaSeguimientoempresa.findSeguimientoempresa(id);
    }
}