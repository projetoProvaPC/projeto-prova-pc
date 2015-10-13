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
        
        <p>
            Matricula: <%=session.getAttribute("matricula")%>
            Nota: <%=( (double) session.getAttribute("nota"))%>
                    
                
        
    </body>
</html>
