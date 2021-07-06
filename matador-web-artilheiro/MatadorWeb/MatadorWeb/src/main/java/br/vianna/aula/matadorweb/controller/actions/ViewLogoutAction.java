/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.vianna.aula.matadorweb.controller.actions;

import br.vianna.aula.matadorweb.controller.commander.GenericCommander;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author cesar
 */
public class ViewLogoutAction extends GenericCommander {

    public ViewLogoutAction(boolean isLogado) {
        super(isLogado);
    }

        
    @Override
    public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       request.getSession().invalidate();
       
       //Passa extensão
       //new ViewLoginAction(isLogado).executa(request, response);
       
       //Não passa a extensão
       response.sendRedirect("control");
    }
    
}
