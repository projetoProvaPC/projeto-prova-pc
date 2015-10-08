<%-- 
    Document   : paginaProfessor
    Created on : 29/09/2015, 15:00:12
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
        <% if(session.getAttribute("autenticacao")==null) response.sendRedirect("login.jsp"); %>
        <h1>Ola professor!</h1>
                <a href="formulario_prova.jsp">Criar Prova</a> <br/>
                <a href="RecuperarTodasAsProvasServlet">Aplicar prova:<a/> <br/>
                <a href="RecuperarAplicacaoDeProvaServlet">Ver Resultados:<a/><br/>
    </body>
</html>
