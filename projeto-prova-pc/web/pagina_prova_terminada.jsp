<%-- 
    Document   : pagina_prova_terminada
    Created on : Oct 1, 2015, 4:50:15 PM
    Author     : lucas
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
        
        <h2>Você acabou!</h2>
        
        <p>
            Matricula: <%=session.getAttribute("matricula")%>
            Nota: <%=session.getAttribute("nota")%>
        </p>            
                
        <%@include file="WEB-INF/jspf/footer.jspf"%>
    </body>
</html>
