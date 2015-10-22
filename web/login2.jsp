<%-- 
    Document   : login
    Created on : 21-oct-2015, 11:58:53
    Author     : minutti
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="js/jquery-1.11.3.min.js" type="text/javascript"></script>
        <title>JSP Page</title>
        <script>
        function comprobarUsuario(){
            var username = $("#username").val();
            var password = $("#password").val();
            
                $.getJSON("login",
                {username:username,password:password},
                function(user){
                    if(user)
                        window.location.href = "/Nega-Spotify/reproductor.jsp";
                    
                    
                });
            }
        </script>
        
        
    </head>
    <body>
        <h1>Login</h1>
        <table>
            <tr>
                <td>Username:</td>
                <td><input type="text" id="username"/></td>
            </tr>
            <tr>
                <td>Password:</td>
                <td><input type="password" id="password"/></td>
            </tr>
            <tr>
                <td>
                </td>
                <td>
                    <input type="button" value="Entrar" onclick="comprobarUsuario()"/>
                </td>
            </tr>
            
        </table>
    </body>
</html>
