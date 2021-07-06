/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.vianna.aula.matadorweb.controller.actions;

import br.vianna.aula.matadorweb.controller.commander.GenericCommander;
import br.vianna.aula.matadorweb.model.Time;
import br.vianna.aula.matadorweb.model.dao.TimeDao;
import java.io.IOException;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author cesar
 */
public class ViewTelaCadTimeAction extends GenericCommander {

    public ViewTelaCadTimeAction(boolean isLogado) {
        super(isLogado);
    }

    @Override
    public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       // RequestDispatcher rd = request.getRequestDispatcher("cadastrar_time.jsp");
       
       RequestDispatcher rd = request.getRequestDispatcher("layout.jsp");

        request.setAttribute("page", "pages/time/cadastrar_time.jsp");
       
        
        String titulo, botao;
        Time tBusca = new Time();
        tBusca.setDataFundacao(new Date());
        if (request.getParameter("id") != null) {
            titulo = "Alterar Time";
            botao = "Salvar Alteração";
            tBusca = TimeDao.BuscaPorId(Integer.parseInt(request.getParameter("id")));
            
        } else {
            titulo = "Cadastrar Time";
            botao = "Salvar Time";
        }

        
        request.setAttribute("time", tBusca);
        request.setAttribute("titulo", titulo);
        request.setAttribute("botao", botao);
        rd.forward(request, response);
    }

}
