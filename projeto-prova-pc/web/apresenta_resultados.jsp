<%-- 
    Document   : apresenta_resultados
    Created on : Oct 1, 2015, 5:28:19 PM
    Author     : lucas
--%>

<%@page import="java.util.List"%>
<%@page import="br.edu.ifpe.garanhuns.projetoProvaPc.dominio.AplicacaoDaProva"%>
<%@page contentType="text/html" pageEncoding="UTF-8" errorPage="pagina_erro.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% if(session.getAttribute("autenticacao")==null) response.sendRedirect("login_professor.jsp"); %>
        <%@include file="WEB-INF/jspf/header.jspf" %>
        <h2>Escolha uma aplicação de prova para ver os resultados</h2>
        <p>Prova, turma, data</p>
        <% 
            List<AplicacaoDaProva> aps = (List<AplicacaoDaProva>) session.getAttribute("aplicacoes_das_provas");
            for(int i=0;i<aps.size();i++) { 
                AplicacaoDaProva ap = aps.get(i);
        %>
        <%=ap.getTema()%>, <%=ap.getTurma()%>, <%=ap.getData()%>, <a href="ApresentaRespostasProvaServlet?ap=<%=i%>">resultados</a> <br/>
        <%  }
        %>
        <%@include file="WEB-INF/jspf/footer.jspf" %>
    </body>
</html>
