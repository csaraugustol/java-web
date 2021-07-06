/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.vianna.aula.jsf.mb;

import br.vianna.aula.jsf.dao.UsuarioDao;
import br.vianna.aula.jsf.model.ENUM.ETipoUsuario;
import br.vianna.aula.jsf.model.Usuario;
import br.vianna.aula.jsf.util.Utils;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.context.FacesContextFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author cesar
 */
@Component
@RequestScoped
public class ValidaLoginMB {

    
    @Autowired
    UsuarioDao userD;
    
     @Autowired
    LoginMB login;

    public String verificaSenha() {
        
        login.setUser(userD.existeUser(login.getNome(), login.getSenha()));

        if (login.getUser() != null) {
            login.setIsLogado(true);
            return "index";
        } else {
            login.setNome("");
            login.setSenha("");
            login.setMsgErro("Login ou senha digitados são incorretos.");
            return "";
        }

    }
    
    
    

}
