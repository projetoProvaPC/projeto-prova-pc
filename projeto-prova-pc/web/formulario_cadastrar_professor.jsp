<%-- 
    Document   : formulario_cadastrar_professor
    Created on : Sep 30, 2015, 8:34:40 PM
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
        <%@include file="WEB-INF/jspf/header.jspf" %>

        <h2>Cadastro de professores</h2>
        <form method="post" action="CadastrarProfessorServlet">
            Siap: <input type="number" name="siap"/> <br/>
            Senha: <input type="password" name="senha1"/> <br/>
            Repetir Senha: <input type="password" name="senha2"/> <br/>
            <input type="submit" value="Cadastrar"/>
        </form>
        <%@include file="WEB-INF/jspf/footer.jspf" %>

    </body>
</html>
