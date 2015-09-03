/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.negaspotify.beans.utilerias;

import com.negaspotify.beans.Artista;
import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author minutti
 */
public class PruebaHibernate {
    
    public static void main(String[] args){
        
        Artista eminem = new Artista();
        eminem.setNombre("Marshall Bruce Mathers III");
        eminem.setEsBanda(false);
        eminem.setGenero("Hip Hop");
        eminem.setNacionalidad("Estadounidense");
        
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        
        session.beginTransaction();
        session.save(eminem);
        
        session.getTransaction().commit();
        
        
        
    }
    
}
