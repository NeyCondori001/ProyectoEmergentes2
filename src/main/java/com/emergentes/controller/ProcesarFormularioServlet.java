package com.emergentes.controller;

import com.emergentes.entidades.Area1;
import com.emergentes.entidades.Area2;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/procesar")
public class ProcesarFormularioServlet extends HttpServlet {

    private static final String PERSISTENCE_UNIT_NAME = "sistemaPUN";
    private static EntityManagerFactory factory;

    @Override
    public void init() throws ServletException {
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String titulo = request.getParameter("titulo");
        int area = Integer.parseInt(request.getParameter("area"));
        String tiempo = request.getParameter("tiempo");
        String requisitos = request.getParameter("requisitos");
        String ubicacion = request.getParameter("ubicacion");
        String descripcion = request.getParameter("descripcion");

        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();

        if (area == 1) {
            Area1 area1 = new Area1();
            area1.setTitulo(titulo);
            area1.setArea(area);
            area1.setTiempo(tiempo);
            area1.setRequisitos(requisitos);
            area1.setUbicacion(ubicacion);
            area1.setDescripcion(descripcion);

            em.persist(area1);
        } else if (area == 2) {
            Area2 area2 = new Area2();
            area2.setTitulo(titulo);
            area2.setArea(area);
            area2.setTiempo(tiempo);
            area2.setRequisitos(requisitos);
            area2.setUbicacion(ubicacion);
            area2.setDescripcion(descripcion);
        }

        em.getTransaction().commit();
        em.close();

        request.getRequestDispatcher("mensajecorrecto.jsp").forward(request, response);
    }

    @Override
    public void destroy() {
        if (factory != null) {
            factory.close();
        }
    }
}
