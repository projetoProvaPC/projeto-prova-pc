<%-- 
    Document   : formulario_rersponder_prova
    Created on : Oct 1, 2015, 4:38:15 PM
    Author     : lucas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form method="post" action="ResponderProvaServlet">
            Matricula: <input type="text" name="matricula"> <br/>
            Senha: <input type="text" name="senha"> <br/>
            <input type="submit" value="Iniciar"/>
        </form>

    </body>
</html>
