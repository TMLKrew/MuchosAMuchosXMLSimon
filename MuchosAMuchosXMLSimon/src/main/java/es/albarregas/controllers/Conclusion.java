package es.albarregas.controllers;

import es.albarregas.beans.Escritor;
import es.albarregas.beans.Libro;
import es.albarregas.dao.IGenericoDAO;
import es.albarregas.daofactory.DAOFactory;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;

/**
 *
 * @author Jesus
 */
@WebServlet(name = "Conclusion", urlPatterns = {"/conclusion"})
public class Conclusion extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DAOFactory daof = DAOFactory.getDAOFactory();
        IGenericoDAO<Escritor> gdao = daof.getGenericoDAO();
        Escritor escritor = new Escritor();
        Set<Libro> libros = new HashSet<Libro>();
        Set<Escritor> escritores = new HashSet<Escritor>();
        Libro libro = null;
        String url = null;
        switch (request.getParameter("op")) {

            case "update":
                try {

            
                    BeanUtils.populate(escritor, request.getParameterMap());
                    escritores.add(escritor);

                    Enumeration<String> parametros = request.getParameterNames();
                    while (parametros.hasMoreElements()) {
                        String nombre = parametros.nextElement();
                        if (nombre.startsWith("libro")) {
                            libro = new Libro();
                            libro.setTitulo(request.getParameter(nombre));
                            libro.setIdLibro(Long.parseLong(request.getParameter("id"+nombre)));
                            libro.setEscritores(escritores);
                            libros.add(libro);
                        }
                    }

                    escritor.setLibros(libros);

                } catch (IllegalAccessException | InvocationTargetException ex) {
                    ex.printStackTrace();
                }

                gdao.insertUpdate(escritor);
                url = "index.html";
                break;
        }
        request.getRequestDispatcher(url).forward(request, response);

    }

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
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
