<%-- 
    Document   : apresentar_aplicacao_prova
    Created on : Oct 1, 2015, 5:10:10 PM
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
        
        <% if(session.getAttribute("autenticacao")==null) response.sendRedirect("login_professor.jsp"); %>
        
        <%@include file="WEB-INF/jspf/header.jspf" %>
        <h2> Aplicação da prova </h2>
        Tema:<%= session.getAttribute("tema")%>
        Turma:<%= session.getAttribute("turma")%>
        Data:<%=session.getAttribute("data")%>
        
        <a href="RecuperarResultadosAplicacaoDeProvaServlet">Resultados</a> <br/>


        <%@include file="WEB-INF/jspf/footer.jspf" %>

    </body>
</html>
