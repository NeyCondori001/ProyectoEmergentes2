<%-- 
    Document   : mensajecorrecto
    Created on : 27 jun. 2024, 11:46:09
    Author     : HP VICTUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            .message-box {
                border: 2px solid #4CAF50;
                padding: 20px;
                background-color: #f9f9f9;
                width: 300px;
                margin: 0 auto;
                text-align: center;
            }
            .button {
                display: inline-block;
                padding: 10px 20px;
                font-size: 14px;
                cursor: pointer;
                text-align: center;
                text-decoration: none;
                outline: none;
                color: #fff;
                background-color: #4CAF50;
                border: none;
                border-radius: 15px;
                box-shadow: 0 5px #999;
                margin: 5px;
            }
            .button:hover {background-color: #3e8e41}
            .button:active {
                background-color: #3e8e41;
                box-shadow: 0 5px #666;
                transform: translateY(4px);
            }
        </style>
    </head>
    <body>
        <div class="message-box">
            <h2>Su mensaje se mandó correctamente</h2>
            <button class="button" onclick="location.href='menu.jsp'">Volver al Menú</button>
        </div>
    </body>
</html>
