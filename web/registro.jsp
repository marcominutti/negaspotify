<%-- 
    Document   : registro
    Created on : 19-oct-2015, 11:29:28
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
            function registrarUsuario(){
                
                var nombre = $("#nombre").val();
                var contrasena = $("#contrasena").val();
                var username = $("#username").val();
                
                $.getJSON("RegistroUser",
                {
                 nombre:nombre,
                 contrasena:contrasena,
                 username:username
                },
                function(resultado){
                    if(resultado)
                    alert("Registro Correcto");
                }
            );
}
            
        </script>
    </head>
    <body>
        <h1>Registro</h1>
        
        <form>
            Nombre:<br><input type="text" id="nombre"><br> 
            Username:<br><input type="text" id="username"><br>
            Password:<br><input type="password" id="contrasena"><br>
            <input type="button" value="Registrar" onclick="registrarUsuario()">
        </form>
        
        
        
    </body>
</html>
