/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.negaspotify.beans;

import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author minutti
 */

@Entity(name = "Artista")
public class Artista implements Serializable {
    
    public static final long serialVersionUID = 0001L;
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private int artistaId;
    
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "nacionalidad")
    private String nacionalidad;
    @Column(name = "genero")
    private String genero;
    @Column(name = "esBanda")
    private Boolean esBanda;
    @Column(name = "foto")
    private String foto;
    private transient ArrayList<Album> albums;
    
    public Artista(){
        this.albums = new ArrayList();
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
     * @return the nacionalidad
     */
    public String getNacionalidad() {
        return nacionalidad;
    }

    /**
     * @param nacionalidad the nacionalidad to set
     */
    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
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
     * @return the esBanda
     */
    public Boolean getEsBanda() {
        return esBanda;
    }

    /**
     * @param esBanda the esBanda to set
     */
    public void setEsBanda(Boolean esBanda) {
        this.esBanda = esBanda;
    }

    /**
     * @return the foto
     */
    public String getFoto() {
        return foto;
    }

    /**
     * @param foto the foto to set
     */
    public void setFoto(String foto) {
        this.foto = foto;
    }

    /**
     * @return the albums
     */
    public ArrayList<Album> getAlbums() {
        return albums;
    }

    /**
     * @param albums the albums to set
     */
    public void setAlbums(ArrayList<Album> albums) {
        this.albums = albums;
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
    
}
