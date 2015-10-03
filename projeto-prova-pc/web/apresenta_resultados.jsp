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
        <h1>Finja qie aqui tem uma tabela com resultados</h1>
        <p>Prova, turma, data</p>
        <% 
            List<AplicacaoDaProva> aps = (List<AplicacaoDaProva>) session.getAttribute("aplicacoes_das_provas");
            for(int i=0;i<aps.size();i++) { 
                AplicacaoDaProva ap = aps.get(i);
        %>
        <%=ap.getTema()%>, <%=ap.getTurma()%>, <%=ap.getData()%>, <a href="ApresentaRespostasProvaServlet?ap=<%=i%>">resultados</a> <br/>
        <%  }
        %>
    </body>
</html>
