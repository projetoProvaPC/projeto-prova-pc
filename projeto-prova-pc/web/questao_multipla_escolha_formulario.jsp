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
        <h1>Pagina em construção!</h1>
        
        <form method="post" action="NovaQuestaoServlet">
            
            Enunciado:<br/>
            <input name="enumciado" type="text"/><br/>
            
            <input type="radio" name="correta" value="a"/>
            <input type="text" name="afirmcaoA"/><br/>
            
            <input type="radio" name="correta" value="b"/>
            <input type="text" name="afirmcaoB"/><br/>
            
            <input type="radio" name="correta" value="c"/>
            <input type="text" name="afirmcaoC"/><br/>
            
            <input type="radio" name="correta" value="d"/>
            <input type="text" name="afirmcaoD"/><br/>
            
            <input type="radio" name="correta" value="e"/>
            <input type="text" name="afirmcaoE"/><br/>
            
            <input type="submit" value="Adicionar"/>
          
        </form>
        
    </body>
</html>
