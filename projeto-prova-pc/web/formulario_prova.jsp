<%-- 
    Document   : newProva
    Created on : 29/09/2015, 15:08:10
    Author     : 20141D12GR0122
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="WEB-INF/jspf/header.jspf" %>

        <h2>Formulario em construção!</h2>
        <form method="post" action="IniciaConstrucaoProvaServlet">
            TEMA: <input type="text" name="tema"> <br/>
            <input type="submit" value="Adicionar Questão">
        </form>
        <%@include file="WEB-INF/jspf/footer.jspf" %>

    </body>
</html>
