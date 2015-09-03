/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.negaspotify.beans;

import java.io.Serializable;
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
@Entity(name = "Cancion")
public class Cancion implements Serializable{
    public static final long serialVersionUID = 0001L;
      
    @Id
    @GeneratedValue (strategy=GenerationType.AUTO)
    private int cancionId;
    
    @Column(name = "titulo")
    private String titulo;
    
    private transient Artista artista;
    
    @Column(name = "genero")
    private String genero;
    
    @Column(name = "anio")
    private Date anio;
    
    @Column(name = "duracion")
    private Long duracion;
    
    @Column(name = "albumId")
    private int albumId;
    
    private transient Album album;
    
    
    public Cancion(){
    }

    /**
     * @return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
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
     * @return the genero
     */
    public String getGenero() {
        return genero;
    }

    /**
     * @param genero the genero to set
     */
    public void setGenero(String genero) {
        this.genero = genero;
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
     * @return the duracion
     */
    public Long getDuracion() {
        return duracion;
    }

    /**
     * @param duracion the duracion to set
     */
    public void setDuracion(Long duracion) {
        this.duracion = duracion;
    }

    /**
     * @return the album
     */
    public Album getAlbum() {
        return album;
    }

    /**
     * @param album the album to set
     */
    public void setAlbum(Album album) {
        this.album = album;
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

    /**
     * @return the cancionId
     */
    public int getCancionId() {
        return cancionId;
    }

    /**
     * @param cancionId the cancionId to set
     */
    public void setCancionId(int cancionId) {
        this.cancionId = cancionId;
    }
    
}
