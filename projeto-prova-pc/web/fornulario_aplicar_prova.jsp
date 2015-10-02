<%-- 
    Document   : fornulario_aplicar_prova
    Created on : 01/10/2015, 16:21:21
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
        tema:<%=session.getAttribute("tema")%> <br>
        
        turma: <input type="text" name="Turma"> <br/>
        
         <a href="AplicarProvaServlet">Aplicar</a>
                
    </body>
</html>
