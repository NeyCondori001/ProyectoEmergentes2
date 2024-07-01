package com.emergentes.controller;

import com.emergentes.bean.BeanUsuario;
import com.emergentes.entidades.Usuario;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "UsuarioServlet", urlPatterns = {"/UsuarioServlet"})
public class UsuarioServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         BeanUsuario daoUsuario = new BeanUsuario();

        Usuario u = new Usuario();
        int id;
        String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
        switch (action) {
            case "add":
                request.setAttribute("usuario", u);
                request.getRequestDispatcher("registro.jsp").forward(request, response);
                break;
            case "edit":
                id = Integer.parseInt(request.getParameter("id"));
                u = daoUsuario.buscar(id);
                request.setAttribute("usuario", u);
                request.getRequestDispatcher("registro.jsp").forward(request, response);
                break;
            case "dele":
                id = Integer.parseInt(request.getParameter("id"));
                daoUsuario.eliminar(id);
                response.sendRedirect("UsuarioServlet");
                break;
            case "view":
                List<Usuario> lista = daoUsuario.listarTodos();
                request.setAttribute("usuarios", lista);
                request.getRequestDispatcher("/inicio.jsp").forward(request, response);
                break;
            case "login":
                request.getRequestDispatcher("login.jsp").forward(request, response);
                break;
            case "register":
                request.getRequestDispatcher("registro.jsp").forward(request, response);
                break;
        }
    }

    @Override
protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    BeanUsuario daoUsuario = new BeanUsuario();
    String action = request.getParameter("action");

    if ("login".equals(action)) {
        String nombreusuario = request.getParameter("nombreusuario");
        String password = request.getParameter("password");
        Usuario usuario = daoUsuario.autenticar(nombreusuario, password);

        if (usuario != null) {
            HttpSession session = request.getSession();
            session.setAttribute("usuario", usuario);

            // Verificar si el usuario autenticado es administrador exclusivo
            if (esAdministradorExclusivo(usuario)) {
                request.getRequestDispatcher("/admin.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("/menu.jsp").forward(request, response);
            }
        } else {
            response.sendRedirect(request.getContextPath() + "/login.jsp?error=true");
        }
    } else if ("register".equals(action) || "add".equals(action) || "edit".equals(action)) {
        String fechanacStr = request.getParameter("fechanac");
        String nombres = request.getParameter("nombres");
        String apellidos = request.getParameter("apellidos");
        String ocupacion = request.getParameter("ocupacion");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String nombreusuario = request.getParameter("nombreusuario");
        String sexo = request.getParameter("sexo");

        // Convertir fecha de nacimiento de String a Date
        Date fechanac = null;
        try {
            fechanac = new SimpleDateFormat("yyyy-MM-dd").parse(fechanacStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        // Crear instancia de Usuario
        Usuario usuario = new Usuario();
        usuario.setFechanac(fechanac);
        usuario.setNombres(nombres);
        usuario.setApellidos(apellidos);
        usuario.setOcupacion(ocupacion);
        usuario.setEmail(email);
        usuario.setPassword(password);
        usuario.setNombreusuario(nombreusuario);
        usuario.setSexo(sexo);

        if ("edit".equals(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            usuario.setId(id);
            daoUsuario.editar(usuario);
        } else {
            daoUsuario.insertar(usuario);
        }

        response.sendRedirect(request.getContextPath() + "/UsuarioServlet?action=view");
    } else {
        // Código para otras acciones, si es necesario
    }
}

// Método para verificar si el usuario es administrador exclusivo
private boolean esAdministradorExclusivo(Usuario usuario) {
    // Definir nombres de usuarios de administradores exclusivos
    String admin1 = "juanito";
    String admin2 = "anita";

    // Verificar si el usuario es uno de los administradores exclusivos
    return usuario.getNombreusuario().equals(admin1) || usuario.getNombreusuario().equals(admin2);
}
}
