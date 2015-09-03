/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.negaspotify.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author minutti
 */
@Entity(name = "Album")
public class Album implements Serializable{
    public static final long serialVersionUID = 0001L;
    @Id
    @GeneratedValue (strategy=GenerationType.AUTO)
    private int albumId;
    
    
    @Column(name = "nombre")
    private String nombre;
    
    private transient Artista artista;
    @Column(name = "cantidadCanciones")
    private int cantidadCanciones;
    @Column(name = "anio")
    private Date anio;
    @Column(name = "portada")
    private String portada;
    @Column(name = "disquera")
    private String disquera;
    @Column(name = "artistaId")
    private int artistaId;
    private transient ArrayList<Cancion> canciones;
    
    
    public Album(){
        this.canciones = new ArrayList();
    }

    /**
     * @return the artista
     */
    public Artista getArtista() {
        return artista;
    }

    /**
     * @param artista the artista to set
     */
    public void setArtista(Artista artista) {
        this.artista = artista;
    }

    /**
     * @return the cantidadCanciones
     */
    public int getCantidadCanciones() {
        return cantidadCanciones;
    }

    /**
     * @param cantidadCanciones the cantidadCanciones to set
     */
    public void setCantidadCanciones(int cantidadCanciones) {
        this.cantidadCanciones = cantidadCanciones;
    }

    /**
     * @return the anio
     */
    public Date getAnio() {
        return anio;
    }

    /**
     * @param anio the anio to set
     */
    public void setAnio(Date anio) {
        this.anio = anio;
    }

    /**
     * @return the portada
     */
    public String getPortada() {
        return portada;
    }

    /**
     * @param portada the portada to set
     */
    public void setPortada(String portada) {
        this.portada = portada;
    }

    /**
     * @return the disquera
     */
    public String getDisquera() {
        return disquera;
    }

    /**
     * @param disquera the disquera to set
     */
    public void setDisquera(String disquera) {
        this.disquera = disquera;
    }

    /**
     * @return the canciones
     */
    public ArrayList<Cancion> getCanciones() {
        return canciones;
    }

    /**
     * @param canciones the canciones to set
     */
    public void setCanciones(ArrayList<Cancion> canciones) {
        this.canciones = canciones;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the artistaId
     */
    public int getArtistaId() {
        return artistaId;
    }

    /**
     * @param artistaId the artistaId to set
     */
    public void setArtistaId(int artistaId) {
        this.artistaId = artistaId;
    }

    /**
     * @return the albumId
     */
    public int getAlbumId() {
        return albumId;
    }

    /**
     * @param albumId the albumId to set
     */
    public void setAlbumId(int albumId) {
        this.albumId = albumId;
    }
    
}
