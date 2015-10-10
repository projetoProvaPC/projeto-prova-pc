<%-- 
    Document   : login
    Created on : 29/09/2015, 14:54:53
    Author     : 20141D12GR0122
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Seja bem-vindo ao Prova PC</h1>
        <form method="post" action="LoginServlet">
            Login: <input type="number" name="login"> <br/>
            Senha: <input type="password" name="pwd"> <br/>
            <input type="submit" value="Entrar"/>
        </form>
    </body>
</html>
