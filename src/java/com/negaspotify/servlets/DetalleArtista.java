/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.negaspotify.servlets;

import com.negaspotify.beans.Artista;
import flexjson.JSONSerializer;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author minutti
 */
@WebServlet(name = "DetalleArtista", urlPatterns = {"/DetalleArtista"})
public class DetalleArtista extends HttpServlet {


    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        ArrayList<Artista> artistas;
        int id = Integer.parseInt(request.getParameter("artistaId"));
        
        
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        String hqlCanciones = "select foto from Artista where artistaId =" + id;
        Query queryCanciones = session.createQuery(hqlCanciones);
        artistas = (ArrayList<Artista>)queryCanciones.list();
        session.close();
        
        JSONSerializer serializador = new JSONSerializer();
        String json = serializador.serialize(artistas);
    
       response.getWriter().println(json);
       response.getWriter().close();
       
        
    }


}
