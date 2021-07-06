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
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author cesar
 */
public class ViewExluiTimeAction extends GenericCommander {

    public ViewExluiTimeAction(boolean isLogado) {
        super(isLogado);
    }

    @Override
    public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");

        TimeDao.getConexao().getTransaction().begin();
        Time t = TimeDao.getConexao().find(Time.class, Integer.parseInt(id));
        TimeDao.getConexao().remove(t);
        TimeDao.getConexao().getTransaction().commit();

        //new ViewTimesAction(isLogado).executa(request, response);
        
        response.sendRedirect("control?ac=times");
    }

}
