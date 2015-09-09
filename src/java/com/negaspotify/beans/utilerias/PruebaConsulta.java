/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.negaspotify.beans.utilerias;

import com.negaspotify.beans.Album;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author minutti
 */
public class PruebaConsulta {
    
    public static void main (String[] args){
    
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        
        
        String hql;
        hql = "from Album";
        Query query = session.createQuery(hql);
        List resultados = query.list();
        session.close();
        Album album;
        for(Object o:resultados){
            album = (Album)o;
            System.out.println(album.getNombre());
        }

        
    
    }
    
}
