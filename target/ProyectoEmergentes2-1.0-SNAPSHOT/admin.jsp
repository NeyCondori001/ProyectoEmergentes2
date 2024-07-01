<%-- 
    Document   : admin
    Created on : 28 jun. 2024, 11:47:11
    Author     : HP VICTUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Restringido</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/admin.css">
    </head>
    <body>

       

        <div class="top-center">
            <a href="menu.jsp" target="_blank"class="round-button">
                <img src="${pageContext.request.contextPath}/images/images.png" alt="Perfiles">
            </a>
            <a href="SeguimientoempresaServlet?action=view" class="button">Seguimiento de Solicitud de empresas</a>
            <a href="SeguimientotrabajoServlet?action=view" class="button">Seguimiento de Solicitudes de trabajos</a>
        </div>


    </body>
</html>
