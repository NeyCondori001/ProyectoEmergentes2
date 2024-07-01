<%@page import="com.emergentes.entidades.Seguimientoempresa"%>
<%@page import="java.util.List"%>
<%
    List<Seguimientoempresa> s = (List<Seguimientoempresa>) request.getAttribute("seguimientoemps");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    </head>
    <body>
        <div class="container">
            <h1 class="mt-5">Seguimiento - Solicitudes a EMPRESAS</h1>
            <table class="table table-bordered table-hover mt-3">
                <thead class="thead-dark">
                    <tr>
                        <th>Id</th>
                        <th>Nombres</th>
                        <th>Apellidos</th>
                        <th>Direccion</th>
                        <th>Ciudad</th>
                        <th>Email</th>
                        <th>Celular</th>
                        <th>Descripcion</th>
                        <th>Empresa</th>
                        <th>Usuario</th>
                        <th>Acciones</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        for (Seguimientoempresa item : s) {
                    %>
                    <tr>
                        <td><%=item.getId()%></td>
                        <td><%=item.getNombres() %></td>
                        <td><%=item.getApellidos() %></td>
                        <td><%=item.getDireccion() %></td>
                        <td><%=item.getCiudad() %></td>
                        <td><%=item.getEmail() %></td>
                        <td><%=item.getCelular() %></td>
                        <td><%=item.getDescripcion() %></td>
                        <td><%=item.getEmpresaId().getNombre() %></td>
                        <td><%=item.getUsuarioId().getNombreusuario() %></td>
                        <td>
                            <a href="SeguimientoempresaServlet?action=edit&id=<%=item.getId()%>" class="btn btn-primary btn-sm">Editar</a>
                            <a href="SeguimientoempresaServlet?action=dele&id=<%=item.getId()%>" class="btn btn-danger btn-sm" onclick="return confirm('Esta seguro de eliminar')">Borrar</a>
                        </td>
                    </tr>
                    <%
                        }
                    %>
                </tbody>
            </table>
        </div>
    </body>
</html>
