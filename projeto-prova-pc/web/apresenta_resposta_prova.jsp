<%-- 
    Document   : apresenta_resposta_prova.jsp
    Created on : Oct 3, 2015, 2:15:57 PM
    Author     : lucas
--%>

<%@page import="java.util.List"%>
<%@page import="br.edu.ifpe.garanhuns.projetoProvaPc.dominio.AplicacaoDaProva"%>
<%@page import="br.edu.ifpe.garanhuns.projetoProvaPc.dominio.RespostaProva"%>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <% if(session.getAttribute("autenticacao")==null) response.sendRedirect("login_professor.jsp"); %>
        
    <%@include file="WEB-INF/jspf/header.jspf" %>
        <h2>Resultados da aplicação da prova </h2>
        Tema da prova: <%=session.getAttribute("tema")%><br/>
        Turma: <%=session.getAttribute("turma")%><br/>
        Data: <%=session.getAttribute("data")%><br/><br/>
        
        <%
        List<RespostaProva> respostas = (List<RespostaProva>) session.getAttribute("respostas");
        for(int i=0;i<respostas.size();i++) {
            RespostaProva r = respostas.get(i); %>
        
            <%=r.getAluno()%> - <%=r.pontuacao()%> <br/>
        
        <%}%>
    <%@include file="WEB-INF/jspf/footer.jspf" %>      
                
    </body>
</html>
