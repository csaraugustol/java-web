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
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author cesar
 */
public class ViewSalvarJogadoresAction extends GenericCommander {

    public ViewSalvarJogadoresAction(boolean isLogado) {
        super(isLogado);
    }

    @Override
    public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Time t = new Time();
        Jogador j = new Jogador();
        String msg;
        JogadorDao.getConexao().getTransaction().begin();

        if (request.getParameter("cpId").equals("") || request.getParameter("cpId") == null) {
            t = TimeDao.BuscaPorId(Integer.parseInt(request.getParameter("cpListaTimes")));
            j = new Jogador(0, request.getParameter("cpNomeJog"), Integer.parseInt(request.getParameter("qtdGols")), t);
            msg = "Jogador cadastrado.";

            if (JogadorDao.existeNome(request.getParameter("cpNomeJog"), Integer.parseInt(request.getParameter("cpListaTimes"))) == true) {
                request.setAttribute("msgErro", "Jogador já cadastrado no time.");
               new ViewTelaCadJogadoresAction(isLogado).executa(request, response);
               return;
            }

//            if (JogadorDao.existeNome(j)) {
//                request.setAttribute("msgErro", "Jogador já cadastrado no time.");
//                new ViewTelaCadJogadoresAction(isLogado).executa(request, response);
//            }

        } else {
            t = TimeDao.BuscaPorId(Integer.parseInt(request.getParameter("cpListaTimes")));
            j = JogadorDao.BuscaPorId(Integer.parseInt(request.getParameter("cpId")));

            j.setNome(request.getParameter("cpNomeJog"));
            j.setNumeroGols(Integer.parseInt(request.getParameter("qtdGols")));
            j.setTime(t);

            msg = "Alteração realizada.";
        }

        JogadorDao.getConexao().persist(j);
        JogadorDao.getConexao().getTransaction().commit();

        request.setAttribute("msg", msg);

        new ViewTelaJogadoresAction(isLogado).executa(request, response);

    }

}
