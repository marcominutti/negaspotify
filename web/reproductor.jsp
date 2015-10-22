<%-- 
    Document   : reproductor
    Created on : 31-ago-2015, 12:00:20
    Author     : minutti
--%>
<%@page import="com.negaspotify.beans.Usuario"%>
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
    Usuario usuario = (Usuario)session.getAttribute("user");
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
    
        out.println("Error en la conexión");
    
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
        <!--frase-->
        <link href='https://fonts.googleapis.com/css?family=Lobster' rel='stylesheet' type='text/css'>
        <script src="js/jquery-1.11.3.min.js" type="text/javascript"></script>
        <title>Reproductor</title>
        <script>
            
            function cargarAlbums(id){
                $.getJSON("ListadoAlbums",
                {artistaId:id},
                function(albums){
                        $("#contenido").html("");
                    for(var i = 0; i < albums.length;i++){
                        var titulo = albums[i].nombre;
                        var albumId = albums[i].albumId;
                        var contenido = "<a href='javascript:consultaAlbum(" + albumId + ")'>" + titulo + "</a>" + "<br>"; 
                        $("#contenido").append(contenido);
                        
                        //$("#contenido").append("<br>");
                    }
                });
            }
            function consultaAlbum(id){
                $.getJSON("Listado",
                {albumId:id},
                function(canciones){
                    $("#contenido").html("");
                    for(var i = 0; i < canciones.length;i++){
                        var titulo = canciones[i].titulo;
                        var cancionId = canciones[i].cancionId;
                        //var contenido = "<a href='javascript:cargarCancion("+ cancionId +")'>" + titulo + "</a>" + "<br>";
                        //$("#contenido").append(contenido);
                        var contenido = "<a href='javascript:cargarCancion("+ cancionId +")' onclick='reproducirCancion("+cancionId+")'>" + titulo + "</a>" + "<br>";
                        $("#contenido").append(contenido);
            }

                });
            }
            //funcion para obtener titulo de la cancion y mostrarlo cuando se de clic a la cancion
            function cargarCancion(id){
                $.getJSON("DetalleCancion",
                {cancionId:id},
                function(cancion){
                    var titulo = cancion;
                    //$("#tituloCancion").text(titulo);
                    $("#tituloCancion").html("");
                    $("#tituloCancion").append("<p id='textoTitulo'>"+titulo+"</p>");
                });
            }
            //funcion para obtener ruta del archivo .mp3 de la cancion y reproducirlo
            function reproducirCancion(id){
                $.getJSON("ArchivoCancion",
                {cancionId:id},
                function(cancion){
                    $("#song").html("");
                    var url = cancion;
                    var new_url = url+".mp3";
                    $("#song").append("<source id='song_file_new' src="+new_url+" type='audio/mpeg'>");
                    $("#song_file_new").attr("src",new_url);
                    document.getElementById("song").load();
                    document.getElementById("song").play();
                    
                });
            }
            
            
            function reproducir(){
                document.getElementById("song").play();
                
            }
            function pausar(){
                document.getElementById("song").pause();
            }
            function parar(){
                document.getElementById("song").pause();
                document.getElementById("song").currentTime = 0;
            }
            
            //function consultaArtista(id){
                //$.getJSON("DetalleArtista",
                //{artistaId:id},
                //function(foto){
                  //  $("#portada").html("");
                   // var rutaImagen = foto;
                    
                    //$("#portada").html("<img src=" + rutaImagen + " alt="+nombre+"/>");
                    //var contenido = "<img src=" + foto + "/>";
                    //$("#portada").append(contenido);
                    //$("#portada").html("<img src="+ foto +"/>");
                //});
            //}
            function consultaArtista(id){
                if(id === 1)
                    $("#portada").html("<img src='imagenes/artistas/eminem.png'/>");
                else if(id === 2)
                    $("#portada").html("<img src='imagenes/artistas/ed_sheeran.png'/>");
                else if(id === 3)
                    $("#portada").html("<img src='imagenes/artistas/lil_wayne.png'/>");
                else if(id === 4)
                    $("#portada").html("<img src='imagenes/artistas/amy.jpg'/>");
            }
            
            
        </script>
    </head>
    <body>
        
        <div id="background"></div>
        <div id="titulo"></div>
        <div id="prueba"></div>
        <div id="status">
        <%
            if(usuario!=null)
                out.println("User: " + usuario.getUsername());
            else
                response.sendRedirect("login.jsp");
                //out.println("<a id='login' href='login.jsp'>Iniciar Sesión</a>");
        %>
        </div>
        <div id="logoutDiv">
            <%
                out.println("<a id='logout' href='logout.jsp'>Logout</a>"); 
            %>
        </div>
        <!--bloque principal-->
        <div id = "principal"></div>
            <div id = "navegacion" class="scroll">
                <ul>
                    <% 
                        for(Artista a: artistas){
                            //out.println("<div class='lista'><a href='javascript:cargarAlbums(" + a.getArtistaId()+")'>" + a.getNombre() + "</a></div>");
                            out.println("<div class='lista'><a href='PleaseEnableJavascript.html' onclick='cargarAlbums("+a.getArtistaId()+");consultaArtista(" + a.getArtistaId() +"); return false;'>" + a.getNombre() + "</a></div>");
                        }
                    %>
                </ul>
            </div>
            <div id = "contenido" class="scroll">
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
            
            <div id="divTituloCancion">
                <marquee direction="left" id="tituloCancion" scrollamount="15"></marquee>
            </div>
            
            <div id = "playback">
                
                <div id="pause_div" onclick="pausar()"><img id="pause" src="imagenes/pause.png" alt="pause"/></div>
                <div id="play_div" onclick="reproducir()"><img id="play" src="imagenes/play.png" alt="play"/></div>
                <div id="stop_div" onclick="parar()"><img id="stop" src="imagenes/stop.png" alt="stop"/></div>
                
            </div>
            <div id="footer"><p id="frase"><b>"</b>One good thing about music, when it hits you, you feel no pain.<b>"</b></p></div>
            
            <audio id="song">
             <source id="song_file" src="" type="audio/mpeg">
                    Your browser does not support the <code>audio</code> tag.
            </audio>
            <div id="audio"></div>
    </body>
</html>
