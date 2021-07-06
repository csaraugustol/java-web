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
public class ViewTelaCadJogadoresAction extends GenericCommander {

    public ViewTelaCadJogadoresAction(boolean isLogado) {
        super(isLogado);
    }

    @Override
    public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("layout.jsp");

        String titulo, botao;
        Jogador BuscaJog = new Jogador();
        if (request.getParameter("id") != null) {
            titulo = "Alterar Jogador";
            botao = "Salvar Alteração";
            BuscaJog = JogadorDao.BuscaPorId(Integer.parseInt(request.getParameter("id")));

        } else {
            titulo = "Cadastrar Jogador";
            botao = "Salvar Jogador";
        }

        Usuario u = (Usuario) request.getSession().getAttribute("u");

        List<Time> times = TimeDao.buscarTimes(u);

        request.setAttribute("times", times);
        request.setAttribute("jog", BuscaJog);
        request.setAttribute("titulo", titulo);
        request.setAttribute("botao", botao);
        request.setAttribute("page", "pages/jogador/cadastrar_jogador.jsp");
        rd.forward(request, response);

    }

}
