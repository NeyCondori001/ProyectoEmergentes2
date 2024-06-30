package com.emergentes.bean;

import com.emergentes.entidades.Seguimientotrabajo;
import com.emergentes.jpa.SeguimientotrabajoJpaController;
import com.emergentes.jpa.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class BeanSeguimientotrabajo {
 private EntityManagerFactory emf;
    private SeguimientotrabajoJpaController jpaSeguimientotrabajo;  //ayuda a interactuar con el controlador

    //constructor y asociar la unidad de persistencia al gestor de entidades
    public BeanSeguimientotrabajo() {
        emf = Persistence.createEntityManagerFactory("sistemaPUN");
        jpaSeguimientotrabajo = new SeguimientotrabajoJpaController(emf);    //inicializado el controlador con persistencia
    }

    //crear metodos que vamos a utilizar en nuestra aplicacion
    public List<Seguimientotrabajo> listarTodos() {      //recuperar todos los registros de la tabla
        return jpaSeguimientotrabajo.findSeguimientotrabajoEntities();
    }

    public void insertar(Seguimientotrabajo e) {  //insertar registros de areas, crea NUEVO registro
        jpaSeguimientotrabajo.create(e);
    }

    public void editar(Seguimientotrabajo e) {  //editar un registro
        try {

            jpaSeguimientotrabajo.edit(e);
        } catch (Exception ex) {
            Logger.getLogger(BeanSeguimientotrabajo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void eliminar(Integer id) { //eliminar registro
        try {
            jpaSeguimientotrabajo.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(BeanSeguimientotrabajo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Seguimientotrabajo buscar(Integer id) { //para buscar cualquier registro
        return jpaSeguimientotrabajo.findSeguimientotrabajo(id);
    }   
}