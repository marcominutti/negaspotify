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
@Entity(name = "Usuario")
public class Usuario implements Serializable {
    public static final long serialVersionUID = 0001L;
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private int usuarioId;
    
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "contrasena")
    private String contrasena;
    @Column(name = "username")
    private String username;
    @Column(name = "ultimoLogin")
    private Date ultimoLogin;

    /**
     * @return the usuarioId
     */
    public int getUsuarioId() {
        return usuarioId;
    }

    /**
     * @param usuarioId the usuarioId to set
     */
    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
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
     * @return the contrasena
     */
    public String getContrasena() {
        return contrasena;
    }

    /**
     * @param contrasena the contrasena to set
     */
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the ultimoLogin
     */
    public Date getUltimoLogin() {
        return ultimoLogin;
    }

    /**
     * @param ultimoLogin the ultimoLogin to set
     */
    public void setUltimoLogin(Date ultimoLogin) {
        this.ultimoLogin = ultimoLogin;
    }
    
    
}
