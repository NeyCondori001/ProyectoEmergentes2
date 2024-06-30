package com.emergentes.controller;

import com.emergentes.bean.BeanArea2;
import com.emergentes.entidades.Area2;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Area2Servlet", urlPatterns = {"/Area2Servlet"})
public class Area2Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id;
        BeanArea2 daoArea2 = new BeanArea2();
        Area2 a2 = new Area2();

        String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
        switch (action) {

            case "dele":
                id = Integer.parseInt(request.getParameter("id"));
                daoArea2.eliminar(id);
                response.sendRedirect("Area2Servlet");
                break;
            case "view":
                //listado de todas las publicacionesarea2
                List<Area2> lista = daoArea2.listarTodos();
                request.setAttribute("areas2", lista);
                request.getRequestDispatcher("2.jsp").forward(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        BeanArea2 daoArea2 = new BeanArea2();  //permite hacer las operaciones

        int id = Integer.parseInt(request.getParameter("id"));
        String titulo = request.getParameter("titulo");
        int area = Integer.parseInt(request.getParameter("area"));
        String tiempo = request.getParameter("tiempo");
        String requisitos = request.getParameter("requisitos");
        String ubicacion = request.getParameter("ubicacion");
        String descripcion = request.getParameter("descripcion");

        Area2 aa2 = new Area2();
        aa2.setId(id);
        aa2.setTitulo(titulo);
        aa2.setArea(area);
        aa2.setTiempo(tiempo);
        aa2.setRequisitos(requisitos);
        aa2.setUbicacion(ubicacion);
        aa2.setDescripcion(descripcion);

        if (id > 0) {
            daoArea2.editar(aa2);
        } else {
            daoArea2.insertar(aa2);
        }
       // response.sendRedirect("Area2Servlet");
        request.getRequestDispatcher("mensajecorrecto.jsp").forward(request, response);
    }

}

