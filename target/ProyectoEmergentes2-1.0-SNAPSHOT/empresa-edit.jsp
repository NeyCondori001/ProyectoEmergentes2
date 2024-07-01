<%@page import="com.emergentes.entidades.Empresa"%>
<%
    Empresa empre = (Empresa) request.getAttribute("empresa");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Publicar servicios de Empresa - Trabajos y Oportunidades Bolivia</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/solicitud.css">
    </head>
    <body>
        <div class="table-container">
            <img src="${pageContext.request.contextPath}/images/WhatsApp Image 2024-05-07 at 3.29.38 PM.png" alt="Fondo" class="background-image">
            <div class="background-image"></div>

            <div class="content">
                <form action="EmpresaServlet" method="post">
                     <h1>Publica sobre tu empresa</h1>

                     <label for="nombre">Nombre:</label> <br>
                    <input type="hidden" name="id" value="<%= empre.getId()%>">
                    <input type="text" name="nombre" value="<%= empre.getNombre()%>"> <br> <br>

                     <label for="ubicacion">Ubicacion: </label> <br>
                    <input type="text" name="ubicacion" value="<%= empre.getUbicacion()%>"> <br> <br>

                    <label for="descripcion">Descripcion de lo que ofrece: </label> <br>
                    <textarea name="descripcion"  rows="8" cols="30"><%=empre.getDescripcion()%></textarea><br><br> <br>
                    <a href="menu.jsp" class="button-link">Volver a Menu</a>
                    <button  type="submit" onclick="return(confirm('Su registro se realizo con exito'))">Enviar</button>
                    <button type="reset">Cancelar</button>   
                </form>
            </div>
        </div>
    </body>
</html>
