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
import java.util.Date;
import java.util.List;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.parser.mp3.Mp3Parser;
import org.hibernate.Query;
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
    
    public static void main (String[] args) throws IOException, SAXException, TikaException{
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Catalogo catalogo = new Catalogo();//Crear catálogo
        
    //___________ARTISTAS__________\\
        
        //Eminem\\
        Artista eminem = new Artista();
        eminem.setNombre("Eminem");
        eminem.setEsBanda(false);
        eminem.setNacionalidad("Estadounidense");
        eminem.setGenero("Hip Hop");
        //eminem.setNombre("Marshall Bruce Mathers III");
        eminem.setFoto("imagenes/artistas/eminem.png");
        session.save(eminem);
        
        //Ed Sheeran\\
        Artista edSheeran = new Artista();
        edSheeran.setNombre("Ed Sheeran");
        edSheeran.setEsBanda(false);
        edSheeran.setNacionalidad("Britanico");
        //edSheeran.setNombre("Edward Christopher Sheeran");
        edSheeran.setFoto("imagenes/artistas/ed_sheeran.png");
        edSheeran.setGenero("indie");
        session.save(edSheeran);
        
        //Lil Wayne\\
        Artista lilWayne = new Artista();
        lilWayne.setNombre("Lil Wayne");
        lilWayne.setEsBanda(false);
        lilWayne.setGenero("Hip Hop");
        lilWayne.setNacionalidad("Estadounidense");
        //lilWayne.setNombre("Dwayne Michael Carter");
        lilWayne.setFoto("imagenes/artistas/lil_wayne.png");
        session.save(lilWayne);
        
        // Artista Amy Winehouse \\
        Artista amyWinehouse = new Artista();
        amyWinehouse.setNombre("Amy Winehouse");//
        amyWinehouse.setEsBanda(false);
        amyWinehouse.setGenero("Jazz, R&B, Soul");
        amyWinehouse.setNacionalidad("Britanica");
        //amyWinehouse.setNombre("Amy Jade Winehouse");
        amyWinehouse.setFoto("imagenes/artistas/amy.jpg");
        session.save(amyWinehouse);
        
        //___________ÁLBUMES____________\\
        
        // Eminem \\
        Album encore = new Album();
        encore.setNombre("Encore Deluxe Edition");
        encore.setArtista(eminem);
        encore.setCantidadCanciones(20);
        encore.setDisquera("Math Records");
        encore.setArtistaId(eminem.getArtistaId());
        encore.setAnio(2004);
        encore.setPortada("imagenes/portadas/+.jpg");
        session.save(encore);
        
        Album theEminemShow = new Album();
        theEminemShow.setNombre("The Eminem Show");
        theEminemShow.setArtista(eminem);
        theEminemShow.setCantidadCanciones(20);
        theEminemShow.setDisquera("After Math");
        theEminemShow.setArtistaId(eminem.getArtistaId());
        theEminemShow.setAnio(2002);
        session.save(theEminemShow);

        Album curtainCall =  new Album();
        curtainCall.setNombre("Curtain Call");
        curtainCall.setArtista(eminem);
        curtainCall.setCantidadCanciones(9);
        curtainCall.setDisquera("Shady/ Aftermath/ Interscope");
        curtainCall.setArtistaId(eminem.getArtistaId());
        curtainCall.setAnio(2005);
        session.save(curtainCall);
        
        //  Ed Sheeran  \\
        Album xDeluxeEdition = new Album();
        xDeluxeEdition.setNombre("X Deluxe Edition");
        xDeluxeEdition.setArtista(edSheeran);
        xDeluxeEdition.setCantidadCanciones(16);
        xDeluxeEdition.setDisquera("Asylum records");
        xDeluxeEdition.setArtistaId(edSheeran.getArtistaId());
        xDeluxeEdition.setAnio(2014);
        session.save(xDeluxeEdition);
        
        Album plusDeluxeEdition = new Album();
        plusDeluxeEdition.setNombre("+ Deluxe Edition");
        plusDeluxeEdition.setArtista(edSheeran);
        plusDeluxeEdition.setCantidadCanciones(16);
        plusDeluxeEdition.setDisquera("Warner Music");
        plusDeluxeEdition.setArtistaId(edSheeran.getArtistaId());
        plusDeluxeEdition.setAnio(2011);
        session.save(plusDeluxeEdition);

        Album cinco =  new Album();
        cinco.setNombre("5");//
        cinco.setArtista(edSheeran);
        cinco.setCantidadCanciones(32);
        cinco.setDisquera("Warner Music");
        cinco.setArtistaId(edSheeran.getArtistaId());
        cinco.setAnio(2014);
        session.save(cinco);
        
        //    Lil Wayne   \\
        Album theCarterVI = new Album();
        theCarterVI.setNombre("The Carter VI");
        theCarterVI.setArtista(lilWayne);
        theCarterVI.setCantidadCanciones(19);
        theCarterVI.setDisquera("Cash Money Records");
        theCarterVI.setArtistaId(lilWayne.getArtistaId());
        theCarterVI.setAnio(2011);
        session.save(theCarterVI);
        
        Album theCarterII = new Album();
        theCarterII.setNombre("The Carter II");
        theCarterII.setArtista(lilWayne);
        theCarterII.setCantidadCanciones(22);
        theCarterII.setDisquera("Cash Money Records");
        theCarterII.setArtistaId(lilWayne.getArtistaId());
        theCarterII.setAnio(2005);
        session.save(theCarterII);

        Album theCarterIII =  new Album();
        theCarterIII.setNombre("The Carter III");
        theCarterIII.setArtista(lilWayne);
        theCarterIII.setCantidadCanciones(16);
        theCarterIII.setDisquera("Cash Money Records");
        theCarterIII.setArtistaId(lilWayne.getArtistaId());
        theCarterIII.setAnio(2005);
        session.save(theCarterIII);//
        
        //   Amy Winehouse   \\
        Album lionessHiddenTreasures =  new Album();
        lionessHiddenTreasures.setNombre("Lioness: Hidden Treasures");
        lionessHiddenTreasures.setArtista(amyWinehouse);
        lionessHiddenTreasures.setCantidadCanciones(5);
        lionessHiddenTreasures.setDisquera("Universal Island Records");
        lionessHiddenTreasures.setArtistaId(amyWinehouse.getArtistaId());
        lionessHiddenTreasures.setAnio(2011);
        session.save(lionessHiddenTreasures);//
        
        Album backToBlack =  new Album();
        backToBlack.setNombre("Back To Black");
        backToBlack.setArtista(amyWinehouse);
        backToBlack.setCantidadCanciones(11);
        backToBlack.setDisquera("Universal Island Records");
        backToBlack.setArtistaId(amyWinehouse.getArtistaId());
        backToBlack.setAnio(2006);
        session.save(backToBlack);//
        
        Album frank =  new Album();
        frank.setNombre("Frank");
        frank.setArtista(amyWinehouse);
        frank.setCantidadCanciones(15);
        frank.setDisquera("Universal Island Records");
        frank.setArtistaId(amyWinehouse.getArtistaId());
        frank.setAnio(2015);
        session.save(frank);//
        
        
        
        /////////FIN DE ALBUMS\\\\\\\\\\\
        
        //_______CANCIONES________\\
        
        //Canciones del Album: Encore - Eminem \\
        //01
        Cancion introEncore = new Cancion();
        introEncore.setTitulo("Intro Encore");
        encore.getCanciones().add(introEncore);
        introEncore.setDuracion(46);
        introEncore.setGenero("Hip Hop");
        introEncore.setAlbumId(encore.getAlbumId());
        introEncore.setAnio(encore.getAnio());
        introEncore.setUrl("Artistas/Eminem/cancion1.mp3");
        session.save(introEncore);
        //02
        Cancion evilDeeds = new Cancion();
        evilDeeds.setTitulo("Evil Deeds");
        encore.getCanciones().add(evilDeeds);
        evilDeeds.setDuracion(259);
        evilDeeds.setGenero("Hip Hop");
        evilDeeds.setAlbumId(encore.getAlbumId());
        evilDeeds.setAnio(encore.getAnio());
        evilDeeds.setUrl("Artistas/Eminem/cancion2.mp3");
        session.save(evilDeeds);
        //03
        Cancion neverEnough = new Cancion();
        neverEnough.setTitulo("Never Enough");
        encore.getCanciones().add(neverEnough);
        neverEnough.setGenero("Hip Hop");
        neverEnough.setAlbumId(encore.getAlbumId());
        neverEnough.setAnio(encore.getAnio());
        neverEnough.setUrl("Artistas/Eminem/cancion3.mp3");
        session.save(neverEnough);
        //04
        Cancion yellowBrickRoad = new Cancion();
        yellowBrickRoad.setTitulo("Yellow Brick Road");
        yellowBrickRoad.setAlbumId(encore.getAlbumId());
        yellowBrickRoad.setAnio(encore.getAnio());
        yellowBrickRoad.setGenero("Hip Hop");
        yellowBrickRoad.setUrl("Artistas/Eminem/cancion4.mp3");
        session.save(yellowBrickRoad);
        //05
        Cancion likeToySoldiers = new Cancion();
        likeToySoldiers.setTitulo("Like Toy Soldiers");
        likeToySoldiers.setAlbumId(encore.getAlbumId());
        likeToySoldiers.setAnio(encore.getAnio());
        likeToySoldiers.setGenero("Hip Hop");
        likeToySoldiers.setUrl("Artistas/Eminem/cancion5.mp3");
        session.save(likeToySoldiers);
        //06
        Cancion mosh = new Cancion();
        mosh.setTitulo("Mosh");
        mosh.setAlbumId(encore.getAlbumId());
        mosh.setAnio(encore.getAnio());
        mosh.setGenero("Hip Hop");
        mosh.setUrl("Artistas/Eminem/cancion6.mp3");
        session.save(mosh);
        //07
        Cancion puke = new Cancion();
        puke.setTitulo("Puke");
        puke.setAlbumId(encore.getAlbumId());
        puke.setAnio(encore.getAnio());
        puke.setGenero("Hip Hop");
        puke.setUrl("Artistas/Eminem/cancion7.mp3");
        session.save(puke);
        //08
        Cancion my1stSingle = new Cancion();
        my1stSingle.setTitulo("My 1st Single");
        my1stSingle.setAlbumId(encore.getAlbumId());
        my1stSingle.setAnio(encore.getAnio());
        my1stSingle.setGenero("Hip Hop");
        my1stSingle.setUrl("Artistas/Eminem/cancion8.mp3");
        session.save(my1stSingle);
        //09
        Cancion paul = new Cancion();
        paul.setTitulo("Paul");
        paul.setAlbumId(encore.getAlbumId());
        paul.setAnio(encore.getAnio());
        paul.setGenero("Hip Hop");
        paul.setUrl("Artistas/Eminem/cancion9.mp3");
        session.save(paul);
        //10
        Cancion rainMan = new Cancion();
        rainMan.setTitulo("Rain Man");
        rainMan.setAlbumId(encore.getAlbumId());
        rainMan.setAnio(encore.getAnio());
        rainMan.setGenero("Hip Hop");
        rainMan.setUrl("Artistas/Eminem/cancion10.mp3");
        session.save(rainMan);
        //11
        Cancion bigWeenie = new Cancion();
        bigWeenie.setTitulo("Big Weenie");
        bigWeenie.setAlbumId(encore.getAlbumId());
        bigWeenie.setAnio(encore.getAnio());
        bigWeenie.setGenero("Hip Hop");
        bigWeenie.setUrl("Artistas/Eminem/cancion11.mp3");
        session.save(bigWeenie);
        //12
        Cancion emCallsPaul = new Cancion();
        emCallsPaul.setTitulo("Em Call Paul");
        emCallsPaul.setAlbumId(encore.getAlbumId());
        emCallsPaul.setAnio(encore.getAnio());
        emCallsPaul.setGenero("Hip Hop");
        emCallsPaul.setUrl("Artistas/Eminem/cancion12.mp3");
        session.save(emCallsPaul);
        //13
        Cancion justLoseIt = new Cancion();
        justLoseIt.setTitulo("Just Lose It");
        justLoseIt.setAlbumId(encore.getAlbumId());
        justLoseIt.setAnio(encore.getAnio());
        justLoseIt.setGenero("Hip Hop");
        justLoseIt.setUrl("Artistas/Eminem/cancion13.mp3");
        session.save(justLoseIt);
        //14
        Cancion assLikeThat = new Cancion();
        assLikeThat.setTitulo("Ass Like That");
        assLikeThat.setAlbumId(encore.getAlbumId());
        assLikeThat.setAnio(encore.getAnio());
        assLikeThat.setGenero("Hip Hop");
        assLikeThat.setUrl("Artistas/Eminem/cancion14.mp3");
        session.save(assLikeThat);
        //15
        Cancion spendSomeTime = new Cancion();
        spendSomeTime.setTitulo("Spend Some Time");
        spendSomeTime.setAlbumId(encore.getAlbumId());
        spendSomeTime.setAnio(encore.getAnio());
        spendSomeTime.setGenero("Hip Hop");
        spendSomeTime.setUrl("Artistas/Eminem/cancion15.mp3");
        session.save(spendSomeTime);
        //16
        Cancion mockingbird = new Cancion();
        mockingbird.setTitulo("Mockingbird");
        mockingbird.setAlbumId(encore.getAlbumId());
        mockingbird.setAnio(encore.getAnio());
        mockingbird.setGenero("Hip Hop");
        mockingbird.setUrl("Artistas/Eminem/cancion16.mp3");
        session.save(mockingbird);
        //17
        Cancion crazyInLove = new Cancion();
        crazyInLove.setTitulo("Crazy In Love");
        crazyInLove.setAlbumId(encore.getAlbumId());
        crazyInLove.setAnio(encore.getAnio());
        crazyInLove.setGenero("Hip Hop");
        crazyInLove.setUrl("Artistas/Eminem/cancion17.mp3");
        session.save(crazyInLove);
        //18
        Cancion oneShot2Shot = new Cancion();
        oneShot2Shot.setTitulo("One Shot 2 Shot");
        oneShot2Shot.setAlbumId(encore.getAlbumId());
        oneShot2Shot.setAnio(encore.getAnio());
        oneShot2Shot.setGenero("Hip Hop");
        oneShot2Shot.setUrl("Artistas/Eminem/cancion18.mp3");
        session.save(oneShot2Shot);
        //19
        Cancion finalThought = new Cancion();
        finalThought.setTitulo("Final Thought");
        finalThought.setAlbumId(encore.getAlbumId());
        finalThought.setAnio(encore.getAnio());
        finalThought.setGenero("Hip Hop");
        finalThought.setUrl("Artistas/Eminem/cancion19.mp3");
        session.save(finalThought);
        //20
        Cancion curtainsDown = new Cancion();
        curtainsDown.setTitulo("Encore / Curtains Down");
        curtainsDown.setAlbumId(encore.getAlbumId());
        curtainsDown.setAnio(encore.getAnio());
        curtainsDown.setGenero("Hip Hop");
        curtainsDown.setUrl("Artistas/Eminem/cancion20.mp3");
        session.save(curtainsDown);
        // Fin canciones Encore - Eminem \\
        
        // Canciones The Eminem Show \\
        //01
        Cancion curtainsUp = new Cancion();
        curtainsUp.setTitulo("Curtains Up Intro");
        theEminemShow.getCanciones().add(curtainsUp);
        curtainsUp.setDuracion(46);
        curtainsUp.setGenero("Hip Hop");
        curtainsUp.setAlbumId(theEminemShow.getAlbumId());
        curtainsUp.setAnio(theEminemShow.getAnio());
        curtainsUp.setUrl("Artistas/Eminem/cancion21.mp3");
        session.save(curtainsUp);
        //02
        Cancion whiteAmerica = new Cancion();
        whiteAmerica.setTitulo("White America");
        theEminemShow.getCanciones().add(whiteAmerica);
        whiteAmerica.setDuracion(46);
        whiteAmerica.setGenero("Hip Hop");
        whiteAmerica.setAlbumId(theEminemShow.getAlbumId());
        whiteAmerica.setAnio(theEminemShow.getAnio());
        whiteAmerica.setUrl("Artistas/Eminem/cancion22.mp3");
        session.save(whiteAmerica);
        //03
        Cancion business = new Cancion();
        business.setTitulo("Business");
        theEminemShow.getCanciones().add(business);
        business.setDuracion(46);
        business.setGenero("Hip Hop");
        business.setAlbumId(theEminemShow.getAlbumId());
        business.setAnio(theEminemShow.getAnio());
        business.setUrl("Artistas/Eminem/cancion23.mp3");
        session.save(business);
        //04
        Cancion cleaningOutMyCloset = new Cancion();
        cleaningOutMyCloset.setTitulo("Cleanin' Out My Closet");
        theEminemShow.getCanciones().add(cleaningOutMyCloset);
        cleaningOutMyCloset.setDuracion(46);
        cleaningOutMyCloset.setGenero("Hip Hop");
        cleaningOutMyCloset.setAlbumId(theEminemShow.getAlbumId());
        cleaningOutMyCloset.setAnio(theEminemShow.getAnio());
        cleaningOutMyCloset.setUrl("Artistas/Eminem/cancion24.mp3");
        session.save(cleaningOutMyCloset);
        //05
        Cancion squareDance = new Cancion();
        squareDance.setTitulo("Square Dance");
        theEminemShow.getCanciones().add(squareDance);
        squareDance.setDuracion(46);
        squareDance.setGenero("Hip Hop");
        squareDance.setAlbumId(theEminemShow.getAlbumId());
        squareDance.setAnio(theEminemShow.getAnio());
        squareDance.setUrl("Artistas/Eminem/cancion24.mp3");
        session.save(squareDance);
        //06
        Cancion theKiss = new Cancion();
        theKiss.setTitulo("The Kiss");
        theEminemShow.getCanciones().add(theKiss);
        theKiss.setDuracion(46);
        theKiss.setGenero("Hip Hop");
        theKiss.setAlbumId(theEminemShow.getAlbumId());
        theKiss.setAnio(theEminemShow.getAnio());
        theKiss.setUrl("Artistas/Eminem/cancion25.mp3");
        session.save(theKiss);
        //07
        Cancion soldier = new Cancion();
        soldier.setTitulo("Soldier");
        theEminemShow.getCanciones().add(soldier);
        soldier.setDuracion(46);
        soldier.setGenero("Hip Hop");
        soldier.setAlbumId(theEminemShow.getAlbumId());
        soldier.setAnio(theEminemShow.getAnio());
        soldier.setUrl("Artistas/Eminem/cancion26.mp3");
        session.save(soldier);
        //08
        Cancion sayGoodbyeHollywood = new Cancion();
        sayGoodbyeHollywood.setTitulo("Say Goodbye Hollywood");
        theEminemShow.getCanciones().add(sayGoodbyeHollywood);
        sayGoodbyeHollywood.setDuracion(46);
        sayGoodbyeHollywood.setGenero("Hip Hop");
        sayGoodbyeHollywood.setAlbumId(theEminemShow.getAlbumId());
        sayGoodbyeHollywood.setAnio(theEminemShow.getAnio());
        sayGoodbyeHollywood.setUrl("Artistas/Eminem/cancion27.mp3");
        session.save(sayGoodbyeHollywood);
        //09
        Cancion drips = new Cancion();
        drips.setTitulo("drips");
        theEminemShow.getCanciones().add(drips);
        drips.setDuracion(46);
        drips.setGenero("Hip Hop");
        drips.setAlbumId(theEminemShow.getAlbumId());
        drips.setAnio(theEminemShow.getAnio());
        drips.setUrl("Artistas/Eminem/cancion28.mp3");
        session.save(drips);
        //10
        Cancion withoutMe = new Cancion();
        withoutMe.setTitulo("Without Me");
        theEminemShow.getCanciones().add(withoutMe);
        withoutMe.setDuracion(46);
        withoutMe.setGenero("Hip Hop");
        withoutMe.setAlbumId(theEminemShow.getAlbumId());
        withoutMe.setAnio(theEminemShow.getAnio());
        withoutMe.setUrl("Artistas/Eminem/cancion29.mp3");
        session.save(withoutMe);
        //11
        Cancion paulRosenberg = new Cancion();
        paulRosenberg.setTitulo("Paul Rosenberg");
        theEminemShow.getCanciones().add(paulRosenberg);
        paulRosenberg.setDuracion(46);
        paulRosenberg.setGenero("Hip Hop");
        paulRosenberg.setAlbumId(theEminemShow.getAlbumId());
        paulRosenberg.setAnio(theEminemShow.getAnio());
        paulRosenberg.setUrl("Artistas/Eminem/cancion30.mp3");
        session.save(paulRosenberg);
        //12
        Cancion singForTheMoment = new Cancion();
        singForTheMoment.setTitulo("Sing For The Moment");
        theEminemShow.getCanciones().add(singForTheMoment);
        singForTheMoment.setDuracion(339);
        singForTheMoment.setGenero("Hip Hop");
        singForTheMoment.setAlbumId(theEminemShow.getAlbumId());
        singForTheMoment.setAnio(theEminemShow.getAnio());
        singForTheMoment.setUrl("Artistas/Eminem/cancion31");
        session.save(singForTheMoment);
        //13
        Cancion superman = new Cancion();
        superman.setTitulo("Superman");
        theEminemShow.getCanciones().add(superman);
        superman.setDuracion(350);
        superman.setGenero("Hip Hop");
        superman.setAlbumId(theEminemShow.getAlbumId());
        superman.setAnio(theEminemShow.getAnio());
        superman.setUrl("Artistas/Eminem/cancion32");
        session.save(superman);
        //14
        Cancion hellieSong = new Cancion();
        hellieSong.setTitulo("Hellie's Song");
        theEminemShow.getCanciones().add(hellieSong);
        hellieSong.setDuracion(320);
        hellieSong.setGenero("Hip Hop");
        hellieSong.setAlbumId(theEminemShow.getAlbumId());
        hellieSong.setAnio(theEminemShow.getAnio());
        hellieSong.setUrl("Artistas/Eminem/cancion33");
        session.save(hellieSong);
        //15
        Cancion steveBerman = new Cancion();
        steveBerman.setTitulo("Steve Berman");
        theEminemShow.getCanciones().add(steveBerman);
        steveBerman.setDuracion(33);
        steveBerman.setGenero("Hip Hop");
        steveBerman.setAlbumId(theEminemShow.getAlbumId());
        steveBerman.setAnio(theEminemShow.getAnio());
        steveBerman.setUrl("Artistas/Eminem/cancion34");
        session.save(steveBerman);
        //16
        Cancion whenTheMusicStops = new Cancion();
        whenTheMusicStops.setTitulo("When The Music Stops");
        theEminemShow.getCanciones().add(whenTheMusicStops);
        whenTheMusicStops.setDuracion(268);
        whenTheMusicStops.setGenero("Hip Hop");
        whenTheMusicStops.setAlbumId(theEminemShow.getAlbumId());
        whenTheMusicStops.setAnio(theEminemShow.getAnio());
        whenTheMusicStops.setUrl("Artistas/Eminem/cancion35");
        session.save(whenTheMusicStops);
        //17
        Cancion sayWhatYouSay = new Cancion();
        sayWhatYouSay.setTitulo("Say What You Say");
        theEminemShow.getCanciones().add(sayWhatYouSay);
        sayWhatYouSay.setDuracion(309);
        sayWhatYouSay.setGenero("Hip Hop");
        sayWhatYouSay.setAlbumId(theEminemShow.getAlbumId());
        sayWhatYouSay.setAnio(theEminemShow.getAnio());
        sayWhatYouSay.setUrl("Artistas/Eminem/cancion36");
        session.save(sayWhatYouSay);
        //18
        Cancion tillIcollapse = new Cancion();
        tillIcollapse.setTitulo("'Till I Collapse");
        theEminemShow.getCanciones().add(tillIcollapse);
        tillIcollapse.setDuracion(337);
        tillIcollapse.setGenero("Hip Hop");
        tillIcollapse.setAlbumId(theEminemShow.getAlbumId());
        tillIcollapse.setAnio(theEminemShow.getAnio());
        tillIcollapse.setUrl("Artistas/Eminem/cancion37");
        session.save(tillIcollapse);
        //19
        Cancion myDadsGoneCrazy = new Cancion();
        myDadsGoneCrazy.setTitulo("My Dad's Gone Crazy");
        theEminemShow.getCanciones().add(myDadsGoneCrazy);
        myDadsGoneCrazy.setDuracion(306);
        myDadsGoneCrazy.setGenero("Hip Hop");
        myDadsGoneCrazy.setAlbumId(theEminemShow.getAlbumId());
        myDadsGoneCrazy.setAnio(theEminemShow.getAnio());
        myDadsGoneCrazy.setUrl("Artistas/Eminem/cancion38");
        session.save(myDadsGoneCrazy);
        //20
        Cancion curtainsClose = new Cancion();
        curtainsClose.setTitulo("Curtains Close");
        theEminemShow.getCanciones().add(curtainsClose);
        curtainsClose.setDuracion(60);
        curtainsClose.setGenero("Hip Hop");
        curtainsClose.setAlbumId(theEminemShow.getAlbumId());
        curtainsClose.setAnio(theEminemShow.getAnio());
        curtainsClose.setUrl("Artistas/Eminem/cancion39");
        session.save(curtainsClose);
        //Fin Canciones The Eminem Show\\
        
        // CANCIONES CURTAIN CALL
             
        //01
        Cancion introCurtainCall = new Cancion();
        introCurtainCall.setTitulo("Intro Curtain Call");
        curtainCall.getCanciones().add(introCurtainCall);
        introCurtainCall.setDuracion(33);
        introCurtainCall.setGenero("Hip Hop");
        introCurtainCall.setAlbumId(curtainCall.getAlbumId());
        introCurtainCall.setAnio(curtainCall.getAnio());
        introCurtainCall.setUrl("Artistas/Eminem/cancion40");
        session.save(introCurtainCall);
        //02   Fack 3:24
        Cancion fack = new Cancion();
        fack.setTitulo("Fack");
        curtainCall.getCanciones().add(fack);
        fack.setDuracion(204);
        fack.setGenero("Hip Hop");
        fack.setAlbumId(curtainCall.getAlbumId());
        fack.setAnio(curtainCall.getAnio());
        fack.setUrl("Artistas/Eminem/cancion41");
        session.save(fack);
        //03
        Cancion theWayIam = new Cancion();
        theWayIam.setTitulo("The Way I am");
        theWayIam.setAlbumId(curtainCall.getAlbumId());
        curtainCall.getCanciones().add(theWayIam);
        theWayIam.setUrl("Artistas/Eminem/cancion42");
        session.save(theWayIam);
        //04
        Cancion myNameIs = new Cancion();
        myNameIs.setTitulo("My Name Is");
        myNameIs.setAlbumId(curtainCall.getAlbumId());
        curtainCall.getCanciones().add(myNameIs);
        myNameIs.setUrl("Artistas/Eminem/cancion43");
        session.save(myNameIs);
        //05
        Cancion stan = new Cancion();
        stan.setTitulo("Stan");
        stan.setAlbumId(curtainCall.getAlbumId());
        curtainCall.getCanciones().add(stan);
        stan.setUrl("Artistas/Eminem/cancion44");
        session.save(stan);
        //06
        Cancion  loseYourself = new Cancion();
        loseYourself.setTitulo("Lose Your Self");
        loseYourself.setAlbumId(curtainCall.getAlbumId());
        curtainCall.getCanciones().add(loseYourself);
        loseYourself.setUrl("Artistas/Eminem/cancion45");
        session.save(loseYourself);
        //07
        Cancion  shakeThat = new Cancion();
        shakeThat.setTitulo("Shake That");
        shakeThat.setAlbumId(curtainCall.getAlbumId());
        curtainCall.getCanciones().add(shakeThat);
        shakeThat.setUrl("Artistas/Eminem/cancion46");
        session.save(shakeThat);
        //08
        Cancion  theRealSlimShady = new Cancion();
        theRealSlimShady.setTitulo("The Real Slim Shady");
        theRealSlimShady.setAlbumId(curtainCall.getAlbumId());
        curtainCall.getCanciones().add(theRealSlimShady);
        theRealSlimShady.setUrl("Artistas/Eminem/cancion47");
        session.save(theRealSlimShady);
        //09
        Cancion  guiltyConscience = new Cancion();
        guiltyConscience.setTitulo("Guilty Conscience");
        guiltyConscience.setAlbumId(curtainCall.getAlbumId());
        curtainCall.getCanciones().add(guiltyConscience);
        guiltyConscience.setUrl("Artistas/Eminem/cancion48");
        session.save(guiltyConscience);
        //09
        Cancion  cleaninOutMyCloset = new Cancion();
        cleaninOutMyCloset.setTitulo("Cleanin' Out My Closet");
        cleaninOutMyCloset.setAlbumId(curtainCall.getAlbumId());
        curtainCall.getCanciones().add(cleaninOutMyCloset);
        cleaninOutMyCloset.setUrl("Artistas/Eminem/cancion49");
        session.save(cleaninOutMyCloset);
        //09
        Cancion  whenImGone = new Cancion();
        whenImGone.setTitulo("When I'm Gone");
        whenImGone.setAlbumId(curtainCall.getAlbumId());
        curtainCall.getCanciones().add(whenImGone);
        whenImGone.setUrl("Artistas/Eminem/cancion50");
        session.save(whenImGone);
      //  FIN CANCIONES CURTAIN CALL DE EMINEM   \\
        
        //Canciones album x Deluxe Edition ed sheeran \\
        //01
        Cancion  one = new Cancion();
        one.setTitulo("One");
        one.setAlbumId(xDeluxeEdition.getAlbumId());
        xDeluxeEdition.getCanciones().add(one);
        one.setUrl("Artistas/Eminem/cancion51");
        session.save(one);
        //02
        Cancion  ImAmess = new Cancion();
        ImAmess.setTitulo("I'm A Mess");
        ImAmess.setAlbumId(xDeluxeEdition.getAlbumId());
        xDeluxeEdition.getCanciones().add(ImAmess);
        ImAmess.setUrl("Artistas/Eminem/cancion52");
        session.save(ImAmess);
        //03
        Cancion  sing = new Cancion();
        sing.setTitulo("Sing");
        sing.setAlbumId(xDeluxeEdition.getAlbumId());
        xDeluxeEdition.getCanciones().add(sing);
        sing.setUrl("Artistas/Eminem/cancion53");
        session.save(sing);
        //04
        Cancion  dont = new Cancion();
        dont.setTitulo("Sing");
        dont.setAlbumId(xDeluxeEdition.getAlbumId());
        xDeluxeEdition.getCanciones().add(dont);
        dont.setUrl("Artistas/Eminem/cancion54");
        session.save(dont);
        //05
        Cancion  nina = new Cancion();
        nina.setTitulo("Nina");
        nina.setAlbumId(xDeluxeEdition.getAlbumId());
        xDeluxeEdition.getCanciones().add(nina);
        nina.setUrl("Artistas/Eminem/cancion55");
        session.save(nina);
        //06
        Cancion  photograph = new Cancion();
        photograph.setTitulo("Photograph");
        photograph.setAlbumId(xDeluxeEdition.getAlbumId());
        xDeluxeEdition.getCanciones().add(photograph);
        photograph.setUrl("Artistas/Eminem/cancion56");
        session.save(photograph);
        //07
        Cancion  bloodstream = new Cancion();
        bloodstream.setTitulo("Bloodstream");
        bloodstream.setAlbumId(xDeluxeEdition.getAlbumId());
        xDeluxeEdition.getCanciones().add(bloodstream);
        bloodstream.setUrl("Artistas/Eminem/cancion57");
        session.save(bloodstream);
        //08
        Cancion  tenerifeSea = new Cancion();
        tenerifeSea.setTitulo("Tenerife Sea");
        tenerifeSea.setAlbumId(xDeluxeEdition.getAlbumId());
        xDeluxeEdition.getCanciones().add(tenerifeSea);
        tenerifeSea.setUrl("Artistas/Eminem/cancion58");
        session.save(tenerifeSea);
        //09
        Cancion  runaway = new Cancion();
        runaway.setTitulo("Runaway");
        runaway.setAlbumId(xDeluxeEdition.getAlbumId());
        xDeluxeEdition.getCanciones().add(runaway);
        runaway.setUrl("Artistas/Eminem/cancion59");
        session.save(runaway);
        //10
        Cancion  theMan = new Cancion();
        theMan.setTitulo("The Man");
        theMan.setAlbumId(xDeluxeEdition.getAlbumId());
        xDeluxeEdition.getCanciones().add(theMan);
        theMan.setUrl("Artistas/Eminem/cancion60");
        session.save(theMan);
        //11
        Cancion  thinkingOutLoud = new Cancion();
        thinkingOutLoud.setTitulo("Thinking Out Loud");
        thinkingOutLoud.setAlbumId(xDeluxeEdition.getAlbumId());
        xDeluxeEdition.getCanciones().add(thinkingOutLoud);
        thinkingOutLoud.setUrl("Artistas/Eminem/cancion61");
        session.save(thinkingOutLoud);
        //12
        Cancion  afireLove = new Cancion();
        afireLove.setTitulo("Afire Love");
        afireLove.setAlbumId(xDeluxeEdition.getAlbumId());
        xDeluxeEdition.getCanciones().add(afireLove);
        afireLove.setUrl("Artistas/Eminem/cancion62");
        session.save(afireLove);
        //13
        Cancion  takeItBack = new Cancion();
        takeItBack.setTitulo("Take It Back");
        takeItBack.setAlbumId(xDeluxeEdition.getAlbumId());
        xDeluxeEdition.getCanciones().add(takeItBack);
        takeItBack.setUrl("Artistas/Eminem/cancion63");
        session.save(takeItBack);
        // Fin canciones x dulex edition ed sheeran\\
        
        // Fin canciones de ed sheeran \\
        
        
        
        
        
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
        //Serializador.serialize(catalogo, new File ("/Users/minutti/Desktop/Catalogo_transient.negspot"));
        
        session.getTransaction().commit();
        session.close();
    }//Cierre de main 
}//Cierre de clase