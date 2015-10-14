<%-- 
    Document   : apresente_aplicacao_da_prova
    Created on : 02/10/2015, 17:05:57
    Author     : 20141D12GR0122
--%>

<%@page import="java.util.List"%>
<%@page import="br.edu.ifpe.garanhuns.projetoProvaPc.dominio.AplicacaoDaProva"%>
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

        <h2>Provas aplicadas</h2>
        
        <% List<AplicacaoDaProva> as = (List<AplicacaoDaProva>) session.getAttribute("aplicacao_da_prova_list"); %>
        
        <% if (as==null) {
           session.setAttribute("exception", new Exception("apresente_aplicacao_da_prova.jsp::session::as==null"));
           response.sendRedirect("pagina_erro.jsp");
        } else if (as.size()==0) {%>
            <p>Não tem nenhuma aplicacao de prova</p>
        <%} else {%>
        
            <% for(int i=0;i<as.size();i++) { %>
            
                <% AplicacaoDaProva a = as.get(i);  %>
        
                <%= a.getTema() %> | <%=a.getTurma()%> | <a href="ApresentaRespostasProvaServlet?i=<%=i%>">Ver resultados</a><br/>
        
            <% }  %>
        
        <% } %>
        <%@include file="WEB-INF/jspf/footer.jspf" %>

    </body>
</html>
