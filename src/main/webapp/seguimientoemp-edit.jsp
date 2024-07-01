<%@page import="com.emergentes.entidades.Empresa"%>
<%@page import="com.emergentes.entidades.Usuario"%>
<%@page import="java.util.List"%>
<%@page import="com.emergentes.entidades.Seguimientoempresa"%>
<%
    Seguimientoempresa seg = (Seguimientoempresa) request.getAttribute("seguimientoemp");
    List<Usuario> usu = (List<Usuario>) request.getAttribute("usuarios");
    List<Empresa> emp = (List<Empresa>) request.getAttribute("empresas");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Solicitud de Servicios - Trabajos y Oportunidades Bolivia</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/solicitud.css">
    </head>
    <body>
        <div class="table-container">
            <img src="${pageContext.request.contextPath}/images/WhatsApp Image 2024-05-07 at 3.29.38 PM.png" alt="Fondo" class="background-image">
            <div class="background-image"></div>

            <div class="content">

                <form action="SeguimientoempresaServlet" method="post">
                    <h1>Solicitud formulario a empresas</h1>
                    <input type="hidden" name="id" value="<%=seg.getId()%>" >

                    <label for="nombre">Nombre:</label> <br>
                    <input type="text" name="nombres" value="<%=seg.getNombres()%>" ><br>

                    <label for="apellidos">Apellidos:</label> <br>
                    <input type="text" name="apellidos" value="<%=seg.getApellidos()%>" ><br>


                    <label for="direccion">Direccion:</label> <br>
                    <input type="text" name="direccion" value="<%=seg.getDireccion()%>" ><br>

                    <label for="ciudad">Ciudad:</label> <br>
                    <input type="text" name="ciudad" value="<%=seg.getCiudad()%>" ><br>


                    <label for="email">Email:</label> <br>
                    <input type="text" name="email" value="<%=seg.getEmail()%>" ><br>


                    <label for="celular">Celular:</label> <br>
                    <input type="number" name="celular" value="<%=seg.getCelular()%>" ><br>


                    <label for="descripcion">Descripcion del servicio que desea:</label> <br>
                    <textarea name="descripcion"  rows="8" cols="30"><%=seg.getDescripcion()%></textarea><br><br>

                    <label for="empresaId">Empresa: </label> <br>
                    <select name="empresaId">
                        <%
                            for (Empresa item : emp) {
                        %>
                        <option value="<%=item.getId()%>"
                                <%=(item.getId() == seg.getEmpresaId().getId()) ? "selected" : ""%>
                                ><%=item.getNombre()%>
                        </option>
                        <%
                            }
                        %>
                    </select><br>

                    <label for="usuarioId">Usuario</label> <br>
                    <select name="usuarioId">
                        <%
                            for (Usuario item : usu) {
                        %>
                        <option value="<%=item.getId()%>"
                                <%=(item.getId() == seg.getUsuarioId().getId()) ? "selected" : ""%>
                                ><%=item.getNombreusuario()%>
                        </option>
                        <%
                            }
                        %>
                    </select><br>

                    <a href="menu.jsp" class="button-link">Volver a Menu</a>
                    <button type="submit">Enviar</button>
                    <button type="reset">Cancelar</button>          
                </form>
            </div>
        </div>
    </body>
</html>
