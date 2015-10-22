<%-- 
    Document   : login
    Created on : 21-oct-2015, 11:58:53
    Author     : minutti
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="css/login.css" rel="stylesheet" type="text/css"/>
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
        <div class="login">
            <div class="heading">
                <h2>Sign in</h2>
                <form action="#">

                    <div class="input-group input-group-lg">
                        <span class="input-group-addon"><i class="fa fa-user"></i></span>
                        <input id="username" type="text" class="form-control" placeholder="Username">
                    </div>

                    <div class="input-group input-group-lg">
                      <span class="input-group-addon"><i class="fa fa-lock"></i></span>
                      <input id="password" type="password" class="form-control" placeholder="Password">
                    </div>

                    <button type="button" class="float" onclick="comprobarUsuario()">Login</button>
                </form>
            </div>
        </div>
    </body>
</html>
