/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.vianna.atividade.appvotacao.servlet;

import br.vianna.atividade.appvotacao.model.Turma;
import br.vianna.atividade.appvotacao.model.Votacao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author cesar
 */
@WebServlet(name = "ServletGanhador", urlPatterns = {"/ganhador"})
public class ServletGanhador extends HttpServlet {

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

        Votacao v = new Votacao(
                request.getParameter("cpNomeVotante"),
                request.getParameter("cpNomeCandidato"));

        String nomeCandidato = request.getParameter("cpNomeCandidato");

        try ( PrintWriter out = response.getWriter()) {

            /* TODO output your page here. You may use following sample code. */
            Turma t = new Turma();
            t = (Turma) request.getSession().getAttribute("turma");

            if (t == null) {
                t = new Turma();
            }
//            
//           for(int i = 0; i < t.getAlunos().size(); i++){
//            if(v.getNomeCandidato().equals(nomeCandidato)){
//            v.setQuantidadeVotos(v.getQuantidadeVotos()+1);
//            }
//
//           }
          
            t.addVoto(v);

            request.getSession().setAttribute("turma", t);

            RequestDispatcher rd = request.getRequestDispatcher("ganhador.jsp");
            request.setAttribute("turma", t);
            rd.forward(request, response);

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
