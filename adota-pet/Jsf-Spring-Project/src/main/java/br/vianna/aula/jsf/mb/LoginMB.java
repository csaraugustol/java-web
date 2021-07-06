/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.vianna.aula.jsf.mb;

import br.vianna.aula.jsf.model.DTO.UsuarioLogDTO;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import org.springframework.stereotype.Component;

/**
 *
 * @author cesar
 */
@Component
@SessionScoped

public class LoginMB implements Serializable {

    private String nome, senha, msgErro, msgAviso;
    private boolean isLogado;
    private UsuarioLogDTO user;


    public LoginMB() {
        msgErro = "";
        msgAviso = "";
        isLogado = false;
        user = null;
    }

   
    
    
    
    public String casdastro(){
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
    return "cadastro?faces-redirect=true";
    }
    
    public String voltar(){
         return "login?faces-redirect=true";
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getMsgErro() {
        return msgErro;
    }

    public void setMsgErro(String msgErro) {
        this.msgErro = msgErro;
    }

    public boolean isIsLogado() {
        return isLogado;
    }

    public void setIsLogado(boolean isLogado) {
        this.isLogado = isLogado;
    }

    public String getMsgAviso() {
        return msgAviso;
    }

    public void setMsgAviso(String msgAviso) {
        this.msgAviso = msgAviso;
    }

    public UsuarioLogDTO getUser() {
        return user;
    }

    public void setUser(UsuarioLogDTO user) {
        this.user = user;
    }


    
    

}
