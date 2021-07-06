/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.vianna.aula.matadorweb.controller.actions;

import br.vianna.aula.matadorweb.controller.commander.GenericCommander;
import br.vianna.aula.matadorweb.model.Jogador;
import br.vianna.aula.matadorweb.model.Time;
import br.vianna.aula.matadorweb.model.Usuario;
import br.vianna.aula.matadorweb.model.dao.JogadorDao;
import br.vianna.aula.matadorweb.model.dao.TimeDao;
import br.vianna.aula.matadorweb.model.dao.UsuarioDao;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author cesar
 */
public class ViewTelaJogadoresAction extends GenericCommander {

    public ViewTelaJogadoresAction(boolean isLogado) {
        super(isLogado);
    }

    @Override
    public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("layout.jsp");

        request.setAttribute("page", "pages/jogador/jogadores.jsp");
        Usuario u = (Usuario) request.getSession().getAttribute("u");

        List<Jogador> jogadores = null;
        List<Time> times = null;
        if (request.getParameter("cpBuscaNome") == null) {
            jogadores = JogadorDao.buscaJogadores(u);
            times = TimeDao.buscarTimes(u);

        }else if(request.getParameter("qtdGols1").equals("") && request.getParameter("qtdGols2").equals("")){
            jogadores = JogadorDao.buscarJogadornome(request.getParameter("cpBuscaNome"));
             times = TimeDao.buscarTimes(u);
            } else{
            
            int qtdGols1;
            
            if(request.getParameter("qtdGols1").equals("")){
            qtdGols1 = 0;
            }else{
            qtdGols1 = Integer.parseInt(request.getParameter("qtdGols1"));
            }
            
            int qtdGols2;
            
            if(request.getParameter("qtdGols2").equals("")){
            qtdGols2 = Integer.MAX_VALUE;
            }else{
            qtdGols2 = Integer.parseInt(request.getParameter("qtdGols2"));
            }
            
            Time ti = new Time(Integer.parseInt(request.getParameter("cpBuscaTimes")));

            jogadores = JogadorDao.buscarJogadorFiltroNomeGols(request.getParameter("cpBuscaNome"), qtdGols1,
                    qtdGols2, ti);
            
            times = TimeDao.buscarTimes(u);
        }

        
        
        
        
        String cpBuscaNome = request.getParameter("cpBuscaNome");
        String g1 = request.getParameter("qtdGols1");
        String g2 = request.getParameter("qtdGols2");
        String selectTime = request.getParameter("cpBuscaTimes");

        if (request.getParameter("cpBuscaTimes") != null) {

            request.setAttribute("cpBuscaNome", cpBuscaNome);
            request.setAttribute("g1", g1);
            request.setAttribute("g2", g2);
            request.setAttribute("cpBuscaTimes", selectTime);

        } else {

            request.setAttribute("cpBuscaNome", "");
            request.setAttribute("g1", "");
            request.setAttribute("g2", "");
            request.setAttribute("cpBuscaTimes", "");
        }

        request.setAttribute("jogadores", jogadores);
        request.setAttribute("times", times);
        rd.forward(request, response);
    }

}
