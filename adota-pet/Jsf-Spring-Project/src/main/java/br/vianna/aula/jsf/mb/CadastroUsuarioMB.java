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
@Component(value = "cadMB")
@RequestScoped
public class CadastroUsuarioMB {

    private Usuario user;
    
    @Autowired
    UsuarioDao userD;
    
     @Autowired
    LoginMB login;

    public CadastroUsuarioMB() {
        user = new Usuario();
    }
    
    public String saveUser() throws NoSuchAlgorithmException{
     user.setTipoUsuario(ETipoUsuario.NORMAL);
     user.setSenha(Utils.md5(user.getSenha()));
     
     userD.save(user);
     
     user = new Usuario();
     
     login.setMsgAviso("Usuário cadastrado com sucesso.");
     
     return "login?faces-redirect=true";
     
    
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }

    public UsuarioDao getUserD() {
        return userD;
    }

    public void setUserD(UsuarioDao userD) {
        this.userD = userD;
    }
    
    
    
    

}
