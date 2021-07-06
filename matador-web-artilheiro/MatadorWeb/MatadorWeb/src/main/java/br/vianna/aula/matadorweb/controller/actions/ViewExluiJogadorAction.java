/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.vianna.aula.matadorweb.controller.actions;

import br.vianna.aula.matadorweb.controller.commander.GenericCommander;
import br.vianna.aula.matadorweb.model.Jogador;
import br.vianna.aula.matadorweb.model.dao.JogadorDao;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author cesar
 */
public class ViewExluiJogadorAction extends GenericCommander {

    public ViewExluiJogadorAction(boolean isLogado) {
        super(isLogado);
    }

    

    @Override
    public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        
        JogadorDao.getConexao().getTransaction().begin();
        Jogador t = JogadorDao.getConexao().find(Jogador.class, Integer.parseInt(id));
        JogadorDao.getConexao().remove(t);
        JogadorDao.getConexao().getTransaction().commit();

        
        response.sendRedirect("control?ac=jogadores");
    }
    
}
