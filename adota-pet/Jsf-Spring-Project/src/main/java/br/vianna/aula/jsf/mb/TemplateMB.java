/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.vianna.aula.jsf.mb;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import org.springframework.stereotype.Component;

/**
 *
 * @author cesar
 */
@Component
@RequestScoped
public class TemplateMB {
    
    public String logout(){
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
    return "index";
    }
    
    public String home(){
    return "index?faces-redirect=true";
    }
    public String cadPet(){
    return "cad_pet?faces-redirect=true";
    }
    
}
