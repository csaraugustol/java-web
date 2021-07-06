/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.vianna.atividade.appcarro.servlet;

import br.vianna.atividade.appcarro.Carro.Carro;
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
@WebServlet(name = "ServletCarro", urlPatterns = {"/montagem"})
public class ServletCarro extends HttpServlet {

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
        
        Carro c = new Carro(request.getParameter("cpNome"),
        request.getParameter("cpAr"),
        request.getParameter("cpCambio"),
        request.getParameter("cpVidro"),
        request.getParameter("cpAlarme"),
        request.getParameter("cpPintura"),
        request.getParameter("cpTetoSolar"),
        request.getParameter("cpMult"),
        request.getParameter("cpMotor"));
//
//        String nome = request.getParameter("cpNome");
//        String ar = request.getParameter("cpAr");
//        String cambio = request.getParameter("cpCambio");
//        String vidro = request.getParameter("cpVidro");
//        String alarme = request.getParameter("cpAlarme");
//        String pintura = request.getParameter("cpPintura");
//        String tetoSolar = request.getParameter("cpTetoSolar");
//        String cetralMult = request.getParameter("cpMult");
//        String motor = request.getParameter("cpMotor");
        
  
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletCarro</title>");
            out.println("</head>");
            out.println("<body style=\"background-color: #17A2B8; color: #fff; text-transform: uppercase;\">");
            out.println("<h3>Carro: " + c.getNome() + "</h3>");
            out.println("<h3>Ar: " + c.getAr() + "</h3>");
            out.println("<h3>Câmbio Automático: " + c.getCambio() + "</h3>");
            out.println("<h3>Vidro Automático: " + c.getVidro() + "</h3>");
            out.println("<h3>Alarme: " + c.getAlarme() + "</h3>");
            out.println("<h3>Pintura: " + c.getPintura() + "</h3>");
            out.println("<h3>Teto Solar: " + c.getTetoSolar() + "</h3>");
            out.println("<h3>Central Multimídia: " + c.getCetralMult() + "</h3>");
            out.println("<h3>Motor: " + c.getMotor() + "</h3>");
            out.println("<h1>Preço final do carro: " + c.calculaIpi() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
