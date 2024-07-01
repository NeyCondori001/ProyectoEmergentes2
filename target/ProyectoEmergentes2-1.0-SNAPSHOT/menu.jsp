<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/paginaprincipal.css">
    </head>
    <body>
        <h1>MENU <br> Bienvenido a Trabajos y Oportunidades Bolivia</h1>
   
            <div class="card-container">
            <div class="profile-card"><br>
                <a href="Area1Servlet?action=view"target="_blank" class="button">Trabajos de empresas</a>

                <img src="${pageContext.request.contextPath}/images/WhatsApp Image 2024-05-07 at 4.48.00 PM.jpeg"alt="Perfil">
                <p><br>Trabajos para personal 
                    con experiencia 
                    profecional de oficinas,
                    empresas, instituciones,
                    trabajos formales,
                    donde puedes encontrar 
                    tu trabajo ideal paraa ti.</p>
                <div></div>

            </div>
  


            <div class="profile-card"><br>
                <a href="Area2Servlet?action=view" target="_blank" class="button">Trabajos de ayudantes o Informales</a>

                <img src="${pageContext.request.contextPath}/images/WhatsApp Image 2024-05-07 at 4.48.43 PM.jpeg"alt="Perfil">
                <p><br>Tienes experiencia o no
                    como trabajador de distintas areas, busca aqui</p>
                <div></div>

            </div>



            <div class="profile-card"><br>
                <a href="EmpresaServlet?action=view" target="_blank" class="button">Servicios de Empresas</a>

                <img src="${pageContext.request.contextPath}/images/WhatsApp Image 2024-05-07 at 4.46.47 PM.jpeg"alt="Perfil">
                <p><br>Requieres algun servicio 
                    o cuentas con un 
                    problema no olvides 
                    contactarnos nos 
                    procupamos por tu 
                    vienestar.</p>
                <div></div>

            </div>



       
            <div class="profile-card"><br>
                <a href="formulario.jsp" target="_blank" class="button">Crea una Publicacion de Trabajo</a>

                <img src="${pageContext.request.contextPath}/images/anuncio.jpeg"alt="Perfil">
                <p><br>Necesitas un trabajador ya sea para trabajo formal e informal? aqui
                    puedes publicar tu propio anuncio!!!</p>
                <div></div>
            </div>


       
            <div class="profile-card"><br>
                <a href="EmpresaServlet?action=add" target="_blank" class="button">Crea tu anuncio de empresa</a>

                <img src="${pageContext.request.contextPath}/images/empresaanuncio.jpg"alt="Perfil">
                <p><br>Quieres que tu empresa sea mas conocida? Aqui tenemos la solucion, publica los servicios
                que ofrece tu empresa!!!!</p>
                <div></div>
            </div>
     
        </div>
    </body>
</html>
