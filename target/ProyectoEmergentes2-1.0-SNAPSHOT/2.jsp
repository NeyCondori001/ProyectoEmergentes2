<%@page import="com.emergentes.entidades.Area2"%>
<%@page import="java.util.List"%>
<%
    List<Area2> a2 = (List<Area2>) request.getAttribute("areas2");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>trabajosyoportunidadesBolivia.com</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/trabajos.css">
    </head>
    <body>

        <header class="header">
            <div class="header">
                <h1>Trabajos informales</h1>
                <div class="header-buttons">
                    <a href="SeguimientotrabajoServlet?action=add"  class="button-link">Enviar curriculum</a>
                    <a href="menu.jsp" class="button-link" >Volver a Menu</a>


                </div>
            </div>
        </header><br>


        <div class="card-container">
            <%
                for (Area2 item : a2) {
            %>
            <div class="profile-card">
                <img src="${pageContext.request.contextPath}/images/icono2.png"alt="icono2" style="width: 100px; height: 100px;">
                <p>
                    Nro : <%=item.getId()%> <br>
                    Titulo : <%=item.getTitulo()%> <br>
                    Tiempo : <%=item.getTiempo()%> <br>
                    Requisitos : <%=item.getRequisitos()%><br>
                    Ubicacion : <%=item.getUbicacion()%><br>
                    Descripcion : <%=item.getDescripcion()%><br>
                    
                </p>

            </div>
            <%
                }
            %>
        </div>

    </body>
</html>