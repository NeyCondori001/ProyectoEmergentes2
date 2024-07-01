<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Registro de Usuario</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/registrate.css">
    </head>
    <body>
        <div class="table-container">
            <img src="${pageContext.request.contextPath}/images/WhatsApp Image 2024-05-07 at 3.29.38 PM.png" alt="Fondo" class="background-image">
            <div class="content">
                <h2>Registrarte</h2>
                <p>Es rápido y fácil.</p>

                <form action="UsuarioServlet" method="post">
                    <input type="hidden" name="action" value="register">
                    <div class="form-group">
                        <label for="fechanac">Fecha de Nacimiento:</label>
                        <input type="date" class="form-control" id="fechanac" name="fechanac" required><br><br>
                    </div>

                    <div class="form-group">
                        <label for="nombres">Nombres:</label>
                        <input type="text" class="form-control" id="nombres" name="nombres" required><br><br>
                    </div>
                    <div class="form-group">
                        <label for="apellidos">Apellidos:</label>
                        <input type="text" class="form-control" id="apellidos" name="apellidos" required><br><br>
                    </div>
                    <div class="form-group">
                        <label for="ocupacion">Ocupacion:</label>
                        <input type="text" class="form-control" id="ocupacion" name="ocupacion" required><br><br>
                    </div>
                    <div class="form-group">
                        <label for="email">Email</label>
                        <input type="email" class="form-control" id="email" name="email" required><br><br>
                    </div>
                    <div class="form-group">
                        <label for="password">Contraseña:</label>
                        <input type="password" class="form-control" id="password" name="password" required><br><br>
                    </div>
                    <div class="form-group">
                        <label for="nombreusuario">nombreusuario:</label>
                        <input type="text" class="form-control" id="nombreusuario" name="nombreusuario" required><br><br>
                    </div> 
                    <div class="form-group">
                        <label>Género:</label><br>
                        <div class="form-check form-check-inline">
                            <input class="form-check-input" type="radio" name="sexo" id="femenino" value="F" required>
                            <label class="form-check-label" for="femenino">Femenino</label>
                        </div>
                        <div class="form-check form-check-inline">
                            <input class="form-check-input" type="radio" name="sexo" id="masculino" value="M">
                            <label class="form-check-label" for="masculino">Masculino</label>
                        </div>
                    </div> 

                    <button type="submit" class="btn btn-primary" onclick="return(confirm('Se registro con exito! ya puede iniciar sesion'))">Registrarse</button>
                </form>
            </div>
        </div> 

    </body>
</html>
