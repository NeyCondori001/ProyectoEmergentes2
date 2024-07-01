<%@page import="com.emergentes.entidades.Area1"%>
<%@page import="java.util.List"%>
<%
    List<Area1> a1 = (List<Area1>) request.getAttribute("areas1");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Trabajos formales -  Trabajos y Oportunidades Bolivia</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/trabajos.css">
  
</head>
<body>
    <header class="header">
        <div class="header">
            <h1>Trabajos Formales </h1>
            <div class="header-buttons">
                <a href="SeguimientotrabajoServlet?action=add" class="button-link">Enviar curriculum</a>
                <a href="menu.jsp" class="button-link" >Volver a Menu</a>

            </div>
        </div>
    </header>
    
    <h1>Listado de registros - AREA 1 </h1>
    <div class="card-container">
        <%
            for (Area1 item : a1) {
        %>
        <div class="profile-card">
            <img src="${pageContext.request.contextPath}/images/icono.png"alt="icono" style="width: 100px; height: 100px;">
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
    <p>

    </p>
</body>
</html>
