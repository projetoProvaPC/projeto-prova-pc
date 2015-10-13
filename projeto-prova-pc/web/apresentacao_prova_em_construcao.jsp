<%-- 
    Document   : mostrarProvaEmConstrucao
    Created on : 29/09/2015, 17:10:43
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
        <%@include file="WEB-INF/jspf/header.jspf" %>
        
        <h2> Prova em construção</h2>

        <a href="formulario_questao_multipla_escolha.jsp">Adicionar outra Questão</a><br/>
        <a href="ConstrucaoProvaServlet">Finalizar</a><br/>
        
        <%@include file="WEB-INF/jspf/footer.jspf" %>

    </body>
</html>
