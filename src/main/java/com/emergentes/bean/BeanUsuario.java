package com.emergentes.bean;

import com.emergentes.entidades.Usuario;
import com.emergentes.jpa.UsuarioJpaController;
import com.emergentes.jpa.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class BeanUsuario {
 private EntityManagerFactory emf;
    private UsuarioJpaController jpaUsuario;  //ayuda a interactuar con el controlador

    //constructor y asociar la unidad de persistencia al gestor de entidades
    public BeanUsuario() {
        emf = Persistence.createEntityManagerFactory("sistemaPUN");
        jpaUsuario = new UsuarioJpaController(emf);    //inicializado el controlador con persistencia
    }

    //crear metodos que vamos a utilizar en nuestra aplicacion
    public List<Usuario> listarTodos() {      //recuperar todos los registros de la tabla
        return jpaUsuario.findUsuarioEntities();
    }

    public void insertar(Usuario e) {  //insertar registros de areas, crea NUEVO registro
        jpaUsuario.create(e);
    }

    public void editar(Usuario e) {  //editar un registro
        try {

            jpaUsuario.edit(e);
        } catch (Exception ex) {
            Logger.getLogger(BeanUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void eliminar(Integer id) { //eliminar registro
        try {
            jpaUsuario.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(BeanUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Usuario buscar(Integer id) { //para buscar cualquier registro
        return jpaUsuario.findUsuario(id);
    }   
    
     // Nuevo método para autenticar usuario
    public Usuario autenticar(String nombreusuario, String password) {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Usuario> query = em.createQuery("SELECT u FROM Usuario u WHERE u.nombreusuario = :nombreusuario AND u.password = :password",
            Usuario.class);
        query.setParameter("nombreusuario", nombreusuario);
        query.setParameter("password", password);

        Usuario usuario = null;
        try {
            usuario = query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return usuario;
    }
    
}

