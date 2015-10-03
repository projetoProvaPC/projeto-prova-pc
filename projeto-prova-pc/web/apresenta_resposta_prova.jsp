<%-- 
    Document   : apresenta_resposta_prova.jsp
    Created on : Oct 3, 2015, 2:15:57 PM
    Author     : lucas
--%>

<%@page import="java.util.List"%>
<%@page import="br.edu.ifpe.garanhuns.projetoProvaPc.dominio.AplicacaoDaProva"%>
<%@page import="br.edu.ifpe.garanhuns.projetoProvaPc.dominio.RespostaProva"%>
<%@page contentType="text/html" pageEncoding="UTF-8" errorPage="pagina_erro.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Aqui aparece uma tabela Matricula - Nota </h1>
        Tema da prova: <%=session.getAttribute("tema")%>
        Turma: <%=session.getAttribute("turma")%>
        Data: <%=session.getAttribute("data")%>
        
        <%
        List<RespostaProva> respostas = (List<RespostaProva>) session.getAttribute("respostas");
        for(int i=0;i<respostas.size();i++) {
            RespostaProva r = respostas.get(i); 
        %>
        
            <%=r.getAluno()%> - <%=r.pontuacao()%> <br/>
        
        <%}%>
                
                
    </body>
</html>
