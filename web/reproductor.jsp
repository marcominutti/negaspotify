<%-- 
    Document   : reproductor
    Created on : 31-ago-2015, 12:00:20
    Author     : minutti
--%>
<%@page import="com.negaspotify.beans.Cancion"%>
<%@page import="com.negaspotify.beans.Album"%>
<%@page import="java.util.List"%>
<%@page import="org.hibernate.Session"%>
<%@page import="org.hibernate.cfg.Configuration"%>
<%@page import="org.hibernate.cfg.Configuration"%>
<%@page import="org.hibernate.SessionFactory"%>
<%@page import="org.hibernate.Query"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.negaspotify.beans.Artista"%>
<%@page import="java.io.File"%>
<%@page import="com.negaspotify.beans.Catalogo"%>
<%@page import="com.negaspotify.beans.utilerias.Serializador"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%--<%Catalogo catalogo = (Catalogo) Serializador.deserialize(new File("/Users/minutti/Desktop/Catalogo.negspot"));%>--%>
<% 
    SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
    Session sess = sessionFactory.openSession();
    sess.beginTransaction();
    
    
    
    
    //Albumes
    String artistaId = request.getParameter("artistaId");
    ArrayList<Album> albums;
    
    //Canciones
    String albumId = request.getParameter("albumId");
    ArrayList<Cancion> canciones;
    
    //Artistas
    String hqlArtistas = "from Artista";
    Query queryArtistas = sess.createQuery(hqlArtistas);
    ArrayList<Artista> artistas;
    artistas = (ArrayList<Artista>)queryArtistas.list();
    //Canciones
    if(albumId != null){
        String hqlCanciones;
        hqlCanciones = "from Cancion where albumId =" + albumId;
        Query queryCanciones = sess.createQuery(hqlCanciones);
        canciones = (ArrayList<Cancion>)queryCanciones.list();
    }else
        canciones = new ArrayList<>();
    //Albumes
    if(artistaId != null){
        String hqlAlbumes;
        hqlAlbumes= "from Album where artistaId =" + artistaId;
        Query queryAlbumes = sess.createQuery(hqlAlbumes);
        albums = (ArrayList<Album>)queryAlbumes.list();
    }else
        albums = new ArrayList<>();
    
    
    sess.close(); 
%>
<!DOCTYPE html>
<html>
    <head>
        <link href="css/estilo.css" rel="stylesheet" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!--titulo-->
        <link href='https://fonts.googleapis.com/css?family=Ubuntu' rel='stylesheet' type='text/css'>
        <!--Contenido-->
        <link href='https://fonts.googleapis.com/css?family=Raleway' rel='stylesheet' type='text/css'>
        <title>Reproductor</title>
    </head>
    <body>
        <h1>Nega Spotify</h1>
        <!--bloque principal-->
        <div id = "principal">
        
            <div id = "navegacion" class="scroll">
                <ul>
                    
                    
                    <% 
                    
                    for(Artista a: artistas){
                        out.println("<li><a href='reproductor.jsp?artistaId=" + a.getArtistaId()+"'>" + a.getNombre() + "</a></li>");
                    }
                    
                    %>
                    
                </ul>
                
            </div>

            <div id = "contenido" class="scroll">
                <ol>
                    <%
                        for(Album a:albums){
                           out.println("<li><a href='reproductor.jsp?albumId=" + a.getAlbumId()+"'>" + a.getNombre() + "</a></li>");
                        }
                    %>
                </ol>
                <ol>
                    <%
                        for(Cancion c:canciones){
                           out.println("<li>"+c.getTitulo()+"</li>");
                        }
                    %>
                </ol>
                
                <%--<% 
                    Album album;
                    for(Object o:resultados){
                        album = (Album)o;
                        out.println(album.getNombre());
                    } 
                %>--%>
            </div>
            
            <div id="portada">
                
            </div>
            
            <div id = "playback">
                <img src="imagenes/pause.png" alt="pause"/>
                <img src="imagenes/play.png" alt="play"/>
                <img src="imagenes/stop.png" alt="stop"/>
            </div>
            
        </div>
                
    </body>
</html>
