<%-- 
    Document   : index
    Created on : Sep 29, 2015, 7:24:29 PM
    Author     : lucas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="br.edu.ifpe.garanhuns.projetoProvaPc.fachada.Logger"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="WEB-INF/jspf/header.jspf" %>
        <h2> Home Page </h2>
        
        <a href="login_professor.jsp">login</a> <br/>
        <a href="formulario_cadastrar_professor.jsp">cadastrar professor</a> <br/>
        <a href="formulario_responder_prova.jsp">responder uma prova</a>

        <%@include file="WEB-INF/jspf/footer.jspf" %>

    </body>
</html>
