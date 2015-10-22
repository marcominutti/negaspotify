/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.negaspotify.servlets;

import com.negaspotify.beans.Usuario;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author minutti
 */
@WebServlet(name = "RegistroUser", urlPatterns = {"/RegistroUser"})
public class RegistroUser extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        System.out.println("registrando");
        try{
            
        String nombre = request.getParameter("nombre");
        String contrasena = request.getParameter("contrasena");
        String username = request.getParameter("username");
        
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        
        Usuario usuario = new Usuario();
        usuario.setNombre(nombre);
        usuario.setContrasena(contrasena);
        usuario.setUsername(username);
        
        session.save(usuario);
        session.flush();
        session.getTransaction().commit();
        session.close();
        
        response.getWriter().println("true");
        
        
        }catch(Exception e){
        
            response.getWriter().println("false");
            e.printStackTrace();
        }
        
        
        
        }
    }



