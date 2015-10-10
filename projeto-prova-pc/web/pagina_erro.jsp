<%-- 
    Document   : error_page
    Created on : Sep 30, 2015, 6:29:39 PM
    Author     : lucas
--%>

<%@page import="java.io.PrintWriter"%>
<%@page import="java.io.StringWriter"%>
<%@page contentType="text/html" pageEncoding="UTF-8" isErrorPage="true" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Ops! Deu pau!</h1>
        <% Exception e = (Exception) request.getSession().getAttribute("exception");
           if (e!=null) { 
                StringWriter sw = new StringWriter();
                PrintWriter pw = new PrintWriter(sw);
                e.printStackTrace(pw);

        %>
           <p> <%=e.getMessage() %> </p>
           <p> <%=sw.toString()%> </p>
           <% } %>
           
           <%@include file="WEB-INF/jspf/escreve_mensagens.jspf" %>
           
    </body>
</html>
