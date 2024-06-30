package com.emergentes.bean;

import com.emergentes.entidades.Area1;
import com.emergentes.jpa.Area1JpaController;
import com.emergentes.jpa.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class BeanArea1 {
 private EntityManagerFactory emf;
    private Area1JpaController jpaArea1;  //ayuda a interactuar con el controlador

    //constructor y asociar la unidad de persistencia al gestor de entidades
    public BeanArea1() {
        emf = Persistence.createEntityManagerFactory("sistemaPUN");
        jpaArea1 = new Area1JpaController(emf);    //inicializado el controlador con persistencia
    }

    //crear metodos que vamos a utilizar en nuestra aplicacion
    public List<Area1> listarTodos() {      //recuperar todos los registros de la tabla
        return jpaArea1.findArea1Entities();
    }

    public void insertar(Area1 e) {  //insertar registros de areas, crea NUEVO registro
        jpaArea1.create(e);
    }

    public void editar(Area1 e) {  //editar un registro
        try {

            jpaArea1.edit(e);
        } catch (Exception ex) {
            Logger.getLogger(BeanArea1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void eliminar(Integer id) { //eliminar registro
        try {
            jpaArea1.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(BeanArea1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Area1 buscar(Integer id) { //para buscar cualquier registro
        return jpaArea1.findArea1(id);
    }   
}