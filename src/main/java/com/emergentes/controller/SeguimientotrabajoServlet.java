package com.emergentes.controller;

import com.emergentes.bean.BeanArea1;
import com.emergentes.bean.BeanArea2;
import com.emergentes.bean.BeanSeguimientotrabajo;
import com.emergentes.bean.BeanUsuario;
import com.emergentes.entidades.Area1;
import com.emergentes.entidades.Area2;
import com.emergentes.entidades.Seguimientotrabajo;
import com.emergentes.entidades.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SeguimientotrabajoServlet", urlPatterns = {"/SeguimientotrabajoServlet"})
public class SeguimientotrabajoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id;
        BeanSeguimientotrabajo daoSeguimientotrabajo = new BeanSeguimientotrabajo();

        //otras tablas
        BeanUsuario daoUsuario = new BeanUsuario();
        BeanArea1 daoArea1 = new BeanArea1();
        BeanArea2 daoArea2 = new BeanArea2();

        Seguimientotrabajo s = new Seguimientotrabajo();

        List<Usuario> lista;
        List<Area1> listaa1;
        List<Area2> listaa2;

        String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
        switch (action) {
            case "add":
                lista = daoUsuario.listarTodos();
                request.setAttribute("usuarios", lista);

                listaa1 = daoArea1.listarTodos();
                request.setAttribute("areas1", listaa1);

                listaa2 = daoArea2.listarTodos();
                request.setAttribute("areas2", listaa2);

                request.setAttribute("seguimientotrab", s);
                request.getRequestDispatcher("seguimientotrab-edit.jsp").forward(request, response);//editar el solicitud
                break;
            case "edit":
                id = Integer.parseInt(request.getParameter("id"));
                s = daoSeguimientotrabajo.buscar(id);

                lista = daoUsuario.listarTodos();
                request.setAttribute("usuarios", lista);
                listaa1 = daoArea1.listarTodos();
                request.setAttribute("areas1", listaa1);

                listaa2 = daoArea2.listarTodos();
                request.setAttribute("areas2", listaa2);

                request.setAttribute("seguimientotrab", s);
                request.getRequestDispatcher("seguimientotrab-edit.jsp").forward(request, response);
                break;

            case "dele":
                id = Integer.parseInt(request.getParameter("id"));
                daoSeguimientotrabajo.eliminar(id);
                response.sendRedirect("SeguimientotrabajoServlet");
                break;
            case "view":
                //listado de todas las SOLICITUDES
                List<Seguimientotrabajo> solislist = daoSeguimientotrabajo.listarTodos();
                request.setAttribute("seguimientotrabs", solislist);
                request.getRequestDispatcher("seguimientotrabs.jsp").forward(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        BeanSeguimientotrabajo daoSeguimientotrabajo = new BeanSeguimientotrabajo();  //permite hacer las operaciones
        BeanUsuario daoUsuario = new BeanUsuario();
        BeanArea1 daoArea1 = new BeanArea1();
        BeanArea2 daoArea2 = new BeanArea2();

        int id = Integer.parseInt(request.getParameter("id"));
        String nombres = request.getParameter("nombres");
        String apellidos = request.getParameter("apellidos");
        String direccion = request.getParameter("direccion");
        String ciudad = request.getParameter("ciudad");
        String estado = request.getParameter("estado");
        String email = request.getParameter("email");
        int celular = Integer.parseInt(request.getParameter("celular"));
        String descripcion1 = request.getParameter("descripcion1");
        String descripcion2 = request.getParameter("descripcion2");
    
        int area1Id = Integer.parseInt(request.getParameter("area1Id")); ///////////////////////////////////////////////////////////
        int area2Id = Integer.parseInt(request.getParameter("area2Id"));
        int usuarioId = Integer.parseInt(request.getParameter("usuarioId"));

        Area1 a1 = daoArea1.buscar(area1Id);
        Area2 a2 = daoArea2.buscar(area2Id);
        Usuario usu = daoUsuario.buscar(usuarioId);

        Seguimientotrabajo s = new Seguimientotrabajo();

        s.setId(id);
        s.setNombres(nombres);
        s.setApellidos(apellidos);
        s.setDireccion(direccion);
        s.setCiudad(ciudad);
        s.setEstado(estado);
        s.setEmail(email);
        s.setCelular(celular);
        s.setDescripcion1(descripcion1);
        s.setDescripcion2(descripcion2);
        s.setArea1Id(a1);
        s.setArea2Id(a2);
        s.setUsuarioId(usu);

        if (id > 0) {
            daoSeguimientotrabajo.editar(s);
        } else {
            daoSeguimientotrabajo.insertar(s);
        }
        //response.sendRedirect("SeguimientotrabajoServlet");
          request.getRequestDispatcher("mensajecorrecto.jsp").forward(request, response);
    }

}
