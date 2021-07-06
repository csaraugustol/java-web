/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.vianna.atividade.servlet;

import br.vianna.atividade.model.Pesquisa;
import br.vianna.atividade.model.Pessoa;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author cesar
 */
@WebServlet(name = "ServletPesquisa", urlPatterns = {"/resultado"})
public class ServletPesquisa extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");

        Pessoa p = new Pessoa(
                request.getParameter("cpCpf"),
                request.getParameter("cpSexo"),
                request.getParameter("cpOlhos"),
                request.getParameter("cpCabelos"),
                Integer.parseInt(request.getParameter("cpIdade")),
                Double.parseDouble(request.getParameter("cpAltura"))
        );

        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            Pesquisa pesq = new Pesquisa();
            pesq = (Pesquisa) request.getSession().getAttribute("pesq");

            if (pesq == null) {
                pesq = new Pesquisa();
            }
               // pesq = (Pesquisa) request.getSession().getAttribute("pesq");
            
            
            pesq.addPessoa(p);
            
           request.getSession().setAttribute("pesq", pesq);

           //request.getSession().setAttribute("pessoa", p);

            response.sendRedirect("resultado.jsp?" + pesq.getPessoa().size());
            
           // out.print("tam: " + pesq.getPessoa().size());
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
