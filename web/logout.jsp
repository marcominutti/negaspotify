<%-- 
    Document   : logout
    Created on : 21-oct-2015, 18:46:46
    Author     : minutti
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Vuelve pronto</h1>
        <%
            session.invalidate();
        %>
        <a href="login.jsp">Login</a>
    </body>
</html>
