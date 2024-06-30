package com.emergentes.controller;

import com.emergentes.bean.BeanArea1;
import com.emergentes.entidades.Area1;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Area1Servlet", urlPatterns = {"/Area1Servlet"})
public class Area1Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id;
        BeanArea1 daoArea1 = new BeanArea1();
        Area1 a1 = new Area1();

        String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
        switch (action) {

            case "dele":
                id = Integer.parseInt(request.getParameter("id"));
                daoArea1.eliminar(id);
                response.sendRedirect("Area1Servlet");
                break;
            case "view":
                //listado de todas las publicacionesarea1
                List<Area1> lista = daoArea1.listarTodos();
                request.setAttribute("areas1", lista);
                request.getRequestDispatcher("1.jsp").forward(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        BeanArea1 daoArea1 = new BeanArea1();  //permite hacer las operaciones

        int id = Integer.parseInt(request.getParameter("id"));
        String titulo = request.getParameter("titulo");
        int area = Integer.parseInt(request.getParameter("area"));
        String tiempo = request.getParameter("tiempo");
        String requisitos = request.getParameter("requisitos");
        String ubicacion = request.getParameter("ubicacion");
        String descripcion = request.getParameter("descripcion");

        Area1 aa1 = new Area1();
        aa1.setId(id);
        aa1.setTitulo(titulo);
        aa1.setArea(area);
        aa1.setTiempo(tiempo);
        aa1.setRequisitos(requisitos);
        aa1.setUbicacion(ubicacion);
        aa1.setDescripcion(descripcion);

        if (id > 0) {
            daoArea1.editar(aa1);
        } else {
            daoArea1.insertar(aa1);
        }
       // response.sendRedirect("Area1Servlet");
        request.getRequestDispatcher("mensajecorrecto.jsp").forward(request, response);
    }

}
