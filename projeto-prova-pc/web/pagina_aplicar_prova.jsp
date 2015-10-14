<%-- 
    Document   : pagina_aplicar_prova
    Created on : 01/10/2015, 16:31:17
    Author     : 20151D12GR0065
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="WEB-INF/jspf/header.jspf"%>
        <h2>Os alunos já podem começar a responder a prova!</h2>
        
        <p>Distribua a senha abaixo para todos os alunos, eles só podem responder a prova com ele!</p>
        <p>Anote-a o mais rápido possível, antes de sair dessa página. Não dá para recuperar depois</p>
        
        <% if (session.getAttribute("turma")==null) {
            session.setAttribute("exception", new Exception("turma is null on pagina_aplica_prova.jso"));
            response.sendRedirect("pagina_erro.jsp");
            return;
        }%>
        
         tema:<%=session.getAttribute("tema")%><br>        
         turma:<%=session.getAttribute("turma")%><br> 
         senha:<%=session.getAttribute("senha")%><br>
         <a href="index_professor.jsp">Voltar</a>
         
         <%@include file="WEB-INF/jspf/footer.jspf"%>
    </body>
</html>
