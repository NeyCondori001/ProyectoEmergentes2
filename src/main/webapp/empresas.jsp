<%@page import="com.emergentes.entidades.Empresa"%>
<%@page import="java.util.List"%>
<%
    List<Empresa> empresas = (List<Empresa>) request.getAttribute("empresas");
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
                <h1>Servicios de empresas</h1>
                <div class="header-buttons">
                    <a href="SeguimientoempresaServlet?action=add"  class="button-link">Solicitar servicio</a>
                    <a href="menu.jsp" class="button-link" >Volver a Menu</a>


                </div>
            </div>
        </header><br>

        <div class="card-container">
            <%
                for (Empresa item : empresas) {
            %>
            <div class="profile-card">
                <img src="${pageContext.request.contextPath}/images/icono3.png"alt="icono3" style="width: 100px; height: 100px;">
                <p>
                    Nro : <%=item.getId()%> <br>
                    Nombre : <%=item.getNombre()%><br>
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
