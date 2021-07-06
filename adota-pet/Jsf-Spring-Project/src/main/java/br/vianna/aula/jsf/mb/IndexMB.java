/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.vianna.aula.jsf.mb;

import java.io.IOException;
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
public class IndexMB {

    private String nomeProj;

    @Autowired
    private LoginMB loginMB = new LoginMB();

    public IndexMB() {

        nomeProj = "Adota Pet :: Home - Versão 1.0";

    }

    @PostConstruct
    public void init() {
        if (!loginMB.isIsLogado()) {
           
            try {
                loginMB.setMsgErro("Acesso negado.");
                FacesContext.getCurrentInstance().getExternalContext().redirect("login.xhtml");
            } catch (IOException ex) {

            }

        }
    }
    
    public String homePag(){
         return "home";
    }
    
    public String indexPag(){
         return "index";
    }

    public String getNomeProj() {
        return nomeProj;
    }

    public void setNomeProj(String nomeProj) {
        this.nomeProj = nomeProj;
    }

}
