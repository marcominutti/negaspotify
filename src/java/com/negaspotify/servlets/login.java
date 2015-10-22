/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.negaspotify.servlets;

import com.negaspotify.beans.Cancion;
import com.negaspotify.beans.Usuario;
import flexjson.JSONSerializer;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "login", urlPatterns = {"/login"})
public class login extends HttpServlet {



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
     
        ArrayList<Usuario> usuarios;
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        String hqlCanciones = "from Usuario where username = '" + username + "'";
        
        Query queryCanciones = session.createQuery(hqlCanciones);
        usuarios = (ArrayList<Usuario>)queryCanciones.list();
        
        session.close();
        
        if(usuarios.size()>0){
            if(usuarios.get(0).getContrasena().equals(password))
            {   
                request.getSession().setAttribute("user",usuarios.get(0));
                response.getWriter().println("true");
            }
            else
                response.getWriter().println("false");
                    

            
        }
        
        
        
    }

}
