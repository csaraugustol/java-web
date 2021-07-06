/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.vianna.aula.matadorweb.controller.commander;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author daves
 */
public abstract class GenericCommander {
    
    public boolean isLogado;

    public GenericCommander(boolean isLogado) {
        this.isLogado = isLogado;
    }
    
    public abstract void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

    public boolean isIsLogado() {
        return isLogado;
    }

    public void setIsLogado(boolean isLogado) {
        this.isLogado = isLogado;
    }
        
}
