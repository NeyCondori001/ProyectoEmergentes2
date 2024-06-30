package com.emergentes.bean;

import com.emergentes.entidades.Area2;
import com.emergentes.jpa.Area2JpaController;
import com.emergentes.jpa.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class BeanArea2 {
 private EntityManagerFactory emf;
    private Area2JpaController jpaArea2;  //ayuda a interactuar con el controlador

    //constructor y asociar la unidad de persistencia al gestor de entidades
    public BeanArea2() {
        emf = Persistence.createEntityManagerFactory("sistemaPUN");
        jpaArea2 = new Area2JpaController(emf);    //inicializado el controlador con persistencia
    }

    //crear metodos que vamos a utilizar en nuestra aplicacion
    public List<Area2> listarTodos() {      //recuperar todos los registros de la tabla
        return jpaArea2.findArea2Entities();
    }

    public void insertar(Area2 e) {  //insertar registros de areas, crea NUEVO registro
        jpaArea2.create(e);
    }

    public void editar(Area2 e) {  //editar un registro
        try {

            jpaArea2.edit(e);
        } catch (Exception ex) {
            Logger.getLogger(BeanArea2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void eliminar(Integer id) { //eliminar registro
        try {
            jpaArea2.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(BeanArea2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Area2 buscar(Integer id) { //para buscar cualquier registro
        return jpaArea2.findArea2(id);
    }   
}