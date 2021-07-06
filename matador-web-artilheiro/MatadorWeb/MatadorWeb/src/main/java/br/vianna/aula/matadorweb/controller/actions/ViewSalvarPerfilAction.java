/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.vianna.aula.matadorweb.controller.actions;

import br.vianna.aula.matadorweb.controller.commander.GenericCommander;
import br.vianna.aula.matadorweb.model.Usuario;
import br.vianna.aula.matadorweb.model.dao.UsuarioDao;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author cesar
 */
public class ViewSalvarPerfilAction extends GenericCommander {

    public ViewSalvarPerfilAction(boolean isLogado) {
        super(isLogado);
    }

    @Override
    public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        
        Usuario user = (Usuario) request.getSession().getAttribute("user");

        Usuario u = UsuarioDao.getConexao().find(Usuario.class,
                user.getIdusuario());

        u.setNome(request.getParameter("cpNome"));
        u.setLogin(request.getParameter("cpLoginUsuario"));
        u.setSenha(request.getParameter("cpSenha"));

        if (UsuarioDao.existeLogin(u) && u.getLogin().equals(user.getLogin())) {

            request.setAttribute("error", "Login já está sendo utilizado.");
            new ViewPerfilAction(isLogado).executa(request, response);

        }

        request.setAttribute("Salvo", "Perfil salvo om sucesso.");

        new ViewPerfilAction(isLogado).executa(request, response);
    }

}
