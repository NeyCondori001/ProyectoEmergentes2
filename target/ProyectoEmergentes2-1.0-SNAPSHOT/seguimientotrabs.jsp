<%@page import="com.emergentes.entidades.Seguimientotrabajo"%>
<%@page import="java.util.List"%>
<%
    List<Seguimientotrabajo> seg = (List<Seguimientotrabajo>) request.getAttribute("seguimientotrabs");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Listado - Solicitudes a TRABAJOS</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-4">
        <h1 class="text-center">Listado - Solicitudes a TRABAJOS</h1>
        
        <table class="table table-striped table-bordered mt-3">
            <thead class="thead-dark">
                <tr>
                    <th>Id</th>
                    <th>Nombres</th>
                    <th>Apellidos</th>
                    <th>Direccion</th>
                    <th>Ciudad</th>
                    <th>Estado</th>
                    <th>Email</th>
                    <th>Celular</th>
                    <th>Descripcion 1</th>
                    <th>Descripcion 2</th>
                    <th>Area 1</th>
                    <th>Area 2</th>
                    <th>Usuario</th>
                    <th>Acciones</th>
                </tr>
            </thead>
            <tbody>
                <%
                    for (Seguimientotrabajo item : seg) {
                %>
                <tr>
                    <td><%=item.getId()%></td>
                    <td><%=item.getNombres() %></td>
                    <td><%=item.getApellidos() %></td>
                    <td><%=item.getDireccion() %></td>
                    <td><%=item.getCiudad() %></td>
                    <td><%=item.getEstado() %></td>
                    <td><%=item.getEmail() %></td>
                    <td><%=item.getCelular() %></td>
                    <td><%=item.getDescripcion1() %></td>
                    <td><%=item.getDescripcion2() %></td>
                    <td><%=item.getArea1Id().getTitulo() %></td>
                    <td><%=item.getArea2Id().getTitulo() %></td>
                    <td><%=item.getUsuarioId().getNombreusuario() %></td>
                    <td>
                        <a href="SeguimientotrabajoServlet?action=edit&id=<%=item.getId()%>" class="btn btn-primary btn-sm">Editar</a>
                        <a href="SeguimientotrabajoServlet?action=dele&id=<%=item.getId()%>" class="btn btn-danger btn-sm" onclick="return confirm('¿Está seguro de eliminar?')">Borrar</a>
                    </td>
                </tr>
                <%
                    }
                %>
            </tbody>
        </table>
    </div>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
