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
public class ViewSalvarUsuarioAction extends GenericCommander {
    
    public ViewSalvarUsuarioAction(boolean isLogado) {
        super(isLogado);
    }

    @Override
    public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String nome = request.getParameter("cpNome");
        String email = request.getParameter("cpEmail");
        String senha = request.getParameter("cpSenha");
        

        Usuario u = new Usuario();
        u.setIdusuario(0);
        u.setNome(nome);
        u.setLogin(email);
        u.setSenha(senha);
        u.setEh_adm("NAO");
        
        
        if(UsuarioDao.existeLogin(u)){
            
            request.setAttribute("msgErro", "Usuário já cadastrado");
            
            u.setLogin("");
            request.setAttribute("u", u);
            
            new ViewCadastroAction(false).executa(request, response);
        }else{
        
        UsuarioDao.getConexao().getTransaction().begin();
        UsuarioDao.getConexao().persist(u);
        UsuarioDao.getConexao().getTransaction().commit();
        
            request.setAttribute("msg", "Usuário cadastrado.");
        
        new ViewLoginAction(isLogado).executa(request, response);
        
        }
        
       
        

    }

    
}
