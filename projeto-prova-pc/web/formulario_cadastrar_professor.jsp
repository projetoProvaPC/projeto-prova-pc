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
        <h1>Cadastro de professores</h1>
        <form method="post" action="CadastrarProfessorServlet">
            Nome: <input type="text" name="nome"/> <br/>
            Siap: <input type="number" name="siap"/> <br/>
            Senha: <input type="password" name="senha1"/> <br/>
            Repetir Senha: <input type="password" name="senha2"/> <br/>
            <input type="submit" value="Cadastrar"/>
        </form>
    </body>
</html>
