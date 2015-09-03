<%-- 
    Document   : reproductor
    Created on : 31-ago-2015, 12:00:20
    Author     : minutti
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="com.negaspotify.beans.Artista"%>
<%@page import="java.io.File"%>
<%@page import="com.negaspotify.beans.Catalogo"%>
<%@page import="com.negaspotify.beans.utilerias.Serializador"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%--<%Catalogo catalogo = (Catalogo) Serializador.deserialize(new File("/Users/minutti/Desktop/Catalogo.negspot"));%>--%>
<!DOCTYPE html>
<html>
    <head>
        <style>
            #principal{ width: 800px; height: 500px; border: 1px solid black; background-color: gray; position: relative; }
            #navegacion{width: 300px; height: 300px; border: 1px solid black; position: absolute; top: 10px; left:10px; }
            #playback{position: absolute;}
        </style>
    
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Reproductor</title>
    </head>
    <body>
        <h1>Reproductor</h1>
        <div id = "principal">
        
            <div id = "navegacion">
                <ul>
                    
                    <%--
                    <% 
                        Artista artista;
                        ArrayList<Artista> artistas = catalogo.getArtistas();
                        for(int i = 0; i < artistas.size();i++){
                            artista = artistas.get(i);
                            out.println("<li>" + artista.getNombre() + "</li>");
                        }
                    %>
                    --%>
                    
                </ul>
                
            </div>

            <img id = "portada"/>

            <div id = "canciones">

            </div>

            <div id = "playback">
                <img src="/Users/minutti/Desktop/NegaSpotify/imagenes/play_button.png" alt=""/>
            </div>
            
        </div>
                
    </body>
</html>
