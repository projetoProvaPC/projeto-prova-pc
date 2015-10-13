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
    <%ui:include file="WEB-INF/jspf/header.jspf"%>
        <h2>Página de login para professores</h2>
        
        <p>Olá, professor! Obrigado por usar o nosso sistema.>/p>
        
        <form method="post" action="LoginServlet">
            Login: <input type="number" name="login"> <br/>
            Senha: <input type="password" name="pwd"> <br/>
            <input type="submit" value="Entrar"/>
        </form>
        
        <%ui:include file="WEB-INF/jspf/footer.jspf"%>
    </body>
</html>
