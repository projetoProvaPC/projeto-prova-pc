<%-- 
    Document   : prova
    Created on : Oct 1, 2015, 4:44:27 PM
    Author     : lucas
--%>

<%@page import="br.edu.ifpe.garanhuns.projetoProvaPc.dominio.QuestaoMultiplaEscolha"%>
<%@page import="java.util.Iterator"%>
<%@page import="br.edu.ifpe.garanhuns.projetoProvaPc.dominio.Afirmacao"%>
<%@page import="br.edu.ifpe.garanhuns.projetoProvaPc.dominio.Questao"%>
<%@page import="br.edu.ifpe.garanhuns.projetoProvaPc.dominio.Prova"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%ui:include file="WEB-INF/jspf/header.jspf"%>
        <h2>A prova!</h2>
        <%---
        Esta página recupera a prova no atributo "prova" da session e contrói
        um formulário a partir dela. Os nomes dos campos (<input>) que serão
        gerados são padronizados. Essa versão só admite questões de mútipla
        escolha, logo o padrão é que a resposta para cada questão está demarcada
        como qN, onde N é um número da questão e a resposta será a letra
        escolhida, i.e., 'a','b','c','d' ou 'e'.
        --%>
        
        <% Prova p = (Prova) session.getAttribute("prova"); %>
        <% Iterator<QuestaoMultiplaEscolha> qs = p.iterator(); %>
        <%! QuestaoMultiplaEscolha q ; %>
        <% int qn = 0; %>
        
        <%! Iterator<Afirmacao> as; %>
        <%! Afirmacao a; %>
        <%! char ac; %>
        
        
        <%
        String senha = session.getAttribute("senha").toString(),
                matricula = session.getAttribute("matricula").toString();
        %>
        
        <form method="post" action="SubmeteRespostaDaProvaServlet">
            
            <input type="hidden" name="senha" value="<%=senha%>"/>
            <input type="hidden" name="matricula" value="<%=matricula%>"/>
            
            <% while ( qs.hasNext() ) { %>
                <% q = (QuestaoMultiplaEscolha) qs.next() ; %>
                <% qn++; %>
                <% ac = 'a'; %>
                
                
                <%=qn%>. <%=q.getEnunciado()%> <br/>
               
                <% for (ac = 'a';ac<='e';ac++) { %>
                
                    <% a = q.getAlterntiva(ac); %>
                    
                    <input type="radio" name="q<%=qn%>" value="<%=ac%>"/>
                    
                    <%=ac%>) <%= a.getTexto() %> <br/>
                
                <% } %>
                
            <% }  %>
            <input type="submit"  value="Terminei"/>
        </form>
        <%ui:include file="WEB-INF/jspf/footer.jspf"%>
    </body>
</html>
