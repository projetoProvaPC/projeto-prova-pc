<%-- 
    Document   : novaQuestao
    Created on : 29/09/2015, 16:11:44
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

        <h2>Adicionando uma nova questão à prova.</h2>
        
        <form method="post" action="ConstrucaoQuestaoMultiplaEscolhaServlet">
            
            Enunciado:<br/>
            <input name="enunciado" type="text"/><br/>
            
            <input type="radio" name="correta" value="a"/>
            <input type="text" name="afirmacaoa"/><br/>
            
            <input type="radio" name="correta" value="b"/>
            <input type="text" name="afirmacaob"/><br/>
            
            <input type="radio" name="correta" value="c"/>
            <input type="text" name="afirmacaoc"/><br/>
            
            <input type="radio" name="correta" value="d"/>
            <input type="text" name="afirmacaod"/><br/>
            
            <input type="radio" name="correta" value="e"/>
            <input type="text" name="afirmacaoe"/><br/>
            
            <input type="submit" value="Adicionar"/>
          
        </form>
        <%@include file="WEB-INF/jspf/footer.jspf" %>

    </body>
</html>
