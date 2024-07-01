<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Publicacion - Trabajos y Oportunidades Bolivia</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/publicaranuncios.css">
    </head>
    <body>
        <div class="table-container">
            <img src="${pageContext.request.contextPath}/images/WhatsApp Image 2024-05-07 at 3.29.38 PM.png" alt="Fondo" class="background-image">
            <div class="background-image"></div>

            <div class="content">
                <form action="procesar" method="post">
                    <h2>CREA TU PUBLICACION</h2>
                    <label for="titulo">Titulo: </label><br><br>
                    <input type="text" name="titulo" required><br><br>

                    <label for="area">Área: </label><br>
                    <label for="area">1 - Trabajos formales o de empresas </label><br>
                    <label for="area">2 - Trabajos Informales </label><br>
                    <input type="number" name="area" required><br><br>

                    <label for="tiempo">Tiempo: </label><br>
                    <input type="text" name="tiempo" required><br><br>

                    <label for="requisitos">Requisitos: </label><br>
                    <input type="text" name="requisitos" required><br><br>

                    <label for="ubicacion">Ubicacion: </label><br>
                    <input type="text" name="ubicacion" required><br><br>

                    <label for="descripcion">Descripcion: </label><br>
                    <input type="text" name="descripcion" required><br><br>

                    <a href="menu.jsp" class="button-link">Volver a Menu</a>
                    <button type="submit">Enviar</button>
                    <button type="reset">Cancelar</button>
                </form>
            </div>
        </div>
    </body>
</html>
