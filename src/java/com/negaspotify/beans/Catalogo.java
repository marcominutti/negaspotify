/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.negaspotify.beans;

import com.negaspotify.beans.utilerias.Serializador;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.parser.mp3.Mp3Parser;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author minutti
 */
public class Catalogo implements Serializable{
    public static final long serialVersionUID = 0001L;
    @Id
    @GeneratedValue (strategy=GenerationType.AUTO)
    private int catalogoId;
    
    private transient ArrayList <Artista> artistas;
    
    public Catalogo(){
        artistas = new ArrayList();
    }

    /**
     * @return the artistas
     */
    public ArrayList <Artista> getArtistas() {
        return artistas;
    }

    /**
     * @param artistas the artistas to set
     */
    public void setArtistas(ArrayList <Artista> artistas) {
        this.artistas = artistas;
    }
    
    public static void main (String[] args) throws IOException, SAXException, TikaException{
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        
        Catalogo catalogo = new Catalogo();//Crear catálogo
        
        //         Artistas
        
        //Artista Eminem
        Artista eminem = new Artista();
        eminem.setNombre("Eminem");
        eminem.setEsBanda(false);
        eminem.setNacionalidad("Estadounidense");
        eminem.setGenero("Hip Hop");
        eminem.setNombre("Marshall Bruce Mathers III");
        session.save(eminem);
        
        //Artista Ed Sheeran
        Artista edSheeran = new Artista();
        edSheeran.setNombre("Ed Sheeran");
        edSheeran.setEsBanda(false);
        edSheeran.setNacionalidad("Britanico");
        edSheeran.setNombre("Edward Christopher Sheeran");
        edSheeran.setGenero("indie");
        session.save(edSheeran);
        
        //Artista Lil Wayne
        Artista lilWayne = new Artista();
        lilWayne.setNombre("Lil Wayne");
        lilWayne.setEsBanda(false);
        lilWayne.setGenero("Hip Hop");
        lilWayne.setNacionalidad("Estadounidense");
        lilWayne.setNombre("Dwayne Michael Carter");
        session.save(lilWayne);
        
        //Artista Amy Winehouse
        Artista amyWinehouse = new Artista();
        amyWinehouse.setNombre("Amy Winehouse");//
        amyWinehouse.setEsBanda(false);
        amyWinehouse.setGenero("Jazz, R&B, Soul");
        amyWinehouse.setNacionalidad("Britanica");
        amyWinehouse.setNombre("Amy Jade Winehouse");
        session.save(amyWinehouse);
        
        //       Álbumes de Eminem 
        Album encore = new Album();
        encore.setNombre("Encore Deluxe Edition");
        encore.setArtista(eminem);
        encore.setCantidadCanciones(20);
        encore.setDisquera("Math Records");
        encore.setArtistaId(eminem.getArtistaId());
        session.save(encore);
        
        Album theEminemShow = new Album();
        theEminemShow.setNombre("The Eminem Show");
        theEminemShow.setArtista(eminem);
        theEminemShow.setCantidadCanciones(20);
        theEminemShow.setDisquera("After Math");
        theEminemShow.setArtistaId(eminem.getArtistaId());
        session.save(theEminemShow);

        Album curtainCall =  new Album();
        curtainCall.setNombre("Curtain Call");
        curtainCall.setArtista(eminem);
        curtainCall.setCantidadCanciones(17);
        curtainCall.setDisquera("Shady/ Aftermath/ Interscope");
        curtainCall.setArtistaId(eminem.getArtistaId());
        session.save(curtainCall);

        Album theMarshallMathers = new Album();
        theMarshallMathers.setNombre("The Marshall Mathers");//
        theMarshallMathers.setArtista(eminem);
        theMarshallMathers.setCantidadCanciones(19);
        theMarshallMathers.setDisquera("Aftermath");
        theMarshallMathers.setArtistaId(eminem.getArtistaId());
        session.save(theMarshallMathers);
        
        //    Álbumes de Ed Sheeran
        Album xDeluxeEdition = new Album();
        xDeluxeEdition.setNombre("X Deluxe Edition");
        xDeluxeEdition.setArtista(edSheeran);
        xDeluxeEdition.setCantidadCanciones(16);
        xDeluxeEdition.setDisquera("Asylum records");
        xDeluxeEdition.setArtistaId(edSheeran.getArtistaId());
        session.save(xDeluxeEdition);
        
        Album plusDeluxeEdition = new Album();
        plusDeluxeEdition.setNombre("+ Deluxe Edition");
        plusDeluxeEdition.setArtista(edSheeran);
        plusDeluxeEdition.setCantidadCanciones(16);
        plusDeluxeEdition.setDisquera("Warner Music");
        plusDeluxeEdition.setArtistaId(edSheeran.getArtistaId());
        session.save(plusDeluxeEdition);

        Album cinco =  new Album();
        cinco.setNombre("5");//
        cinco.setArtista(edSheeran);
        cinco.setCantidadCanciones(32);
        cinco.setDisquera("Warner Music");
        cinco.setArtistaId(edSheeran.getArtistaId());
        session.save(cinco);
        
        //    Álbumes de Lil Wayne
        Album theCarterVI = new Album();
        theCarterVI.setNombre("The Carter VI");
        theCarterVI.setArtista(lilWayne);
        theCarterVI.setCantidadCanciones(19);
        theCarterVI.setDisquera("Cash Money Records");
        theCarterVI.setArtistaId(lilWayne.getArtistaId());
        session.save(theCarterVI);
        
        Album theCarterII = new Album();
        theCarterII.setNombre("+ The Carter II");
        theCarterII.setArtista(lilWayne);
        theCarterII.setCantidadCanciones(22);
        theCarterII.setDisquera("Cash Money Records");
        theCarterII.setArtistaId(lilWayne.getArtistaId());
        session.save(theCarterII);

        Album theCarterIII =  new Album();
        theCarterIII.setNombre("The Carter III");
        theCarterIII.setArtista(lilWayne);
        theCarterIII.setCantidadCanciones(16);
        theCarterIII.setDisquera("Cash Money Records");
        theCarterIII.setArtistaId(lilWayne.getArtistaId());
        session.save(theCarterIII);//
        
        //Canciones del Album: Encore - Eminem
        Cancion evilDeeds = new Cancion();
        evilDeeds.setTitulo("Evil Deeds");
        encore.getCanciones().add(evilDeeds);
        
        
        
        Cancion neverEnough = new Cancion();
        neverEnough.setTitulo("Never Enough");
        encore.getCanciones().add(neverEnough);
        
        Cancion yellowBrickRoad = new Cancion();
        yellowBrickRoad.setTitulo("Yellow Brick Road");
        
        Cancion likeToySoldiers = new Cancion();
        yellowBrickRoad.setTitulo("Like Toy Soldiers");
        
        Cancion mosh = new Cancion();
        yellowBrickRoad.setTitulo("Mosh");
        
        Cancion puke = new Cancion();
        yellowBrickRoad.setTitulo("Puke");
        
        Cancion my1stSingle = new Cancion();
        yellowBrickRoad.setTitulo("My 1st Single");
        
        Cancion paul = new Cancion();
        yellowBrickRoad.setTitulo("Paul");
        //Fin canciones Encore - Eminem
        
        
        //Agregar artistas al catalogo
        catalogo.getArtistas().add(eminem);
        catalogo.getArtistas().add(lilWayne);
        catalogo.getArtistas().add(edSheeran);
        catalogo.getArtistas().add(amyWinehouse);
        
        
        
        
        //Agregar albumes
        eminem.getAlbums().add(theEminemShow);
        edSheeran.getAlbums().add(xDeluxeEdition);
                
        /*Leer carpeta y leer archivos y obtener metadatos
         int contador = 0;//variable para conocer el número de canciones que se imprimieron correctamente
         String carpeta = "/Users/minutti/Music";//Carpeta de música
         //String name = "/Users/minutti/Desktop/between.mp3";ruta de mp3 de prueba
    
         File directorio = new File(carpeta);
         File[] archivos = directorio.listFiles();

         if(directorio.exists()){
         while(contador<10){//poner un límite de canciones a recorrer
         for (File archivo : archivos) {
         try{
         if(!archivo.isDirectory()){//si el archivo no es directorio entonces se procede
         InputStream input = new FileInputStream(new File(archivo.getPath()));
         ContentHandler handler = new DefaultHandler();
         Metadata metadata = new Metadata();
         Parser parser = new Mp3Parser();
         ParseContext parseCtx = new ParseContext();
         parser.parse(input, handler, metadata, parseCtx);
         input.close();
         if(metadata.get("title")!=null){//Si el título es diferente de null entonces se imprime
         System.out.println("Título: " + metadata.get("title"));
         contador++;
         }
         }

         }catch(FileNotFoundException e){
         }
         }
         }
         System.out.println(contador);
         }
         else{
         //si no existe esa carpeta se imprime el mensaje
         System.out.println("No existe");
         }*/
        
        //Serializar guardar archivo
        Serializador.serialize(catalogo, new File ("/Users/minutti/Desktop/Catalogo_transient.negspot"));
        session.getTransaction().commit();
        session.close();
        //prueba de imprimir el id del album a traves de la cancion
        System.out.println(evilDeeds.getAlbumId());
    }//Cierre de main
    /**
     * @return the catalogoId
     */
    public int getCatalogoId() {
        return catalogoId;
    }
    /**
     * @param catalogoId the catalogoId to set
     */
    public void setCatalogoId(int catalogoId) {
        this.catalogoId = catalogoId;
    }
}//Cierre de clase