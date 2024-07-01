<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
         <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>trabajosyoportunidadesBolivia</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css">
    </head>
    <body>
        <div class="table-container">
            <img src="${pageContext.request.contextPath}/images/WhatsApp Image 2024-05-07 at 3.29.38 PM.png" alt="Fondo" class="background-image">
            <div class="login-container">
                <h2>Login</h2>
                <% if (request.getParameter("error") != null && request.getParameter("error").equals("true")) { %>
                <div class="alert alert-danger" role="alert">
                    Usuario o contraseña incorrectos.
                </div>
                <% }%>

                <form action="UsuarioServlet" method="post">

                    <input type="hidden" name="action" value="login">

                    <div class="form-group">
                        <label for="nombreusuario">Usuario:</label>
                        <input type="text" class="form-control" id="nombreusuario" name="nombreusuario" required>
                    </div>
                    <div class="form-group">
                        <label for="password">Contraseña:</label>
                        <input type="password" class="form-control" id="password" name="password" required>
                    </div>
                    <button type="submit" class="btn btn-primary">Iniciar sesión</button>
                </form>
            </div>
        </div>
    </body>
</html>