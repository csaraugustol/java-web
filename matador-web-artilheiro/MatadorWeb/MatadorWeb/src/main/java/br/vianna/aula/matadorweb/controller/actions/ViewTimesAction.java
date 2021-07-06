/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.vianna.aula.matadorweb.controller.actions;

import br.vianna.aula.matadorweb.controller.commander.GenericCommander;
import br.vianna.aula.matadorweb.model.Time;
import br.vianna.aula.matadorweb.model.Usuario;
import br.vianna.aula.matadorweb.model.dao.TimeDao;
import br.vianna.aula.matadorweb.model.dao.UsuarioDao;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author cesar
 */
public class ViewTimesAction extends GenericCommander {

    public ViewTimesAction(boolean isLogado) {
        super(isLogado);
    }

    @Override
    public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("layout.jsp");

        request.setAttribute("page", "pages/time/times.jsp");

        Usuario u = (Usuario) request.getSession().getAttribute("u");

        List<Time> times = null;
        List<Usuario> users = null;
        if (request.getParameter("cpBuscaNome") == null) {
            times = TimeDao.buscarTimes(u);
            users = UsuarioDao.buscaNomesUsuarios();

        } else {

            Usuario user = new Usuario(Integer.parseInt(request.getParameter("cpBuscaUsuario")));
            String dt1 = request.getParameter("cpdata1"); //yyyy-MM-dd
            String dt2 = request.getParameter("cpdata2");

            times = TimeDao.buscarTimesFiltro(request.getParameter("cpBuscaNome"), user,
                    dt1, dt2);
            users = UsuarioDao.buscaNomesUsuarios();

        }

        String cpBuscaNome = request.getParameter("cpBuscaNome");
        String date1 = request.getParameter("cpdata1");
        String date2 = request.getParameter("cpdata2");
        String nomeUser = request.getParameter("cpBuscaUsuario");

        if (request.getParameter("cpBuscaUsuario") != null) {

            request.setAttribute("cpBuscaNome", cpBuscaNome);
            request.setAttribute("cpdata1", date1);
            request.setAttribute("cpdata2", date2);
            request.setAttribute("nomeUser", nomeUser);

        } else {

            request.setAttribute("cpBuscaNome", "");
            request.setAttribute("cpdata1", "");
            request.setAttribute("cpdata2", "");
            request.setAttribute("nomeUser", "");
        }

        request.setAttribute("times", times);
        request.setAttribute("users", users);
        rd.forward(request, response);

    }

}
