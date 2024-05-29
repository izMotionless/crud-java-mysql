/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Clases.Usuario;
import DAO.UsuarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author rodri
 */
public class ControladorLogin extends HttpServlet {

    int counterAdmin = 0;
    int counterEmpleado = 0;
    int counterCliente = 0;

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
        UsuarioDAO dao = new UsuarioDAO();
        String user = request.getParameter("txtUser");
        String pass = request.getParameter("txtPass");
        Usuario usu = new Usuario();
        int r;
        usu.setUser(user);
        usu.setPass(pass);
        r=dao.login(usu);
        if (r==1) {
            if (usu.getTipo()==1){
                counterAdmin++;
                request.getSession().setAttribute("contadorAdmin", counterAdmin);
                request.getSession().setAttribute("contadorEmpleado", counterEmpleado);
                request.getSession().setAttribute("contadorCliente", counterCliente);
            } else if (usu.getTipo()==2) {
                counterEmpleado++;
                request.getSession().setAttribute("contadorEmpleado", counterEmpleado);
                request.getSession().setAttribute("contadorCliente", counterCliente);
                request.getSession().setAttribute("contadorAdmin", counterAdmin);
            } else if (usu.getTipo()==3){
                counterCliente++;
                request.getSession().setAttribute("contadorCliente", counterCliente);
                request.getSession().setAttribute("contadorAdmin", counterAdmin);
                request.getSession().setAttribute("contadorEmpleado", counterEmpleado);
            }
            request.getSession().setAttribute("usuario", usu);
            request.getRequestDispatcher("home.jsp").forward(request, response);
        } else {
            request.setAttribute("err", "Credenciales incorrectas");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }

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
        request.getSession().invalidate();
        response.sendRedirect("index.jsp");
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
