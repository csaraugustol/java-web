/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.vianna.aula.matadorweb.controller;

import br.vianna.aula.matadorweb.controller.actions.ViewSalvarPerfilAction;
import br.vianna.aula.matadorweb.controller.actions.ViewExluiJogadorAction;
import br.vianna.aula.matadorweb.controller.actions.ViewSalvarJogadoresAction;
import br.vianna.aula.matadorweb.controller.actions.ViewTelaCadJogadoresAction;
import br.vianna.aula.matadorweb.controller.actions.ViewTelaJogadoresAction;
import br.vianna.aula.matadorweb.controller.actions.ViewExluiTimeAction;
import br.vianna.aula.matadorweb.controller.actions.ViewPerfilAction;
import br.vianna.aula.matadorweb.controller.actions.LoginVerifyAction;
import br.vianna.aula.matadorweb.controller.actions.ViewSalvarTimeAction;
import br.vianna.aula.matadorweb.controller.actions.ViewSalvarUsuarioAction;
import br.vianna.aula.matadorweb.controller.actions.ViewCadastroAction;
import br.vianna.aula.matadorweb.controller.actions.ViewHomeLogadoAction;
import br.vianna.aula.matadorweb.controller.actions.ViewLoginAction;
import br.vianna.aula.matadorweb.controller.actions.ViewLogoutAction;
import br.vianna.aula.matadorweb.controller.actions.ViewTelaCadTimeAction;
import br.vianna.aula.matadorweb.controller.actions.ViewTimesAction;
import br.vianna.aula.matadorweb.controller.commander.GenericCommander;
import br.vianna.aula.matadorweb.model.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author daves
 */
@WebServlet(name = "ControleCentral", urlPatterns = {"/control", "/"})
public class ControleCentral extends HttpServlet {

    static HashMap<String, GenericCommander> comandos;

    static {
        comandos = new HashMap<>();

        comandos.put(null, new ViewLoginAction(false));
        comandos.put("login", new LoginVerifyAction(false));
        comandos.put("cad", new ViewCadastroAction(false));
        comandos.put("salvarUsuario", new ViewSalvarUsuarioAction(false));
        comandos.put("home", new ViewHomeLogadoAction(true));
        comandos.put("logout", new ViewLogoutAction(true));
        comandos.put("times", new ViewTimesAction(true));
        comandos.put("cadTimes", new ViewSalvarTimeAction(true));
        comandos.put("telaCadTime", new ViewTelaCadTimeAction(true));
        comandos.put("editTime", new ViewTelaCadTimeAction(true));
        comandos.put("perfil", new ViewPerfilAction(true));
        comandos.put("exluirTime", new ViewExluiTimeAction(true));
        comandos.put("jogadores", new ViewTelaJogadoresAction(true));
        comandos.put("telaCadJogad", new ViewTelaCadJogadoresAction(true));
        comandos.put("editJogador", new ViewTelaCadJogadoresAction(true));
        comandos.put("cadJogad", new ViewSalvarJogadoresAction(true));
        comandos.put("excluirJogador", new ViewExluiJogadorAction(true));
        comandos.put("salvarPerfil", new ViewSalvarPerfilAction(true));

    }

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

        Usuario u = new Usuario(Integer.MIN_VALUE, request.getParameter("cpNome"), request.getParameter("cpEmail"),
                request.getParameter("cpSenha"));

        try ( PrintWriter out = response.getWriter()) {

            String acao = request.getParameter("ac");

            try {
                //Antes de chamar testa se está logadp
                if (!comandos.get(acao).isIsLogado() || request.getSession().getAttribute("u") != null) {

                    comandos.get(acao).executa(request, response);
                } else {
                    request.setAttribute("msg", "Acesso não autorizado");
                    new ViewLoginAction(false).executa(request, response);

                }
            } catch (Exception e) {
                RequestDispatcher rd = request.getRequestDispatcher("error.jsp");

                request.setAttribute("error", e.getMessage() == null ? "Ação não encontrada" : e.getMessage());

                rd.forward(request, response);
            }

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
