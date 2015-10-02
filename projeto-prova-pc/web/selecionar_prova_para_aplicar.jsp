<%-- 
    Document   : selecionar_prova_para_aplicar
    Created on : 01/10/2015, 16:12:50
    Author     : 20151D12GR0065
--%>

<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page import="br.edu.ifpe.garanhuns.projetoProvaPc.dominio.Prova"%>
<%@page import="br.edu.ifpe.garanhuns.projetoProvaPc.dominio.Prova"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1></h1>
        <% 
        List<Prova> provas = (List<Prova>) session.getAttribute("provas");
        
        
        for(int i=0;i<provas.size();i++){ 
            Prova p = provas.get(i);
        %>
        <%=p.getTema()%>: <a href="PreparaFormularioAplicarProvaServlet?i=<%=i%>">Aplicar</a>
        <% } %>
    </body>
</html>
