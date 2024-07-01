<%@page import="com.emergentes.entidades.Area1"%>
<%@page import="com.emergentes.entidades.Area2"%>
<%@page import="com.emergentes.entidades.Usuario"%>
<%@page import="java.util.List"%>
<%@page import="com.emergentes.entidades.Seguimientotrabajo"%>
<%
    Seguimientotrabajo seg = (Seguimientotrabajo) request.getAttribute("seguimientotrab");
    List<Usuario> usu = (List<Usuario>) request.getAttribute("usuarios");
    List<Area1> a1 = (List<Area1>) request.getAttribute("areas1");
    List<Area2> a2 = (List<Area2>) request.getAttribute("areas2");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Solicitud de Empleo - Trabajos y Oportunidades Bolivia</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/solicitud.css">
    </head>
    <body>
        <div class="table-container">
            <img src="${pageContext.request.contextPath}/images/WhatsApp Image 2024-05-07 at 3.29.38 PM.png" alt="Fondo" class="background-image">
            <div class="background-image"></div>

            <div class="content">
                
                
                <form action="SeguimientotrabajoServlet" method="post">
                    <br><br><br><br><br><br><br><br><br><br><br><br><br><br>
                    <h2>SOLICITUD DE TRABAJO</h2>
                    <input type="hidden" name="id" value="<%=seg.getId()%>" >

                    <label for="nombre">Nombre:</label> <br>
                    <input  type="text" name="nombres" value="<%=seg.getNombres()%>" ><br>

                    <label for="apellidos">Apellidos: </label> <br>
                    <input type="text" name="apellidos" value="<%=seg.getApellidos()%>" ><br>

                    <label for="direccion">Direccion: </label> <br>
                    <input type="text" name="direccion" value="<%=seg.getDireccion()%>" ><br>

                    <label for="ciudad">Ciudad: </label> <br>
                    <input type="text" name="ciudad" value="<%=seg.getCiudad()%>" ><br>

                    <label for="estado">Estado </label> <br>
                    <input type="text" name="estado" value="<%=seg.getEstado()%>" ><br>

                    <label for="email">Email: </label> <br>
                    <td><input type="text" name="email" value="<%=seg.getEmail()%>" ><br>

                        <label for="celular">Celular: </label> <br>
                        <input type="number" name="celular" value="<%=seg.getCelular()%>" ><br>


                        <label for="descripcion1">Por que desea el empleo</label> <br>
                        <textarea name="descripcion1" rows="10" cols="50"><%=seg.getDescripcion1()%></textarea><br>

                        <label for="descripcion2">Anteriores empleos</label> <br>
                        <textarea name="descripcion2"  rows="10" cols="50"><%=seg.getDescripcion2()%></textarea><br>

                        <label for="area1Id">Trabajo Formal</label> <br>
                        <label for="area1Id">¿Que numero de trabajo desea?</label><br><br>
                        <select name="area1Id">
                            <%
                                for (Area1 item : a1) {
                            %>
                            <option value="<%=item.getId()%>"
                                    <%=(item.getId() == seg.getArea1Id().getId()) ? "selected" : ""%>
                                    ><%=item.getId() %>
                            </option>
                            <%
                                }
                            %>
                        </select><br><br>


                        <label for="area2Id">¿Trabajo Informal?</label> <br>
                        <label for="area2Id">¿Que numero de trabajo desea?</label> <br>
                    <td>
                        <select name="area2Id">
                            <%
                                for (Area2 item : a2) {
                            %>
                            <option value="<%=item.getId()%>"
                                    <%=(item.getId() == seg.getArea2Id().getId()) ? "selected" : ""%>
                                    ><%=item.getId() %>
                            </option>
                            <%
                                }
                            %>
                        </select><br><br>

                        <label for="usuarioId">Usuario: </label> <br>

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
                        <br><br>
                        <a href="menu.jsp" class="button-link">Volver a Menu</a>
                        <button type="submit">Enviar</button>
                        <button type="reset">Cancelar</button>
                </form>
            </div>
        </div>
    </body>
</html>
