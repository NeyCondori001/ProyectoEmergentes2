package com.emergentes.controller;

import com.emergentes.bean.BeanEmpresa;
import com.emergentes.bean.BeanSeguimientoempresa;
import com.emergentes.bean.BeanUsuario;
import com.emergentes.entidades.Empresa;
import com.emergentes.entidades.Seguimientoempresa;
import com.emergentes.entidades.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SeguimientoempresaServlet", urlPatterns = {"/SeguimientoempresaServlet"})
public class SeguimientoempresaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id;
        BeanSeguimientoempresa daoSeguimientoempresa = new BeanSeguimientoempresa();

        //otras tablas
        BeanUsuario daoUsuario = new BeanUsuario();
        BeanEmpresa daoEmpresa = new BeanEmpresa();

        Seguimientoempresa s = new Seguimientoempresa();

        List<Usuario> lista;
        List<Empresa> listaem;

        String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
        switch (action) {
            case "add":
                lista = daoUsuario.listarTodos();
                request.setAttribute("usuarios", lista);
                listaem = daoEmpresa.listarTodos();
                request.setAttribute("empresas", listaem);

                request.setAttribute("seguimientoemp", s);
                request.getRequestDispatcher("seguimientoemp-edit.jsp").forward(request, response);//editar el solicitud
                break;
            case "edit":
                id = Integer.parseInt(request.getParameter("id"));
                s = daoSeguimientoempresa.buscar(id);
                lista = daoUsuario.listarTodos();
                request.setAttribute("usuarios", lista);
                listaem = daoEmpresa.listarTodos();
                request.setAttribute("empresas", listaem);

                request.setAttribute("seguimientoemp", s);
                request.getRequestDispatcher("seguimientoemp-edit.jsp").forward(request, response);
                break;

            case "dele":
                id = Integer.parseInt(request.getParameter("id"));
                daoSeguimientoempresa.eliminar(id);
                response.sendRedirect("SeguimientoempresaServlet");
                break;
            case "view":
                //listado de todas las SOLICITUDES
                List<Seguimientoempresa> solislist = daoSeguimientoempresa.listarTodos();
                request.setAttribute("seguimientoemps", solislist);
                request.getRequestDispatcher("seguimientoemps.jsp").forward(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        BeanSeguimientoempresa daoSeguimientoempresa = new BeanSeguimientoempresa();  //permite hacer las operaciones
        BeanUsuario daoUsuario = new BeanUsuario();
        BeanEmpresa daoEmpresa = new BeanEmpresa();

        int id = Integer.parseInt(request.getParameter("id"));
        String nombres = request.getParameter("nombres");
        String apellidos = request.getParameter("apellidos");
        String direccion = request.getParameter("direccion");
        String ciudad = request.getParameter("ciudad");
        String email = request.getParameter("email");
        int celular = Integer.parseInt(request.getParameter("celular"));
        String descripcion = request.getParameter("descripcion");
        
        int empresaId = Integer.parseInt(request.getParameter("empresaId"));
        int usuarioId = Integer.parseInt(request.getParameter("usuarioId"));

        Empresa emp = daoEmpresa.buscar(empresaId);
        Usuario usu = daoUsuario.buscar(usuarioId);
        
        Seguimientoempresa s = new Seguimientoempresa();

        s.setId(id);
        s.setNombres(nombres);
        s.setApellidos(apellidos);
        s.setDireccion(direccion);
        s.setCiudad(ciudad);
        s.setEmail(email);
        s.setCelular(celular);
        s.setDescripcion(descripcion);
        s.setEmpresaId(emp);
        s.setUsuarioId(usu);


        if (id > 0) {
            daoSeguimientoempresa.editar(s);
        } else {
            daoSeguimientoempresa.insertar(s);
        }
       // response.sendRedirect("SeguimientoempresaServlet");
        request.getRequestDispatcher("mensajecorrecto.jsp").forward(request, response);
    }

}
